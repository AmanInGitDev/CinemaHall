import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Cinema:\n  1 2 3 4 5 6 7 8");

        for(int i=1; i<8; i++){
            System.out.println(i+" S S S S S S S S");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        int seatsReq = sc.nextInt();

        int seats = rows*seatsReq;
        if (seats <= 60) {
            if(rows <= 4){
                int ticketPrice = 10;
                int profit = ticketPrice * seats;
                System.out.println(profit);
            }
            else {
                int ticketPrice = 8;
                int profit = ticketPrice * seats;
                System.out.println(profit);       
            }
        }








    }
}

// If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
//In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half.
// Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the other 5 rows.