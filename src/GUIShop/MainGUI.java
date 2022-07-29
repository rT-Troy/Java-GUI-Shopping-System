package GUIShop;

import javax.swing.*;

public class MainGUI {

    private GoodList goodlist;
    private Bag shoppingBag;

    public MainGUI(GoodList list,Bag bag){
        goodlist = list;
        shoppingBag = bag;
        JFrame mainFrame = new JFrame("Shopping System");
        JPanel panel = new JPanel();
        Box mainBox = Box.createVerticalBox();
        Box firstLine = Box.createHorizontalBox();
        Box contentBox = Box.createHorizontalBox();


        ListPanel tlistPanel = new ListPanel(list,bag);
        bag = tlistPanel.getShopBag();
        JPanel listPanel = tlistPanel.getListPanel();
        BagPanel tbagPanel = new BagPanel(list,bag);
        JPanel bagPanel = tbagPanel.getBagPanel();


        firstLine.add(new JLabel(String.valueOf(bag.getShoppingBag().size())));
        contentBox.add(listPanel);
        contentBox.add(Box.createHorizontalStrut(10));
        contentBox.add(bagPanel);
        mainBox.add(firstLine);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(contentBox);

        panel.add(mainBox);
        mainFrame.add(panel);

        mainFrame.setBounds(200,200,1000,500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Bag getShoppingBag() {
        return shoppingBag;
    }

    public GoodList getGoodlist() {
        return goodlist;
    }
}
