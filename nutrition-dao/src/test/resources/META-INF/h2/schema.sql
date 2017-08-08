CREATE TABLE IF NOT EXISTS source (
	id smallint IDENTITY PRIMARY KEY,
	source varchar,
	create_date timestamp,
	version timestamp
);

CREATE TABLE IF NOT EXISTS food_group (
  id smallint IDENTITY PRIMARY KEY,
  name varchar,
  create_date timestamp,
  version timestamp
);

CREATE TABLE IF NOT EXISTS nutrient_group (
  id smallint IDENTITY PRIMARY KEY,
  name varchar,
  create_date timestamp,
  version timestamp
);

CREATE TABLE IF NOT EXISTS unit (
  id smallint IDENTITY PRIMARY KEY,
  name varchar,
  abbreviation varchar,
  create_date timestamp,
  version timestamp
);

CREATE TABLE IF NOT EXISTS food (
  id int IDENTITY PRIMARY KEY,
  name VARCHAR,
  food_group_id smallint,
  create_date timestamp,
  version timestamp,
  FOREIGN KEY (food_group_id) REFERENCES public.food_group(id)
);

CREATE TABLE IF NOT EXISTS nutrient (
  id int IDENTITY PRIMARY KEY,
  name VARCHAR,
  nutrient_group_id smallint,
  unit_id smallint,
  recommended_dietary_allowance decimal(6,2),
  overdose_limit decimal(6,2),
  create_date timestamp,
  version timestamp,
  FOREIGN KEY (nutrient_group_id) REFERENCES public.nutrient_group(id),
  FOREIGN KEY (unit_id) REFERENCES public.unit(id)
);

CREATE TABLE IF NOT EXISTS food_measure (
  id int IDENTITY PRIMARY KEY,
  food_id int,
  size varchar,
  quantity decimal(6,2),
  grams decimal(6,2),
  create_date timestamp,
  version timestamp,
  FOREIGN KEY (food_id) REFERENCES public.food(id)
);

CREATE TABLE IF NOT EXISTS nutrient_measure (
  id int IDENTITY PRIMARY KEY,
  food_id int,
  nutrient_id int,
  amount_per_gram decimal(12,6),
  create_date timestamp,
  version timestamp,
  FOREIGN KEY (food_id) REFERENCES public.food(id),
  FOREIGN KEY (nutrient_id) REFERENCES public.nutrient(id)
);

CREATE TABLE IF NOT EXISTS usda_food_source (
  id int IDENTITY PRIMARY KEY,
  usda_food_id int,
  food_id int,
  source_id smallint,
  create_date timestamp,
  version timestamp,
  UNIQUE KEY usda_food_id (usda_food_id),
  UNIQUE KEY food_id (food_id),
  FOREIGN KEY (food_id) REFERENCES public.food(id),
  FOREIGN KEY (source_id) REFERENCES public.source(id)
);

CREATE TABLE IF NOT EXISTS usda_nutrient_source (
  id int IDENTITY PRIMARY KEY,
  usda_nutrient_id int,
  nutrient_id int,
  source_id smallint,
  create_date timestamp,
  version timestamp,
  UNIQUE KEY usda_nutrient_id (usda_nutrient_id),
  UNIQUE KEY nutrient_id (nutrient_id),
  FOREIGN KEY (nutrient_id) REFERENCES public.nutrient(id),
  FOREIGN KEY (source_id) REFERENCES public.source(id)
);
