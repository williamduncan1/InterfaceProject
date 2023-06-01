import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameSuperstore implements Game{

    private Superstore store;

    public GameSuperstore(){
        store = new Superstore();
    }
    
    public String getGameName(){
        return "Super Store Game";
    }

    public String getScore(){
        return String.valueOf(store.getScore());
    }

    public void writeHighScore(File f){

        try (FileWriter fw = new FileWriter(f)) {
            fw.write(getGameName() + "," + getScore());
        }
        catch (Exception e){}
    }
    
    public static void loadPencils(Superstore store, String color, String quality, String size, double price){

        for (int i = 0; i < 10; i ++){
            Pencil p = new Pencil(color, quality, size,price);
            store.addPencil(p);
        }
    }
    public void play(){
        //Superstore store = new Superstore();
        loadPencils(store,"black", "bad", "small", 0.5);
        loadPencils(store, "green", "good", "small", 0.5); 
        loadPencils(store, "blue", "excelent", "big",2);
        loadPencils(store, "red", "excelent","medium", 1);

        System.out.println("Wlcome to " + store.getName());
        System.out.println();
        System.out.println();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Would you like to buy a pencil y/n: ");
            String resp = in.nextLine();
            if(resp.startsWith("n")){
                break;
            }

            System.out.println("What color would you prefer: ");
            String color = in.nextLine();
            System.out.println("What should be the quality(bad/good/excelent): ");
            String quality = in.nextLine();
            System.out.println("What should be the size(small/medium/good): ");
            String size = in.nextLine();

            if(store.buyPencil(color, quality, size)){
                System.out.println("Congratulations you bought a pencil!");
            }
            else{
                System.out.println("This pencil is not in stock.  Please try again");
            }
        }

        System.out.println("Thank you for visiting " + store.getName());
        System.out.println("You spent $" + store.getCash());

        
    }
}
