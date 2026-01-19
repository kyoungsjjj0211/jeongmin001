// api/axios.js

import axios from "axios";

const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_BASE_URL || "http://localhost:8484", 
  // 기본 api 서버주소, 환경변수가 없으면 로컬서버 사용
  withCredentials: true, 
  // refresh Token 이 HttpOnly 쿠키에 저장 되어 있으면 자동 포함 필요
  headers: {
    "Content-Type": "application/json",   // → 요청기본 json
    Accept: "application/json",         // → 응답을 JSON으로 받도록 지정
  },
});
 //요청인터셉터 : 요청 보내기 전에 Access Token 을 헤더에 추가
api.interceptors.request.use(
  (config) => {
    if (typeof window !== "undefined") {  //→ CSR 환경에서만 localStarage 접근
      const accessToken = localStorage.getItem("accessToken");  // → 저장된 Access Token 가져오기
      if (accessToken) {
        config.headers.Authorization = `Bearer ${accessToken}`;   // → Authorization 헤더에 추가
      }
    }
    return config;  
  },
  (error) => Promise.reject(error)   //요청에러처리
); 
api.interceptors.response.use(
  (res) => res, // → 정상 응답은 그대로 반환
  async (error) => {
    const original = error.config; // → 원래 요청 정보
    const status = error.response?.status; // → 응답 상태 코드
 //401 발생시 Refresh Token 재발급
    if (status === 401 && !original._retry) {
      original._retry = true; // → 무한 루프 방지 플래그
      try {
        const { data } = await api.post("/auth/refresh"); 
        const newAccessToken = data?.accessToken;  

        if (typeof window !== "undefined" && newAccessToken) {
          localStorage.setItem("accessToken", newAccessToken);  //Local 저장 
        }

        original.headers.Authorization = `Bearer ${newAccessToken}`;   // 원 요청 헤더 갱신
        return api(original); 
      } catch (refreshErr) {
        if (typeof window !== "undefined") {
          localStorage.removeItem("accessToken");  
          window.location.href = "/login";        
        }
        return Promise.reject(refreshErr);  
      }
    }

    return Promise.reject(error);  
  }
);
 
export default api;
