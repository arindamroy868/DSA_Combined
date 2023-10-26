#include<bits/stdc++.h>
using namespace std;
// Coding Exercise 5 : K-Rotate

// Using Brute Force Approach which take O(kn) time ~ O(n^2)
// Clockwise Rotation by Kth term
vector<int> kRotateClockwise(vector<int> a, int k){
    // your code  goes here
    int n = a.size();
    for(int j=0;j<k;j++){
        int temp = a[n-1];
        for (int i = n-1; i > 0; i--){
            a[i] = a[i-1];
        }
        a[0] = temp;
    } 
    return a;
}

// Anti-clockwise Rotation
vector<int> kRotateAntiClockwise(vector<int> a, int k){
    // your code  goes here
    int n = a.size();
    for(int j=0;j<k;j++){
        int temp = a[0];
        for (int i = 0; i < n-1; i++){
            a[i] = a[i+1];
        }
        a[n-1] = temp;
    } 
    return a;
}

int main(){
    vector<int> arr = {1,3,5,7,9};
    int k = 2;
    vector<int> resultClock = kRotateClockwise(arr, k);
    vector<int> resultAntiClock = kRotateAntiClockwise(arr, k);

    // Print Vector
    for (auto x : resultClock){
        cout << x << " ";
    }

    cout << "\n\n";

    for (auto x : resultAntiClock){
        cout << x << " ";
    }

    cout << endl;
    return 0;
}