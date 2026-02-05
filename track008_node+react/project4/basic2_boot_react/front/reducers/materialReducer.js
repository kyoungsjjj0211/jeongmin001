import { createSlice } from '@reduxjs/toolkit';

export const initialState = {
  materials: [],             // 식재료 목록
  currentMaterial: null,     // 상세 보기 데이터
  loading: false,
  error: null,
  createMaterialDone: false,
  updateMaterialDone: false,
  deleteMaterialDone: false,
  totalElements: 0,          // 전체 개수 (필요 시)
};

const materialSlice = createSlice({
  name: 'material',
  initialState,
  reducers: {
    // 0. 상태 초기화 액션
    CREATE_MATERIAL_RESET: (state) => {
      state.createMaterialDone = false;
      state.error = null;
    },
    UPDATE_MATERIAL_RESET: (state) => {
      state.updateMaterialDone = false;
      state.error = null;
    },
    DELETE_MATERIAL_RESET: (state) => {
      state.deleteMaterialDone = false;
      state.error = null;
    },

    // 1. 기본 전체 조회
    fetchMaterialsRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchMaterialsSuccess: (state, action) => {
      state.loading = false;
      state.materials = action.payload;
    },
    fetchMaterialsFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    // 2. 단일 상세 조회
    fetchMaterialRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchMaterialSuccess: (state, action) => {
      state.loading = false;
      state.currentMaterial = action.payload;
    },
    fetchMaterialFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
      state.currentMaterial = null;
    },

    // 3. 페이징 조회 (검색 포함)
    fetchMaterialsPagedRequest: (state) => {
      state.loading = true;
      state.error = null;
    },
    fetchMaterialsPagedSuccess: (state, action) => {
      state.loading = false;
      // action.payload가 { data: [...], page: 1 } 형태라고 가정
      const { data, page } = action.payload;

      if (page === 1) {
        state.materials = data;
      } else {
        const merged = [...state.materials, ...data];
        // materialid 기준으로 중복 제거
        state.materials = merged.filter(
          (m, index, self) => index === self.findIndex(t => t.materialid === m.materialid)
        );
      }
    },
    fetchMaterialsPagedFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    // 4. 식재료 생성 (C)
    createMaterialRequest: (state) => {
      state.loading = true;
      state.error = null;
      state.createMaterialDone = false;
    },
    createMaterialSuccess: (state, action) => {
      state.loading = false;
      state.createMaterialDone = true;
      state.materials.unshift(action.payload);
    },
    createMaterialFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    // 5. 식재료 수정 (U)
    updateMaterialRequest: (state) => {
      state.loading = true;
      state.error = null;
      state.updateMaterialDone = false;
    },
    updateMaterialSuccess: (state, action) => {
      state.loading = false;
      state.updateMaterialDone = true;
      // materialid가 일치하는 항목 교체
      state.materials = state.materials.map(m => 
        m.materialid === action.payload.materialid ? action.payload : m
      );
      if (state.currentMaterial && state.currentMaterial.materialid === action.payload.materialid) {
        state.currentMaterial = action.payload;
      }
    },
    updateMaterialFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    // 6. 식재료 삭제 (D)
    deleteMaterialRequest: (state) => {
      state.loading = true;
      state.error = null;
      state.deleteMaterialDone = false;
    },
    deleteMaterialSuccess: (state, action) => {
      state.loading = false;
      state.deleteMaterialDone = true;
      state.materials = state.materials.filter(m => m.materialid !== action.payload);
      if (state.currentMaterial && state.currentMaterial.materialid === action.payload) {
        state.currentMaterial = null;
      }
    },
    deleteMaterialFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
  },
});

export const {
  CREATE_MATERIAL_RESET,
  UPDATE_MATERIAL_RESET,
  DELETE_MATERIAL_RESET,
  fetchMaterialsRequest, fetchMaterialsSuccess, fetchMaterialsFailure,
  fetchMaterialRequest, fetchMaterialSuccess, fetchMaterialFailure,
  fetchMaterialsPagedRequest, fetchMaterialsPagedSuccess, fetchMaterialsPagedFailure,
  createMaterialRequest, createMaterialSuccess, createMaterialFailure,
  updateMaterialRequest, updateMaterialSuccess, updateMaterialFailure,
  deleteMaterialRequest, deleteMaterialSuccess, deleteMaterialFailure,
} = materialSlice.actions;

export default materialSlice.reducer;