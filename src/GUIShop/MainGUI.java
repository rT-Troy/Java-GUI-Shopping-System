package GUIShop;

import javax.swing.*;

public class MainGUI {
    private JFrame mainFrame;
    private GoodList goodList;
    private Bag shopBag;

    public MainGUI(GoodList list,Bag bag){
        goodList = list;
        shopBag = bag;
        mainFrame = new JFrame("Shopping System");
        JPanel panel = new JPanel();
        Box mainBox = Box.createVerticalBox();
        Box firstLine = Box.createHorizontalBox();
        Box contentBox = Box.createHorizontalBox();
        Box listBox = Box.createVerticalBox();
        Box bagBox = Box.createVerticalBox();

        ListPanel tlistPanel = new ListPanel(list,bag);
        bag = tlistPanel.getShopBag();
        JPanel listPanel = tlistPanel.getListPanel();
        BagPanel tbagPanel = new BagPanel(bag);
        JPanel bagPanel = tbagPanel.getBagPanel();

        listBox.add(listPanel);
        listBox.add(Box.createHorizontalStrut(10));
        listBox.add(bagPanel);

        firstLine.add(new JLabel("Welcome!"));
        contentBox.add(listBox);
        contentBox.add(Box.createHorizontalStrut(10));
        contentBox.add(bagBox);
        mainBox.add(firstLine);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(contentBox);

        panel.add(mainBox);
        mainFrame.add(panel);

        mainFrame.setBounds(200,200,1000,500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Bag getShopBag() {
        return shopBag;
    }
}
