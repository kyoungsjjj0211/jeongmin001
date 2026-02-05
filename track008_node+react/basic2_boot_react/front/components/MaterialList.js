// 파일 경로: components/MaterialList.js
import React from 'react';
import { List, Card, Button, Tag, Typography } from 'antd';
import { useDispatch } from 'react-redux';
import { REMOVE_MATERIAL_REQUEST } from '../reducers/material';

const { Text } = Typography;

const MaterialList = ({ materials, loading }) => {
  const dispatch = useDispatch();

  const onRemove = (id) => () => {
    if (window.confirm('식재료 정보를 삭제하시겠습니까?')) {
      dispatch({ type: REMOVE_MATERIAL_REQUEST, data: id });
    }
  };

  return (
    <List
      grid={{ gutter: 16, xs: 1, sm: 2, md: 3 }}
      dataSource={materials}
      loading={loading}
      renderItem={(item) => (
        <List.Item>
          <Card 
            hoverable
            title={item.title} 
            extra={<Button danger size="small" onClick={onRemove(item.materialid)}>삭제</Button>}
            cover={item.imageurl && <img alt={item.title} src={item.imageurl} style={{ height: 200, objectFit: 'cover' }} />}
          >
            <div style={{ marginBottom: '8px' }}>
              <Tag color="green">{item.category}</Tag>
              <Tag color="gold">{item.season}</Tag>
            </div>
            <Text type="secondary">효능: </Text>
            <Text ellipsis={{ tooltip: item.efficacy }} style={{ width: '100%' }}>
              {item.efficacy}
            </Text>
            <div style={{ marginTop: '8px' }}>
              <Text type="secondary">칼로리: </Text><Text strong>{item.calories100g}kcal</Text>
            </div>
          </Card>
        </List.Item>
      )}
    />
  );
};

export default MaterialList;