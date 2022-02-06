CREATE DATABASE rcrypto;

\c rcrypto;

CREATE TABLE prices(
id serial PRIMARY KEY,
price VARCHAR
);
