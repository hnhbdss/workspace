drop table r_comp
;
create table r_comp (
       sno int,
       imsi int,
       imsdn int,
       netype int, 
       proceduretype int,
       accesstime int,
       releasetime int                           
)
;

-- usn 
insert into r_comp values (1, 1, 1, 3, 1, 100, 150);

insert into r_comp values (2, 2, 2, 3, 2, 200, 250);

insert into r_comp values (3, 3, 3, 3, 3, 300, 350);

insert into r_comp values (4, 3, 3, 3, 3, 300, 350);

insert into r_comp values (5, 3, 3, 3, 4, 300, 350);   -- not fullish any one of procedure type

-- ugw
insert into r_comp values (100, 1, 1, 4, 10, 101, 103); -- fulllish with 1 

insert into r_comp values (101, 1, 1, 4, 10, 105, 109); -- not fullish with any one

insert into r_comp values (102, 1, 1, 4, 10, 104, 104); -- fullish with 1 

insert into r_comp values (103, 1, 1, 4, 10, 110, 115);

insert into r_comp values (104, 3, 3, 4, 10, 301, 304); -- fulllish with 3, 4 

insert into r_comp values (105, 3, 3, 4, 10, 302, 304); -- fulllish with 3, 4 

-- gxy 

insert into r_comp values (1000, 1, 1, 4, 100, 102, 102); -- fullish with 100 

insert into r_comp values (1001, 1, 1, 4, 100, 103, 103); -- fulllist with 100

insert into r_comp values (1002, 1, 1, 4, 101, 111, 112); -- fulllist with ugw 103

insert into r_comp values (1003, 3, 3, 4, 102, 302, 303); -- fullist with ugw 104, 105 

insert into r_comp values (1004, 3, 3, 4, 102, 303, 303); -- fullist with ugw 104, 105 

insert into r_comp values (1005, 3, 3, 4, 102, 310, 320); -- nothing with relation




