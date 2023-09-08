CREATE TABLE sightings (
    id serial PRIMARY KEY,
    animal_id int,
    location varchar,
    ranger_name varchar,
    timestamp timestamp
);