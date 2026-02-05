import React, { useEffect, useCallback } from 'react';
import { useRouter } from 'next/router';
import { useDispatch, useSelector } from 'react-redux';
import { Card, Descriptions, Button, Divider, Tag, Spin, Modal, message } from 'antd';
import { ArrowLeftOutlined, EditOutlined, DeleteOutlined } from '@ant-design/icons';
// ✅ delete 관련 액션 추가
import { 
    fetchMaterialRequest, 
    deleteMaterialRequest, 
    DELETE_MATERIAL_RESET 
} from '../../reducers/materialReducer';

const MaterialDetail = () => {
    const router = useRouter();
    const dispatch = useDispatch();
    const { id } = router.query; 
    
    const { currentMaterial, loading, error, deleteMaterialDone } = useSelector((state) => state.material);
    const { user } = useSelector((state) => state.auth);

    // 1. 상세 정보 데이터 로드
    useEffect(() => {
        if (id) {
            dispatch(fetchMaterialRequest({ materialid: id }));
        }
    }, [id, dispatch]);

    // 2. ✅ 삭제 완료 시 처리 로직
    useEffect(() => {
        if (deleteMaterialDone) {
            message.success('식재료가 성공적으로 삭제되었습니다.');
            dispatch(DELETE_MATERIAL_RESET()); // 상태 초기화
            router.push('/materials'); // 목록 페이지로 이동
        }
    }, [deleteMaterialDone, dispatch, router]);

    // 3. ✅ 삭제 버튼 핸들러 (모달 확인)
    const onDelete = useCallback(() => {
        Modal.confirm({
            title: '식재료 삭제',
            content: '정말로 이 식재료를 삭제하시겠습니까? 삭제된 정보는 복구할 수 없습니다.',
            okText: '삭제',
            okType: 'danger',
            cancelText: '취소',
            onOk() {
                dispatch(deleteMaterialRequest(id)); // 삭제 요청 디스패치
            },
        });
    }, [dispatch, id]);

    // 로딩 처리
    if (loading || !currentMaterial) {
        return <div style={{ textAlign: 'center', padding: '50px' }}><Spin size="large" tip="로딩 중..." /></div>;
    }

    // 에러 처리
    if (error) {
        return <Card style={{ margin: '20px' }}>에러가 발생했습니다: {error}</Card>;
    }

    return (
        <div style={{ padding: '20px', maxWidth: '900px', margin: '0 auto' }}>
            <Button 
                icon={<ArrowLeftOutlined />} 
                onClick={() => router.push('/materials')} 
                style={{ marginBottom: '20px' }}
            >
                목록으로 돌아가기
            </Button>

            <Card
                cover={
                    currentMaterial.image && (
                        <img 
                            alt={currentMaterial.title} 
                            src={currentMaterial.image} 
                            style={{ maxHeight: '400px', objectFit: 'cover' }} 
                        />
                    )
                }
                // ✅ 관리자 계정(1@1)일 때만 수정/삭제 버튼 노출
                actions={
                    user?.email === '1@1' ? [
                        <Button 
                            type="link" 
                            icon={<EditOutlined />} 
                            onClick={() => router.push(`/materials/edit/${id}`)}
                        >
                            수정하기
                        </Button>,
                        <Button 
                            type="link" 
                            danger 
                            icon={<DeleteOutlined />} 
                            onClick={onDelete}
                        >
                            삭제하기
                        </Button>
                    ] : []
                }
            >
                <Card.Meta 
                    title={<h1 style={{ fontSize: '28px', margin: 0 }}>{currentMaterial.title}</h1>}
                    description={<Tag color="green">{currentMaterial.category}</Tag>}
                />
                
                <Divider />

                <Descriptions title="상세 정보" bordered column={1}>
                    <Descriptions.Item label="제철">{currentMaterial.season || '정보 없음'}</Descriptions.Item>
                    <Descriptions.Item label="보관 온도">{currentMaterial.temperature || '정보 없음'}</Descriptions.Item>
                    <Descriptions.Item label="칼로리 (100g)">{currentMaterial.calories100g ? `${currentMaterial.calories100g} kcal` : '정보 없음'}</Descriptions.Item>
                    <Descriptions.Item label="주요 효능">{currentMaterial.efficacy || '내용이 없습니다.'}</Descriptions.Item>
                    <Descriptions.Item label="고르는 법">{currentMaterial.buyguide || '내용이 없습니다.'}</Descriptions.Item>
                    <Descriptions.Item label="손질법">{currentMaterial.trimguide || '내용이 없습니다.'}</Descriptions.Item>
                    <Descriptions.Item label="보관법">{currentMaterial.storeguide || '내용이 없습니다.'}</Descriptions.Item>
                    <Descriptions.Item label="알레르기 주의">{currentMaterial.allergy || '특이사항 없음'}</Descriptions.Item>
                </Descriptions>
            </Card>
        </div>
    );
};

export default MaterialDetail;