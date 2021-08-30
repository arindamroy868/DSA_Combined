import java.util.Scanner;

class FindDuplicateInArray {
    public static int findDuplicate(int[] nums) {
        int i = 0;
        while(nums[i] >0){
            int next = nums[i];
            nums[i] = -1;
            i = next;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println("Enter Size of Array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Please Enter the elements of Array");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Duplicate Element "+findDuplicate(arr));
    }
}