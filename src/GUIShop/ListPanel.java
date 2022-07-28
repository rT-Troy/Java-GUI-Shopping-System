package GUIShop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListPanel{

    private JPanel listPanel;

    public ListPanel(GoodList list){
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("List");
        ArrayList<Box> perListArrayList = new ArrayList<Box>();
        Box listBox = Box.createVerticalBox();
        for (int i = 0; i < list.getGoodList().size(); i++) {
            Box perListBox = Box.createHorizontalBox();
            perListBox.add(new JLabel(list.getGoodList().get(i).getgName()));
            perListBox.add(Box.createHorizontalStrut(5));
            perListBox.add(new JLabel((list.getGoodList().get(i).getgPrice()+"$")));
            perListArrayList.add(perListBox);
        }
        listBox.add(label);
        for (Box box : perListArrayList) {
            listBox.add(box);
            listBox.add(Box.createVerticalStrut(5));
        }
        panel.add(listBox);
        listPanel = panel;
    }

    public JPanel getListPanel() {
        return listPanel;
    }
}
