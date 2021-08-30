#include<bits/stdc++.h>
using namespace std;
// Coding Exercise 4 : Sorted Pair Sum
// Using Two Pointer method

pair<int, int> closestSum(vector<int> arr, int x){
    // your code goes here
    int n = arr.size();
    int i = 0;
    int j = n-1;
    int diff = INT_MAX;
    int rl = i;
    int rr = j;

    while (i < j){
        if(abs(arr[i] + arr[j] - x) < diff){
            rl = i;
            rr = j;
            diff = abs(arr[i] + arr[j] - x);
        }

        if(abs(arr[i] + arr[j]) > x)
            j--;
        else
            i++;
    }
    return {arr[rl], arr[rr]};
}

int main(){
    vector<int> arr = {10, 22, 28, 29, 30, 40};
    int x = 54;
    pair<int, int> result = closestSum(arr, x);
    cout << result.first << " and " << result.second;

    cout << endl;
    return 0;
}