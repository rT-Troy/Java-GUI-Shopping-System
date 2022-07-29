package GUIShop;

import java.util.ArrayList;

public class Bag {

    private ArrayList<Good> shoppingBag;
    private ArrayList<Integer> count;

    /**
     * Constructor
     * @param bag the bag with all goods
     * @param num the count of each goods, with same position in there own list
     */
    public Bag(ArrayList<Good> bag,ArrayList<Integer> num) {
        shoppingBag = bag;
        count = num;
    }

    public ArrayList<Good> getShoppingBag() {
        return shoppingBag;
    }

    public ArrayList<Integer> getCount() {
        return count;
    }

    /**
     * add good on list panel
     * @param good the specified good
     * @param num the spinner shows count
     */
    public void addGood(Good good,int num) {

        if (findGoodNum(good) == -1){
            shoppingBag.add(good);
            count.add(num);
        }else{
            count.set(findGoodNum(good),num+count.get(findGoodNum(good)));
        }
    }

    /**
     * remove good from bag in bag panel
     * @param n the position of both ArrayList
     */
    public void removeGood(int n) {
        shoppingBag.remove(n);
        count.remove(n);
    }

    /**
     * change count in bag panel
     * @param no the position of both ArrayList
     * @param be how much count it will be
     */
    public void changeInBag(int no,int be){
        count.set(no,be);
    }

    /**
     * check out function in bag panel
     * @return String of total cost sentence
     */
    public String checkOut(){
        double amount = 0;
        for (int i = 0; i < shoppingBag.size(); i++) {
            amount += shoppingBag.get(i).getgPrice()*count.get(i);
        }
        return "Total: "+amount+" $";
    }

    /**
     * judge if the specified good exist in bag ArrayList
     * @param good the specified good
     * @return the position of both ArrayList, not exist with '-1' return
     */
    //return -1 if not found
    public int findGoodNum(Good good) {
        int num = -1;
        String gName = good.getgName();
        for (int i = 0; i < shoppingBag.size(); i++) {
            if (shoppingBag.get(i).getgName().equals(gName)) {
                num = i;
                break;
            }
        }
        return num;
    }


}
