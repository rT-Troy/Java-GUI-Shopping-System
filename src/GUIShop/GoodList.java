package GUIShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GoodList {

    private ArrayList<Good> goodList;

    public GoodList(ArrayList<Good> list) {
        goodList = list;
    }

    public ArrayList<Good> getGoodList() {
        return goodList;
    }

    /**
     * read the file and generate all good list
     * @param fileName file name (xx.csv)
     */
    public void readFile(String fileName) {
        File shopFile = new File(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(shopFile);
            scanner.useDelimiter(",");
            int id;
            String name;
            double price;
            String category;
            while (scanner.hasNext()) {
                String[] inputArray = scanner.nextLine().split(",");
                id = Integer.parseInt(inputArray[0]);
                name = inputArray[1];
                price = Double.parseDouble(inputArray[2]);
                category = inputArray[3];
                goodList.add(new Good(id, name, price, category));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Good search(String name) {
        int n = -1;
        for (int i = 0; i < goodList.size(); i++) {
            if(goodList.get(i).getgName().equals(name)){
                n = i;
                break;
            }
        }
        return goodList.get(n);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Good good : goodList) {
            sb.append(good);
            //sb.append("\n");
        }
        return sb.toString();
    }
}
