DROP TABLE IF EXISTS work;
CREATE TABLE work(id INT AUTO_INCREMENT PRIMARY KEY,
		  name VARCHAR(250) NOT NULL,
		   phonenumber 	VARCHAR(10) NOT NULL,
		   email  VARCHAR(50),
		   address VARCHAR(250));
INSERT INTO work(name,phonenumber,email,address) 
	VALUES('Johnson','8765432567','john.son@gmail.com','8566 henderson rd,dublin,OH-43065'),
		('sarvani','8765432437','sarvani.son@gmail.com','8566 henderson rd,dublin,OH-43065'),
	('Jack','8765432567','jack.son@gmail.com','8566 henderson rd,dublin,OH-43065'),
	('george','8765432167','george.son@gmail.com','8566 henderson rd,dublin,OH-43065'),
	('August','8765432567','august.sun@gmail.com','8566 henderson rd,dublin,OH-43065'),
	      ('Grey','6145679864','grey.anderson@gmail.com','6986 chesire ct,austin,tx-35467');