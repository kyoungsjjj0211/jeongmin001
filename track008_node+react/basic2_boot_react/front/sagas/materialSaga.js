// 파일 경로: sagas/materialSaga.js
import { all, fork, put, takeLatest, call } from 'redux-saga/effects';
import axios from 'axios';
import {
  LOAD_MATERIALS_REQUEST, LOAD_MATERIALS_SUCCESS, LOAD_MATERIALS_FAILURE,
  ADD_MATERIAL_REQUEST, ADD_MATERIAL_SUCCESS, ADD_MATERIAL_FAILURE,
  REMOVE_MATERIAL_REQUEST, REMOVE_MATERIAL_SUCCESS, REMOVE_MATERIAL_FAILURE,
} from '../reducers/material';

function loadMaterialsAPI(data) {
  // GET /api/materials?keyword=...&page=1&size=10
  return axios.get('/api/materials', { params: data });
}

function addMaterialAPI(data) {
  // POST /api/materials (FormData 전송)
  return axios.post('/api/materials', data);
}

function removeMaterialAPI(materialid) {
  // DELETE /api/materials/{materialid}
  return axios.delete(`/api/materials/${materialid}`);
}

function* loadMaterials(action) {
  try {
    const result = yield call(loadMaterialsAPI, action.data);
    yield put({ type: LOAD_MATERIALS_SUCCESS, data: result.data });
  } catch (err) {
    yield put({ type: LOAD_MATERIALS_FAILURE, error: err.response?.data || err.message });
  }
}

function* addMaterial(action) {
  try {
    const result = yield call(addMaterialAPI, action.data);
    yield put({ type: ADD_MATERIAL_SUCCESS, data: result.data });
  } catch (err) {
    yield put({ type: ADD_MATERIAL_FAILURE, error: err.response?.data || err.message });
  }
}

function* removeMaterial(action) {
  try {
    yield call(removeMaterialAPI, action.data);
    yield put({ type: REMOVE_MATERIAL_SUCCESS, data: action.data });
  } catch (err) {
    yield put({ type: REMOVE_MATERIAL_FAILURE, error: err.response?.data || err.message });
  }
}

function* watchLoadMaterials() { yield takeLatest(LOAD_MATERIALS_REQUEST, loadMaterials); }
function* watchAddMaterial() { yield takeLatest(ADD_MATERIAL_REQUEST, addMaterial); }
function* watchRemoveMaterial() { yield takeLatest(REMOVE_MATERIAL_REQUEST, removeMaterial); }

export default function* materialSaga() {
  yield all([fork(watchLoadMaterials), fork(watchAddMaterial), fork(watchRemoveMaterial)]);
}