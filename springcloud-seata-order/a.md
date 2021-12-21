

--------------------

USE seata_order;
CREATE TABLE t_order(
id BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
user_id BIGINT(11) DEFAULT NULL COMMENT '用户id',
product_id BIGINT(11) DEFAULT NULL COMMENT '产品id',
count INT(11) DEFAULT NULL COMMENT '数量',
money DECIMAL(11,0) DEFAULT NULL COMMENT '金额',
status INT(1) DEFAULT NULL COMMENT '订单状态：0创建中，1已完结'
)ENGINE=InnoDB AUTO_INCREMENT=7 CHARSET=utf8;



USE seata_storage;
CREATE TABLE t_storage(
id BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
product_id BIGINT(11) DEFAULT NULL COMMENT '产品id',
total INT(11) DEFAULT NULL COMMENT '总库存',
used INT(11) DEFAULT NULL COMMENT '已用库存',
residue INT(11) DEFAULT NULL COMMENT '剩余库存'
)ENGINE=InnoDB AUTO_INCREMENT=7 CHARSET=utf8;
INSERT INTO t_storage(id, product_id, total, used, residue) VALUES(1,1,100,0,100);



USE seata_account;
CREATE TABLE t_account(
id BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
user_id BIGINT(11) DEFAULT NULL COMMENT '用户id',
total DECIMAL(10,0) DEFAULT NULL COMMENT '总额度',
used DECIMAL(10,0) DEFAULT NULL COMMENT '已用额度',
residue DECIMAL(10,0) DEFAULT 0 COMMENT '剩余可用额度'
)ENGINE=InnoDB AUTO_INCREMENT=7 CHARSET=utf8;
INSERT INTO t_account(id, user_id, total, used, residue) VALUES(1,1,1000,0,1000);



-- -------------------------------- The script used when storeMode is 'db' --------------------------------
-- the table to store GlobalSession data
CREATE TABLE IF NOT EXISTS `global_table`
(
`xid`                       VARCHAR(128) NOT NULL,
`transaction_id`            BIGINT,
`status`                    TINYINT      NOT NULL,
`application_id`            VARCHAR(32),
`transaction_service_group` VARCHAR(32),
`transaction_name`          VARCHAR(128),
`timeout`                   INT,
`begin_time`                BIGINT,
`application_data`          VARCHAR(2000),
`gmt_create`                DATETIME,
`gmt_modified`              DATETIME,
PRIMARY KEY (`xid`),
KEY `idx_gmt_modified_status` (`gmt_modified`, `status`),
KEY `idx_transaction_id` (`transaction_id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- the table to store BranchSession data
CREATE TABLE IF NOT EXISTS `branch_table`
(
`branch_id`         BIGINT       NOT NULL,
`xid`               VARCHAR(128) NOT NULL,
`transaction_id`    BIGINT,
`resource_group_id` VARCHAR(32),
`resource_id`       VARCHAR(256),
`branch_type`       VARCHAR(8),
`status`            TINYINT,
`client_id`         VARCHAR(64),
`application_data`  VARCHAR(2000),
`gmt_create`        DATETIME(6),
`gmt_modified`      DATETIME(6),
PRIMARY KEY (`branch_id`),
KEY `idx_xid` (`xid`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- the table to store lock data
CREATE TABLE IF NOT EXISTS `lock_table`
(
`row_key`        VARCHAR(128) NOT NULL,
`xid`            VARCHAR(128),
`transaction_id` BIGINT,
`branch_id`      BIGINT       NOT NULL,
`resource_id`    VARCHAR(256),
`table_name`     VARCHAR(32),
`pk`             VARCHAR(36),
`gmt_create`     DATETIME,
`gmt_modified`   DATETIME,
PRIMARY KEY (`row_key`),
KEY `idx_branch_id` (`branch_id`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `distributed_lock`
(
`lock_key`       CHAR(20) NOT NULL,
`lock_value`     VARCHAR(20) NOT NULL,
`expire`         BIGINT,
primary key (`lock_key`)
) ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4;

INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('AsyncCommitting', ' ', 0);
INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('RetryCommitting', ' ', 0);
INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('RetryRollbacking', ' ', 0);
INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('TxTimeoutCheck', ' ', 0);

-- 在业务数据库中创建undo_log（与上面的脚本不在一个数据库中）
CREATE TABLE IF NOT EXISTS `undo_log`
(
`branch_id`     BIGINT       NOT NULL COMMENT 'branch transaction id',
`xid`           VARCHAR(128) NOT NULL COMMENT 'global transaction id',
`context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
`rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
`log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
`log_created`   DATETIME(6)  NOT NULL COMMENT 'create datetime',
`log_modified`  DATETIME(6)  NOT NULL COMMENT 'modify datetime',
UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARSET = utf8 COMMENT ='AT transaction mode undo table';


