INSERT INTO 
	TBL_HEROES (first_name, last_name, superhero_name) 
VALUES
  	('bruce', 'banner', 'batman'),
  	('peter', 'parker', 'spiderman');
  	
  	
INSERT INTO 
	TBL_MISSIONS (mission_name, is_deleted, is_completed) 
VALUES
  	('gotham', 'false', 'true'),
  	('neighborhood', 'false', 'false');
  	
INSERT INTO 
	HEROES_MISSIONS (heroes_id, missions_id)
VALUES
  	(1,1),
  	(2,2);