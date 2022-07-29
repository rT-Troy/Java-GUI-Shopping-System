package GUIShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BagPanel {

    private JPanel bagPanel;

    public BagPanel(GoodList list, Bag bag){
        JPanel panel = new JPanel();
        JLabel title = new JLabel();
        title.setText("Bag");
        ArrayList<Box> perBagArrayList = new ArrayList<Box>();
        Box bagBox = Box.createVerticalBox();
        bagBox.add(title);
        if(!bag.getShoppingBag().isEmpty()) {
            for (int i = 0; i < bag.getShoppingBag().size(); i++) {
                int ii = i;
                JButton remButton = new JButton("-");
                Box perBagBox = Box.createHorizontalBox();
                JPanel perBagPanel = new JPanel();
                perBagPanel.add(new JLabel(bag.getShoppingBag().get(i).getgName()));
                perBagPanel.add(Box.createHorizontalStrut(5));
                perBagPanel.add(new JLabel((bag.getShoppingBag().get(i).getgPrice() + "$")));
                perBagPanel.add(new JLabel("x"+bag.getCount().get(i)));
                perBagPanel.add(remButton);
                remButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bag.removeGood(ii);
                        new MainGUI(list,bag);
                    }
                });
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
