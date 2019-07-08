--------------------------------------------------------
--  파일이 생성됨 - 금요일-7월-05-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SCORE
--------------------------------------------------------

  CREATE TABLE "ORA_USER"."SCORE" 
   (	"USER_ID" VARCHAR2(20 BYTE), 
	"RAIN_SCORE" NUMBER, 
	"MINE_SCORE" NUMBER, 
	"TOTAL_SCORE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into ORA_USER.SCORE
SET DEFINE OFF;
Insert into ORA_USER.SCORE (USER_ID,RAIN_SCORE,MINE_SCORE,TOTAL_SCORE) values ('AA',0,0,0);
Insert into ORA_USER.SCORE (USER_ID,RAIN_SCORE,MINE_SCORE,TOTAL_SCORE) values ('AAA',0,0,0);
Insert into ORA_USER.SCORE (USER_ID,RAIN_SCORE,MINE_SCORE,TOTAL_SCORE) values ('김경래',0,0,0);
Insert into ORA_USER.SCORE (USER_ID,RAIN_SCORE,MINE_SCORE,TOTAL_SCORE) values ('A',0,125,125);
--------------------------------------------------------
--  Constraints for Table SCORE
--------------------------------------------------------

  ALTER TABLE "ORA_USER"."SCORE" MODIFY ("USER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SCORE
--------------------------------------------------------

  ALTER TABLE "ORA_USER"."SCORE" ADD CONSTRAINT "SCORE_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES "ORA_USER"."USER0" ("USER_ID") ENABLE;
