package GUIShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListPanel{

    private JPanel listPanel;
    private Bag shopBag;

    public ListPanel(GoodList list,Bag bag){
        JPanel panel = new JPanel();
        JLabel title = new JLabel();
        JLabel feedBack = new JLabel();
        title.setText("List");
        ArrayList<Box> perListArrayList = new ArrayList<Box>();
        Box listBox = Box.createVerticalBox();
        for (int i = 0; i < list.getGoodList().size(); i++) {
            int ii = i;
            Box perListBox = Box.createHorizontalBox();
            JPanel perListPanel = new JPanel();
            JButton addButton = new JButton("+");
            perListPanel.add(new JLabel(list.getGoodList().get(i).getgName()));
            perListPanel.add(Box.createHorizontalStrut(5));
            perListPanel.add(new JLabel((list.getGoodList().get(i).getgPrice()+"$")));
            perListPanel.add(addButton);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bag.addGood(new Good(list.getGoodList().get(ii).getgId(),
                            list.getGoodList().get(ii).getgName(),
                            list.getGoodList().get(ii).getgPrice(),
                            list.getGoodList().get(ii).getgCategory()));
                    feedBack.setText(bag.getShoppingBag().get(bag.getShoppingBag().size()-1).getgName()+" added to bag successful!");
                    new MainGUI(list, bag);
                }
            });
            perListPanel.setBackground(Color.lightGray);
            perListBox.add(perListPanel);
            perListArrayList.add(perListBox);
        }
        listBox.add(title);
        for (Box box : perListArrayList) {
            listBox.add(box);
            listBox.add(Box.createVerticalStrut(5));
        }
        listBox.add(feedBack);
        panel.add(listBox);
        listPanel = panel;
        shopBag = bag;
    }

    public JPanel getListPanel() {
        return listPanel;
    }

    public Bag getShopBag() {
        return shopBag;
    }
}
