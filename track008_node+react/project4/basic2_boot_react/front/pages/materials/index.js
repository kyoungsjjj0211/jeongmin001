// pages/materials/index.js

import React, { useEffect } from 'react';
import { Button, List, Card } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { useRouter } from 'next/router'; 
import { fetchMaterialsPagedRequest } from '../../reducers/materialReducer';

const MaterialIndex = () => {
    const dispatch = useDispatch();
    const router = useRouter();
    const { materials, loading } = useSelector((state) => state.material);
    const { user } = useSelector((state) => state.auth);

    useEffect(() => {
        // 초기 데이터 로드 (1페이지, 10개씩)
        dispatch(fetchMaterialsPagedRequest({ page: 1, size: 10 }));
    }, [dispatch]);

    return (
        <div style={{ padding: '20px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '20px' }}>
                <h2>내 냉장고 속 재료 목록</h2>
                {/* 관리자일 경우에만 등록 버튼 노출 */}
                {user?.email === '1@1' && (
                    <Button type="primary" onClick={() => router.push('/materials/new')}>
                        새 재료 등록
                    </Button>
                )}
            </div>

            <List
                grid={{ gutter: 16, column: 4 }}
                dataSource={materials}
                loading={loading}
                renderItem={(item) => (
                    <List.Item>
                        <Card 
                            title={item.title} 
                            cover={item.image && <img alt={item.title} src={item.image} />}
                            onClick={() => router.push(`/materials/${item.materialid}`)}
                            hoverable
                        >
                            <Card.Meta description={item.category} />
                        </Card>
                    </List.Item>
                )}
            />
        </div>
    );
};

export default MaterialIndex;