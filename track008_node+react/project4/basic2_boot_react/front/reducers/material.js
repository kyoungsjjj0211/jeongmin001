import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  materials: [],
  currentMaterial: null,
  loading: false,
  error: null,
};

const materialSlice = createSlice({
  name: 'material',
  initialState,
  reducers: {
    fetchMaterialsRequest: (state) => { state.loading = true; state.error = null; },
    fetchMaterialsSuccess: (state, action) => {
      state.loading = false;
      state.materials = action.payload;
    },
    fetchMaterialsFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    fetchMaterialDetailRequest: (state) => { state.loading = true; state.error = null; },
    fetchMaterialDetailSuccess: (state, action) => {
      state.loading = false;
      state.currentMaterial = action.payload;
    },
    fetchMaterialDetailFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
      state.currentMaterial = null;
    },

    fetchMaterialsPagedRequest: (state) => { state.loading = true; state.error = null; },
    fetchMaterialsPagedSuccess: (state, action) => {
      state.loading = false;
      const merged = [...state.materials, ...action.payload];
      const unique = merged.filter(
        (m, index, self) => index === self.findIndex(p => p.materialid === m.materialid)
      );
      state.materials = unique.sort((a, b) => new Date(b.createdat) - new Date(a.createdat));
    },
    fetchMaterialsPagedFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    createMaterialRequest: (state) => { state.loading = true; state.error = null; },
    createMaterialSuccess: (state, action) => {
      state.loading = false;
      state.materials.unshift(action.payload);
    },
    createMaterialFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    updateMaterialRequest: (state) => { state.loading = true; state.error = null; },
    updateMaterialSuccess: (state, action) => {
      state.loading = false;
      state.materials = state.materials.map(m =>
        m.materialid === action.payload.materialid ? action.payload : m
      );
      state.currentMaterial = action.payload;
    },
    updateMaterialFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },

    deleteMaterialRequest: (state) => { state.loading = true; state.error = null; },
    deleteMaterialSuccess: (state, action) => {
      state.loading = false;
      state.materials = state.materials.filter(m => m.materialid !== action.payload);
      if (state.currentMaterial?.materialid === action.payload) {
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
  fetchMaterialsRequest, fetchMaterialsSuccess, fetchMaterialsFailure,
  fetchMaterialDetailRequest, fetchMaterialDetailSuccess, fetchMaterialDetailFailure,
  fetchMaterialsPagedRequest, fetchMaterialsPagedSuccess, fetchMaterialsPagedFailure,
  createMaterialRequest, createMaterialSuccess, createMaterialFailure,
  updateMaterialRequest, updateMaterialSuccess, updateMaterialFailure,
  deleteMaterialRequest, deleteMaterialSuccess, deleteMaterialFailure,
} = materialSlice.actions;

export default materialSlice.reducer;