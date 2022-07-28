package GUIShop;

import javax.swing.*;

public class MainGUI {
    private JFrame mainFrame;
    private GoodList goodList;

    public MainGUI(GoodList list){
        goodList = list;
        mainFrame = new JFrame("Shopping System");
        JPanel panel = new JPanel();
        Box mainBox = Box.createVerticalBox();
        Box firstLine = Box.createHorizontalBox();
        Box contentBox = Box.createHorizontalBox();
        Box listBox = Box.createVerticalBox();
        Box bagBox = Box.createVerticalBox();

        ListPanel tlistPanel = new ListPanel(goodList);
        JPanel listPanel = tlistPanel.getListPanel();

        listBox.add(listPanel);

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

    public GoodList getGoodList() {
        return goodList;
    }
}
