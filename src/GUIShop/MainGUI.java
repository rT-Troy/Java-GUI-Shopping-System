package GUIShop;

import javax.swing.*;

public class MainGUI {

    /**
     * Main GUI Frame-with BoxLayOut
     * @param list the provided goods List
     * @param bag the provided shopping Bag
     */
    public MainGUI(GoodList list,Bag bag){
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

        //start
        firstLine.add(new JLabel("Welcome!"));

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
}
