public class SortArrayOf012 {
    
    public void sortArrayOf012(int[] arr){
        int i=0,start=0,last=arr.length-1;

        while(i<=last){
            if(arr[i] == 2){
                if(arr[last] != 2){
                    int temp = arr[last];
                    arr[last] = arr[i];
                    arr[i] = temp;
                }
                last--;
            }
            if(arr[i] == 0){
                int temp = arr[start];
                arr[start++] = arr[i];
                arr[i] = temp;
            }
            if(arr[i] == 1){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SortArrayOf012 obj = new SortArrayOf012();
        
        int[] unsortedArray =  new int[]{2,0,1,1,1,2,0,0,0,1,2};
        System.out.println("Before Sorting");
        for(int ele:unsortedArray){
            System.out.print(" "+ele+" ");
        }
        System.out.println();
        obj.sortArrayOf012(unsortedArray);
        System.out.println("After Sorting");
        for(int ele:unsortedArray){
            System.out.print(" "+ele+" ");
        }
        System.out.println();

        
    }
}
