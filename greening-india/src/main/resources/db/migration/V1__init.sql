CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE plantation_drive (
    id BIGSERIAL PRIMARY KEY,
    location VARCHAR(255),
    date DATE,
    target_trees INT NOT NULL
);

CREATE TABLE plantation_record (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    drive_id BIGINT NOT NULL,
    trees_planted INT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_drive FOREIGN KEY (drive_id) REFERENCES plantation_drive(id)
);