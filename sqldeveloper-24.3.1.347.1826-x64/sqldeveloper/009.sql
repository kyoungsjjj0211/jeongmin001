create sequence post_seq --;
start with 1
increment by 1
nocache
nocycle;

create table post(
    id          number not null, -- PRIMARY KEY
    app_user_id number not null,
    title varchar2(200) not null,
    content clob not null,
    pass varchar2(100),
    created_at date default sysdate,
    hit number default 0,
    primary key(id)
    );
--    constraint fk_post_appuser foreign key (app_user_id)
--    references appuser(app_user_id)
--    );

1. [글쓰기]글쓰기 sql :
insert into post (id, app_user_id, title, content, pass) values (post_seq.nextval, 1, 'title', 'content', '1111');

public int insert(PostDto dto){
    int result=-1;
    // 드 커 프 리
    return result;
}
2. [전체보기[ 전체글 가져오기, appuser 테이블에서  email도 같이 가져오기 sql :
select p.* , u.email
from post p join appuser u on p.app_user_id=u.app_user_id;

public ArrayList<PostDto dto> selectAll(){
ArrayList<PostDto dto>result = new ArrayList<>();
// 드 커 프 리
return result;
}

1. create sequence appuser_seq;
2. join.jsp 실행해서 회원가입

3. [상세보기] 글번호 해당하는 글가쟈오기 sql :

update post set hit = hit + 1 where id = 1;
select * from post where id = 1;

public PostDto select(int id){
    PostDto result = new PostDto();
    // 드 커 프 리
    return result;
}
    public int update_hit(int id){
    int result = -1;
    // 드 커 프 리
    return result;
    }

4. 글수정하기 sql : 
update post set title = 'new-title', content = 'new-content' where id = 1 and pass = '1111';

public int update (PostDto dto){
int result = -1;
// 드 커 프 리
return result;
}


5. 글번호 해당하는 삭제 
delete from post where id=1 and pass='1111'

public int delete (PostDto dto){
int result = -1;
// 드 커 프 리
return result;
}