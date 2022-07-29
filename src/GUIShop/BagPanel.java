package GUIShop;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BagPanel {

    private JPanel bagPanel;

    /**
     * the shopping bag panel of the main content panel shows on the right
     * @param list the provided goods List
     * @param bag the provided shopping bag
     */
    public BagPanel(GoodList list, Bag bag){
        JPanel panel = new JPanel();
        JLabel amoMoney = new JLabel();
        ArrayList<Box> perBagArrayList = new ArrayList<Box>();
        Box bagBox = Box.createVerticalBox();

        //start
        //check if shopping bag ain't empty
        if(!bag.getShoppingBag().isEmpty()) {
            for (int i = 0; i < bag.getShoppingBag().size(); i++) {
                int ii = i;
                JButton remButton = new JButton("-");
                Box perBagBox = Box.createHorizontalBox();
                JPanel perBagPanel = new JPanel();
                //per line
                perBagPanel.add(new JLabel(bag.getShoppingBag().get(i).getgName()));
                perBagPanel.add(Box.createHorizontalStrut(5));
                perBagPanel.add(new JLabel((bag.getShoppingBag().get(i).getgPrice() + "$")));

                int value = bag.getCount().get(i);
                //spinner
                SpinnerNumberModel model = new SpinnerNumberModel(value,1,99,1);
                JSpinner spin = new JSpinner(model);
                perBagPanel.add(spin);
                spin.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        int num = Integer.parseInt(((JSpinner)e.getSource()).getValue().toString());
                        bag.changeInBag(ii,num);
                        new MainGUI(list,bag);
                    }
                });
                //remove button
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
            //check out button
            JButton coButton = new JButton("Check out");
            coButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    amoMoney.setText(bag.checkOut());
                }
            });
            //shows
            bagBox.add(new JLabel("Bag"));
            for (Box box : perBagArrayList) {
                bagBox.add(box);
                bagBox.add(Box.createVerticalStrut(5));
            }
            bagBox.add(coButton);
            bagBox.add(amoMoney);
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
