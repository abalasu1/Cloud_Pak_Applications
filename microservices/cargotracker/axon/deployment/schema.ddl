CREATE SCHEMA `bookingquerymsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
use bookingquerymsdb;

CREATE USER 'bookingquerymsdb'@'%' IDENTIFIED BY 'bookingquerymsdb';
GRANT ALL PRIVILEGES ON bookingquerymsdb.* TO 'bookingquerymsdb'@'%';
---

CREATE SCHEMA `handlingmsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
use handlingmsdb;

CREATE USER 'handlingmsdb'@'%' IDENTIFIED BY 'handlingmsdb';
GRANT ALL PRIVILEGES ON handlingmsdb.* TO 'handlingmsdb'@'%';

##Handling_activity DDL 
CREATE TABLE handling_activity ( 
  id int(11) NOT NULL AUTO_INCREMENT, 
  event_completion_time timestamp NULL DEFAULT NULL, 
  event_type varchar(225) DEFAULT NULL, 
  booking_id varchar(20) DEFAULT NULL, 
  voyage_number varchar(100) DEFAULT NULL, 
  location varchar(100) DEFAULT NULL, 
  PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
---

CREATE SCHEMA `routingmsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
use routingmsdb;

CREATE USER 'routingmsdb'@'%' IDENTIFIED BY 'routingmsdb';
GRANT ALL PRIVILEGES ON routingmsdb.* TO 'routingmsdb'@'%';

##Voyage Table DDL
CREATE TABLE `voyage` (
`Id` int(11) NOT NULL AUTO_INCREMENT,
`voyage_number` varchar(20) NOT NULL,
PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

##Carrier Movement Table DDL -
CREATE TABLE `carrier_movement` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `arrival_location_id` varchar(100) DEFAULT NULL,
  `departure_location_id` varchar(100) DEFAULT NULL,
  `voyage_id` int(11) DEFAULT NULL,
  `arrival_date` date DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1358 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

### Data to ensure Routing works fine ->
insert voyage (Id,voyage_number) values(3,'0100S');
insert voyage (Id,voyage_number) values(4,'0101S');
insert voyage (Id,voyage_number) values(5,'0102S');

INSERT INTO `voyage` (`Id`, `voyage_number`) VALUES ('6', '0103S');
INSERT INTO `voyage` (`Id`, `voyage_number`) VALUES ('7', '0104S');
INSERT INTO `voyage` (`Id`, `voyage_number`) VALUES ('8', '0105S');

insert into carrier_movement (Id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (1355,'CNHGH','CNHKG',3,'2019-08-28','2019-08-25');
insert into carrier_movement (Id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (1356,'JNTKO','CNHGH',4,'2019-09-10','2019-09-01');
insert into carrier_movement (Id,arrival_location_id,departure_location_id,voyage_id,arrival_date,departure_date) 		values (1357,'USNYC','JNTKO',5,'2019-09-25','2019-09-15');  

INSERT INTO `carrier_movement` (`Id`, `arrival_location_id`, `departure_location_id`, `voyage_id`, `arrival_date`, `departure_date`) VALUES ('1358', 'USNYC', 'JNTKO', '6', '2020-01-15', '2020-01-18');
INSERT INTO `carrier_movement` (`Id`, `arrival_location_id`, `departure_location_id`, `voyage_id`, `arrival_date`, `departure_date`) VALUES ('1359', 'JNTKO', 'CNHGH', '7', '2020-01-19', '2020-01-22');
INSERT INTO `carrier_movement` (`Id`, `arrival_location_id`, `departure_location_id`, `voyage_id`, `arrival_date`, `departure_date`) VALUES ('1360', 'CNHGH', 'CNHKG', '8', '2020-01-23', '2020-01-25');
---

CREATE SCHEMA `trackingmsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
use trackingmsdb;

CREATE USER 'trackingmsdb'@'%' IDENTIFIED BY 'trackingmsdb';
GRANT ALL PRIVILEGES ON trackingmsdb.* TO 'trackingmsdb'@'%';