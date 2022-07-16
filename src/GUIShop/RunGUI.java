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

        Box mainBox = Box.createVerticalBox();
        Box firstLine = Box.createHorizontalBox();
        //Box mContBox = Box.createHorizontalBox();
        Box listBox = Box.createVerticalBox();
        Box bagBox = Box.createVerticalBox();
        Box perBagBox = Box.createHorizontalBox();
        ArrayList<Box> listBagArrayList = new ArrayList<Box>();
        ArrayList<Box> listBoxArrayList = new ArrayList<Box>();


        //Start
        JFrame frame = new JFrame("Shopping System");
        JTextField searchText = createBoxTextField();
        searchText.setText("Type to search...");
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        firstLine.add(new JLabel("Welcome!"));
        firstLine.add(searchText);
        firstLine.add(searchButton);


        for (int i = 0; i < allGoods.getGoodList().size(); i++) {
            Box perListBox = Box.createHorizontalBox();
            JLabel nameLabel = new JLabel();
            JLabel priceLabel = new JLabel();
            nameLabel.setText(allGoods.getGoodList().get(i).getgName());
            priceLabel.setText(allGoods.getGoodList().get(i).getgPrice()+" $");
            nameLabel.setFont(new Font("good", Font.ITALIC,20));
            priceLabel.setFont(new Font("good2", Font.PLAIN,15));
            nameLabel.setHorizontalAlignment(JLabel.LEFT);
            perListBox.add(nameLabel);
            perListBox.add(Box.createHorizontalStrut(10));
            perListBox.add(priceLabel);
            perListBox.add(Box.createHorizontalStrut(5));
            listBoxArrayList.add(perListBox);
        }
        for (int i = 0; i < listBoxArrayList.size(); i++) {
            listBox.add(listBoxArrayList.get(i));
            listBox.add(Box.createVerticalStrut(5));
        }

        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(firstLine);
        mainBox.add(listBox);

        frame.add(mainBox);
        frame.setBounds(200,200,700,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JTextField createBoxTextField() {
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(textField.getPreferredSize());
        return textField;
    }



}
