import React, { useEffect, useState, useCallback } from 'react';
import { Card, Form, Input, Button, Upload, Select, Row, Col, message } from 'antd';
import { UploadOutlined } from '@ant-design/icons';
import { useDispatch, useSelector } from 'react-redux';
import { useRouter } from 'next/router';
import { createMaterialRequest, CREATE_MATERIAL_RESET } from '../../reducers/materialReducer';

export default function NewMaterialPage() {
  const router = useRouter();
  const dispatch = useDispatch();
  const [form] = Form.useForm();
  const { user } = useSelector((s) => s.auth);
  const { loading, createMaterialDone } = useSelector((s) => s.material);
  const [fileList, setFileList] = useState([]);

  useEffect(() => {
    // ✅ 관리자 '1@1' 체크 삭제 -> 로그인 여부만 확인
    if (!user) {
      message.warning("로그인이 필요한 서비스입니다.");
      router.push("/login");
    }
  }, [user]);

  useEffect(() => {
    if (createMaterialDone) {
      message.success('내 냉장고 리스트에 추가되었습니다.');
      dispatch(CREATE_MATERIAL_RESET());
      router.push('/materials');
    }
  }, [createMaterialDone]);

  const onFinish = useCallback((values) => {
    dispatch(createMaterialRequest({
      dto: values, // ✅ 폼에 입력된 모든 필드 전송
      file: fileList[0]?.originFileObj,
    }));
  }, [fileList, dispatch]);

  return (
    <Card title="내 냉장고 속 재료 등록" style={{ maxWidth: 800, margin: "20px auto" }}>
      <Form form={form} layout="vertical" onFinish={onFinish}>
        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="title" label="재료명" rules={[{ required: true, message: '재료명을 입력하세요' }]}>
              <Input placeholder="예: 유기농 달걀" />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="category" label="보관 장소">
              <Select placeholder="장소 선택">
                <Select.Option value="냉장">냉장</Select.Option>
                <Select.Option value="냉동">냉동</Select.Option>
                <Select.Option value="실온">실온</Select.Option>
              </Select>
            </Form.Item>
          </Col>
        </Row>
        
        <Row gutter={16}>
          <Col span={8}><Form.Item name="season" label="구매날짜/유통기한"><Input placeholder="2023-11-01" /></Form.Item></Col>
          <Col span={8}><Form.Item name="temperature" label="보관 온도"><Input placeholder="4°C" /></Form.Item></Col>
          <Col span={8}><Form.Item name="calories100g" label="칼로리(100g)"><Input suffix="kcal" /></Form.Item></Col>
        </Row>

        <Form.Item name="efficacy" label="재료 상태/참고 사항">
          <Input.TextArea rows={2} placeholder="현재 상태나 간단한 메모를 적어주세요." />
        </Form.Item>
        
        <Form.Item name="storeguide" label="나만의 보관 꿀팁">
          <Input.TextArea rows={2} placeholder="다른 사람들에게 공유할 보관법" />
        </Form.Item>

        <Form.Item label="사진 업로드">
          <Upload 
            listType="picture-card" 
            fileList={fileList} 
            onChange={({ fileList }) => setFileList(fileList)} 
            beforeUpload={() => false}
          >
            {fileList.length < 1 && <UploadOutlined />}
          </Upload>
        </Form.Item>

        <Button type="primary" htmlType="submit" loading={loading} block size="large">
          냉장고에 넣기
        </Button>
      </Form>
    </Card>
  );
}