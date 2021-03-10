DROP TABLE IF EXISTS Member;
CREATE TABLE Member(
        memberID serial PRIMARY KEY,
        password VARCHAR(255),
        firstName VARCHAR(255),
        lastName VARCHAR(255),
        dateOfBirth VARCHAR(255),
        email VARCHAR(255),
        phone VARCHAR(255),
        postalCode VARCHAR(255),
        city VARCHAR(255),
        address VARCHAR(255),
        memberImage VARCHAR(255),
        registerTime VARCHAR(255),
        userType SMALLINT);

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders(
       orderID serial PRIMARY KEY,
       memberID VARCHAR(50),
       productID VARCHAR(50),
       orderDate VARCHAR(50),
       shipDate VARCHAR(8),
       quantity VARCHAR(100),
       amount VARCHAR(10),
       paid VARCHAR(10),
       orderStatus VARCHAR(50));

DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
        productID serial PRIMARY KEY,
        productName VARCHAR(200),
        categoryID VARCHAR(50),
        unitPrice VARCHAR(50));