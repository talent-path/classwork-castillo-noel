INSERT INTO public."Ingredients"(
	"name")
	VALUES  ('Egg'), ('Beef Patty'), ('Wheat Bun'), 
	('Cheddar'),('Salmon Filet'), ('Pineapples'),
	('Tomato Sauce'), ('Oats'), ('Water'), ('Sugar'),
	('Dough'), ('Rice Grains'), ('Mozzarella'),
	('Oil'), ('Ham');

INSERT INTO public."Menus"(name)
	VALUES ('Breakfast Menu'), ('Lunch Menu'), ('Dinner Menu');

INSERT INTO public."Dishes"(name)
	VALUES ('Eggs'), ('Cheeseburger'), ('Salmon'), ('Oatmeal'),
			('Pizza'), ('Rice');

INSERT INTO public."Recipes"(
	"dishId", name, instructions)
	VALUES (1, 'Scrambled Eggs', 'Crack the eggs and scrambled the insides. Then cook on hot skillet'),
		(1, 'Sunny Side Up', ''),
		(1, 'Omelette', ''),
		(4, 'Plain Oatmeal', ''),
		(2, 'Flame Broiled Patty', 'Start a fire. Cook patty over the fire.'),
		(5, 'Oven Baked Pizza', ''),
		(5, 'Hawaiian Pizza', ''),
		(3, 'Oven Baked Salmon', 'Turn over to 400 degrees Fahrenheit. Place salmon filet in oven for 15 minutes.'),
		(6, 'Fried Rice', ''),
		(6, 'White Rice', '');
	
INSERT INTO public."Suppliers"(
	name, address, email)
	VALUES ('Virginia Chicken Ranch', 'Alexandria, VA', 'VAChikns@g.com'),
			('Texas Cow Fields', 'Houston, TX', 'EatCows@g.com'),
			('Atlantic Fishes', 'Boston, MA', 'BostonFishes@g.com'),
			('Ethnic Foods','NYC, NY','ethnicfoods@g.com'),
			('Food Service','Miami, FL','foodsvc@g.com'),
			('Sysco', 'Denver, CO', 'sysco@g.com'),
			('Mr. Fish', 'San Diego, CA', 'mrfish@g.com'),
			('Fruits', 'The Caribbeans', 'fruits@g.com');
		
INSERT INTO public."Tabletops"("seatCount")
	VALUES (4), (4), (4);

INSERT INTO public."Orders"(
	"tabletopId")
	VALUES (1), (2), (3);
	
INSERT INTO public."RecipeIngredients"(
	"recipeId", "ingredientId", quantity, unit)
	VALUES (1, 1, 2, 'eggs'),
			(2, 1, 1, 'eggs'),
			(3, 1, 3, 'eggs'),
			(4, 8, 1, 'lbs'),
			(4, 9, 0.50, 'ounces'),
			(4, 10, 0.10, 'ounces'),
			(5, 2, 1, '1/2 lbs patty'),
			(5, 3, 2, 'bun'),
			(5, 4, 1, 'thin slice'),
			(6, 7, 20, 'ounces')
			(6, 11, 2, 'lbs of flour'),
			(6, 13, 1, 'lbs'),
			(7, 7, 20, 'ounces')
			(7, 11, 2, 'lbs of flour'),
			(7, 13, 1, 'lbs'),
			(7, 6, 0.50, 'lbs'),
			(8, 5, 1, 'lbs'),
			(8, 14, 0.50, 'ounces'),
			(9, 12, 1 'lbs'),
			(9, 14, 0.50, 'ounces'),
			(10, 12, 1, 'lbs');
	
INSERT INTO public."MenuDishes"(
	"menuId", "dishId", price)
	VALUES (1, 1, 7.99), (1, 4, 4.99), (1, 5, 6.99),
	(2, 2, 9.99), (2, 5, 6.99), (2, 3, 12.99), 
	(3, 3, 19.99),(3, 2, 11.99), (3, 5 , 9.99);

INSERT INTO public."SupplierIngredients"(
	"supplierId", "ingredientId", "qtyAvailable", units, "unitCost")
	VALUES (1, 1, 100, 'egg', 0.05),
			(5, 1, 100, 'egg', 0.03),
			(6, 1, 100, 'egg', 0.90),
			(2, 2, 100, '1/2 lbs patty', 0.10),
			(4, 2, 100, '1/2 lbs patty', 0.20),
			(5, 3, 100, 'bun', 0.05),
			(6, 3, 100, 'bun', 0.10),
			(2, 4, 100, 'lbs', 1.20),
			(5, 4, 100, 'lbs', 1.00),
			(3, 5, 100, '1/2 lbs filet', 0.20),
			(7, 5, 100, '1/2 lbs filet', 0.25),
			(4, 6, 100, 'lbs', 0.30),
			(5, 6, 100, 'lbs', 0.40),
			(6, 6, 100, 'lbs', 0.50),
			(8, 6, 100, 'lbs', 0.20),
			(4, 7, 100, 'ounces', 0.03),
			(5, 7, 100, 'ounces', 0.01),
			(8, 7, 100, 'ounces', 0.02),
			(5, 8, 100, 'lbs', 0.05),
			(6, 8, 100, 'lbs', 0.06),
			(3, 9, 100, 'ounces', 0.01),
			(7, 9, 100, 'ounces', 0.01),
			(4, 10, 100, 'lbs', 0.10),
			(5, 10, 100, 'lbs', 0.15),
			(4, 11, 100, 'lbs of flour', 0.10),
			(6, 11, 100, 'lbs of flour', 0.12),
			(4, 12, 100, 'lbs', 0.04),
			(6, 12, 100, 'lbs', 0.03),
			(2, 13, 100, 'lbs', 0.20),
			(6, 13, 100, 'lbs', 0.40),
			(3, 14, 100, 'ounces', 0.25),
			(6, 14, 100, 'ounces', 0.30),
			(2, 15, 100, 'lbs', 0.30),
			(4, 15, 100, 'lbs', 0.40);	
					
INSERT INTO public."OrderDishes"(
	"orderId", "dishId", "menuId", quantity)
	VALUES (1, 1, 1, 1),
			(2, 2, 2, 1),
			(3, 3, 3, 1);