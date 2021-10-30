CREATE DATABASE sj_person_jdbc DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE sj_person_jdbc;

CREATE TABLE person (
    person_id     INT         NOT NULL AUTO_INCREMENT, # 数据库表ID
    person_name   VARCHAR(50) NOT NULL,                # 名字
    person_gender VARCHAR(50) NOT NULL,                # 性别
    PRIMARY KEY (person_id)                            # 添加主键
) ENGINE = INNODB;