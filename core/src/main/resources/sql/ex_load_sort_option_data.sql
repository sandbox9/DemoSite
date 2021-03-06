# test
-- 확장 카테고리 매핑 테이블.
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (1);
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (2);
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (2001);
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (2002);
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (2003);
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (2004);
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (2005);
INSERT INTO `EX_CATEGORY` (`CATEGORY_ID`) VALUES (2006);

-- 정렬조건
INSERT INTO `EX_SORT_OPTION` (`SORT_OPTION_ID`,`DEFAULT_SORT_DIRECTION`,`DESCRIPTION`,`DISPLAY_TEXT`,`SORT_CONDITION`,`SORT_DIRECTION_TOGGLABLE`) VALUES (1,'ASC','인기상품순','popular','popular', 0);
INSERT INTO `EX_SORT_OPTION` (`SORT_OPTION_ID`,`DEFAULT_SORT_DIRECTION`,`DESCRIPTION`,`DISPLAY_TEXT`,`SORT_CONDITION`,`SORT_DIRECTION_TOGGLABLE`) VALUES (2,'ASC','이름순','title','title', 1);
INSERT INTO `EX_SORT_OPTION` (`SORT_OPTION_ID`,`DEFAULT_SORT_DIRECTION`,`DESCRIPTION`,`DISPLAY_TEXT`,`SORT_CONDITION`,`SORT_DIRECTION_TOGGLABLE`) VALUES (3,'ASC','가격순','price','price', 1);
INSERT INTO `EX_SORT_OPTION` (`SORT_OPTION_ID`,`DEFAULT_SORT_DIRECTION`,`DESCRIPTION`,`DISPLAY_TEXT`,`SORT_CONDITION`,`SORT_DIRECTION_TOGGLABLE`) VALUES (4,'ASC','등록순','date','date', 1);

-- 카테고리별 정렬조건 매핑
INSERT INTO `EX_CAT_SORT_OPTION_XREF` (`CATEGORY_SORT_OPTION_ID`,`DISPLAY_ORDER`,`CATEGORY_ID`,`SORT_OTPION_ID`) VALUES (1,0,1,1);
INSERT INTO `EX_CAT_SORT_OPTION_XREF` (`CATEGORY_SORT_OPTION_ID`,`DISPLAY_ORDER`,`CATEGORY_ID`,`SORT_OTPION_ID`) VALUES (2,1,1,2);
INSERT INTO `EX_CAT_SORT_OPTION_XREF` (`CATEGORY_SORT_OPTION_ID`,`DISPLAY_ORDER`,`CATEGORY_ID`,`SORT_OTPION_ID`) VALUES (3,2,1,3);
INSERT INTO `EX_CAT_SORT_OPTION_XREF` (`CATEGORY_SORT_OPTION_ID`,`DISPLAY_ORDER`,`CATEGORY_ID`,`SORT_OTPION_ID`) VALUES (4,2,1,3);

-- 카테고리별 정렬조건 예외처리.
INSERT INTO `BLC_CAT_EXCL_SORT_OPTION_XREF` (`CATEGORY_ID`,`SORT_OPTION_ID`) VALUES (2002,1);