#include<bits/stdc++.h>
using namespace std;
// DSA450 16: Count Inversion

int merge(int arr[], int temp[], int left, int mid, int right){
    int i = left;
    int j = mid;
    int k = left;
    int count = 0;

    while (i <= mid-1 && j <= right ){
        if (arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else{
            count += mid-i;
            temp[k++] = arr[j++];
        }
    }
    
    while (i <= mid-1){
        temp[k++] = arr[i++];
    }
    
    while (j <= right){
        temp[k++] = arr[j++];
    }

    for (int i = left; i <= right; i++){
        arr[i] = temp[i];
    }
    
    return count;
}

int countInversion(int arr[], int temp[], int left, int right){
    int countInv = 0;
    int mid;
    if(right > left){
        mid = left + (right-left)/2;
        countInv += countInversion(arr, temp, left, mid);
        countInv += countInversion(arr, temp, mid+1, right);
        countInv += merge(arr, temp, left, mid+1, right);
    }
    return countInv;
}

int main(){
    int arr[] = {2, 4, 1, 3, 5};
    int n = sizeof(arr)/sizeof(int);
    int temp[n];

    cout << countInversion(arr, temp, 0, n-1);

    cout << endl;
    return 0;
}