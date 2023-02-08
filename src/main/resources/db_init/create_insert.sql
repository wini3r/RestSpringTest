CREATE TABLE `carrier_directory`.`CARRIER`
	(
            `ID`          BIGINT NOT NULL AUTO_INCREMENT
	  , `NAME`        VARCHAR(90) NOT NULL
	  , `INN`         VARCHAR(12) NOT NULL
	  , `REG_ADDRESS` VARCHAR(255) NOT NULL
	  , `REG_COUNTRY` VARCHAR(90) NOT NULL
	  , `TAX_SYSTEM`  TINYINT NULL
	  , PRIMARY KEY (`ID`)
	)
	ENGINE = InnoDB
;

INSERT INTO `carrier` (`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) 
VALUES ('Name'
  , 'INN'
  , 'REG_ADDRESS'
  , 'Белоруссия'
  , 20)
;

INSERT INTO `carrier` (`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) 
VALUES ('ТОО "СAТ ТРАНС"'
  , '080640004791'
  , 'г. Семей, ул. Чимкентская, д. 2'
  , 'Казахстан'
  , NULL)
;

INSERT INTO `carrier` (`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) 
VALUES ('ТОО "VIS-A-VIS.RA"'
  , '030740000832'
  , 'г. Алматы, ул. Мауленова, д. 111, кв. 39'
  , 'Казахстан'
  , 0)
;

INSERT INTO `carrier` (`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) 
VALUES ('ТОО "Nord-Kaztrans PV"'
  , '070540009579'
  , 'г. Павлодар, Северная промзона'
  , 'Казахстан'
  , 10)
;


INSERT INTO `carrier` (`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) 
VALUES ('ООО "Тракт"'
  , '7807048204'
  , 'г. Санкт-Петербург, ул. Доблести, д. 24/1, лит. А, пом. 8Н, (812) 232-00-41'
  , 'Россия'
  , 10)
;


INSERT INTO `carrier` (`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) 
VALUES ('ЗАО "РутрансЛогистик"'
  , '7805144375'
  , 'г. Москва, ул. Рябиновая, вл. 43 А, (495) 363-51-44'
  , 'Россия'
  , 20)
;


INSERT INTO `carrier` (`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) 
VALUES ('ООО "Транстех"'
  , '7805514724'
  , 'г. Санкт-Петербург, ул. Трефолева, д. 2, лит. БН, (812) 326-20-70'
  , 'Россия'
  , 10)
;