INSERT INTO CATEGORY(ID, NAME, DESCRIPTION) VALUES
('101', 'Test-Category', 'This is just a test, pls work'),
('102', 'Test-Category-2', 'This is just a test, pls work');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, QUANTITY, IN_STOCK) VALUES
('101', 'Dell XPS', 'This is a laptop computer', 69, true);

INSERT INTO CATEGORY_PRODUCT(CATEGORY_ID, PRODUCT_ID) VALUES ('101', '101');