select mn."id", MAX(md."price" - (ri."quantity" * "min")) as profit
	from "Menus" as mn
		left join "MenuDishes" as md
			on mn."id" = md."menuId"
    	left join "Dishes" as d
			on md."dishId" = d."id"
        left join "Recipes" as r
            on d."id" = r."dishId"	
        left join "RecipeIngredients" as ri
			on r."id" = ri."recipeId"		
        left join (
            select t."ingredientId", t."min", i."name"
                from (
                    select si."ingredientId", min("unitCost")
                        from "SupplierIngredients" as si
                        group by "ingredientId"
                ) as t
                inner join "Ingredients" as i
                    on i."id" = t."ingredientId"
            ) as imin
            on ri."ingredientId" = imin."ingredientId"
	group by mn."id";