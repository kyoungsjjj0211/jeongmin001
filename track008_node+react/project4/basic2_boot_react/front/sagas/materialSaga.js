import { call, put, takeLatest, all, fork } from 'redux-saga/effects';
import axios from '../api/axios';
import { message } from 'antd';
import {
  fetchMaterialsRequest, fetchMaterialsSuccess, fetchMaterialsFailure,
  fetchMaterialRequest, fetchMaterialSuccess, fetchMaterialFailure,
  fetchMaterialsPagedRequest, fetchMaterialsPagedSuccess, fetchMaterialsPagedFailure,
  createMaterialRequest, createMaterialSuccess, createMaterialFailure,
  updateMaterialRequest, updateMaterialSuccess, updateMaterialFailure,
  deleteMaterialRequest, deleteMaterialSuccess, deleteMaterialFailure,
} from '../reducers/materialReducer';

// 1. 전체 식재료 조회
export function* fetchMaterials() {
  try {
    const { data } = yield call(() => axios.get('/api/materials/all'));
    yield put(fetchMaterialsSuccess(data));
  } catch (err) {
    yield put(fetchMaterialsFailure(err.response?.data?.message || err.message));
  }
}

// 2. 단건 식재료 상세 조회
export function* fetchMaterial(action) {
  try {
    const { data } = yield call(() => axios.get(`/api/materials/${action.payload.materialid}`));
    yield put(fetchMaterialSuccess(data));
  } catch (err) {
    yield put(fetchMaterialFailure(err.response?.data?.message || err.message));
  }
}

// 3. 식재료 페이징 조회 (검색 포함)
export function* fetchMaterialsPaged(action) {
  try {
    const { keyword, page, size } = action.payload;
    // 백엔드: GET /api/materials?keyword=...&page=...&size=...
    const { data } = yield call(() => 
      axios.get(`/api/materials`, { params: { keyword, page, size } })
    );
    yield put(fetchMaterialsPagedSuccess({ data, page }));
  } catch (err) {
    const errorMsg = err.response?.data?.message || err.message;
    yield put(fetchMaterialsPagedFailure(errorMsg));
    message.error(errorMsg);
  }
}

// 4. 식재료 등록 (FormData 활용)
export function* createMaterial(action) {
  try {
    const { dto, file } = action.payload;
    const formData = new FormData();

    // DTO 데이터 추가 (MaterialRequestDto 필드 대응)
    formData.append('title', dto.title);
    formData.append('season', dto.season);
    formData.append('temperature', dto.temperature);
    formData.append('calories100g', dto.calories100g);
    formData.append('efficacy', dto.efficacy);
    formData.append('buyguide', dto.buyguide);
    formData.append('trimguide', dto.trimguide);
    formData.append('storeguide', dto.storeguide);
    formData.append('category', dto.category);
    formData.append('allergy', dto.allergy);

    // 단일 파일 추가
    if (file) {
      const actualFile = file.originFileObj ? file.originFileObj : file;
      formData.append('file', actualFile);
    }

    const { data } = yield call(() =>
      axios.post('/api/materials', formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
      })
    );

    yield put(createMaterialSuccess(data));
    message.success('식재료가 등록되었습니다.');
  } catch (err) {
    const errorMsg = err.response?.data?.message || err.message;
    yield put(createMaterialFailure(errorMsg));
    message.error('등록 실패: ' + errorMsg);
  }
}

// 5. 식재료 수정 (FormData 활용)
export function* updateMaterial(action) {
  try {
    const { materialid, dto, file } = action.payload;
    const formData = new FormData();

    formData.append('title', dto.title);
    formData.append('season', dto.season);
    formData.append('temperature', dto.temperature);
    formData.append('calories100g', dto.calories100g);
    formData.append('efficacy', dto.efficacy);
    formData.append('buyguide', dto.buyguide);
    formData.append('trimguide', dto.trimguide);
    formData.append('storeguide', dto.storeguide);
    formData.append('category', dto.category);
    formData.append('allergy', dto.allergy);

    if (file) {
      const actualFile = file.originFileObj ? file.originFileObj : file;
      formData.append('file', actualFile);
    }

    const { data } = yield call(() =>
      axios.put(`/api/materials/${materialid}`, formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
      })
    );

    yield put(updateMaterialSuccess(data));
    message.success('식재료 정보가 수정되었습니다.');
  } catch (err) {
    const errorMsg = err.response?.data?.message || err.message;
    yield put(updateMaterialFailure(errorMsg));
    message.error('수정 실패: ' + errorMsg);
  }
}

// 6. 식재료 삭제
export function* deleteMaterial(action) {
  try {
    const materialid = action.payload; // payload가 바로 id인 경우
    yield call(() => axios.delete(`/api/materials/${materialid}`));
    yield put(deleteMaterialSuccess(materialid));
    message.success('식재료가 삭제되었습니다.');
  } catch (err) {
    const errorMsg = err.response?.data?.message || err.message;
    yield put(deleteMaterialFailure(errorMsg));
    message.error('삭제 실패: ' + errorMsg);
  }
}

// 감시자
function* watchFetchMaterials() { yield takeLatest(fetchMaterialsRequest.type, fetchMaterials); }
function* watchFetchMaterial() { yield takeLatest(fetchMaterialRequest.type, fetchMaterial); }
function* watchFetchMaterialsPaged() { yield takeLatest(fetchMaterialsPagedRequest.type, fetchMaterialsPaged); }
function* watchCreateMaterial() { yield takeLatest(createMaterialRequest.type, createMaterial); }
function* watchUpdateMaterial() { yield takeLatest(updateMaterialRequest.type, updateMaterial); }
function* watchDeleteMaterial() { yield takeLatest(deleteMaterialRequest.type, deleteMaterial); }

export default function* materialSaga() {
  yield all([
    fork(watchFetchMaterials),
    fork(watchFetchMaterial),
    fork(watchFetchMaterialsPaged),
    fork(watchCreateMaterial),
    fork(watchUpdateMaterial),
    fork(watchDeleteMaterial),
  ]);
}