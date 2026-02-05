// ✅ 수정: materialSlice.actions에서 액션 생성자를 가져와야 합니다.
import materialReducer, { deleteMaterialSuccess } from '../materialReducer';

describe('Material Reducer CRUD', () => {
  it('삭제 성공 시 목록에서 해당 아이템이 제거되어야 한다', () => {
    const initialState = {
      materials: [
        { materialid: 1, title: '당근' }, 
        { materialid: 2, title: '양파' }
      ],
      currentMaterial: null,
      loading: false,
      error: null,
      deleteMaterialDone: false
    };

    // ✅ 수정: 액션 객체를 직접 만들지 않고 액션 생성자 함수를 호출합니다.
    // deleteMaterialSuccess(1)은 { type: 'material/deleteMaterialSuccess', payload: 1 }을 반환합니다.
    const action = deleteMaterialSuccess(1);
    
    const state = materialReducer(initialState, action);
    
    // 검증
    expect(state.materials).toHaveLength(1);
    expect(state.materials[0].materialid).toBe(2);
    expect(state.deleteMaterialDone).toBe(true); // 추가된 상태값도 검증 가능
  });
});