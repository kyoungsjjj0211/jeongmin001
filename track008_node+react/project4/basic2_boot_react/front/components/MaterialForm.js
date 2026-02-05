import React, { useCallback, useRef } from 'react';
import { Form, Input, Button } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { ADD_MATERIAL_REQUEST } from '../reducers/material';

const MaterialForm = () => {
  const { addMaterialLoading } = useSelector((state) => state.material);
  const dispatch = useDispatch();
  const imageInput = useRef();

  const onFinish = useCallback((values) => {
    const formData = new FormData();
    // 파일 추가
    if (imageInput.current.files[0]) {
      formData.append('file', imageInput.current.files[0]);
    }
    // DTO 필드 추가
    formData.append('title', values.title);
    formData.append('season', values.season);
    formData.append('category', values.category);
    formData.append('content', values.content); // 백엔드 efficacy 등 적절한 필드 매핑

    dispatch({ type: ADD_MATERIAL_REQUEST, data: formData });
  }, [dispatch]);

  return (
    <Form onFinish={onFinish} layout="vertical" style={{ padding: '20px', background: '#fff' }}>
      <Form.Item name="title" label="식재료명" rules={[{ required: true }]}>
        <Input />
      </Form.Item>
      <Form.Item name="category" label="카테고리">
        <Input placeholder="예: 채소, 과일" />
      </Form.Item>
      <Form.Item name="season" label="제철">
        <Input placeholder="예: 봄, 1월~3월" />
      </Form.Item>
      <input type="file" name="file" hidden ref={imageInput} />
      <Button onClick={() => imageInput.current.click()}>이미지 업로드</Button>
      <Button type="primary" htmlType="submit" loading={addMaterialLoading} style={{ float: 'right' }}>
        등록
      </Button>
    </Form>
  );
};

export default MaterialForm;