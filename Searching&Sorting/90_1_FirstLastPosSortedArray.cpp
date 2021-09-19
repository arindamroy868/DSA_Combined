#include<bits/stdc++.h>
using namespace std;
// DSA450 90: Find the first and last occurence of element in a sorted array 

// Using lower_bound() & upper_bound() stl function which will take O(logn) time
vector<int> find(int arr[], int n , int x ){
    vector<int> result;
    // Getting first occurence using lower_bound() stl function
    int firstOccurence = lower_bound(arr, arr+n, x)-arr;
    if (firstOccurence < n && arr[firstOccurence] == x)
        result.push_back(firstOccurence);
    else
        result.push_back(-1);

    // Last Occurence
    int lastOccurence = upper_bound(arr, arr+n, x)-arr;
    lastOccurence--;
    if (lastOccurence >= 0 && arr[lastOccurence] == x)
        result.push_back(lastOccurence);
    else
        result.push_back(-1);

    return result;
    
}

int main(){
    int arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
    int n = sizeof(arr)/sizeof(arr[0]);
    int x = 5;

    for (auto x : find(arr, n, x))
        cout << x << " ";

    cout << endl;
    return 0;
}