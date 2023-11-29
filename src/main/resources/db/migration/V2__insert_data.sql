-- Insert data into Category table
INSERT INTO category (category_id, name, ingredients) VALUES
    (1, 'Ice cafe', 'Milk, Coffee, Ice'),
    (2, 'Hot cafe', 'Milk, Coffee'),
    (3, 'Black cafe', 'Coffee');

-- Insert data into Product table
INSERT INTO product (product_id, name, price, category_id) VALUES
    (1, 'Cappuccino', 60, 1),
    (2, 'Latte', 20, 2),
    (3, 'Espresso', 50, 3);

INSERT INTO user_table (user_id, username, role, password) VALUES
    (1, 'username1', 'ROLE_ADMIN', '$2a$10$VRJh6RWQ7EcQw2G9GMSKY.yhaw7bReoq5fJbBiomk1Xaosa2OgJni'),
    (2, 'username2', 'ROLE_USER', '$2a$10$mSmYDoB8jSrdrTvEK9vTIesiV53q5.B/Ln2IWweHmqRCC.7Rw.ZhG'),
    (3, 'username3', 'ROLE_USER',  '$2a$10$mSmYDoB8jSrdrTvEK9vTIesiV53q5.B/Ln2IWweHmqRCC.7Rw.ZhG');

-- Insert data into Order table
INSERT INTO order_table (order_id, user_id, product_id) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);

