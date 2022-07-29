package GUIShop;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListPanel{

    private JPanel listPanel;
    private Bag shopBag;
    private int num;

    /**
     * the good list panel of main content panel shows on the left
     * @param list the provided goods List
     * @param bag the provided shopping bag
     */
    public ListPanel(GoodList list,Bag bag){
        JPanel panel = new JPanel();
        JLabel feedBack = new JLabel();
        ArrayList<Box> perListArrayList = new ArrayList<Box>();
        Box listBox = Box.createVerticalBox();


        for (int i = 0; i < list.getGoodList().size(); i++) {
            num = 1;
            int ii = i;
            Box perListBox = Box.createHorizontalBox();
            JPanel perListPanel = new JPanel();
            JButton addButton = new JButton("+");
            //per line
            perListPanel.add(new JLabel(list.getGoodList().get(i).getgName()));
            perListPanel.add(Box.createHorizontalStrut(5));
            perListPanel.add(new JLabel((list.getGoodList().get(i).getgPrice()+"$")));
            //spinner
            SpinnerNumberModel model = new SpinnerNumberModel(1,1,99,1);
            JSpinner spin = new JSpinner(model);
            perListPanel.add(spin);
            spin.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    num = Integer.parseInt(((JSpinner)e.getSource()).getValue().toString());
                }
            });
            //add button
            perListPanel.add(addButton);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bag.addGood(new Good(list.getGoodList().get(ii).getgId(),
                            list.getGoodList().get(ii).getgName(),
                            list.getGoodList().get(ii).getgPrice(),
                            list.getGoodList().get(ii).getgCategory()),num);

                    new ListPanel(list, bag);
                    new MainGUI(list,bag);
                }
            });
            perListPanel.setBackground(Color.lightGray);
            perListBox.add(perListPanel);
            perListArrayList.add(perListBox);
        }
        //shows
        listBox.add(new JLabel("List"));
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
