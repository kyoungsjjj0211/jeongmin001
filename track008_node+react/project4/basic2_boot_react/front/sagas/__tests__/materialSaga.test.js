import { expectSaga } from 'redux-saga-test-plan';
import { call } from 'redux-saga/effects';
import { throwError } from 'redux-saga-test-plan/providers';
import * as matchers from 'redux-saga-test-plan/matchers';

// 테스트할 대상들 import
import { 
  deleteMaterial, 
  createMaterial, 
  deleteMaterialAPI, 
  createMaterialAPI 
} from '../materialSaga';

// 리듀서 액션들 import
import { 
  deleteMaterialRequest, deleteMaterialSuccess, deleteMaterialFailure,
  createMaterialRequest, createMaterialSuccess, createMaterialFailure 
} from '../../reducers/materialReducer';

describe('Material Saga CRUD 테스트', () => {
  const materialId = 1;

  /**
   * 1. 삭제(Delete) 성공 케이스
   */
  it('식재료 삭제 성공 시 deleteMaterialSuccess 액션을 발생시킨다', () => {
    return expectSaga(deleteMaterial, deleteMaterialRequest(materialId))
      .provide([
        // deleteMaterialAPI가 materialId와 함께 호출되면 성공 응답을 시뮬레이션
        [call(deleteMaterialAPI, materialId), { status: 200 }]
      ])
      .put(deleteMaterialSuccess(materialId)) // 리듀서로 성공 액션이 가는지 확인
      .run();
  });

  /**
   * 2. 삭제(Delete) 실패 케이스
   */
  it('식재료 삭제 실패 시 deleteMaterialFailure 액션을 발생시킨다', () => {
    const errorMsg = '삭제 권한이 없습니다.';
    const error = { message: errorMsg };

    return expectSaga(deleteMaterial, deleteMaterialRequest(materialId))
      .provide([
        // API 호출 시 에러 발생 시뮬레이션
        [call(deleteMaterialAPI, materialId), throwError(error)]
      ])
      .put(deleteMaterialFailure(errorMsg)) // 실패 액션과 에러 메시지 확인
      .run();
  });

  /**
   * 3. 등록(Create) 성공 케이스 (Multipart/FormData)
   */
  it('식재료 등록 성공 시 createMaterialSuccess 액션을 발생시킨다', () => {
    const mockPayload = { 
      dto: { title: '유기농 배추', category: '채소류' }, 
      file: null 
    };
    const mockResponse = { 
      data: { materialid: 100, title: '유기농 배추' } 
    };

    return expectSaga(createMaterial, createMaterialRequest(mockPayload))
      .provide([
        /** * FormData는 객체 참조가 매번 다르므로 matchers.call.fn을 사용하여
         * createMaterialAPI 함수가 호출되는지만 검증하고 mockResponse를 반환합니다.
         */
        [matchers.call.fn(createMaterialAPI), mockResponse]
      ])
      .put(createMaterialSuccess(mockResponse.data))
      .run();
  });

  /**
   * 4. 등록(Create) 실패 케이스
   */
  it('식재료 등록 실패 시 createMaterialFailure 액션을 발생시킨다', () => {
    const mockPayload = { dto: { title: '에러 데이터' }, file: null };
    const errorMsg = '잘못된 형식의 데이터입니다.';

    return expectSaga(createMaterial, createMaterialRequest(mockPayload))
      .provide([
        [matchers.call.fn(createMaterialAPI), throwError(new Error(errorMsg))]
      ])
      .put(createMaterialFailure(errorMsg))
      .run();
  });
});