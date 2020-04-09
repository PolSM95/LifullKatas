CREATE TABLE IF NOT EXISTS Product (
  idProduct INTEGER PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(250) NOT NULL,
  product_price DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS BasketItem (
  idBasketItem INTEGER PRIMARY KEY AUTO_INCREMENT,
  idProduct INTEGER NOT NULL,
  idShoppingBasket INTEGER NOT NULL,
  quantity DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS ShoppingBasket (
  idShoppingBasket INTEGER PRIMARY KEY AUTO_INCREMENT ,
  userId INTEGER NOT NULL,
  creationDate VARCHAR(250) NOT NULL
);
