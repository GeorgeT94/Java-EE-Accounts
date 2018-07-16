INSERT INTO Account(account_id, firstName, lastName, accountNumber) VALUES (1000001, 'george', 'timbrell', '000001'), (1000002, 'benny', 'wong', '000002'), (1000003, 'sam', 'kirk', '000003');
INSERT INTO Transaction(id, name, account_id) VALUES (1, 'first transaction', 1000001);
INSERT INTO Transaction(id, name ,account_id) VALUES (2, 'another transaction', 1000002);