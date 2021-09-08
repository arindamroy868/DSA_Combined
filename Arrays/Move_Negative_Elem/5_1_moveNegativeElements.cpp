#include<bits/stdc++.h>
using namespace std;
// DSA450 Arrays 5 : Move all negative elements to one side of an array

// Using Two Pointer Approach
void moveNegativeElement(vector<int> &v){
    // Taking two pointers
    int left = 0;
    int right = v.size()-1;

    while (left <= right){
        if(v[left] < 0 && v[right] < 0)
            left++;

        else if(v[left] >= 0 && v[right] < 0)
            swap(v[left++], v[right--]);

        else if(v[left] >= 0 && v[right] >= 0)
            right--;

        else{
            left++;
            right--;
        }
    }
    
}

int main(){
    vector<int> v = {3,6,-8,9,-3,1,-6,-2};

    moveNegativeElement(v);

    for (auto x : v){
        cout << x << " ";
    }

    cout << endl;
    return 0;
}