import java.util.Scanner;
import java.lang.Math;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n value: ");
        int n = sc.nextInt();
        int temp = n;
        int temp1 = n;
        int count = 0;
        int rem, res, sum = 0;
        while (n > 0){
            rem = n % 10;
            count += 1;
            n = n / 10;
        }
        while (temp > 0){
            rem = temp % 10;
            res = (int)Math.pow(rem, count);
            sum = sum + res;
            temp = temp / 10;
        }
        if (sum == temp1){
            System.out.println(temp1+" is a Armstrong number");
        }
        else{
            System.out.println(temp1+" is not a Armstrong number");
        }
    }
}