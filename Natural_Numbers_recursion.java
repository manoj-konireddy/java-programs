public class Natural_Numbers_recursion
{
    static int Natural_Numbers(int n){
        if (n==1){
            return 1;
        }
        else{
            return n+Natural_Numbers(n-1);
        }
    }
    
	public static void main(String[] args) {
	    int n = 5;
	    int result = Natural_Numbers(n);
	    System.out.println("Sum of Natural numbers of "+n+" is "+result);
	}
}