import { call, put } from 'redux-saga/effects';
import { updateMaterial } from '../materialSaga'; // 경로 수정 완료
import { updateMaterialSuccess, updateMaterialFailure } from '../../reducers/material'; // 경로 수정 완료
import axios from '../../api/axios';

describe('Material Saga 테스트', () => {
  const action = {
    payload: {
      materialid: 1,
      dto: { title: '수정된 배추' },
      file: null
    }
  };

  it('식재료 수정 성공 시 updateMaterialSuccess를 디스패치해야 한다', () => {
    const generator = updateMaterial(action);
    const mockResponse = { data: { materialid: 1, title: '수정된 배추' } };

    generator.next(); // FormData 생성 및 call 준비
    const putEffect = generator.next(mockResponse).value;

    expect(putEffect).toEqual(put(updateMaterialSuccess(mockResponse.data)));
    expect(generator.next().done).toBe(true);
  });

  it('실패 시 updateMaterialFailure를 디스패치해야 한다', () => {
    const generator = updateMaterial(action);
    const error = { response: { data: { message: '수정 에러' } } };

    generator.next();
    const putEffect = generator.throw(error).value;

    expect(putEffect).toEqual(put(updateMaterialFailure('수정 에러')));
  });
});