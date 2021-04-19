select max(BOARD_NUM) from board;

insert into web_gradle_erp.board
(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE)
values(1, '홍길동', '1111', '마칠시간', '5시', 'test.txt', 0, 0, 0, 0, '2021-03-03');

select * from board;

insert into web_gradle_erp.board
(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF)
values(1, '홍길동', '1111', '마칠시간', '5시', 'test.txt', 0);

-- listcount
select count(*) from board;



-- list 페이징
/*
 * [1][2][3]
 * 
 * (page -1) * 10 => 1 page => 0부터 10개, 2 page => 10부터 10개, 3 page => 20부터 10개
 */

select BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT
	, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE
  from board
order by BOARD_RE_REF desc, BOARD_RE_SEQ asc
 limit 0, 10;

select BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT
	, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE
  from board 
order by BOARD_RE_REF desc, BOARD_RE_SEQ asc
 limit 10, 10;
 
-- 글 내용 보기
select BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT
	, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE
from board where BOARD_NUM = 3;
  
-- readCount
update board set BOARD_READCOUNT = BOARD_READCOUNT + 1 where BOARD_NUM = 39;

-- 글 삭제
select * from board where BOARD_NUM = 25;

delete from board where BOARD_NUM = 26;

select 1 from board where BOARD_NUM = 25 and BOARD_PASS = '1234';







