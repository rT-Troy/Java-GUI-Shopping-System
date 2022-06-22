/**
 * Simple Shopping System
 * Author: Jun Zhang
 * Date: 31st May 2022
 */
package ComShop;
import java.util.ArrayList;
import java.util.Scanner;

public class RunCheckOut {

    public static void main(String[] args) {
        ArrayList<Good> goodList = new ArrayList<Good>();
        GoodList allGoods = new GoodList(goodList);
        ArrayList<Good> bagList = new ArrayList<Good>();
        Bag bag = new Bag(bagList);
        Good good = null;
        boolean finish = false;
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/ComShop/goods.csv");

        //switch by different input
        System.out.println("Welcome to Troy's store! Type \"help\" for more information.");
        Scanner scanner = new Scanner(System.in);
        while (!finish) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                switch (input) {
                    case "help" -> fHelp();
                    case "list" -> fList(allGoods);
                    case "add" -> {
                        fAdd(good, allGoods, bag);
                        fBag(bag);
                    }
                    case "del" -> {
                        fBag(bag);
                        fDel(bag);
                    }
                    case "bag" -> fBag(bag);
                    case "check" -> {
                        fCheck(bag);
                        finish = true;
                    }
                    case "sort" -> fCategory(allGoods);
                }
            }
        }
    }

    /**
     * help
     */
    private static void fHelp() {
        System.out.println("1.help,  2.list,  3.add,  4.del,  5.bag,  6.check,  7.sort");
    }

    /**
     * List everything
     * @param list the given list transfer by .csv file
     */
    private static void fList(GoodList list) {
        System.out.println(list.toString());
    }

    /**
     * Function to adding good to bag
     * @param g the given good
     * @param ag the whole list
     * @param b the bag
     */
    private static void fAdd(Good g, GoodList ag, Bag b) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type the good's name: ");
        if (scan.hasNextLine()) {
            String input = scan.nextLine();
            g = ag.search(input);
            System.out.print("Result: ");
            System.out.println(g.toString());
            System.out.println("Do you wanna add it to the bag? y/n");
            if (scan.hasNextLine()) {
                String bl = scan.nextLine();
                if (bl.equals("y")) {
                    b.addGood(g);
                }
            }
        }
    }

    /**
     * delete good from bag
     * @param b bag
     */
    private static void fDel(Bag b) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type the good's number: ");
        if (scan.hasNextInt()) {
            int num = scan.nextInt();
            if (b.getShoppingBag().contains(b.getShoppingBag().get(num-1))) {
                b.delGood(num);
                System.out.println("Delete success!");
            } else {
                System.out.println("oops! good not found!");
            }
        }
    }

    /**
     * list the bag
     * @param b bag
     */
    private static void fBag(Bag b) {
        System.out.println("=============The bag============");
        System.out.println(b.toString());
        System.out.println("\"check\" to check out\n");
    }

    /**
     * check out
     * @param b bag
     */
    private static void fCheck(Bag b) {
        b.calculate();
    }

    /**
     * sort all goods
     * @param gl the all goods list
     */
    private static  void fCategory(GoodList gl) {
        System.out.println("Type the category name: ");
        ArrayList<Good> same = new ArrayList<Good>();
        GoodList sameCat = new GoodList(same);
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            String str = scan.nextLine();
            for (int i = 0; i < gl.getGoodList().size(); i++) {
                if (str.equals(gl.getGoodList().get(i).getgCategory())) {
                    sameCat.getGoodList().add(gl.getGoodList().get(i));
                }
            }
        }
        System.out.println(sameCat.toString());

    }

}
