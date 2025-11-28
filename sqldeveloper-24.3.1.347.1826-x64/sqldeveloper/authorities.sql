create table authorities(
    userid varchar2(100) not null,
    auth varchar2(100) not null
);

alter table authorities rename column userid to email;

insert into authorities(email, auth) values ('1@1', 'MEMBER');
insert into authorities(email, auth) values ('1@1', 'ADMIN');

commit;

select u.email, password, auth
from appuser u,  authorities a
where u.email = a.email and u.email = '1@1';

select email, password, auth
from appuser natural join authorities
where email = '1@1';

select u.email, password, auth
from appuser u left join authorities a on (u.email = a.email)
where u.email = '1@1';

select email, password, auth
from appuser left join authorities using(email) 
where email = '1@1';




drop table authorities;



