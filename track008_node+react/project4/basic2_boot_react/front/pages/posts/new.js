import { Card, Form, Input, Button, Upload, message, Select } from "antd";
import { UploadOutlined } from "@ant-design/icons";
import { useDispatch, useSelector } from "react-redux";
import { useRouter } from "next/router";
import { createPostRequest } from "../../reducers/postReducer";
import { useState, useEffect } from "react"; // useEffect 추가

export default function NewPostPage() {
    const router = useRouter();
    const dispatch = useDispatch();
    const { user } = useSelector((s) => s.auth);
    const { loading, error, createPostDone } = useSelector((s) => s.post); // createPostDone 추가 권장

    const [fileList, setFileList] = useState([]);

    // 1. [권한 제어] 1@1 아이디 체크 로직
    // 로그인이 안 되어 있거나 1@1이 아니면 접근 차단
    useEffect(() => {
        if (!user) {
            message.error("로그인이 필요합니다.");
            router.push("/login");
            return;
        }
        if (user.email !== '1@1') {
            message.warning("게시글 작성 권한이 없습니다 (관리자 전용).");
            router.push("/");
        }
    }, [user, router]);

    // 2. [에러 방지] 포스트 작성이 완료되면 그때 이동하도록 처리 (선택 사항)
    // 현재는 onFinish에서 즉시 이동하므로, 상태 업데이트 충돌을 피하기 위해 setTimeout 사용
    const onFinish = (values) => {
        const dto = {
            content: values.content,
            hashtags: values.hashtags ? values.hashtags.join(",") : "",
        };
        const files = fileList.map((f) => f.originFileObj);

        dispatch(createPostRequest({ dto, files }));
        message.success("게시글 작성 요청 완료");

        // ✅ 핵심 수정: 페이지 이동과 상태 변경을 아주 약간 뒤로 미뤄서
        // 현재 컴포넌트의 렌더링 사이클이 안전하게 끝나도록 합니다.
        setTimeout(() => {
            setFileList([]);
            router.push("/");
        }, 0);
    };

    if (!user || user.email !== '1@1') {
        return <Card style={{ textAlign: 'center', marginTop: 50 }}>접근 권한을 확인 중입니다...</Card>;
    }

    return (
        <Card title="게시글 작성 (관리자)" style={{ maxWidth: 600, margin: "20px auto" }}>
            <Form onFinish={onFinish} layout="vertical">
                <Form.Item
                    label="내용"
                    name="content"
                    rules={[{ required: true, message: '내용을 입력하세요' }]}
                >
                    <Input.TextArea rows={4} placeholder="게시글 내용을 입력하세요." />
                </Form.Item>

                <Form.Item label="해시태그" name="hashtags">
                    {/* Select 모드 설정 시 발생하는 내부 업데이트 충돌 방지 */}
                    <Select mode="tags" style={{ width: "100%" }} placeholder="해시태그 입력후 Enter" />
                </Form.Item>

                <Form.Item label="이미지 업로드">
                    <Upload 
                        multiple 
                        beforeUpload={() => false} 
                        fileList={fileList}
                        onChange={({ fileList }) => setFileList(fileList)}
                        listType="picture-card"
                    >
                        {fileList.length < 8 && (
                            <div>
                                <UploadOutlined />
                                <div style={{ marginTop: 8 }}>이미지 선택</div>
                            </div>
                        )}
                    </Upload>
                </Form.Item>

                <Button type="primary" htmlType="submit" loading={loading} block>
                    게시글 작성
                </Button>
                
                {/* 에러가 객체일 경우를 대비해 처리 */}
                {error && <p style={{ color: "red", marginTop: 10 }}>{typeof error === 'object' ? '서버 에러 발생' : error}</p>}
            </Form>
        </Card>
    );
}