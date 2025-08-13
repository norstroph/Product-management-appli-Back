CREATE TABLE IF NOT EXISTS car(
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    price DOUBLE,
    stock_quantity INT
);

CREATE TABLE IF NOT EXISTS product(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    stock_quantity INT NOT NULL,
    type ENUM('CAR', 'PART') NOT NULL,
    -- si doublon leve une DuplicateKeyException
    CONSTRAINT unique_product UNIQUE (name, price, stock_quantity, type)

);


CREATE TABLE IF NOT EXISTS customers(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255),
    password VARCHAR(300)
);

CREATE TABLE IF NOT EXISTS orders(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_date DATE NOT NULL,
     customer_id BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)  ON DELETE CASCADE
);




CREATE TABLE IF NOT EXISTS order_product(
    order_id BIGINT,
    product_id BIGINT,
    quantity INT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (product_id) REFERENCES product(id)  ON DELETE CASCADE,
    FOREIGN KEY (order_id) REFERENCES orders(id)  ON DELETE CASCADE
);


