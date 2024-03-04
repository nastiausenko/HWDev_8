INSERT INTO worker
(name, birthday, level, salary)
VALUES
    ('John', '1990-05-15', 'Trainee', 800),
    ('Alice', '1985-09-22', 'Junior', 1200),
    ('Bob', '1982-03-10', 'Middle', 3000),
    ('Emily', '1995-12-03', 'Senior', 5500),
    ('Michael', '1988-07-18', 'Trainee', 900),
    ('Sophia', '1992-11-27', 'Junior', 1100),
    ('William', '1984-04-05', 'Middle', 3200),
    ('Olivia', '1997-08-14', 'Senior', 5200),
    ('James', '1993-02-28', 'Trainee', 950),
    ('Emma', '1989-06-20', 'Junior', 1300);

INSERT INTO client
(name)
VALUES
    ('Sam'),
    ('Antony'),
    ('Anne'),
    ('Jade'),
    ('Luke');

INSERT INTO project
(client_id, start_date, finish_date)
VALUES
    (1, '2023-01-01', '2023-12-15'),
    (2, '2023-02-10', '2023-04-25'),
    (3, '2023-03-20', '2023-09-05'),
    (3, '2023-04-05', '2023-06-20'),
    (5, '2023-05-15', '2023-09-30'),
    (1, '2023-06-01', '2023-10-15'),
    (2, '2023-07-10', '2023-09-25'),
    (3, '2023-08-20', '2023-10-05'),
    (4, '2023-09-05', '2023-11-20'),
    (5, '2023-10-15', '2023-12-30');

INSERT INTO project_worker
(project_id, worker_id)
VALUES
    (1, 1),
    (2, 2),
    (2, 3),
    (3, 4),
    (4, 5),
    (5, 6),
    (5, 7),
    (6, 1),
    (7, 2),
    (8, 9),
    (9, 8),
    (9, 9),
    (9, 10),
    (10, 2);