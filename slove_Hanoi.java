public class slove_Hanoi
{
    public static void sloveHanoi(int n, char source, char auxiliary, char destination){
        if (n==1){
            System.out.println("move disk-1 from "+source+" to "+destination);
            return;
        }
        sloveHanoi(n-1, source, destination, auxiliary);
        System.out.println("move disk "+n+" from "+source+" to "+destination);
        sloveHanoi(n-1, auxiliary, source, destination);
    }
    
	public static void main(String[] args) {
	    int num_Disks = 4;
	    System.out.println("towers of Hanoi solutions for "+num_Disks+" disks: ");
	    sloveHanoi(num_Disks, 'A', 'B', 'c');
	}
}