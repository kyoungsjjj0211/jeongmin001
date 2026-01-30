import { call, put, takeLatest } from 'redux-saga/effects';
import axios from '../api/axios';
import {
  fetchMaterialsRequest, fetchMaterialsSuccess, fetchMaterialsFailure,
  fetchMaterialDetailRequest, fetchMaterialDetailSuccess, fetchMaterialDetailFailure,
  createMaterialRequest, createMaterialSuccess, createMaterialFailure,
  updateMaterialRequest, updateMaterialSuccess, updateMaterialFailure,
  deleteMaterialRequest, deleteMaterialSuccess, deleteMaterialFailure,
} from '../reducers/material'; // 경로 수정 완료

export function* fetchMaterials(action) {
  try {
    const { keyword, page, size } = action.payload || {};
    const { data } = yield call(() => axios.get(`/api/materials`, { params: { keyword, page, size } }));
    yield put(fetchMaterialsSuccess(data));
  } catch (err) {
    yield put(fetchMaterialsFailure(err.response?.data?.message || err.message));
  }
}

export function* fetchMaterialDetail(action) {
  try {
    const { materialid } = action.payload;
    const { data } = yield call(() => axios.get(`/api/materials/${materialid}`));
    yield put(fetchMaterialDetailSuccess(data));
  } catch (err) {
    yield put(fetchMaterialDetailFailure(err.response?.data?.message || err.message));
  }
}

export function* createMaterial(action) {
  try {
    const { dto, file } = action.payload;
    const formData = new FormData();
    Object.entries(dto || {}).forEach(([k, v]) => formData.append(k, v));
    if (file) formData.append('file', file);
    const { data } = yield call(() => axios.post('/api/materials', formData));
    yield put(createMaterialSuccess(data));
  } catch (err) {
    yield put(createMaterialFailure(err.response?.data?.message || err.message));
  }
}

export function* updateMaterial(action) {
  try {
    const { materialid, dto, file } = action.payload;
    const formData = new FormData();
    Object.entries(dto || {}).forEach(([k, v]) => formData.append(k, v));
    if (file) formData.append('file', file);
    const { data } = yield call(() => axios.put(`/api/materials/${materialid}`, formData));
    yield put(updateMaterialSuccess(data));
  } catch (err) {
    yield put(updateMaterialFailure(err.response?.data?.message || err.message));
  }
}

export function* deleteMaterial(action) {
  try {
    const { materialid } = action.payload;
    yield call(() => axios.delete(`/api/materials/${materialid}`));
    yield put(deleteMaterialSuccess(materialid));
  } catch (err) {
    yield put(deleteMaterialFailure(err.response?.data?.message || err.message));
  }
}

export default function* materialSaga() {
  yield takeLatest(fetchMaterialsRequest.type, fetchMaterials);
  yield takeLatest(fetchMaterialDetailRequest.type, fetchMaterialDetail);
  yield takeLatest(createMaterialRequest.type, createMaterial);
  yield takeLatest(updateMaterialRequest.type, updateMaterial);
  yield takeLatest(deleteMaterialRequest.type, deleteMaterial);
}