INSERT INTO WINE (ID, NAME, BODEGA, GRAPE, TANNIN, AGEING, DESCRIPTION, REGION_ID)
VALUES (1, 'Enrique Mendoza', 'Bodegas Mendoza', 'Monastrell 50% y Merlot 50%', 'Taninos finos y elegantes', '12 meses en barrica', 'Fermentado en pequeños depósitos de acero- inoxidable a baja temperatura. La fermentación maloláctica se realizó en barricas y el vino se ha criado durante 12 meses en barricas de roble Francés Allier y roble Americano Oregón. Debido a su elaboración artesanal puede tener sedimentos naturales con la edad.', 1),
       (2, 'Finca Terrerazo 2017', 'Seco', 'Alta', 'Taninos finos y elegantes', '09', 'cuerpo estable', 2),
       (3, 'La Loba 2017', 'Seco', 'Alta', 'Taninos finos y elegantes', '08', 'cuerpo estable', 3),
       (4, 'Las Gravas 2018', 'Seco', 'Alta', 'Taninos finos y elegantes', '07', 'cuerpo estable', 4),
       (5, 'Brujidera 2019', 'Seco', 'Alta', 'Taninos finos y elegantes', '06', 'cuerpo estable', 5),
       (6, 'Agala Altitud 1050 2019', 'Dule', 'Alta', 'Taninos finos y elegantes', '05', 'cuerpo estable', 6),
       (7, 'ÀN/2 2018', 'Dule', 'Alta', 'Taninos finos y elegantes', '04', 'cuerpo estable', 1),
       (8, 'Bastardo Negro 2013', 'Dule', 'Alta', 'Taninos finos y elegantes', '03', 'cuerpo estable', 2),
       (9, 'Casa Sosegada 2018', 'Dule', 'Alta', 'Taninos finos y elegantes', '02', 'cuerpo estable', 3),
       (10, 'El Sequé 2018', 'SemiSeco', 'Media', 'Taninos finos y elegantes', '01', 'cuerpo estable', 4),
       (11, 'Lava 2019', 'SemiSeco', 'Media', 'Taninos finos y elegantes', '10', 'cuerpo estable', 5),
       (12, 'Oller del Mas Picapoll Negre 2017', 'SemiSeco', 'Media', 'Taninos finos y elegantes', '05', 'cuerpo estable', 6),
       (13, 'Carles Andreu Trepat 2018', 'SemiSeco', 'Media', 'Taninos finos y elegantes', '06', 'cuerpo estable', 1),
       (14, 'El Hombre Bala 2017', 'Rasposo', 'Media', 'Taninos finos y elegantes', '07', 'cuerpo estable', 2),
       (15, 'Las Sabias 2017', 'Rasposo', 'Baja', 'Taninos finos y elegantes', '08', 'cuerpo estable', 3),
       (16, 'Cadalso 2018', 'Rasposo', 'Baja', 'Taninos finos y elegantes', '09', 'cuerpo estable', 4),
       (17, 'Gaba do Xil Tinto 2018', 'Rasposo', 'Baja', 'Taninos finos y elegantes', '07', 'cuerpo estable', 5),
       (18, 'Grimalt Caballero 2018', 'Rasposo', 'Baja', 'Taninos finos y elegantes', '06', 'cuerpo estable', 6);

INSERT INTO REGION (ID, NAME, LOCATION, COUNTRY)
VALUES (1, 'Rioja Alavesa', 'Alava', 'España'),
       (2, 'Tierra de Cadiz', 'Andalucia', 'España'),
       (3, 'Ribera del Duero', 'Valladolid', 'España'),
       (4, 'Sotomontando', 'Valladolid', 'España'),
       (5, 'Valle de Tolombón', 'Salta', 'Argentina'),
       (6, 'Rioja', 'La Rioja', 'España');
