import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { 
  Card, Spin, Form, Input, Button, Upload, List, Tabs, Select, message 
} from "antd";
import { UploadOutlined, PlusOutlined } from "@ant-design/icons";
import { useRouter } from "next/router";

import api from "../api/axios";
import { wrapper } from "../store/configureStore";
import MaterialCard from "../components/MaterialCard"; // 앞서 만든 카드 컴포넌트
import { 
  fetchMaterialsRequest, 
  createMaterialRequest,
  fetchMaterialsPagedRequest 
} from "../reducers/material";
import { loginSuccess, logout } from "../reducers/authReducer";

const { TabPane } = Tabs;
const { Option } = Select;

export default function MaterialsPage() {
  const dispatch = useDispatch();
  const router = useRouter();
  const [form] = Form.useForm();
  
  // 스토어에서 상태 가져오기
  const { user, loading: authLoading } = useSelector((state) => state.auth);
  const { materials, loading: materialLoading } = useSelector((state) => state.material);

  // 1. 사용자 인증 확인 (클라이언트 사이드)
  useEffect(() => {
    const verify = async () => {
      try {
        const token = localStorage.getItem("accessToken");
        if (!token) {
          router.replace("/login");
          return;
        }
        const me = await api.get("/auth/me", {
          headers: { Authorization: `Bearer ${token}` },
          withCredentials: true,
        });
        if (me?.data && me.data.nickname) {
          dispatch(loginSuccess({ user: me.data }));
        } else {
          dispatch(logout());
          router.replace("/login");
        }
      } catch (error) {
        dispatch(logout());
        router.replace("/login");
      }
    };
    verify();
  }, [dispatch, router]);

  // 2. 초기 데이터 로드 (식재료 목록)
  useEffect(() => {
    if (user) {
      dispatch(fetchMaterialsRequest({ page: 0, size: 10 }));
    }
  }, [user, dispatch]);

  // 등록용 파일 상태
  const [fileList, setFileList] = useState([]);

  // 등록 핸들러
  const onFinish = (values) => {
    const file = fileList[0]?.originFileObj;
    dispatch(createMaterialRequest({
      dto: {
        title: values.title,
        category: values.category,
        season: values.season,
        content: values.content,
      },
      file
    }));
    form.resetFields();
    setFileList([]);
    message.success("식재료가 성공적으로 등록되었습니다.");
  };

  if (authLoading) return <div style={{ textAlign: 'center', marginTop: 50 }}><Spin size="large" /></div>;
  if (!user) return null;

  return (
    <Card title="식재료 관리 센터" style={{ maxWidth: 1000, margin: "20px auto", borderRadius: "12px" }}>
      <Tabs defaultActiveKey="list">
        
        {/* 식재료 목록 탭 */}
        <TabPane tab={`전체 식재료 (${materials.length})` } key="list">
          <List
            grid={{ gutter: 16, xs: 1, sm: 2, md: 2, lg: 2, xl: 2, xxl: 2 }}
            loading={materialLoading}
            dataSource={materials}
            renderItem={(item) => (
              <List.Item>
                <MaterialCard 
                  material={item} 
                  user={user} 
                  dispatch={dispatch}
                  handleEdit={(m) => router.push(`/materials/edit/${m.materialid}`)} 
                />
              </List.Item>
            )}
            loadMore={
              materials.length > 0 && (
                <div style={{ textAlign: 'center', marginTop: 12 }}>
                  <Button onClick={() => dispatch(fetchMaterialsPagedRequest({ page: 1, size: 10 }))}>
                    더 보기
                  </Button>
                </div>
              )
            }
          />
        </TabPane>

        {/* 식재료 등록 탭 (관리자 혹은 특정 권한용) */}
        <TabPane tab="새 식재료 등록" key="add">
          <Form
            form={form}
            layout="vertical"
            onFinish={onFinish}
            style={{ padding: "0 20px" }}
          >
            <Form.Item name="title" label="식재료명" rules={[{ required: true }]}>
              <Input placeholder="예: 유기농 배추" />
            </Form.Item>

            <Form.Item name="category" label="카테고리" rules={[{ required: true }]}>
              <Select placeholder="카테고리 선택">
                <Option value="채소">채소</Option>
                <Option value="과일">과일</Option>
                <Option value="수산물">수산물</Option>
                <Option value="육류">육류</Option>
              </Select>
            </Form.Item>

            <Form.Item name="season" label="제철 시기" rules={[{ required: true }]}>
              <Input placeholder="예: 11월 ~ 1월" />
            </Form.Item>

            <Form.Item name="content" label="상세 설명">
              <Input.TextArea rows={4} placeholder="식재료의 특징이나 보관법을 입력하세요" />
            </Form.Item>

            <Form.Item label="식재료 사진">
              <Upload
                beforeUpload={() => false}
                fileList={fileList}
                onChange={({ fileList }) => setFileList(fileList)}
                maxCount={1}
                listType="picture-card"
              >
                {fileList.length < 1 && (
                  <div>
                    <PlusOutlined />
                    <div style={{ marginTop: 8 }}>업로드</div>
                  </div>
                )}
              </Upload>
            </Form.Item>

            <Form.Item>
              <Button type="primary" htmlType="submit" icon={<UploadOutlined />} block size="large">
                식재료 등록하기
              </Button>
            </Form.Item>
          </Form>
        </TabPane>
      </Tabs>
    </Card>
  );
}

// 3. 서버사이드 렌더링 권한 체크 (패턴 유지)
export const getServerSideProps = wrapper.getServerSideProps((store) => async (ctx) => {
  try {
    const me = await api.get("/auth/me", {
      headers: { cookie: ctx.req.headers.cookie || "" },
      withCredentials: true,
    });

    if (me?.data && me.data.nickname) {
      store.dispatch(loginSuccess({ user: me.data }));
      return { props: {} };
    }
  } catch (error) {
    return {
      redirect: {
        destination: "/login",
        permanent: false,
      },
    };
  }
  return { props: {} };
});