--changelog: 002
INSERT INTO payment (ID,type,amount, currency) VALUES (1,'CASH', 100, 'CZK');
INSERT INTO payment (ID,type,amount, currency, payment_date) VALUES (2,'CARD', 300, 'CZK', '2024-04-17');
--rollback delete from payment where id in (1,2);