import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import AppLayout from '../components/AppLayout';
import MaterialForm from '../components/MaterialForm';
import MaterialList from '../components/MaterialList';
import { LOAD_MATERIALS_REQUEST } from '../reducers/material';

const Materials = () => {
  const dispatch = useDispatch();
  const { user } = useSelector((state) => state.auth);
  const { materials, loadMaterialsLoading } = useSelector((state) => state.material);

  useEffect(() => {
    dispatch({
      type: LOAD_MATERIALS_REQUEST,
      data: { page: 1, size: 10 } // 백엔드 기본값 대응
    });
  }, [dispatch]);

  return (
    <AppLayout>
      {user && <MaterialForm />}
      <MaterialList 
        materials={materials} 
        loading={loadMaterialsLoading} 
        user={user}
        dispatch={dispatch}
      />
    </AppLayout>
  );
};

export default Materials;