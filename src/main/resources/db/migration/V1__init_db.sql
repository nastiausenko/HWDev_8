CREATE TABLE IF NOT EXISTS worker (
    id INT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000),
    birthday DATE CHECK (birthday >= '1900-01-01'),
    level ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    salary INT CHECK (salary >= 100 AND salary <= 100000)
);

CREATE TABLE IF NOT EXISTS client (
    id INT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000)
);

CREATE TABLE IF NOT EXISTS project (
    id INT PRIMARY KEY,
    client_id INT,
    start_date DATE,
    finish_date DATE,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS project_worker (
     project_id INT,
     worker_id INT,
     PRIMARY KEY (project_id, worker_id),
     FOREIGN KEY (project_id) REFERENCES project(id),
     FOREIGN KEY (worker_id) REFERENCES worker(id)
);