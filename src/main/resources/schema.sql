CREATE TABLE customer (
	id BIGINT NOT NULL AUTO_INCREMENT,
    name char(50),
    mobile char(20),
	email char(50),
    address1 char(100),
    address2 char(100),
    PRIMARY KEY(id)
);

CREATE TABLE account (
	id BIGINT NOT NULL AUTO_INCREMENT,
    accountType ENUM('savings', 'checkings'),
    accountNumber BIGINT,
    availableBalance NUMERIC(15,4),
    customerId BIGINT,
    PRIMARY KEY(id),
	FOREIGN KEY(customerId) REFERENCES customer(id)
);
