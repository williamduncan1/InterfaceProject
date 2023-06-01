
public class Pencil {
    private double price;
    private String color;
    private String quality;
    private String size;

    public Pencil(String c, String q, String s, double p){
        price = p;
        color = c;
        quality = q;
        size = s;
    }

    public double getPrice(){
        return price;
    }

    public String getColor(){
        return color;
    }

    public String getQuality(){
        return quality;
    }

    public String getSize(){
        return size;
    }

}
