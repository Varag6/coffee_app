CREATE TABLE category (
                          category_id INTEGER  NOT NULL PRIMARY KEY auto_increment,
                          name VARCHAR(255),
                          ingredients VARCHAR(255)
);
CREATE TABLE product (
                         product_id INTEGER NOT NULL PRIMARY KEY auto_increment,
                         name VARCHAR(255),
                         price INT,
                         category_id INT,
                         CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE user_table (
                            user_id INTEGER NOT NULL PRIMARY KEY auto_increment,
                            username VARCHAR(255),
                            role VARCHAR(255),
                            password VARCHAR(255)
);

CREATE TABLE order_table (
                         order_id INTEGER NOT NULL PRIMARY KEY auto_increment,
                         product_id INT,
                         user_id INT,
                         CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product(product_id),
                         CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user_table(user_id)
);


