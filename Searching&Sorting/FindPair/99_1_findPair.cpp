#include<bits/stdc++.h>
using namespace std;
// DSA450 99: find a pair with a given difference

// Method 1 : BruteForce TC - O(n^2), SC - O(1)
bool findPair1(int arr[], int size, int n){
    bool res = 0;
    for (int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
            if(abs(arr[i]- arr[j]) == n)
                return 1;
        }
    }
    return res;
}

// Method 2 : Using HashMap TC - O(n), SC - O(n)
bool findPair2(int arr[], int size, int n){
    bool res = 0;
    unordered_map<int, int> mp;
    for (int i = 0; i < size; i++)
        mp[arr[i]] = 1;
    for (int i = 0; i < size; i++){
        if(mp[arr[i]+n])
            return 1;
    }
    return res;
}

// Method 3 : Using Sorting TC - O(nlogn), SC - O(1)
bool findPair3(int arr[], int size, int n){
    bool res = 0;
    sort(arr, arr+size);
    for (int i = 0; i < size; i++){
        int index = upper_bound(arr, arr+size, arr[i]+n)-arr;
        index--;    // As upper_bound() always points to next higher index
        if(arr[index]-arr[i] == n && index >= 0)
            return 1;
    }
    return res;
}

int main(){
    //int arr[] = {5, 20, 3, 2, 5, 80};
    int arr[] = {90, 70, 20, 80, 50};
    // 5, 20, 3, 2, 5, 80   n = 78
    //    n = 45
    int size = sizeof(arr)/sizeof(arr[0]);
    //int n = 78;
    int n = 45;

    cout << findPair3(arr, size, n);

    cout << endl;
    return 0;
}