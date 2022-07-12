package GUIShop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RunGUI {

    public static void main(String[] args) {
        ArrayList<Good> goodList = new ArrayList<Good>();
        GoodList allGoods = new GoodList(goodList);
        ArrayList<Good> bagList = new ArrayList<Good>();
        Bag bag = new Bag(bagList);
        Good good = null;
        boolean finish = false;
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/ComShop/goods.csv");


        //Start
        JFrame frame = new JFrame("Shopping System");
        JPanel listPanel = new JPanel();
        JPanel BagPanel = new JPanel();
        JPanel cards = new JPanel(new CardLayout());
        listPanel.add(new JLabel("Welcome!"));

        cards.add(listPanel,"list");
        cards.add(BagPanel,"bag");
        CardLayout c1 = (CardLayout)cards.getLayout();
        c1.show(cards,"list");

        frame.add(cards);
        frame.setBounds(200,200,700,500);
        frame.setVisible(true);

    }
}
