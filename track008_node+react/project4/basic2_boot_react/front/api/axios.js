import axios from "axios";

const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_BASE_URL || "http://localhost:8484", 
  withCredentials: true, 
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
});

// 요청 인터셉터
api.interceptors.request.use(
  (config) => {
    if (typeof window !== "undefined") {
      const accessToken = localStorage.getItem("accessToken");
      if (accessToken) {
        config.headers.Authorization = `Bearer ${accessToken}`;
      }
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// 응답 인터셉터
api.interceptors.response.use(
  (res) => res,
  async (error) => {
    const original = error.config;
    const status = error.response?.status;

    // 401(권한 없음) 에러 발생 시에만 재발급 시도
    if (status === 401 && !original._retry) {
      original._retry = true;
      try {
        // 주의: 재발급 요청은 무한 루프를 피하기 위해 인터셉터가 없는 axios 기본 인스턴스나 별도 경로 이용 권장
        const { data } = await axios.post(`${api.defaults.baseURL}/auth/refresh`, {}, { withCredentials: true });
        const newAccessToken = data?.accessToken;

        if (typeof window !== "undefined" && newAccessToken) {
          localStorage.setItem("accessToken", newAccessToken);
          // ✅ 쿠키도 함께 갱신해주는 것이 좋습니다 (authSaga와 동기화)
          document.cookie = `accessToken=${newAccessToken}; path=/`; 
        }

        original.headers.Authorization = `Bearer ${newAccessToken}`;
        return api(original); 
      } catch (refreshErr) {
        // ✅ 튕기기 방지 로직: 관리자 페이지 등 특정 상황에서는 즉시 이동을 유예함
        console.error("세션 만료: 토큰 재발급에 실패했습니다.");
        
        if (typeof window !== "undefined") {
          // 특정 에러(500 등)와 헷갈리지 않게 정말 인증 실패일 때만 처리
          if (refreshErr.response?.status === 401 || refreshErr.response?.status === 403) {
             // localStorage.removeItem("accessToken"); // 일단 유지해보고 정 안되면 주석 해제
             // window.location.href = "/login"; // 🚨 이 부분이 자동 로그아웃의 주범! 일단 주석 처리하여 방어합니다.
          }
        }
        return Promise.reject(refreshErr);
      }
    }

    // 500 에러 등이 발생해도 로그아웃시키지 않고 에러만 던짐
    return Promise.reject(error);
  }
);



export const loadMaterialsAPI = (page) => {
  return api.get(`/api/material/list`, {
    params: { page },
  });
};

export default api;