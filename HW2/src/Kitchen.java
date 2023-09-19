public class Kitchen {
    public static void main(String[] args) {
        Ingredient i1 = new Ingredient(1.5, "Milk");
        Ingredient i2 = new Ingredient(3, "Eggs");
        Ingredient i3 = new Ingredient(7.5, "Flour");
        Ingredient i4 = new Ingredient();
        Ingredient[] ingredients = new Ingredient[] {i1, i2, i3, i4};
        Recipe r1 = new Recipe("Cookies", 40, 5, ingredients);
        Recipe r2 = new Recipe();
        Recipe[] recipes = new Recipe[] {r1, r2};
        Chef standard = new Chef();
        Chef chef = new Chef("Chef", "Cookies", recipes);
        standard.cook(0);
        standard.cook(1);
        standard.cater(8);
        standard.cater(0);
        chef.cook(0);
        chef.cook(1);
        chef.cater(5);
        chef.cater(8);
        r1.scaleRecipe(4);
        chef.cook(0);
        System.out.println(r1.dominantIngredient().getQuantity());
    }
}
