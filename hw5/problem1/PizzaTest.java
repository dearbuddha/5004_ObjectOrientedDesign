package hw5.problem1;
/**
 *  Wenhan Cai
 *  CS 5004 homework 5-1
 */
final class Pizza{

    public Pizza(String size, int cheeseTopping, int pepperoniTopping, int hamTopping){
        if(size.equals("small") || size.equals("medium") || size.equals("large") ) this.setSize(size);
        else throw new IllegalArgumentException("Instantiation failed. Illegal size.");
        this.setCheeseTopping(cheeseTopping);
        this.setPepperoniTopping(pepperoniTopping);
        this.setHamTopping(hamTopping);
    }

    private String size;
    private int cheeseTopping;
    private int pepperoniTopping;
    private int hamTopping;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCheeseTopping() {
        return cheeseTopping;
    }

    public void setCheeseTopping(int cheeseTopping) {
        this.cheeseTopping = cheeseTopping;
    }

    public int getPepperoniTopping() {
        return pepperoniTopping;
    }

    public void setPepperoniTopping(int pepperoniTopping) {
        this.pepperoniTopping = pepperoniTopping;
    }

    public int getHamTopping() {
        return hamTopping;
    }

    public void setHamTopping(int hamTopping) {
        this.hamTopping = hamTopping;
    }

    public double calCost(){
        double res;
        if(this.size.equals("small")){
            res = 10.0 + 2*(this.getCheeseTopping()+this.getPepperoniTopping()+this.getHamTopping());
        } else if(this.size.equals("medium")){
            res = 12.0 + 2*(this.getCheeseTopping()+this.getPepperoniTopping()+this.getHamTopping());
        } else {
            res = 14 + 2*(this.getCheeseTopping()+this.getPepperoniTopping()+this.getHamTopping());
        }
        return res;
    }

    public String getDescription(){
        return "Size: "+ this.getSize()+ ", CheeseTopping: "+ this.getCheeseTopping()+ ", PepperoniTopping: "
                + this.getPepperoniTopping() +", HamTopping: "+ this.getHamTopping() + ", Cost: "  + this.calCost();
    }
}

public class PizzaTest{
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("large", 1, 1, 2);
        System.out.println(pizza1.getDescription());
        Pizza pizza2 = new Pizza("small", 2, 2, 4);
        System.out.println(pizza2.getDescription());
//        Pizza pizza3 = new Pizza("extraLarge", 10,10,5); //this will throw an exception as expected
//        System.out.println(pizza3.getDescription());
    }

}
