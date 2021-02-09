select *,
    from "Dishes" as d
        left join "Recipes" as r
            on d."id" = r."dishId"
        left join "RecipeIngredients" as ri
            on ri."recipeId" = r."id"
        left join (
            select t."ingredientid", t."min", i."name"
                from (
                    select si."ingredientid", min("unitcost")
                        from "SupplierIngredients" as si
                        group by "ingredientid"
                ) as t
                inner join "Ingredients" as i
                    on i."ingredientid" = t."ingredientid"
            ) as imin
            on ri."ingredientid" = imin."ingredientid";