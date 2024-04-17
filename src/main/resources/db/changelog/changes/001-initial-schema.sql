--changelog: 001
CREATE TABLE payment (
    id INT PRIMARY KEY,
    type VARCHAR(50) not null,
    amount float null,
    currency VARCHAR(50) not null,
    payment_date date null)
--rollback drop table payment;