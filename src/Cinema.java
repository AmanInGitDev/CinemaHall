import java.util.Scanner;

public class Cinema {
    static char[][] seats;
    static int rows;
    static int cols;
    static int purchasedTickets = 0;
    static int currentIncome = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        cols = sc.nextInt();
        
        seats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = 'S';
            }
        }
        
        while (true) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> showSeats();
                case 2 -> buyTicket(sc);
                case 3 -> showStats();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    
    static void showSeats() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void buyTicket(Scanner sc) {
        while (true) {
            System.out.println("Enter a row number:");
            int row = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            int col = sc.nextInt();
            
            if (row < 1 || row > rows || col < 1 || col > cols) {
                System.out.println("Wrong input!");
                continue;
            }
            
            if (seats[row - 1][col - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;
            }
            
            int price = getTicketPrice(row);
            System.out.println("Ticket price: $" + price);
            seats[row - 1][col - 1] = 'B';
            purchasedTickets++;
            currentIncome += price;
            break;
        }
    }
    
    static int getTicketPrice(int row) {
        int totalSeats = rows * cols;
        if (totalSeats <= 60) {
            return 10;
        } else {
            return (row <= rows / 2) ? 10 : 8;
        }
    }
    
    static void showStats() {
        int totalSeats = rows * cols;
        double percentage = (double) purchasedTickets / totalSeats * 100;
        int totalIncome = calculateTotalIncome();
        
        System.out.println("\nNumber of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
    
    static int calculateTotalIncome() {
        int income = 0;
        int totalSeats = rows * cols;
        
        if (totalSeats <= 60) {
            income = totalSeats * 10;
        } else {
            int frontHalf = rows / 2;
            int backHalf = rows - frontHalf;
            income = (frontHalf * cols * 10) + (backHalf * cols * 8);
        }
        
        return income;
    }
}