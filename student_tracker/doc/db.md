


```sql
CREATE USER 'spring'@'localhost' IDENTIFIED BY 'spring';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'localhost';
CREATE DATABASE `lec_spring`;

CREATE TABLE `student` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```