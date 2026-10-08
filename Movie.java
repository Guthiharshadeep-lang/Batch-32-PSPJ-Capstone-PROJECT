import java.util.Scanner;
public class Movie{
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

static int calculatePrice(char row, int normal, int deluxe) {
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
    public static void main(String[] args) {
    
        Scanner input= new Scanner(System.in);
        int normal= 200,deluxe= 350, price, ticket;
        String selectedmovie= "";
        int total = 0;
        System.out.println("Enter your name:");
        String name= input.nextLine();
        System.out.println("");
      
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

        price = calculatePrice(row, normal, deluxe);
        System.out.println("SELECTED " + getRowType(row) + " ROW");
        System.out.println("TICKET PRICE: " + price + "/-");
        total = total + price;

       
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
    System.out.println("------------------BILL GENERATED-------------------");
    System.out.println("Customer Name:"+name);
    System.out.println("Tickets purchased:"+ticket);
   System.out.println("Fare before discount: " + total);
   System.out.println("Final fare: " + finalAmount);

    System.out.println("Thank you for your purchase! See you at the cinema.");
    System.out.println("---------------------------------------------------");

}
}