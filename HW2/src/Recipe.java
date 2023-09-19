public class Recipe {
    private String name;
    private int prepTime;
    private int numServings;
    private Ingredient[] ingredients;
    public Recipe() {
        this.name = "Lamb Sauce";
        this.prepTime = 60;
        this.numServings = 8;
        this.ingredients = new Ingredient[] {new Ingredient()};
    }
    public Recipe(String n, int pT, int nS, Ingredient[] i) {
        if ((name == null) && ((n == null) || (n.trim().equals("")))) {
            name = "Lamb Sauce";
        } else {
            name = n.trim();
        }
        if (pT > 0) {
            prepTime = pT;
        } else {
            prepTime = 60;
        }
        if (nS > 0) {
            numServings = nS;
        } else {
            numServings = 8;
        }
        if (i.length > 0) {
            ingredients = i;
        } else {
            ingredients[0] = new Ingredient();
        }
    }
    public String getName() {
        return name;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public int getNumServings() {
        return numServings;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }
    public void setName(String n) {
        if ((n != null) && (!n.trim().equals(""))) {
            name = n;
        }
    }
    public void setPrepTime(int pT) {
        if (pT > 0) {
            prepTime = pT;
        }
    }
    public void setNumServings(int nS) {
        if (nS > 0) {
            numServings = nS;
        }
    }
    public void setIngredients(Ingredient[] i) {
        if (i.length > 0) {
            ingredients = i;
        }
    }
    public Ingredient dominantIngredient() {
        int max = 0;
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i].getQuantity() > ingredients[max].getQuantity()) {
                max = i;
            }
        }
        return ingredients[max];
    }
    public void scaleRecipe(int scale) {
        if (scale > 0) {
            this.prepTime = prepTime * scale;
            this.numServings = numServings * scale;
            for (int i = 0; i < ingredients.length; i++) {
                ingredients[i].setQuantity(ingredients[i].getQuantity() * scale);
            }
        }
    }
}
