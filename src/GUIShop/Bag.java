package GUIShop;

import java.util.ArrayList;

public class Bag {

    private ArrayList<Good> shoppingBag;
    private ArrayList<Integer> count;
    private int xx =0;

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


    public void addGood(Good good,int num) {

        if (findGoodNum(good) == -1){
            shoppingBag.add(good);
            count.add(num);
        }else{
            count.set(findGoodNum(good),num+count.get(findGoodNum(good)));
        }
    }

    public void removeGood(Good good) {
        shoppingBag.remove(findGoodNum(good));
        count.remove(findGoodNum(good));
    }

    public void removeGood(int n) {
        shoppingBag.remove(n);
        count.remove(n);
    }

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
