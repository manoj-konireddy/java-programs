import java.util.Scanner;

public class Main {

    // Method to count how many times the ant returns to the original position (0)
    public static int countReturnsToOrigin(int[] moves) {
        int position = 0; // Current position of the ant, starting at 0
        int count = 0;    // Counter for how many times the ant returns to position 0
        
        // Iterate through each move in the array
        for (int move : moves) {
            position += move;  // Update position based on move (1 or -1)
            
            // Check if the ant has returned to the original position
            if (position == 0) {
                count++;       // Increment count if back at original position
            }
        }
        
        return count; // Return total count of returns to origin
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of moves from user input
        int N = sc.nextInt();
        
        // Initialize array to hold the moves
        int[] moves = new int[N];
        
        // Read each move (1 or -1) from user input
        for (int i = 0; i < N; i++) {
            moves[i] = sc.nextInt();
        }
        
        // Call the function and print the number of times ant returns to origin
        System.out.println(countReturnsToOrigin(moves));
        
        sc.close(); // Close the scanner resource
    }
}
 