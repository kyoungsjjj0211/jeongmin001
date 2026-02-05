import React, { useEffect, useState, useCallback } from 'react';
import { useRouter } from 'next/router';
import { useDispatch, useSelector } from 'react-redux';
import { Card, Form, Input, Button, Upload, message, Select, Row, Col, Spin } from 'antd';
import { UploadOutlined, ArrowLeftOutlined } from '@ant-design/icons';
// ✅ 리듀서에서 필요한 액션들 임포트
import { 
  fetchMaterialRequest, 
  updateMaterialRequest, 
  UPDATE_MATERIAL_RESET 
} from '../../../reducers/materialReducer';

export default function EditMaterialPage() {
  const router = useRouter();
  const dispatch = useDispatch();
  const { id } = router.query; // URL에서 materialid 추출
  const [form] = Form.useForm();
  
  const { user } = useSelector((s) => s.auth);
  const { currentMaterial, loading, updateMaterialDone } = useSelector((s) => s.material);
  const [fileList, setFileList] = useState([]);

  // 1. [권한 체크] 관리자가 아니면 튕겨내기
  useEffect(() => {
    if (user?.email !== '1@1') {
      message.warning("수정 권한이 없습니다.");
      router.push("/materials");
    }
  }, [user, router]);

  // 2. [데이터 로드] 수정할 기존 식재료 정보 불러오기
  useEffect(() => {
    if (id) {
      dispatch(fetchMaterialRequest({ materialid: id }));
    }
  }, [id, dispatch]);

  // 3. [데이터 바인딩] 불러온 정보를 폼에 채우기
  useEffect(() => {
    if (currentMaterial) {
      form.setFieldsValue(currentMaterial); // 기존 텍스트 데이터 매칭
      if (currentMaterial.image) {
        // 기존 이미지가 있다면 업로드 목록에 표시
        setFileList([{
          uid: '-1',
          name: 'current_image.png',
          status: 'done',
          url: currentMaterial.image,
        }]);
      }
    }
  }, [currentMaterial, form]);

  // 4. [수정 완료 처리]
  useEffect(() => {
    if (updateMaterialDone) {
      message.success('식재료 정보가 수정되었습니다.');
      dispatch(UPDATE_MATERIAL_RESET());
      router.push(`/materials/${id}`); // 수정 후 상세 페이지로 이동
    }
  }, [updateMaterialDone, router, id, dispatch]);

  // 5. [제출 핸들러]
  const onFinish = useCallback((values) => {
    const formData = {
      materialid: id, // 어떤걸 수정할지 ID 포함
      dto: { ...values },
      // 새 파일이 추가되었다면 originFileObj를, 아니면 null 전송
      file: fileList[0]?.originFileObj || null, 
    };
    dispatch(updateMaterialRequest(formData));
  }, [dispatch, id, fileList]);

  if (loading && !currentMaterial) return <div style={{ textAlign: 'center', padding: '50px' }}><Spin size="large" /></div>;

  return (
    <Card 
      title={<span><ArrowLeftOutlined onClick={() => router.back()} style={{ marginRight: 10, cursor: 'pointer' }} /> 식재료 정보 수정</span>} 
      style={{ maxWidth: 800, margin: "20px auto" }}
    >
      <Form form={form} layout="vertical" onFinish={onFinish}>
        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="title" label="식재료명" rules={[{ required: true, message: '이름을 입력하세요' }]}>
              <Input />
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

        <Row gutter={16}>
          <Col span={8}>
            <Form.Item name="season" label="제철"><Input /></Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item name="temperature" label="보관 온도"><Input /></Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item name="calories100g" label="칼로리(100g당)"><Input suffix="kcal" /></Form.Item>
          </Col>
        </Row>

        <Form.Item name="efficacy" label="효능"><Input.TextArea rows={2} /></Form.Item>
        <Form.Item name="buyguide" label="고르는 법"><Input.TextArea rows={2} /></Form.Item>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="trimguide" label="손질법"><Input.TextArea rows={3} /></Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="storeguide" label="보관법"><Input.TextArea rows={3} /></Form.Item>
          </Col>
        </Row>

        <Form.Item name="allergy" label="알레르기 주의사항"><Input /></Form.Item>

        <Form.Item label="이미지 변경 (변경 시에만 업로드)">
          <Upload
            listType="picture-card"
            fileList={fileList}
            onChange={({ fileList }) => setFileList(fileList)}
            beforeUpload={() => false}
            maxCount={1}
          >
            {fileList.length < 1 && <div><UploadOutlined /><div style={{ marginTop: 8 }}>업로드</div></div>}
          </Upload>
        </Form.Item>

        <Button type="primary" htmlType="submit" loading={loading} block size="large">
          수정사항 저장하기
        </Button>
      </Form>
    </Card>
  );
}