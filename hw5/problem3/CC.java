package hw5.problem3;
/**
 *  Wenhan Cai
 *  CS 5004 homework 5-3
 */
class Pizza {

    public Pizza(){
        this.setSize("");
        this.setCheeseTopping(0);
        this.setPepperoniTopping(0);
        this.setHamTopping(0);
    }

    /**
     * This is the copy constructor
     * @param other
     */
    public Pizza(Pizza other){
        setSize(other.size);
        setCheeseTopping(other.cheeseTopping);
        setPepperoniTopping(other.cheeseTopping);
        setHamTopping(other.hamTopping);
    }

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

class PizzaOrder {

    int numPizzas;
    Pizza pizza1;
    Pizza pizza2;
    Pizza pizza3;

    public PizzaOrder(){
        setNumPizzas(0);
    }

    /**
     * This is the copy constructor
     * @param other
     */
    public PizzaOrder(PizzaOrder other){
        this.numPizzas = other.numPizzas;
        this.pizza1 = other.pizza1;
        this.pizza2 = other.pizza2;
        this.pizza3 = other.pizza3;
    }

    public PizzaOrder(int numPizzas){
        if(numPizzas>3 || numPizzas < 1) throw new IllegalArgumentException("Illegal number.");
        setNumPizzas(numPizzas);

        if(numPizzas == 1) this.pizza1 = new Pizza();

        if(numPizzas == 2)
            this.pizza1 = new Pizza();
        this.pizza2 = new Pizza();

        if(numPizzas == 3)
            this.pizza1 = new Pizza();
        this.pizza2 = new Pizza();
        this.pizza3 = new Pizza();
    }

    public void setNumPizzas(int numPizzas){
        this.numPizzas = numPizzas;
    }

    public void setPizza1(Pizza pizza1){
        this.pizza1 = pizza1;

    }

    public void setPizza2(Pizza pizza2){
        if(this.numPizzas == 1) throw new IllegalCallerException("Only one pizza in this order. Unable to set a second pizza.");
        this.pizza2 = pizza2;
    }

    public void setPizza3(Pizza pizza3){
        if(this.numPizzas == 1 || this.numPizzas == 2) throw new IllegalCallerException("Less than three pizza in this order");
        this.pizza3 = pizza3;
    }

    public double calcTotal(){
        double total = 0.0;
        if(this.numPizzas == 1){
            total = this.pizza1.calCost();
        }
        else if(this.numPizzas == 2){
            total = this.pizza1.calCost()+this.pizza2.calCost();
        }
        else {
            total = this.pizza1.calCost()+this.pizza2.calCost()+this.pizza3.calCost();
        }
        return total;
    }

}

//public class CC {
//
//    public static void main(String[] args) {
////        PizzaOrder order1 = new PizzaOrder(4);  --> IllegalArgumentException: Illegal number.
//        PizzaOrder order2 = new PizzaOrder(2);
//        Pizza pizza1 = new Pizza("small", 1, 1, 1);
//        Pizza pizza2 = new Pizza("large", 2, 2, 2);
//        Pizza pizza3 = new Pizza(pizza1);
//        pizza3.setSize("medium");
//        order2.setPizza1(pizza1);
//        order2.setPizza2(pizza2);
//        PizzaOrder order3 = new PizzaOrder(order2);
//        order3.setNumPizzas(3);
//        order3.setPizza3(pizza3);
//        System.out.println(order3.pizza1.getDescription());
//        System.out.println(order3.pizza2.getDescription());
//        System.out.println(order3.pizza3.getDescription());
//    }
//}
