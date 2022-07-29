package GUIShop;

import java.util.ArrayList;

public class RunGUI {

    public RunGUI(){
        ArrayList<Good> goodList = new ArrayList<Good>();
        GoodList allGoods = new GoodList(goodList);
        ArrayList<Good> bagList = new ArrayList<Good>();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        Bag bag = new Bag(bagList,numList);

        //read file for macOS or Windows
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/ComShop/goods.csv");
        //allGoods.readFile("C:\\Users\\18111\\Desktop\\Shopping_System\\src\\GUIShop\\goods.csv");

        new MainGUI(allGoods,bag);
    }

    public static void main(String[] args) {
        new RunGUI();
    }

}
