import java.util.ArrayList;
import java.util.Scanner;

public class RunCheckOut {

    public static void main(String[] args) {
        ArrayList<Good> goodList = new ArrayList<Good>();
        GoodList allGoods = new GoodList(goodList);
        ArrayList<Good> bagList = new ArrayList<Good>();
        Bag bag = new Bag(bagList);
        Good good = null;
        allGoods.readFile("/Users/troy/Desktop/Shopping_System/src/goods.csv");

        System.out.println("Welcome to Troy's store!");
        Scanner scanner = new Scanner(System.in);
        boolean finish = false;


        while (!finish) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equals("help")) {
                    fHelp();
                } else if (input.equals("list")) {
                    fList(allGoods);
                } else if (input.equals("add")) {
                    fAdd(good, allGoods,bag);
                    fBag(bag);
                } else if (input.equals("del")) {
                    fBag(bag);
                    fDel(bag);
                } else if (input.equals("bag")) {
                    fBag(bag);
                } else if (input.equals("check")) {
                    fCheck(bag);
                    finish = true;
                }
            }
        }
    }

    private static void fList(GoodList list) {
        System.out.println(list.toString());
    }

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
                    if (g == null) {
                        System.out.println("opps!There's no good has been searched.");
                    } else {
                        b.addGood(g);
                    }
                }
            }
        }
    }

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

    private static void fBag(Bag b) {
        System.out.println("=============The bag============");
        System.out.println(b.toString());
        System.out.println("\"check\" to check out\n");
    }

    private static void fCheck(Bag b) {
        b.calculate();
    }

    private static void fHelp() {
        System.out.println("1.help,2.list,3.add,4.del,5.bag,6.check");
    }

}
