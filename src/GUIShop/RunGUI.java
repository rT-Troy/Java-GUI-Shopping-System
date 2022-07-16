package GUIShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JTextField searchText = new JTextField();
        JButton searchButton = new JButton("Search");
        searchText.setColumns(20);
        searchText.setText("please tap here to search:");


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        listPanel.add(new JLabel("Welcome!"));
        listPanel.add(searchText);
        listPanel.add(searchButton);

        cards.add(listPanel,"list");
        cards.add(BagPanel,"bag");
        CardLayout c1 = (CardLayout)cards.getLayout();
        c1.show(cards,"list");
        //c1.show(cards,"bag");

        frame.add(cards);
        frame.setBounds(200,200,700,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
