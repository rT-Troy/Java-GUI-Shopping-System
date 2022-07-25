package GUIShop;

import java.util.ArrayList;

public class Bag {

    private ArrayList<Good> shoppingBag;

    public Bag(ArrayList<Good> bag) {
        shoppingBag = bag;
    }

    public ArrayList<Good> getShoppingBag() {
        return shoppingBag;
    }

    /**
     * add good to bag
     * @param good the good
     */
    public void addGood(Good good) {
        shoppingBag.add(good);
    }

    /**
     * delete good from bag by bag-list ID
     * @param bagId bag-list ID
     */
    public void delGood(int bagId){
        shoppingBag.remove(bagId-1);
    }

    /**
     * get the total price
     */
    public void calculate() {
        double total = 0.0;
        for (Good good : shoppingBag) {
            total += good.getgPrice();
        }
        System.out.println("Total $" + total);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < shoppingBag.size(); i++) {
            sb.append(i+1);
            sb.append(shoppingBag.get(i).toString());
            //sb.append("\n");
        }
        return sb.toString();
    }

}
