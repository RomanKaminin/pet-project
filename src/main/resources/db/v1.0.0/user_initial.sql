CREATE TABLE pet.user
(
  id SERIAL PRIMARY KEY NOT NULL,
  name character varying(200) UNIQUE,
  email character varying(200) UNIQUE,
  position character varying(100) NULL,
  phone character varying(100) NULL,
  image_url character varying(200) NULL,
  code character varying(100) UNIQUE
);
grant all PRIVILEGES on pet.user to ${own};


CREATE SEQUENCE pet.pet_user_id_seq;
grant USAGE ON SEQUENCE pet.pet_user_id_seq to ${own};

-- INSERT INTO
--     pet.user(id,name,email,position,phone,image_url,code)
-- VALUES
--     (nextval('${schema}.user_id_seq'), 'Тестовский Тест Тестович', 'test@mail.com', 'Директор', '88888888888', null, null);
