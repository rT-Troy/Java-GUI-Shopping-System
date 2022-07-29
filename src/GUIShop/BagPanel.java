package GUIShop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BagPanel {

    private JPanel bagPanel;

    public BagPanel(Bag bag){
        JPanel panel = new JPanel();
        JLabel title = new JLabel();
        title.setText("Bag");
        ArrayList<Box> perBagArrayList = new ArrayList<Box>();
        Box bagBox = Box.createVerticalBox();
        bagBox.add(title);
        if(!bag.getShoppingBag().isEmpty()) {
            for (int i = 0; i < bag.getShoppingBag().size(); i++) {
                Box perBagBox = Box.createHorizontalBox();
                JPanel perBagPanel = new JPanel();
                perBagPanel.add(new JLabel(bag.getShoppingBag().get(i).getgName()));
                perBagPanel.add(Box.createHorizontalStrut(5));
                perBagPanel.add(new JLabel((bag.getShoppingBag().get(i).getgPrice() + "$")));
                perBagPanel.add(new JLabel("x"+bag.getCount().get(i)));
                perBagPanel.setBackground(Color.blue);
                perBagBox.add(perBagPanel);
                perBagArrayList.add(perBagBox);
            }
            for (Box box : perBagArrayList) {
                bagBox.add(box);
                bagBox.add(Box.createVerticalStrut(5));
            }
        }else {
            bagBox.add(new JLabel("empty!"));
        }

        panel.add(bagBox);
        bagPanel = panel;
    }

    public JPanel getBagPanel() {
        return bagPanel;
    }
}
