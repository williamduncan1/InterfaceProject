
import java.util.ArrayList;

public class Superstore {
    private String name;
    private ArrayList<Pencil> pencils;
    private double cash;
    private int score;

    
    public Superstore(){
        name = "PENCILS SUPERSTORE";
        cash = 0;
        pencils = new ArrayList<>();
        score = 0;

    }
    public String getName(){
        return name;
    }

    public void addPencil(Pencil p){
        pencils.add(p);
    }

    public double getCash(){
        return cash;
    }

    public int getScore(){
        return score;
    }

    

    public boolean buyPencil(String color, String quality, String size){
        for (int i = 0; i < pencils.size(); i++){
            if (pencils.get(i).getColor().equals (color) &&
                pencils.get(i).getQuality().equals(quality) &&
                pencils.get(i).getSize().equals(size)){
                    cash = cash + pencils.get(i).getPrice();
                    pencils.remove(i);
                    score ++;
                    return true;
                }
        }

        return false;
        
    }



}