


```sql
# MySql

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


```postgresql

CREATE USER spring WITH PASSWORD 'spring';
GRANT ALL PRIVILEGES ON DATABASE lec_spring TO spring;
CREATE DATABASE lec_spring;

# Use Database가 PostGres에는 없음 
CREATE TABLE student (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(45),
                         last_name VARCHAR(45),
                         email VARCHAR(45)
);

```