#include<bits/stdc++.h>
using namespace std;
// DSA 450 : Merge two sorted arrays 

// Method 1 : Time Complexity - O((n+m)log(n+m)) , space - O(n+m)
void merge(int arr1[], int n, int arr2[], int m){
    int arr3[n+m];  // Taking 3rd array

    // Assigning value to arr3
    int i;  
    for (i = 0; i < n+m; i++){
        if(i<n)
            arr3[i] = arr1[i];
        else
            arr3[i] = arr2[i-n];
    }

    sort(arr3, arr3+n+m);

    // Reassigning the sorted value
    i = 0; // reassigning i to 0
    for (; i < n+m; i++){
        if(i<n)
            arr1[i] = arr3[i];
        else
            arr2[i-n] = arr3[i];
    }
}


// Method 2 : T - O(nlogn), S - O(1)
// Logic : Taking two pointers i&k in arr1[] and another pointer j on arr2[] and compairing each element of arr1 with arr2 from start and if arr2 contain
// smaller element than replace it with kth element  
void merge2(int *arr1, int n, int *arr2, int m){
    int i=0, j=0, k=n-1;
    while (i<=k && j < m){
        if(arr1[i] < arr2[j])
            i++;
        else
            swap(arr2[j++], arr1[k--]);
    }

    sort(arr1, arr1+n);
    sort(arr2, arr2+m);
}


// Method 3: Gap algorithm, T- O(nlogn) , S - O(1)
// Logic : Taking gap = ceil of (n+m)/2 and compairing element pair wise 
int getGap(int gap){
        if(gap <= 1)
            return 0;
        return (gap/2) + (gap%2);
    }

void merge3(int *arr1, int n, int *arr2, int m){
    int gap = n+m;

    for (gap = getGap(gap); gap>0; gap=getGap(gap)){
            // Traversing arr1
        int i,j;
        for (i = 0; i+gap < n; i++){
            if(arr1[i] > arr1[i+gap])
                swap(arr1[i], arr1[i+gap]);
        }

        // Traversing both arr1[] & arr2[]
        for (j = gap>n?gap-n:0; i < n && j < m; i++,j++){
            if(arr1[i] > arr2[j])
                swap(arr1[i], arr2[j]);
        }
    
        // Traversing arr2[] remaining element
        if(j < m){
            for (j = 0; j+gap < m; j++){
                if(arr2[j] > arr2[j+gap])
                    swap(arr2[j], arr2[j+gap]);
            }
        }
    }
}


// Method 4 : T - O(m+n), S - O(1)
// Logic : if A & B are two no. and N is greater among A&b than we can get A from B and vice versa without any extra variable.
// A -> A + B*N => to get A do the modulo with N & to get B divide A by N 
void merge4(int *arr1, int n, int *arr2, int m){
    int mx = 0;
    // Calculating max element
    for (int i = 0; i < n; i++)
        mx = max(mx, arr1[i]);

    for (int j = 0; j < m; j++)
        mx = max(mx, arr2[j]);
    
    mx++;   // Incrementing max element in order to avoid conflict btw 0 amd max element

    int i=0, j=0, k=0;

    while(i<n && j<m && k<n+m){
        // Getting the original element
        int num1 = arr1[i]%mx;
        int num2 = arr2[j]%mx;

        if(num1 <= num2){
            if(k<n)
                arr1[k] += num1*mx;
            else
                arr2[k-n] += num1*mx;
            i++;
            k++; 
        }
        else{
            if(k<n)
                arr1[k] += num2*mx;
            else
                arr2[k-n] += num2*mx;
            j++;
            k++;
        }
    }

    // Remaining element of arr1[]
    while(i<n){
        int num1 = arr1[i] % mx;
        if (k<n)
            arr1[k] += num1*mx;
        else
            arr2[k-n] += num1*mx;
        i++;
        k++;
    }

    // Remaining element of arr2[]
    while (j<m){
        int num2 = arr2[j] % mx;
        if (k<n)
            arr1[k] += num2*mx;
        else
            arr2[k-n] += num2*mx;
        j++;
        k++;
    }
    
    for (int i = 0; i < n; i++)
        arr1[i] /= mx;
    
    for (int j = 0; j < m; j++)
        arr2[j] /= mx;
}


int main(){
    int arr1[] = {3, 27, 38, 43};
    int n = sizeof(arr1)/sizeof(int);
    int arr2[] = {9, 10, 82};
    int m = sizeof(arr2)/sizeof(int);

    // Function Call
    //merge(arr1, n, arr2, m);

    // merge2(arr1, n, arr2, m);

    // merge3(arr1, n, arr2, m);

    merge4(arr1, n, arr2, m);

    // Print array
    for(auto x : arr1)
        cout << x << " ";
    
    cout << endl;

    for(auto x : arr2)
        cout << x << " ";

    cout << endl;
    return 0;
}