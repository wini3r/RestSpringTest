
-- ----------------------------------------------------------------------COUNTRY
CREATE TABLE `COUNTRY`
(
    `ID`         BIGINT NOT NULL AUTO_INCREMENT
  , `CODE`       INT NOT NULL
  , `NAME`       VARCHAR(90) NOT NULL
  , `SHORT_NAME` VARCHAR(2) NOT NULL
  , PRIMARY KEY (`ID`)
)
ENGINE = InnoDB
;
 
INSERT INTO `COUNTRY`(`CODE`, `NAME`, `SHORT_NAME`) 
VALUES (643, 'РОССИЯ', 'RU')
;
INSERT INTO `COUNTRY`(`CODE`, `NAME`, `SHORT_NAME`) 
VALUES (398, 'КАЗАХСТАН', 'KZ')
;
INSERT INTO `COUNTRY`(`CODE`, `NAME`, `SHORT_NAME`) 
VALUES (112, 'БЕЛАРУСЬ', 'BY')
; 
INSERT INTO `COUNTRY`(`CODE`, `NAME`, `SHORT_NAME`) 
VALUES (804, 'УКРАИНА', 'UA')
; 
 
-- -------------------------------------------------------------------TAX_SYSTEM
CREATE TABLE `TAX_SYSTEM`
(
    `ID`         BIGINT         NOT NULL AUTO_INCREMENT
  , `NAME`       VARCHAR(90)    NOT NULL
  , `TAX_VALUE`  DECIMAL(4,2)   NULL
  , PRIMARY KEY (`ID`)
)
ENGINE = InnoDB
;

INSERT INTO `TAX_SYSTEM`(`NAME`, `TAX_VALUE`) 
VALUES ('Без НДС', NULL)
; 
INSERT INTO `TAX_SYSTEM`(`NAME`, `TAX_VALUE`) 
VALUES ('НДС 0%', 0.00)
; 
INSERT INTO `TAX_SYSTEM`(`NAME`, `TAX_VALUE`) 
VALUES ('НДС 10%', 10.00)
; 
INSERT INTO `TAX_SYSTEM`(`NAME`, `TAX_VALUE`) 
VALUES ('НДС 20%', 20.00)
; 
 
-- ----------------------------------------------------------------------CARRIER 
CREATE TABLE `CARRIER`
(
    `ID`          BIGINT        NOT NULL AUTO_INCREMENT
  , `NAME`        VARCHAR(90)   NOT NULL
  , `INN`         VARCHAR(12)   NOT NULL
  , `REG_ADDRESS` VARCHAR(255)  NOT NULL
  , `FK_COUNTRY`  BIGINT        NOT NULL
  , `FK_TAX_SYSTEM`  BIGINT     NOT NULL
  , PRIMARY KEY (`ID`)
  , INDEX `IDX_CARRIER_FK_COUNTRY` (`FK_COUNTRY`)
  , FOREIGN KEY (`FK_COUNTRY`)
    REFERENCES `COUNTRY`(`ID`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT 
  , INDEX `IDX_CARRIER_FK_TAX_SYSTEM` (`FK_TAX_SYSTEM`)
  , FOREIGN KEY (`FK_TAX_SYSTEM`)
    REFERENCES `TAX_SYSTEM`(`ID`)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

INSERT INTO `CARRIER` (`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) 
VALUES ('Name'
  , 'INN'
  , 'REG_ADDRESS'
  , 4
  , 1)
;

INSERT INTO `CARRIER` (`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) 
VALUES ('ТОО "СAТ ТРАНС"'
  , '080640004791'
  , 'г. Семей, ул. Чимкентская, д. 2'
  , 2
  , 1)
;

INSERT INTO `CARRIER` (`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) 
VALUES ('ТОО "VIS-A-VIS.RA"'
  , '030740000832'
  , 'г. Алматы, ул. Мауленова, д. 111, кв. 39'
  , 2
  , 2)
;

INSERT INTO `CARRIER` (`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) 
VALUES ('ТОО "Nord-Kaztrans PV"'
  , '070540009579'
  , 'г. Павлодар, Северная промзона'
  , 2
  , 2)
;

INSERT INTO `CARRIER` (`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) 
VALUES ('ООО "Тракт"'
  , '7807048204'
  , 'г. Санкт-Петербург, ул. Доблести, д. 24/1, лит. А, пом. 8Н, (812) 232-00-41'
  , 1
  , 3)
;

INSERT INTO `CARRIER` (`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) 
VALUES ('ЗАО "РутрансЛогистик"'
  , '7805144375'
  , 'г. Москва, ул. Рябиновая, вл. 43 А, (495) 363-51-44'
  , 1
  , 3)
;

INSERT INTO `CARRIER` (`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) 
VALUES ('ООО "Транстех"'
  , '7805514724'
  , 'г. Санкт-Петербург, ул. Трефолева, д. 2, лит. БН, (812) 326-20-70'
  , 1
  , 4)
;