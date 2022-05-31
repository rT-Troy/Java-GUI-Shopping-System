import java.util.ArrayList;

public class RunCheckOut {

    public static void main(String[] args) {
        ArrayList<Good> goodsList = new ArrayList<Good>();
        GoodList allGoods = new GoodList(goodsList);
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/goods.csv");

    }
}
