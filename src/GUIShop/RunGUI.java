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
        Box mContBox = Box.createHorizontalBox();
        JLabel listLabel = new JLabel("list");
        JLabel bagLabel = new JLabel("bag");
        JPanel mainListPanel = new JPanel();
        JPanel mainBagPanel = new JPanel();
        Box listBox = Box.createVerticalBox();
        Box bagBox = Box.createVerticalBox();
        ArrayList<Box> listBagArrayList = new ArrayList<Box>();
        ArrayList<Box> listBoxArrayList = new ArrayList<Box>();
        ArrayList<JPanel> bagPanelArrayList = new ArrayList<JPanel>();


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

        //first line
        firstLine.add(new JLabel("Welcome!"));
        firstLine.add(searchText);
        firstLine.add(searchButton);
        

        //list box
        listBox.add(listLabel);
        for (int i = 0; i < allGoods.getGoodList().size(); i++) {
            Box perListBox = Box.createHorizontalBox();
            JPanel perListPanel = new JPanel();
            JLabel nameLabel = new JLabel();
            JLabel priceLabel = new JLabel();
            SpinnerModel spin = new SpinnerNumberModel(1,1,99,1);
            JSpinner spinner = new JSpinner(spin);
            nameLabel.setText(allGoods.getGoodList().get(i).getgName());
            priceLabel.setText(allGoods.getGoodList().get(i).getgPrice()+" $");
            nameLabel.setFont(new Font("good", Font.ITALIC,20));
            priceLabel.setFont(new Font("good2", Font.PLAIN,15));
            JButton perAdd = new JButton("+");
            //per good make a line
            perListPanel.add(nameLabel);
            perListPanel.add(Box.createHorizontalStrut(10));
            perListPanel.add(priceLabel);
            perListPanel.add(Box.createHorizontalStrut(5));
            perListPanel.add(spinner);
            perListPanel.add(Box.createHorizontalStrut(5));
            perListPanel.add(perAdd);
            perListPanel.setBackground(Color.gray);
            perListBox.add(perListPanel);
            listBoxArrayList.add(perListBox);

            perAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bagPanelArrayList.add(perListPanel);
                }
            });
        }for (int i = 0; i < listBoxArrayList.size(); i++) {
            listBox.add(listBoxArrayList.get(i));
            listBox.add(Box.createVerticalStrut(5));
        }
        mainListPanel.add(listBox);

        //bag box
        Box perBagBox = Box.createHorizontalBox();
        perBagBox.add(bagLabel);
        for (int i = 0; i < bagPanelArrayList.size(); i++) {
            perBagBox.add(bagPanelArrayList.get(i));
            bagBox.add(perBagBox);
        }
        

        //set in
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(firstLine);
        mContBox.add(mainListPanel);
        mContBox.add(Box.createHorizontalStrut(30));
        mContBox.add(mainBagPanel);
        mainBox.add(mContBox);
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
