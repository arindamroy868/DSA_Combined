#include<bits/stdc++.h>
using namespace std;
// K- Rotate 2nd Method

// Leetcode : Rotate Array
// Logic : First reverse the whole array than reverse the array till k-1 and from k to n  Time Complexity = O(n), Space = O(1)

// Clockwise Rotate
vector<int> kRotateClockwise(vector<int> a, int k){
    // To check whether k > size of vector
    k = k % a.size();
    // reverse() stl function has the range [start, end) it doesn't include the last element and a.end() is a iterator points to (last element + 1)
    reverse(a.begin(), a.end());
    reverse(a.begin(), a.begin()+k);
    reverse(a.begin()+k, a.end());     
    return a;
}

// Anti-Clockwise Rotate
vector<int> kRotateAntiClockwise(vector<int> a, int k){
    k = k % a.size();
    reverse(a.begin(), a.end());
    reverse(a.rbegin(), a.rbegin()+k);
    reverse(a.rbegin()+k, a.rend());     
    return a;
}

int main(){
    vector<int> arr = {1,2,3,4,5,6,7};
    int k = 3;
    vector<int> a = kRotateClockwise(arr, k);
    vector<int> b = kRotateAntiClockwise(arr, k);

    for (auto x : a){
        cout << x << " ";
    }

    cout << "\n \n";

    for (auto x : b){
        cout << x << " ";
    }
    
    cout << endl;
    return 0;
}