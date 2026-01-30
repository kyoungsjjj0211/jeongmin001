import materialReducer, {
  fetchMaterialsRequest,
  fetchMaterialsSuccess,
  deleteMaterialSuccess
} from '../material'; // 파일명이 material.js인지 확인하세요!

describe('material 리듀서 테스트', () => {
  // 테스트에서 공통으로 사용할 초기 상태
  const initialState = {
    materials: [],
    currentMaterial: null,
    loading: false,
    error: null,
  };

  it('초기 상태를 반환해야 한다', () => {
    // Redux 내부에서 처음에 수행하는 동작 확인
    expect(materialReducer(undefined, { type: '@@INIT' })).toEqual(initialState);
  });

  it('fetchMaterialsRequest 시 loading 상태가 반영되어야 한다', () => {
    const state = materialReducer(initialState, fetchMaterialsRequest());
    expect(state.loading).toBe(true);
    expect(state.error).toBeNull();
  });

  it('fetchMaterialsSuccess 시 데이터가 저장되어야 한다', () => {
    const mockData = [
      { materialid: 1, title: '배추', createdat: '2024-01-01' },
      { materialid: 2, title: '무', createdat: '2024-01-02' }
    ];
    const state = materialReducer(initialState, fetchMaterialsSuccess(mockData));
    
    expect(state.loading).toBe(false);
    expect(state.materials).toEqual(mockData);
    expect(state.materials).toHaveLength(2);
  });

  it('deleteMaterialSuccess 시 해당 ID의 데이터만 제거되어야 한다', () => {
    // 1. 데이터가 있는 이전 상태 준비
    const prevState = {
      ...initialState,
      materials: [
        { materialid: 1, title: '배추' },
        { materialid: 2, title: '무' }
      ]
    };

    // 2. ID가 1인 항목 삭제 액션 실행
    // 리듀서 로직: m.materialid !== action.payload
    const state = materialReducer(prevState, deleteMaterialSuccess(1));

    // 3. 검증
    expect(state.materials).toHaveLength(1);
    expect(state.materials[0].materialid).toBe(2);
    expect(state.materials.find(m => m.materialid === 1)).toBeUndefined();
  });
});