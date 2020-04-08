DROP TABLE IF EXISTS Product;

CREATE TABLE Product (
  idProduct INT AUTO_INCREMENT  PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  product_price DOUBLE NOT NULL,
);

CREATE TABLE BasketItem (
  idBasketItem INT AUTO_INCREMENT  PRIMARY KEY,
  idProduct INT NOT NULL,
  idShoppingBasket INT NOT NULL,
  quantity DOUBLE NOT NULL,
);

CREATE TABLE ShoppingBasket (
  idShoppingBasket INT AUTO_INCREMENT  PRIMARY KEY,
  userId INT NOT NULL,
  creationDate VARCHAR(250) NOT NULL,
);

