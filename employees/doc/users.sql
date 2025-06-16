CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY,
                       password VARCHAR(500) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);
CREATE UNIQUE INDEX ix_auth_username on authorities (username,authority);


INSERT INTO users (username, password, enabled) VALUES
          ('user1', '{noop}same_thing', true),
          ('user2', '{noop}same_thing', true),
          ('admin', '{noop}admin', true);
INSERT INTO authorities VALUES
                          ('user1', 'ROLE_EMPLOYEE'),
                          ('user2', 'ROLE_EMPLOYEE'),
                          ('user2', 'ROLE_MANAGER'),
                          ('admin', 'ROLE_EMPLOYEE'),
                          ('admin', 'ROLE_MANAGER'),
                          ('admin', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled) VALUES
                                                    ('user1', '{bcrypt}$2a$10$.p5wt3M60gCzgYfh.tfhj.Cee7PheDYXarGh94Uz2oOSPG2cHrXvG', true),
                                                    ('user2', '{bcrypt}$2a$10$Uwop4YYoOT0I/TWB8v9Z2uuyRg3MyGRgt.0qxv6NT5Bsn4kJ8FpM2', true),
                                                    ('admin', '{bcrypt}$2a$10$aL/ojUEqaLhV3.X4ucDPy.EX0o1Q5ZG4tMilhaJjyWcHF2jHI9KvC', true);
