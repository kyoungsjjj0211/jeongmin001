import React from "react";
import { Card, List, Carousel, Image, Row, Col, Tag, Typography } from "antd";
import { CalendarOutlined, tagOutlined } from "@ant-design/icons";
import Link from "next/link";

import EditDeleteButtons from "./EditDeleteButtons"; // 기존 컴포넌트 재사용 가정
import { deleteMaterialRequest } from "../reducers/material";

const { Text } = Typography;

export default function MaterialCard({
  material,
  user,
  dispatch,
  handleEdit,
}) {
  // 이미지 경로 처리 (서버 주소와 결합)
  const imageUrl = material?.imageurl 
    ? `${process.env.NEXT_PUBLIC_API_BASE_URL}/${material.imageurl}`
    : null;

  return (
    <Card 
      style={{ marginBottom: "30px", borderRadius: "12px", overflow: "hidden" }}
      hoverable
    >
      <List.Item style={{ borderBottom: "none", padding: 0 }}>
        
        {/* 1. 이미지 영역 (Carousel 패턴 유지) */}
        {imageUrl && (
          <div style={{ textAlign: "center", marginBottom: "15px" }}>
            <Image
              src={imageUrl}
              alt={material?.title}
              style={{ 
                width: "100%", 
                maxHeight: "300px", 
                borderRadius: "12px", 
                objectFit: "cover" 
              }}
              fallback="/images/default-material.png" // 이미지 없을 때 기본 이미지
            />
          </div>
        )}

        {/* 2. 메타 정보 영역 */}
        <List.Item.Meta
          title={
            <div style={{ fontSize: "18px", fontWeight: "bold" }}>
              {material?.title}
              <Tag color="green" style={{ marginLeft: "10px" }}>{material?.category}</Tag>
            </div>
          }
          description={
            <>
              {/* 제철 정보 */}
              <div style={{ marginBottom: "8px" }}>
                <CalendarOutlined style={{ marginRight: "5px" }} />
                <Text type="secondary">추천 제철: </Text>
                <Text strong color="orange">{material?.season}</Text>
              </div>

              {/* 상세 내용 (생략 처리 가능) */}
              <div style={{ 
                whiteSpace: "pre-line", 
                marginBottom: "12px", 
                color: "#444",
                minHeight: "40px" 
              }}>
                {material?.content || "상세 설명이 없습니다."}
              </div>

              {/* 작성 정보 */}
              <div style={{ fontSize: "12px", color: "#999" }}>
                등록일: {material?.createdat ? new Date(material.createdat).toLocaleDateString() : "-"}
              </div>
            </>
          }
        />

        {/* 3. 하단 버튼 영역 */}
        <Row justify="end" align="middle" style={{ marginTop: "15px" }}>
          <Col>
            {/* 수정/삭제 버튼 (작성자 본인이나 관리자일 경우) */}
            <EditDeleteButtons
              post={material} // 덕타이핑을 위해 material 전달
              user={user}
              onEdit={() => handleEdit(material)}
              dispatch={dispatch}
              deletePostRequest={deleteMaterialRequest} // 식재료 삭제 액션 연결
            />
          </Col>
        </Row>
      </List.Item>
    </Card>
  );
}