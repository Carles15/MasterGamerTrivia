-- Poblacion de la Base de Datos
-- Tabla preguntas
INSERT INTO pregunta VALUES (null,'¿¿Cómo se llamaba el caballo de Arthas en Warcraft 3?','Bolwar','Terenas','Luz','Invencible',1,4);
INSERT INTO pregunta VALUES (null,'¿Como se llama el arma de Thrall?','Frostmourne','Crematoria','Ventormenta','Martillo maldito',1,2);
INSERT INTO pregunta VALUES (null,'¿Cúales son las sagas de Heroes of the storm?','World of warcraft','Starcraft','Diablo 3','Todas son correctas',1,1);
INSERT INTO pregunta VALUES (null,'¿De que raza son los héroes de Diablo 3?','Arcángeles','Dephalem','Tephalem','Nephalem',3,2);
INSERT INTO pregunta VALUES (null,'¿Como se llama el shooter de Blizzard?','Hiperwatch','Overcraft','Overseen','Overwatch',8,1);
INSERT INTO pregunta VALUES (null,'¿Líder de los renegados?','Thrall','Anduin','Garrosh','Sylvanas',4,2);
INSERT INTO pregunta VALUES (null,'¿Líder de los trolls lanza negra?','Thrall','Sylvanas','Rexxar','Voljin',1,2);

-- Tabla juegos
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('1', 'World of warcraft', 'Juego de rol ambientando en el mundo de Warcraft', 'mmorpg');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('2', 'Hearthstone', 'Juego de cartas ambientado en el mundo de warcraft', 'cartas');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('3', 'Heroes of the storm', 'Juego basado en los mundos de warcraft, Starcraft y Diablo', 'moba');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('4', 'Overwatch', 'Juego con ambientación real y futurista', 'shooter');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('5', 'DOTA', 'Juego basado en \"Defense Of The Ancients\"', 'moba');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('6', 'League of legends', 'Juego basado en \"Defense Of The Ancientes\"', 'moba');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('7', 'Counter Strike', 'Juego multijugador de disparos', 'shooter');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('8', 'Diablo 3', 'Continuación de la saga de diablo 3', 'hack and slash');
INSERT INTO `mastergamertrivia`.`juegos` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('9', 'Minecraft', 'Juego de construcción', 'construccion');
INSERT INTO `mastergamertrivia`.`juego` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('10', 'DarkSouls', 'Prepare to Die Edition', 'rpg');
INSERT INTO `mastergamertrivia`.`juego` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('11', 'Final Fantasy', 'Juego por turnos', 'rpg');
INSERT INTO `mastergamertrivia`.`juego` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('12', 'Pokémon', 'Juego de colección de pokémons', 'simulación');
INSERT INTO `mastergamertrivia`.`juego` (`id`, `nombre`, `descripcion`, `categoria`) VALUES ('13', 'The Legend of Zelda', 'Juego de ambientación fantastica', 'rpg');



-- Consulta para generar Randoms desde MySQL
-- SELECT id, juegoPertenece, FLOOR(RAND() * (SELECT COUNT(*) FROM pregunta)) AS 'random_number' FROM pregunta;
-- Falta trabajarla no funciona del todo bien;


-- Tabla dificultades
INSERT INTO `mastergamertrivia`.`dificultad` (`id`, `nombre`, `descripcion`) VALUES ('1', 'noob', 'fácil');
INSERT INTO `mastergamertrivia`.`dificultad` (`id`, `nombre`, `descripcion`) VALUES ('2', 'experto', 'normal');
INSERT INTO `mastergamertrivia`.`dificultad` (`id`, `nombre`, `descripcion`) VALUES ('3', 'pro', 'dificil');
INSERT INTO `mastergamertrivia`.`dificultad` (`id`, `nombre`, `descripcion`) VALUES ('4', 'gamer', 'imposible');
