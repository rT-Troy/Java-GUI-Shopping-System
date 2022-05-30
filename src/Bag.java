import java.util.ArrayList;

public class Bag {

    private int numId;
    private ArrayList<Good> bag;


    public Bag(ArrayList<Good> shoppingBag){
        bag = shoppingBag;
    }

    public ArrayList<Good> getBag() {
        return bag;
    }

    /*
    add good to bag
     */
    public void addGood(int id, String name, double price, String category){
        Good good = new Good(id, name, price, category);
        bag.add(good);
    }

    /*
    delete good from bag by ArrayList id
     */
    public void delGood(int ListId){
        Good good = bag.get(ListId);
        bag.remove(good);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bag.size(); i++) {
            sb.append(i);
            sb.append(bag.get(i).toString());
            sb.append("\n");
        }
        String str = sb.toString();
        return str;
    }
}
