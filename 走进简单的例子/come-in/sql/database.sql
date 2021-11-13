CREATE DATABASE come_in DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE come_in;

CREATE TABLE person (
  person_id       INT         NOT NULL AUTO_INCREMENT, # 数据库表ID
  person_phone    CHAR(11)    NOT NULL,                # 手机号码
  person_password CHAR(68)    NOT NULL,                # 密码
  person_name     VARCHAR(12) NOT NULL,                # 名字
  person_time     TIMESTAMP   NOT NULL,                # 注册时间
  PRIMARY KEY (person_id)                              # 添加主键
) ENGINE = INNODB;