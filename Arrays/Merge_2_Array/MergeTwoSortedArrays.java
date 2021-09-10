public class MergeTwoSortedArrays {
    //Time=O(N*M)
    //Space=O(1)
    public void mergeTwoArraysMethod1(int[] a1,int[] a2){
        int i=0;
        int n=a1.length,m=a2.length;

        while(i<n){
            if(a1[i]>a2[0]){
                int temp1 = a1[i];
                a1[i] = a2[0];
                a2[0] = temp1;
                int j=0;
                while(j<m-1){
                    if(a2[j]>a2[j+1]){
                        int temp2 = a2[j];
                        a2[j] = a2[j+1];
                        a2[j+1] = temp2;
                        j++;
                    }
                    else{
                        break;
                    }
                }
            }
            i++;
        }
    }

    //Time=O((N+M)*Log(N+M))
    //Space=O(1)
    private int nextGap(int gap)
	{
		if (gap <= 1)
			return 0;
		return (gap / 2) + (gap % 2);
	}
    
    public void mergeTwoArraysMethod2(int[] arr1,
							int[] arr2, int n,
							int m)
	{
		int i, j, gap = n + m;
		for (gap = nextGap(gap); gap > 0;
			gap = nextGap(gap))
		{
			// comparing elements in the first
			// array.
			for (i = 0; i + gap < n; i++)
				if (arr1[i] > arr1[i + gap])
				{
					int temp = arr1[i];
					arr1[i] = arr1[i + gap];
					arr1[i + gap] = temp;
				}

			// comparing elements in both arrays.
			for (j = gap > n ? gap - n : 0;
				i < n && j < m;
				i++, j++)
				if (arr1[i] > arr2[j])
				{
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}

			if (j < m)
			{
				// comparing elements in the
				// second array.
				for (j = 0; j + gap < m; j++)
					if (arr2[j] > arr2[j + gap])
					{
						int temp = arr2[j];
						arr2[j] = arr2[j + gap];
						arr2[j + gap] = temp;
					}
			}
		}
	}
    public static void main(String[] args) {
        MergeTwoSortedArrays obj = new MergeTwoSortedArrays();
        int[] a1 = new int[] {1,4,7};
        int[] a2 = new int[] {2,3,9,8,10};
        System.out.println("Arrays Before Sorting");
        for(int x:a1){
            System.out.print(" "+x+" ");
        }
        System.out.println();
        for(int x:a2){
            System.out.print(" "+x+" ");
        }
        System.out.println();

        obj.mergeTwoArraysMethod2(a1,a2,a1.length,a2.length );

        System.out.println("Arrays After Sorting");
        for(int x:a1){
            System.out.print(" "+x+" ");
        }
        System.out.println();
        for(int x:a2){
            System.out.print(" "+x+" ");
        }
        System.out.println();
    }
}
