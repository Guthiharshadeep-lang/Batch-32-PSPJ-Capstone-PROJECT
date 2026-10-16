import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


abstract class CinemaBooking{
            abstract int calculatePrice(char row);
}
class Customer{
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getname(){
        return name;
    }
}
interface Billoperations{
    void generateBill(String name,int tickets,int total,double finalAmount);
}
public class Cinema1 extends CinemaBooking implements Billoperations{
    int normal;
    int deluxe;
    Cinema1(){
        normal=200;
        deluxe=350;
    }
     static void displaymovies(){
         System.out.println("--------Available movies----------");
        String[] movies = {"1.The Odyssey","2.Spiderman:Brand New Day","3.Doomsday","4.Dune:part three","5.Project Hail Mary"};
        for(String movie: movies){
            System.out.println(movie);
        }
     }
     static void displayseats(){
         System.out.println("Available Seats:");
        for(char row = 'A'; row <= 'E'; row++){
            for(int seat = 1; seat <= 10; seat++)
                {
        System.out.print(row + "" + seat + " ");
    }
        System.out.println("");
        }
        System.out.println("---------SCREEN HERE----------");
        System.out.println("");
        System.out.println("Enter the amount of tickets you want to purchase:");
     }

 int calculatePrice(char row) {
    if (row == 'A') {
        return deluxe;
    }
    return normal;
}


static boolean isValidSeat(char row, int seatNumber) {
    return row >= 'A' && row <= 'E' && seatNumber >= 1 && seatNumber <= 10;
}


static String getRowType(char row) {
    if (row == 'A') {
        return "DELUXE";
    }
    return "NORMAL";
}
static double calculateTotal(int total) {
    return total;
}

static double calculateTotal(int total, double discountPercent) {
    return total - (total * discountPercent / 100);
}

@Override
public void generateBill(String name, int tickets,
                         int total, double finalAmount) {
    System.out.println();
    System.out.println("------ BILL GENERATED ------");
    System.out.println("Customer Name: " + name.toUpperCase());
    System.out.println("Tickets purchased: " + tickets);
    System.out.println("Fare before discount: " + total);
    System.out.println("Final fare: " + finalAmount);
    System.out.println("Thank you for your purchase!");
    System.out.println("----------------------------");
}


    public static void main(String[] args) {
        Cinema1 c = new Cinema1();
    
        Scanner input= new Scanner(System.in);
        int  price, ticket;
        String selectedmovie= "";
        int total = 0;
        Customer customer = new Customer();
        System.out.println("Enter your name:");
        String name= input.nextLine().trim();
        customer.setName(name.toLowerCase());
       // System.out.println("--------Available movies----------");
        //String[] movies = {"1.The Odyssey","2.Spiderman:Brand New Day","3.Doomsday","4.Dune:part three","5.Project Hail Mary"};
       // for(int i=0;i<movies.length;i++){
         //   System.out.println(movies[i]);
        //}
        
        // System.out.println("------AVAILABLE MOVIES-------");
        // System.out.println("1. The Oddessey");
        // System.out.println("2. Spiderman: Brand New Day");
        // System.out.println("3. Doomsday");
        // System.out.println("4. Dune: Part Three");
        // System.out.println("5. Project Hail Mary");
        displaymovies();
         System.out.println("");
         System.out.println("Enter your movie choice:");
        int moviechoice= input.nextInt();
        System.out.println("");
        System.out.println("");

        switch(moviechoice)   {
        case 1:
        System.out.println("You selected The Odyssey");
        selectedmovie = "The Odyssey";
        break;

        case 2:
        System.out.println("You selected Spiderman: Brand New Day");
        selectedmovie = "Spiderman: Brand New Day";
        break;

        case 3:
        System.out.println("You selected Doomsday");
        selectedmovie = "Doomsday";
        break;

        case 4:
        System.out.println("You selected Dune: Part Three");
        selectedmovie = "Dune: Part Three";
        break;

        case 5:
        System.out.println("You selected Project: Hail Mary");
        selectedmovie = "Project: Hail Mary";
        break;

        default:
        System.out.println("Invalid movie choice");
        return;
           }  
           System.out.println("");
        System.out.println("Available Seats:");
    //     for(char row = 'A'; row <= 'E'; row++){
    //         for(int seat = 1; seat <= 10; seat++)
    //             {
    //     System.out.print(row + "" + seat + " ");
    // }
    //     System.out.println("");
    //     }
    //     System.out.println("---------SCREEN HERE----------");
    //     System.out.println("");
    //     System.out.println("Enter the amount of tickets you want to purchase:");
        displayseats();
        ticket = input.nextInt();
        if (ticket>10){
            System.out.println("Oops! too many tickets, maximum tickets allowed are 10");
            return;
        }
        
        for(int i = 1; i <= ticket; i++){
        System.out.println("Enter Row for ticket " + i + ":");
        char row = input.next().charAt(0);

        System.out.println("Enter Seat number for ticket " + i + ":");
        int seatnumber = input.nextInt();
        if (!isValidSeat(row, seatnumber)) {
        System.out.println("Invalid seat! Try again.");
        i--;          
       continue;
}

        price = c.calculatePrice(row);
        System.out.println("SELECTED " + getRowType(row) + " ROW");
        System.out.println("TICKET PRICE: " + price + "/-");
        total = total + price;

        // if (row == 'A'){
        //     System.out.println("SElECTED DELUXE ROW");
        //     System.out.println("TICKET PRICE: 350/-");
        //     price = deluxe;
        // }
        // else if (row == 'B'){
        //     System.out.println("SElECTED DELUXE ROW");
        //     System.out.println("TICKET PRICE: 300/-");
        //     price = deluxe;
        // }
        
        // else  (){
        //     System.out.println(" SELECTED NORMAL ROW");
        //     System.out.println("TICKET PRICE: 200/-");
        //     price = normal;
        // }
        //total= total+ price;B
        
    }
    double finalAmount;
if (ticket >= 5) {
    System.out.println("Group discount of 10% applied!");
    finalAmount = calculateTotal(total, 10.0);
} else {
    finalAmount = calculateTotal(total);
}
    System.out.println("");
    System.out.println("");
//     System.out.println("------------------BILL GENERATED-------------------");
//     System.out.println("Customer Name:"+customer.getname());
//     System.out.println("Tickets purchased:"+ticket);
//    System.out.println("Fare before discount: " + total);
//    System.out.println("Final fare: " + finalAmount);
// // System.out.println("Fare:"+total);
//     System.out.println("Thank you for your purchase! See you at the cinema.");
//     System.out.println("---------------------------------------------------");
      c.generateBill(customer.getname(),ticket,total,finalAmount);
      
saveBookingToFile(customer.getname(), selectedmovie, ticket, total, finalAmount);
    }
    public static void saveBookingToFile(String name, String movie,
        int tickets, double beforeDiscount, double finalFare) {

    try {
        FileWriter writer = new FileWriter("booking.txt", true);

        writer.write("----- Cinema Booking Bill -----\n");
        writer.write("Customer Name: " + name + "\n");
        writer.write("Movie: " + movie + "\n");
        writer.write("Tickets: " + tickets + "\n");
        writer.write("Fare before discount: " + beforeDiscount + "\n");
        writer.write("Final fare: " + finalFare + "\n");
        writer.write("-------------------------------\n\n");

        writer.close();
        System.out.println("Booking bill saved in booking.txt");

    } catch (IOException e) {
        System.out.println("Error while saving booking.");
    }
}

}  // class ends here

