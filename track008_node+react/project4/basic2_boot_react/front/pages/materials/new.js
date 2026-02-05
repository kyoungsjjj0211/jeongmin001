import React, { useEffect, useState, useCallback } from 'react';
import { Card, Form, Input, Button, Upload, InputNumber, message, Select, Row, Col } from 'antd';
import { UploadOutlined } from '@ant-design/icons';
import { useDispatch, useSelector } from 'react-redux';
import { useRouter } from 'next/router';
import { createMaterialRequest, CREATE_MATERIAL_RESET } from '../../reducers/materialReducer';

export default function NewMaterialPage() {
  const router = useRouter();
  const dispatch = useDispatch();
  const [form] = Form.useForm();
  
  const { user } = useSelector((s) => s.auth);
  const { loading, error, createMaterialDone } = useSelector((s) => s.material);
  const [fileList, setFileList] = useState([]);

  useEffect(() => {
    dispatch(CREATE_MATERIAL_RESET());
    if (!user || user.email !== '1@1') {
      message.warning("권한이 없습니다.");
      router.push("/");
    }
  }, [user, router, dispatch]);

  useEffect(() => {
    if (createMaterialDone) {
      message.success('재료가 성공적으로 등록되었습니다.');
      dispatch(CREATE_MATERIAL_RESET()); 
      router.push('/materials');
    }
  }, [createMaterialDone, router, dispatch]);

  const onFinish = useCallback((values) => {
    const formData = {
      dto: { ...values }, // 폼의 모든 값을 DTO로 전달
      file: fileList[0]?.originFileObj,
    };
    dispatch(createMaterialRequest(formData));
  }, [dispatch, fileList]);

  return (
    <Card title="새 재료 등록" style={{ maxWidth: 800, margin: "20px auto" }}>
      <Form form={form} layout="vertical" onFinish={onFinish}>
        {/* 1. 기본 정보 섹션 */}
        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="title" label="식재료명" rules={[{ required: true }]}>
              <Input placeholder="예: 고구마" />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="category" label="카테고리">
              <Select placeholder="선택하세요">
                <Select.Option value="채소류">채소류</Select.Option>
                <Select.Option value="육류">육류</Select.Option>
                <Select.Option value="해산물">해산물</Select.Option>
                <Select.Option value="곡류">곡류</Select.Option>
              </Select>
            </Form.Item>
          </Col>
        </Row>

        {/* 2. 상세 수치/특성 섹션 */}
        <Row gutter={16}>
          <Col span={8}>
            <Form.Item name="season" label="제철">
              <Input placeholder="예: 9월~10월" />
            </Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item name="temperature" label="보관 온도">
              <Input placeholder="예: 10~15℃" />
            </Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item name="calories100g" label="칼로리(100g당)">
              <Input placeholder="예: 128" suffix="kcal" />
            </Form.Item>
          </Col>
        </Row>

        {/* 3. 가이드 섹션 */}
        <Form.Item name="efficacy" label="효능">
          <Input.TextArea rows={2} placeholder="영양소 및 건강상 이점" />
        </Form.Item>

        <Form.Item name="buyguide" label="고르는 법">
          <Input.TextArea rows={2} placeholder="신선한 제품을 선택하는 팁" />
        </Form.Item>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="trimguide" label="손질법">
              <Input.TextArea rows={3} placeholder="깨끗하게 손질하는 방법" />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="storeguide" label="보관법">
              <Input.TextArea rows={3} placeholder="장기 보관 및 신선도 유지법" />
            </Form.Item>
          </Col>
        </Row>

        <Form.Item name="allergy" label="알레르기 주의사항">
          <Input placeholder="예: 해당 사항 없음 또는 특정 체질 주의" />
        </Form.Item>

        {/* 4. 이미지 섹션 */}
        <Form.Item label="재료 대표 이미지">
          <Upload
            listType="picture-card"
            fileList={fileList}
            onChange={({ fileList }) => setFileList(fileList)}
            beforeUpload={() => false}
            maxCount={1}
          >
            {fileList.length < 1 && (
              <div><UploadOutlined /><div style={{ marginTop: 8 }}>이미지 업로드</div></div>
            )}
          </Upload>
        </Form.Item>

        <Button type="primary" htmlType="submit" loading={loading} block size="large">
          식재료 등록하기
        </Button>
      </Form>
    </Card>
  );
}