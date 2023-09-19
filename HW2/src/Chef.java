public class Chef {
    private String name;
    private String specialty;
    private Recipe[] recipes;

    public Chef() {
        this.name = "Gordon Ramsay";
        this.specialty = "Lamb Sauce";
        this.recipes = new Recipe[]{new Recipe()};
    }

    public Chef(String n, String s, Recipe[] r) {
        if ((name == null) && ((n == null) || (n.trim().equals("")))) {
            name = "Gordon Ramsay";
        /*} else if ((n == null) || (!n.trim().equals(""))) {
            name = "Gordon Ramsay";*/
        } else {
            name = n.trim();
        }
        if ((specialty == null) && ((s == null) || (s.trim().equals("")))) {
            specialty = "Lamb Sauce";
        /*} else if ((s == null) || (!s.trim().equals(""))) {
            specialty = "Lamb Sauce";*/
        } else {
            specialty = s.trim();
        }
        if (r.length > 0 && r.length <= 10) {
            recipes = r;
        } else {
            recipes[0] = new Recipe();
        }
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }

    public void cook(int index) {
        Recipe[] r = getRecipes();
        if (index < 0 || index >= r.length) {
            System.out.println("What is this nonsense? Get out of my kitchen, I won't make that!");
        } else {
            System.out.println("Bon Appetit! Using");
            Ingredient[] ingredients = r[index].getIngredients();
            for (int i = 0; i < ingredients.length; i++) {
                System.out.println(ingredients[i].getQuantity() + " grams of " + ingredients[i].getKind());
            }
            if (r[index].getName().equals(getSpecialty())) {
                System.out.println("I, " + getName() + ", finished cooking "
                        + r[index].getName() + " after "
                        + r[index].getPrepTime() / 2 + " minutes(s). This can serve "
                        + r[index].getNumServings() + " people.");
            } else {
                System.out.println("I, " + getName() + ", finished cooking "
                        + r[index].getName() + " after "
                        + r[index].getPrepTime() + " minutes(s). This can serve "
                        + r[index].getNumServings() + " people.");
            }
        }
    }

    public void cater(int people) {
        Recipe[] r = getRecipes();
        boolean available = false;
        for (int i = 0; i < r.length; i++) {
            if (r[i].getNumServings() >= people) {
                cook(i);
                available = true;
                break;
            }
        }
        if (!available) {
            System.out.println("My gran could do better... than me?!");
        }
    }
}

