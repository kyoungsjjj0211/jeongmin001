create table userinfo (
no     number       not null,
email  VARCHAR2(100) not null,
age    number
);

create sequence userinfo_seq

-- insert
insert into userinfo (no,email, age) values (1, '123@123', 25);
insert into userinfo (no, email, age) values (2, '321@321',30);


//select*from userinfo order by no desc;
//select * from userinfo where no=1
//update userinfo set email='a@a', age=100 where no =1
//delete from userinfo where no=1

-- select
select no, email, age 
from userinfo
where  no = 1;
-- where  no = 2;

-- update
update userinfo
set email='213@123',
    age  = 25
where no = 1;
--where no = 2;

delete from userinfo
where no=1;
-- where no = 2;


commit;
desc userinfo ;
select * from userinfo;

CREATE TABLE milk (
    mno     NUMBER        NOT NULL primary key,    
    mname   VARCHAR2(100) NOT NULL,    
    nnum    NUMBER        NOT NULL,    
    mtotal  NUMBER                     
    );
    
insert into milk (mno, mname, nnum, mtotal)
values (1, '서울우유', 10, 1000);

create sequence milk_seq


select mno, mname, nnum, mtotal
from milk
where mno=1;

select mno, mname,nnum,mtotal
from milk
order by mno desc;

update milk set mname= '매일우유',
                nnum = 20,
                mtotal = 200
where mno = 1;

delete from milk
where mno=1;

desc milk;
alter table milk
rename column nnum to mnum;

select * from milk;


drop table milk ;
