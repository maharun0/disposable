import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataFile {
    // Datafields
    static Scanner read;
    static String s;

    // Files
    // public final static File purchaseHistoryFile = new File("src/textfiles/Purchase_History.txt");
    // public final static File userInfoFileFile = new File("src/textfiles/User_Info.txt");
    public final static File BandDetailsFile = new File("C:\\Users\\Neko\\Desktop\\Github_Open\\Concert-Management\\Concert-Management\\src\\textfiles\\Band_Details.txt");
    public final static File ConcertDetailsFile = new File("C:\\Users\\Neko\\Desktop\\Github_Open\\Concert-Management\\Concert-Management\\src\\Concert_Details.txt");

    // List to be added from files
    public static ArrayList<Concert> concertList = new ArrayList<>();
    public static ArrayList<Band> bandList = new ArrayList<>();
    //public static ArrayList<Customer> customerList = new ArrayList<>();
 
    //customerList.add(new Customer(name, username, pass))

    // Reading from Band_Details.txt file and updating List
    public static void takeInputBandDetails() throws FileNotFoundException{
        read = new Scanner(BandDetailsFile);

        String name = "";
        ArrayList<String> members = new ArrayList<>();

        int bandNumbers = 5, bandMembers = 5;
        for (int i = 0; i < bandNumbers; i++){
            name = read.next();

            for (int j = 0; j < bandMembers; j++){
                s = read.next();
                members.add(s);
            }
            bandList.add(new Band(name, members));
            members.clear();
        }
    }

    // Reading from Concert_Details.txt file and updating list
    public static void takeInputConcertDetails() throws FileNotFoundException{
        read = new Scanner(ConcertDetailsFile);

        Band band = new Band();
        String place, time;
        double ticketPrice;

        //Band band, String place, String timing, double ticketPrice
        for (int i = 0; i < 4; i++){
            s = read.next();
            for (Band b : bandList){
                if (b.getName().equals(b.getName())){
                    band = b;
                    break;
                }
            }

            place = read.next();
            time  = read.next();
            ticketPrice = read.nextDouble();

            concertList.add(new Concert(band, place, time, ticketPrice));
        }

    }

    // Search for bands
    public static String searchForBands(String s){
        String output = "";
        int count = 0;
        for(Band b : bandList){
            if (s.toLowerCase().equals(b.getName().toLowerCase())) {
                if (count == 0)
                    output += "Available bands:\n";
                output += b.getName() + "\n";
                count++;
            }
        }

        if(count==0){
            output += "No such band was found.";
        }
        return output;
    }

    // Search for concerts
    public static String searchForConcerts(String s){
        String output = "";
        int count = 0;
        for (Concert c : concertList) {
            if (s.toLowerCase().equals(c.getBand().getName().toLowerCase())) {
                if (count == 0)
                    output += "Available concerts:";
                output += c.getBand().getName();
                count++;
            }
        }

        if (count == 0) {
            output += "No such concert was found.";
        }
        return output;
    }
    
    // Search for memebers
    // public static void searchForMembers(String s){
    //     String output = ""
    //     int count = 0;
    //     for (Band b : bandList) {
    //         if () {
    //             if (count == 0)
    //                 output += "Available concerts:\n";
    //             System.out.println(b.getName());
    //             count++;
    //         }
    //     }

    //     if (count == 0) {
    //         System.out.println("No such concert was found.");
    //     }
    // }
}
