CREATE TABLE pet.role
(
  id bigint NOT NULL PRIMARY KEY,
  authority character varying(100) UNIQUE,
  title character varying(100) UNIQUE,
  groupTitle character varying(100)
);
grant all PRIVILEGES on pet.role to ${own};

CREATE TABLE pet.user_roles
(
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  CONSTRAINT unique_user_role UNIQUE (user_id, role_id)
);
grant all PRIVILEGES on pet.user_roles to ${own};

CREATE SEQUENCE pet.role_id_seq;
grant USAGE ON SEQUENCE pet.role_id_seq to ${own};

INSERT INTO
    pet.role(id,authority,title,groupTitle)
VALUES
    (nextval('${schema}.role_id_seq'), 'ADMINISTRATOR', 'Админ', 'Приложение');
INSERT INTO
    pet.role(id,authority,title,groupTitle)
VALUES
    (nextval('${schema}.role_id_seq'), 'USER', 'Пользователь', 'Приложение');

INSERT INTO pet.user_roles(user_id,role_id) VALUES (1, 1);