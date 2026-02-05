import { useState, useEffect, useMemo, useCallback } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Spin, message, Tabs, Button, Modal, Form, Input, Upload, Radio } from "antd"; 
import { PlusOutlined, UploadOutlined, FilterOutlined } from "@ant-design/icons";
import InfiniteScroll from "react-infinite-scroll-component";

// 컴포넌트 및 액션 임포트
import MaterialList from "../components/MaterialList"; 
import PostList from "../components/PostList";
import EditPostModal from "../components/EditPostModal";

import { LOAD_MATERIALS_REQUEST, ADD_MATERIAL_REQUEST } from "../reducers/material";
import { 
    fetchPostsPagedRequest, 
    fetchCategoryPostsRequest, 
    fetchLikedPostsRequest, 
    fetchMyAndRetweetsRequest, 
    updatePostRequest,
    UPDATE_POST_RESET 
} from "../reducers/postReducer";
import { addLikeRequest, removeLikeRequest, fetchMyLikesRequest } from "../reducers/likeReducer";
import { toggleFollowRequest, loadFollowingsRequest } from "../reducers/followReducer";
import { fetchMyRetweetsRequest } from "../reducers/retweetReducer";

export default function Home() {
    const dispatch = useDispatch();
    const [form] = Form.useForm();

    //// 1. Reducer 상태 추출
    const { user } = useSelector((state) => state.auth);
    const { posts, likedPosts, myAndRetweets, loading, hasNext, updatePostDone } = useSelector((state) => state.post);
    const { likes = {}, likesCount = {}, loading: likeLoading } = useSelector((state) => state.like);
    const { followingsMap, loading: followLoading } = useSelector((state) => state.follow);
    const { retweets, retweetsCount } = useSelector((state) => state.retweet);
    const { mainMaterials, loadMaterialsLoading } = useSelector((state) => state.material);

    //// 2. UI 제어용 로컬 상태
    const [expandedPostId, setExpandedPostId] = useState(null);
    const [isEditModalVisible, setIsEditModalVisible] = useState(false);
    const [editPost, setEditPost] = useState(null);
    const [uploadFiles, setUploadFiles] = useState([]);
    const [pageAll, setPageAll] = useState(1);
    const [currentCategory, setCurrentCategory] = useState("전체"); 
    
    const [isMaterialModalVisible, setIsMaterialModalVisible] = useState(false);
    const [materialFile, setMaterialFile] = useState(null);

    //// 3. 이벤트 핸들러

    // ✅ 수정 성공 후 처리 로직
    useEffect(() => {
        if (updatePostDone) {
            message.success("레시피가 수정되었습니다.");
            setIsEditModalVisible(false);
            setEditPost(null);
            setUploadFiles([]);
            dispatch({ type: UPDATE_POST_RESET });
        }
    }, [updatePostDone, dispatch]);

    const handleEdit = useCallback((post) => { 
        setEditPost(post); 
        setIsEditModalVisible(true); 
        setUploadFiles([]); 
    }, []);

    const handleEditSubmit = useCallback((values) => {
        if (!editPost) return;
        dispatch(updatePostRequest({
            postId: editPost.id,
            dto: {
                title: values.title,
                category: values.category,
                servingSize: values.servingSize,
                difficulty: values.difficulty,
                description: values.description, 
                instructions: values.instructions, 
                content: values.instructions, 
                ingredients: values.ingredients,
                hashtags: Array.isArray(values.hashtags) ? values.hashtags.join(",") : values.hashtags,
            },
            files: uploadFiles.map(f => f.originFileObj).filter(Boolean), 
        }));
    }, [dispatch, editPost, uploadFiles]);

    const onSaveMaterial = useCallback((values) => {
        const formData = new FormData();
        formData.append("title", values.title);
        formData.append("category", values.category);
        formData.append("allergy", values.allergy || "");
        formData.append("efficacy", values.efficacy || "");
        if (materialFile) formData.append("file", materialFile);

        dispatch({ type: ADD_MATERIAL_REQUEST, data: formData });
        setIsMaterialModalVisible(false);
        form.resetFields();
    }, [dispatch, materialFile, form]);

    const handleToggleLike = useCallback((postId) => {
        if (!user) return message.warning("로그인 후 이용 가능합니다.");
        const key = String(postId);
        likes[key] === true ? dispatch(removeLikeRequest({ postId })) : dispatch(addLikeRequest({ postId }));
    }, [user, likes, dispatch]);

    const handleToggleFollow = useCallback((authorId) => {
        if (!user) return message.warning("로그인 후 이용 가능합니다.");
        dispatch(toggleFollowRequest(authorId));
    }, [user, dispatch]);

    // ✅ 카테고리 변경 핸들러 보강
const onCategoryChange = useCallback((e) => {
    const category = e.target.value;
    setCurrentCategory(category);
    setPageAll(1); // 페이지 초기화

    if (category === "전체") {
        // ✅ '전체'일 때는 페이징 API 호출
        console.log("전체 카테고리 로드 시작");
        dispatch(fetchPostsPagedRequest({ page: 1, size: 10 }));
        setPageAll(2);
    } else {
        // ✅ 특정 카테고리 API 호출
        console.log(`${category} 카테고리 로드 시작`);
        dispatch(fetchCategoryPostsRequest({ category }));
    }
}, [dispatch]);

    // Home.js 내부의 useEffect 수정
useEffect(() => {
    dispatch(fetchPostsPagedRequest({ page: 1, size: 10 }));
    setPageAll(2);

    if (user) {
        dispatch(fetchPostsPagedRequest({ page: 1, size: 10 }));
        dispatch({ type: LOAD_MATERIALS_REQUEST, data: 1 });
        dispatch(fetchLikedPostsRequest({ page: 1, size: 10 }));
        // ✅ 여기서 호출하는 액션이 Saga의 /api/posts/my-activity를 찌릅니다.
        dispatch(fetchMyAndRetweetsRequest({ page: 1, size: 10 }));
        
        dispatch(fetchMyLikesRequest({ userId: user.id }));
        dispatch(fetchMyRetweetsRequest({ userId: user.id }));
        dispatch(loadFollowingsRequest());
    }
}, [dispatch, user]);

    // 무한 스크롤: "전체" 카테고리일 때만 작동
    const fetchMoreAll = useCallback(() => {
        if (!hasNext || currentCategory !== "전체") return;
        dispatch(fetchPostsPagedRequest({ page: pageAll, size: 10 }));
        setPageAll((prev) => prev + 1);
    }, [hasNext, currentCategory, pageAll, dispatch]);

    //// 5. 탭 구성
    const tabItems = useMemo(() => {
        const items = [];

        items.push({
            key: "all",
            label: "🍳 레시피 피드",
            children: (
                <div style={{ padding: '10px 0' }}>
                    {/* 카테고리 필터 영역 - 디저트 추가 완료 */}
                    <div style={{ textAlign: 'center', marginBottom: '20px', background: '#fff', padding: '15px', borderRadius: '8px', boxShadow: '0 2px 8px rgba(0,0,0,0.05)' }}>
                        <FilterOutlined style={{ marginRight: 8 }} />
                        <Radio.Group value={currentCategory} onChange={onCategoryChange} buttonStyle="solid">
                            <Radio.Button value="전체">전체</Radio.Button>
                            <Radio.Button value="한식">한식</Radio.Button>
                            <Radio.Button value="일식">일식</Radio.Button>
                            <Radio.Button value="중식">중식</Radio.Button>
                            <Radio.Button value="양식">양식</Radio.Button>
                            <Radio.Button value="디저트">디저트</Radio.Button>
                        </Radio.Group>
                    </div>

                    <InfiniteScroll
                        dataLength={posts.length}
                        next={fetchMoreAll}
                        hasMore={hasNext && currentCategory === "전체"}
                        loader={<Spin tip="더 불러오는 중..." style={{ display: 'block', margin: '20px auto' }} />}
                    >
                        <PostList
                            posts={posts} user={user} likes={likes} likesCount={likesCount}
                            retweetedPosts={retweets} retweetsCount={retweetsCount}
                            expandedPostId={expandedPostId} setExpandedPostId={setExpandedPostId}
                            handleToggleLike={handleToggleLike} 
                            handleToggleFollow={handleToggleFollow}
                            handleEdit={handleEdit} dispatch={dispatch} likeLoading={likeLoading}
                            followingsMap={followingsMap} followLoading={followLoading}
                            title={currentCategory === "전체" ? "모든 레시피" : `${currentCategory} 레시피`}
                        />
                    </InfiniteScroll>
                </div>
            )
        });

        if (user) {
            items.push({
                key: "material",
                label: "🍲 추천 식재료",
                children: (
                    <div style={{ padding: '20px' }}>
                        {user.email === '1@1' && (
                            <div style={{ marginBottom: 20, textAlign: 'right' }}>
                                <Button type="primary" icon={<PlusOutlined />} onClick={() => setIsMaterialModalVisible(true)}>
                                    식재료 추가 (관리자)
                                </Button>
                            </div>
                        )}
                        {loadMaterialsLoading && <Spin tip="재료 불러오는 중..." />}
                        <MaterialList materials={mainMaterials || []} />
                    </div>
                )
            });
        }


        if (user) {
            items.push(
                {
                    key: "liked",
                    label: "❤️ 좋아요",
                    children: <PostList posts={likedPosts} user={user} likes={likes} followingsMap={followingsMap} handleToggleLike={handleToggleLike} handleToggleFollow={handleToggleFollow} dispatch={dispatch} title="내가 찜한 레시피" />
                },
                // {
                //     key: "my",
                //     label: "👤 내 활동",
                //     children: <PostList posts={myAndRetweets} user={user} likes={likes} followingsMap={followingsMap} handleToggleLike={handleToggleLike} handleToggleFollow={handleToggleFollow} dispatch={dispatch} title="내 레시피 & 공유글" />
                // }
    {
      key: "myPosts",
      label: "👤 내 레시피",
      children: (
        <PostList
          posts={myAndRetweets.filter(p => p.authorId === user.id)} // ✅ 내가 작성한 글만
          user={user}
          likes={likes}
          followingsMap={followingsMap}
          handleToggleLike={handleToggleLike}
          handleToggleFollow={handleToggleFollow}
          dispatch={dispatch}
          title="내가 작성한 레시피"
        />
      )
    },
    {
      key: "myActivity",
      label: "📌 내 활동(작성글+리트윗)",
      children: (
        <PostList
          posts={myAndRetweets} // ✅ 기존 그대로 (작성글+리트윗)
          user={user}
          likes={likes}
          followingsMap={followingsMap}
          handleToggleLike={handleToggleLike}
          handleToggleFollow={handleToggleFollow}
          dispatch={dispatch}
          title="내 레시피 & 공유글"
        />
      )
    }


            );
        }
        return items;
    }, [user, currentCategory, mainMaterials, loadMaterialsLoading, posts, hasNext, likedPosts, myAndRetweets, handleToggleLike, handleToggleFollow, handleEdit, likes, likesCount, retweets, retweetsCount, expandedPostId, followingsMap, followLoading, likeLoading, onCategoryChange, fetchMoreAll]);

    return (
        <div style={{ background: '#f5f5f5', minHeight: '100vh' }}>
            <Tabs 
             defaultActiveKey="all"   // ✅ 항상 레시피 피드 탭부터 시작

                // activeKey={currentCategory === "전체" && !user ? "all" : undefined}
                // defaultActiveKey={user ? "material" : "all"} 
                centered 
                items={tabItems} 
                style={{ padding: '0 20px' }}
                onChange={(key) => {
                    if (key === "liked" && user) dispatch(fetchLikedPostsRequest({ page: 1, size: 10 }));
                    // if (key === "my" && user) dispatch(fetchMyAndRetweetsRequest({ page: 1, size: 10 }));
                    if ((key === "myPosts" || key === "myActivity") && user) {
      dispatch(fetchMyAndRetweetsRequest({ page: 1, size: 10 }));
    }

                }}
            />

            {/* 식재료 추가 모달 */}
            <Modal title="새 식재료 등록" open={isMaterialModalVisible} onCancel={() => setIsMaterialModalVisible(false)} onOk={() => form.submit()}>
                <Form form={form} layout="vertical" onFinish={onSaveMaterial}>
                    <Form.Item name="title" label="재료명" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="category" label="카테고리" rules={[{ required: true }]}><Input /></Form.Item>
                    <Form.Item name="allergy" label="알레르기 정보"><Input /></Form.Item>
                    <Form.Item name="efficacy" label="효능"><Input.TextArea rows={3} /></Form.Item>
                    <Form.Item label="재료 이미지">
                        <Upload beforeUpload={(file) => { setMaterialFile(file); return false; }} maxCount={1}>
                            <Button icon={<UploadOutlined />}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>
                </Form>
            </Modal>

            {/* 수정 모달 */}
            <EditPostModal
                visible={isEditModalVisible} 
                editPost={editPost}
                loading={loading}
                onCancel={() => {
                    setIsEditModalVisible(false);
                    setEditPost(null);
                }} 
                onSubmit={handleEditSubmit}
                uploadFiles={uploadFiles} 
                setUploadFiles={setUploadFiles}
            /> 
        </div>
    );
}