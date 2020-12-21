
INSERT INTO STM_USER (NAME, LAST_NAME, EMAIL, PASSWORD) VALUES ('Patryk','Jurzec','patjur@wp.pl','admin');
INSERT INTO STM_USER (NAME, LAST_NAME, EMAIL, PASSWORD) VALUES ('andrzej@interia.pl', 'Nowak', 'Andrzej', '1234');
INSERT INTO STM_USER (NAME, LAST_NAME, EMAIL, PASSWORD,STATUS) VALUES ( 'Wojtek','Niewiadomski', 'wojtek@onet.pl','1234',true );
INSERT INTO STM_USER (NAME, LAST_NAME, EMAIL, PASSWORD,STATUS) VALUES ('Patryk','Lewandowski', 'patryk@gmail.com','1234',true);

INSERT INTO STM_TASK (TITLE,DESCRIPTION,stm_type, stm_status) VALUES ('Zadanie','Obsluga RTX','TASK','NEW');
INSERT INTO STM_TASK (TITLE,DESCRIPTION,stm_type, stm_status) VALUES ('Interfejs','Interfejs znika','BUG','NEW');
INSERT INTO STM_TASK (TITLE,DESCRIPTION,stm_type, stm_status) VALUES ('Obiekty','Obiekty sie przenikaja','BUG','NEW');