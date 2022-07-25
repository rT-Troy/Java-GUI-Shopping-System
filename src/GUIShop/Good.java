package GUIShop;

public class Good {

    private int gId;
    private String gName;
    private double gPrice;
    private String gCategory;

    public Good(int id, String name, double price, String category){
        gId = id;
        gName = name;
        gPrice = price;
        gCategory = category;
    }

    public int getgId() {
        return gId;
    }

    public String getgName() {
        return gName;
    }

    public double getgPrice() {
        return gPrice;
    }

    public String getgCategory() {
        return gCategory;
    }

    @Override
    public String toString() {
        return "Good{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gCategory='" + gCategory + '\'' +
                '}';
    }
}
