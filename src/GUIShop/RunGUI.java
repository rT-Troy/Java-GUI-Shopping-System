package GUIShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RunGUI {

    public RunGUI(){
        ArrayList<Good> goodList = new ArrayList<Good>();
        GoodList allGoods = new GoodList(goodList);
        ArrayList<Good> bagList = new ArrayList<Good>();
        Bag bag = new Bag(bagList);
        Good good = null;
        boolean getFirst = false;
        boolean finish = false;
        //read file for macOS
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/ComShop/goods.csv");
        //read file for pc
        //allGoods.readFile("C:\\Users\\18111\\Desktop\\Shopping_System\\src\\GUIShop\\goods.csv");

        new MainGUI(allGoods,bag);
    }
/*        ArrayList<Good> goodList = new ArrayList<Good>();
        GoodList allGoods = new GoodList(goodList);
        ArrayList<Good> bagList = new ArrayList<Good>();
        Bag bag = new Bag(bagList);
        Good good = null;
        boolean getFirst = false;
        boolean finish = false;
        //read file for macOS
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/ComShop/goods.csv");
        //read file for pc
        //allGoods.readFile("C:\\Users\\18111\\Desktop\\Shopping_System\\src\\GUIShop\\goods.csv");

        Box firstLine = Box.createHorizontalBox();

        Box mainBox = Box.createVerticalBox();
        Box mContBox = Box.createHorizontalBox();
        JLabel listLabel = new JLabel("list");
        JLabel bagLabel = new JLabel("bag");
        JPanel mainListPanel = new JPanel();
        JPanel mainBagPanel = new JPanel();
        Box listBox = Box.createVerticalBox();
        Box bagBox = Box.createVerticalBox();
        ArrayList<Box> listBoxArrayList = new ArrayList<Box>();
        ArrayList<JPanel> bagPanelArrayList = new ArrayList<JPanel>();

        JLabel bnameLabel = new JLabel();
        JLabel bpriceLabel = new JLabel();



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
            //SpinnerModel spin = new SpinnerNumberModel(1,1,99,1);
            //JSpinner spinner = new JSpinner(spin);
            nameLabel.setText(allGoods.getGoodList().get(i).getgName());
            priceLabel.setText(allGoods.getGoodList().get(i).getgPrice()+" $");
            nameLabel.setFont(new Font("good", Font.ITALIC,20));
            priceLabel.setFont(new Font("good2", Font.PLAIN,15));
            JButton perAdd = new JButton("+"+allGoods.getGoodList().get(i).getgId());
            //per good make a line
            perListPanel.add(nameLabel);
            perListPanel.add(Box.createHorizontalStrut(10));
            perListPanel.add(priceLabel);
            perListPanel.add(Box.createHorizontalStrut(5));
            //perListPanel.add(spinner);
            //perListPanel.add(Box.createHorizontalStrut(5));
            perListPanel.add(perAdd);
            perListPanel.setBackground(Color.gray);
            perListPanel.setName(""+i);
            perListBox.add(perListPanel);
            listBoxArrayList.add(perListBox);

            perAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel perBagPanel = new JPanel();
                    Box perBagBox = Box.createHorizontalBox();
                    ArrayList<Box> bagBoxArrayList = new ArrayList<Box>();

                    bag.addGood(allGoods.getGoodList().get(Integer.parseInt(perListPanel.getName())));
                    //bagLabel.setText(bag.getShoppingBag().toString());
                    bnameLabel.setText(bag.getShoppingBag().get(bag.getShoppingBag().size()-1).getgName());
                    bpriceLabel.setText(bag.getShoppingBag().get(bag.getShoppingBag().size()-1).getgPrice()+" $");
                    bnameLabel.setFont(new Font("good", Font.ITALIC,20));
                    bpriceLabel.setFont(new Font("good2", Font.PLAIN,15));
                    //per good make a line
                    perBagPanel.add(bnameLabel);
                    perBagPanel.add(Box.createHorizontalStrut(10));
                    perBagPanel.add(bpriceLabel);
                    perBagPanel.add(Box.createHorizontalStrut(5));
                    perBagPanel.setBackground(Color.gray);
                    perBagBox.add(perBagPanel);
                    bagBoxArrayList.add(perBagBox);
                    for (int i = 0; i < bagBoxArrayList.size(); i++) {
                        bagBox.add(bagBoxArrayList.get(i));
                        bagBox.add(Box.createVerticalStrut(5));
                    }
                    //mainListPanel.add(listBox);
                    mainBagPanel.add(bagBox);


                    //set in
                    mainBox.add(firstLine);
                    mContBox.add(mainListPanel);
                    //mContBox.add(Box.createHorizontalStrut(10));
                    mContBox.add(mainBagPanel);
                    mainBox.add(mContBox);


                }
            });
        }for (int i = 0; i < listBoxArrayList.size(); i++) {
            listBox.add(listBoxArrayList.get(i));
            listBox.add(Box.createVerticalStrut(5));
        }

        //bag
*//*        bagBox.add(bagLabel);
        for (int i = 0; i < bag.getShoppingBag().size(); i++) {
            Box perBagBox = Box.createHorizontalBox();
            JPanel perBagPanel = new JPanel();
            JLabel nameLabel = new JLabel();
            JLabel priceLabel = new JLabel();
            //SpinnerModel spin = new SpinnerNumberModel(1,1,99,1);
            //JSpinner spinner = new JSpinner(spin);
            nameLabel.setText(bag.getShoppingBag().get(i).getgName());
            priceLabel.setText(bag.getShoppingBag().get(i).getgPrice()+" $");
            nameLabel.setFont(new Font("good", Font.ITALIC,20));
            priceLabel.setFont(new Font("good2", Font.PLAIN,15));
            //per good make a line
            perBagPanel.add(nameLabel);
            perBagPanel.add(Box.createHorizontalStrut(10));
            perBagPanel.add(priceLabel);
            perBagPanel.add(Box.createHorizontalStrut(5));
            perBagPanel.setBackground(Color.gray);
            perBagPanel.setName(""+i);
            perBagBox.add(perBagPanel);
            bagBoxArrayList.add(perBagBox);
        }for (int i = 0; i < bagBoxArrayList.size(); i++) {
            bagBox.add(bagBoxArrayList.get(i));
            bagBox.add(Box.createVerticalStrut(5));
        }*//*

        bagBox.add(bagLabel);
        mainListPanel.add(listBox);
        mainBagPanel.add(bagBox);


        //set in
        //mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(firstLine);
        mContBox.add(mainListPanel);
        //mContBox.add(Box.createHorizontalStrut(10));
        mContBox.add(mainBagPanel);
        mainBox.add(mContBox);
        frame.add(mainBox);
        frame.setBounds(200,200,1000,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JTextField createBoxTextField() {
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(textField.getPreferredSize());
        return textField;
    }*/

    public static void main(String[] args) {
        new RunGUI();
    }

}
