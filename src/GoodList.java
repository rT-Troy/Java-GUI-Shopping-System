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


}
