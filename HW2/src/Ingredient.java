public class Ingredient {
    private String kind;
    private double quantity;
    public Ingredient() {
        this.kind = "Salt";
        this.quantity = 0.2;
    }
    public Ingredient(double q, String k) {
        boolean a = false;
        boolean b = false;
        if ((k == null) || (k.trim().equals(""))) {
            a = true;
        }
        if (q <= 0) {
            b = true;
        }
        if ((kind == null) && (a)) {
            kind = "Salt";
        } else {
            kind = k.trim();
        }
        if (b) {
            quantity = 0.2;
        } else {
            quantity = q;
        }
    }
    public String getKind() {
        return kind;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setKind(String k) {
        if ((k != null) && (!k.trim().equals(""))) {
            kind = k.trim();
        }
    }
    public void setQuantity(double q) {
        if (q > 0) {
            quantity = q;
        }
    }
}
