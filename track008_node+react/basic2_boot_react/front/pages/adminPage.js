import React, { useEffect, useState, useCallback } from 'react';
import { useRouter } from 'next/router'; 
import { useSelector } from 'react-redux';
import * as adminApi from '../api/adminApi';
import UserTable from '../components/UserTable'; 

const AdminPage = () => { 
    const reduxUser = useSelector((state) => state.auth?.user || state.user?.user);
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(false);
    const [isChecking, setIsChecking] = useState(true);
    const router = useRouter();

    const loadUsers = useCallback(async () => {
        try {
            setLoading(true);
            const response = await adminApi.fetchAllUsers();
            setUsers(response.data);
        } catch (error) {
            console.error("데이터 로딩 실패:", error);
            // 403 에러가 날 때만 메인으로 보냄 (단순 404/500 에러 시에는 유지)
            if (error.response?.status === 403) {
                alert("권한이 부족하거나 세션이 만료되었습니다.");
                router.push('/');
            }
        } finally {
            setLoading(false);
        }
    }, [router]);

    useEffect(() => {
        const getStoredUser = () => {
            if (typeof window !== 'undefined') {
                const item = localStorage.getItem('user');
                return item ? JSON.parse(item) : null;
            }
            return null;
        };

        const currentUser = reduxUser || getStoredUser();

        if (currentUser) {
            if (currentUser.role === 'ROLE_ADMIN') {
                setIsChecking(false);
                // 중복 호출 방지
                if (users.length === 0 && !loading) {
                    loadUsers();
                }
            } else {
                alert("관리자 권한이 없습니다.");
                router.push('/');
            }
        } else {
            // 유저 정보가 아예 로딩되지 않았을 때만 잠시 대기
            const timeout = setTimeout(() => {
                if (!reduxUser && !getStoredUser()) {
                    alert("로그인이 필요합니다.");
                    router.push('/login');
                }
            }, 1000);
            return () => clearTimeout(timeout);
        }
    }, [reduxUser, loadUsers, router]);

    const handleToggleStatus = async (userId) => {
        try {
            await adminApi.toggleUserStatus(userId);
            loadUsers(); 
        } catch (error) {
            alert("상태 변경 실패");
        }
    };

    const handleDeleteUser = async (userId) => {
        if (window.confirm("사용자를 강제 탈퇴시키겠습니까?")) {
            try {
                await adminApi.forceDeleteUser(userId);
                loadUsers();
            } catch (error) {
                alert("삭제 처리 실패");
            }
        }
    };

    if (isChecking) return <div style={{ padding: '50px', textAlign: 'center' }}>보안 검사 중...</div>;

    return (
        <div style={{ padding: '30px', maxWidth: '1200px', margin: '0 auto' }}>
            <h1>사용자 관리 시스템 (Admin)</h1>
            <p>전체 사용자: {users.length}명</p>
            {loading ? <p>로딩 중...</p> : (
                <UserTable users={users} onToggle={handleToggleStatus} onDelete={handleDeleteUser} />
            )}
        </div>
    );
};

export default AdminPage;