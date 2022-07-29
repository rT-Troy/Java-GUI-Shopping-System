/**
 * Simple Shopping System
 * Author: Jun Zhang
 * Date: 29th July 2022
 */
package GUIShop;

import GUIShop.MainGUI;

import java.util.ArrayList;

public class RunGUI {
    public static void main(String[] args) {
        ArrayList<Good> list = new ArrayList<Good>();
        GoodList allGoods = new GoodList(list);
        ArrayList<Good> bagList = new ArrayList<Good>();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        Bag bag = new Bag(bagList,numList);

        //read file for macOS or Windows
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/ComShop/goods.csv");
        //allGoods.readFile("C:\\Users\\18111\\Desktop\\Shopping_System\\src\\GUIShop\\goods.csv");

        new MainGUI(allGoods,bag);
    }
}
