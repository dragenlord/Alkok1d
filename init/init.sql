CREATE SCHEMA IF NOT EXISTS public;

SET search_path TO public;

DROP TABLE IF EXISTS cocktail_ingredient CASCADE;
DROP TABLE IF EXISTS steps CASCADE;
DROP TABLE IF EXISTS cocktails CASCADE;
DROP TABLE IF EXISTS assortments CASCADE;

CREATE TABLE assortments (
                             id BIGSERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL UNIQUE,
                             description TEXT,
                             price INT NOT NULL,
                             count INT NOT NULL,
                             image VARCHAR(255)
);
CREATE TABLE Users (
    id BIGINT PRIMARY KEY,
    name varchar(255) not null  unique ,
    password varchar not null ,
    Role varchar

);

CREATE TABLE cocktails (
                           id BIGSERIAL PRIMARY KEY,
                           cocktail_name VARCHAR(255) NOT NULL,
                           description TEXT,
                           vol INT NOT NULL,
                           price INT NOT NULL,
                           volume INT NOT NULL,
                           count INT NOT NULL,
                           image VARCHAR(255)
);

CREATE TABLE steps (
                       id BIGSERIAL PRIMARY KEY,
                       step_number INT NOT NULL,
                       description TEXT,
                       cocktail_id BIGINT REFERENCES cocktails(id) ON DELETE CASCADE
);

CREATE TABLE cocktail_ingredient (
                                     cocktail_id BIGINT REFERENCES cocktails(id) ON DELETE CASCADE,
                                     ingredient_id BIGINT REFERENCES assortments(id) ON DELETE CASCADE,
                                     PRIMARY KEY (cocktail_id, ingredient_id)
);

INSERT INTO assortments (name, description, price, count, image) VALUES
                                                                     ('Водка', 'Классическая русская водка', 350, 200, 'vodka.png'),
                                                                     ('Джин', 'Лондонский сухой джин с можжевельником', 400, 150, 'gin.png'),
                                                                     ('Белый ром', 'Светлый ром с ванильными нотками', 380, 180, 'white-rum.png'),
                                                                     ('Темный ром', 'Выдержанный ром с карамельным вкусом', 450, 120, 'dark-rum.png'),
                                                                     ('Текила', 'Серебряная текила из голубой агавы', 500, 100, 'tequila.png'),
                                                                     ('Виски', 'Шотландский виски с дымным ароматом', 480, 90, 'whiskey.png'),
                                                                     ('Бурбон', 'Американский бурбон с ванилью', 520, 80, 'bourbon.png'),
                                                                     ('Коньяк', 'Французский коньяк VSOP', 600, 60, 'cognac.png'),
                                                                     ('Ликер амаретто', 'Миндальный итальянский ликер', 450, 100, 'amaretto.png'),
                                                                     ('Ликер блю кюрасао', 'Голубой апельсиновый ликер', 400, 120, 'blue-curacao.png'),
                                                                     ('Ликер мараскино', 'Вишневый ликер', 550, 80, 'maraschino.png'),
                                                                     ('Ликер калуа', 'Кофейный ликер', 500, 90, 'kahlua.png'),
                                                                     ('Ликер байлис', 'Ирландский сливочный ликер', 580, 70, 'baileys.png'),
                                                                     ('Вермут красный', 'Сладкий красный вермут', 350, 150, 'sweet-vermouth.png'),
                                                                     ('Вермут сухой', 'Сухой белый вермут', 350, 150, 'dry-vermouth.png'),
                                                                     ('Апероль', 'Итальянский красный апертив', 400, 100, 'aperol.png'),
                                                                     ('Кампари', 'Горький красный биттер', 420, 90, 'campari.png'),
                                                                     ('Абсент', 'Зеленый абсент с полынью', 650, 50, 'absinthe.png'),
                                                                     ('Сок апельсиновый', 'Свежевыжатый апельсиновый сок', 120, 300, 'orange-juice.png'),
                                                                     ('Сок лимонный', 'Свежевыжатый лимонный сок', 100, 300, 'lemon-juice.png'),
                                                                     ('Сок лаймовый', 'Свежевыжатый сок лайма', 100, 300, 'lime-juice.png'),
                                                                     ('Сок клюквенный', 'Клюквенный сок', 120, 250, 'cranberry-juice.png'),
                                                                     ('Сок ананасовый', 'Ананасовый сок', 120, 250, 'pineapple-juice.png'),
                                                                     ('Сок грейпфрутовый', 'Грейпфрутовый сок', 120, 250, 'grapefruit-juice.png'),
                                                                     ('Сок томатный', 'Томатный сок', 100, 200, 'tomato-juice.png'),
                                                                     ('Сахарный сироп', 'Классический сахарный сироп', 80, 500, 'sugar-syrup.png'),
                                                                     ('Сироп гренадин', 'Гранатовый сироп', 150, 200, 'grenadine.png'),
                                                                     ('Сироп ванильный', 'Ванильный сироп', 150, 200, 'vanilla-syrup.png'),
                                                                     ('Сироп карамельный', 'Карамельный сироп', 150, 200, 'caramel-syrup.png'),
                                                                     ('Сироп кокосовый', 'Кокосовый сироп', 150, 200, 'coconut-syrup.png'),
                                                                     ('Сироп имбирный', 'Имбирный сироп', 150, 200, 'ginger-syrup.png'),
                                                                     ('Сироп мятный', 'Мятный сироп', 150, 200, 'mint-syrup.png'),
                                                                     ('Тоник', 'Классический тоник', 100, 300, 'tonic.png'),
                                                                     ('Содовая', 'Газированная вода', 80, 400, 'soda.png'),
                                                                     ('Кола', 'Кока-кола', 100, 300, 'cola.png'),
                                                                     ('Имбирное пиво', 'Острое имбирное пиво', 120, 200, 'ginger-beer.png'),
                                                                     ('Сливки', 'Жирные сливки 33%', 150, 150, 'cream.png'),
                                                                     ('Молоко', 'Цельное молоко', 80, 200, 'milk.png'),
                                                                     ('Яйцо', 'Куриное яйцо', 50, 200, 'egg.png'),
                                                                     ('Мята', 'Свежая мята', 50, 300, 'mint.png'),
                                                                     ('Лайм', 'Свежий лайм', 60, 300, 'lime.png'),
                                                                     ('Лимон', 'Свежий лимон', 50, 300, 'lemon.png'),
                                                                     ('Апельсин', 'Свежий апельсин', 70, 250, 'orange.png'),
                                                                     ('Вишня коктейльная', 'Коктейльная вишня', 100, 200, 'cherry.png'),
                                                                     ('Оливка', 'Зеленые оливки', 80, 200, 'olive.png'),
                                                                     ('Соль', 'Морская соль', 20, 500, 'salt.png'),
                                                                     ('Перец табаско', 'Острый соус табаско', 200, 100, 'tabasco.png'),
                                                                     ('Вустершир', 'Вустерширский соус', 200, 100, 'worcestershire.png');

INSERT INTO cocktails (cocktail_name, description, vol, price, volume, count, image) VALUES
                                                                                         ('Мохито', 'Освежающий кубинский коктейль с мятой и лаймом', 12, 350, 250, 10, 'mojito.png'),
                                                                                         ('Маргарита', 'Классический мексиканский коктейль на основе текилы', 15, 400, 200, 10, 'margarita.png'),
                                                                                         ('Дайкири', 'Кубинский коктейль с ромом и лаймом', 20, 380, 180, 10, 'daiquiri.png'),
                                                                                         ('Пина колада', 'Тропический коктейль с ромом, ананасом и кокосом', 10, 450, 300, 10, 'pina-colada.png'),
                                                                                         ('Мартини', 'Классический коктейль с джином и вермутом', 30, 500, 120, 10, 'martini.png'),
                                                                                         ('Космополитен', 'Популярный коктейль с водкой, клюквой и лаймом', 20, 420, 180, 10, 'cosmopolitan.png'),
                                                                                         ('Кровавая Мэри', 'Пикантный коктейль с водкой и томатным соком', 15, 380, 250, 10, 'bloody-mary.png'),
                                                                                         ('Лонг-Айленд', 'Крепкий коктейль из пяти видов алкоголя', 35, 550, 300, 10, 'long-island.png'),
                                                                                         ('Беллини', 'Итальянский коктейль из просекко и персикового пюре', 8, 320, 200, 10, 'bellini.png'),
                                                                                         ('Негрони', 'Горьковатый итальянский коктейль', 25, 480, 120, 10, 'negroni.png');

INSERT INTO cocktail_ingredient (cocktail_id, ingredient_id) VALUES
                                                                 (1, 3), (1, 21), (1, 26), (1, 32), (1, 41), (1, 40),
                                                                 (2, 5), (2, 21), (2, 26), (2, 41), (2, 47),
                                                                 (3, 3), (3, 21), (3, 26),
                                                                 (4, 3), (4, 23), (4, 30), (4, 26),
                                                                 (5, 2), (5, 15),
                                                                 (6, 1), (6, 22), (6, 21), (6, 27),
                                                                 (7, 1), (7, 25), (7, 20), (7, 47), (7, 48), (7, 46),
                                                                 (8, 1), (8, 2), (8, 3), (8, 5), (8, 9), (8, 20), (8, 26), (8, 35),
                                                                 (9, 45), (9, 23),
                                                                 (10, 2), (10, 17), (10, 14);

INSERT INTO steps (step_number, description, cocktail_id) VALUES
                                                              (1, 'Положите мяту и лайм в стакан', 1),
                                                              (2, 'Добавьте сахарный сироп', 1),
                                                              (3, 'Разомните мадлером', 1),
                                                              (4, 'Наполните стакан льдом', 1),
                                                              (5, 'Влейте белый ром', 1),
                                                              (6, 'Долейте содовую', 1),
                                                              (1, 'Сделайте соляную окантовку бокала', 2),
                                                              (2, 'В шейкере смешайте текилу, ликер и сок лайма', 2),
                                                              (3, 'Добавьте лед и энергично встряхните', 2),
                                                              (1, 'Наполните стакан льдом', 7),
                                                              (2, 'Влейте водку', 7),
                                                              (3, 'Добавьте томатный сок', 7);

SELECT setval('assortments_id_seq', (SELECT MAX(id) FROM assortments));
SELECT setval('cocktails_id_seq', (SELECT MAX(id) FROM cocktails));
SELECT setval('steps_id_seq', (SELECT MAX(id) FROM steps));