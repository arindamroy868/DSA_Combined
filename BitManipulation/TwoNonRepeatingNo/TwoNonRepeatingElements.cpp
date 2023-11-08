#include<bits/stdc++.h>
using namespace std;
// DSA450 440: Find two non-repeating elements 

vector<int> singleNumber(vector<int> nums) {
    int uni = 0;    // imp or else will give incorrect output

    // uniing of all the array elements in order to get non-repeating elements
    for (int i = 0; i < nums.size(); i++){
        uni = uni ^ nums[i];
    }

    // Getting Right most set bit mask
    int mask = uni & -uni; // x & -x  here -x = ~x+1 i.e., 2's Compliment

    // Now getting individual non-repeating no.
    int x = 0;
    int y = 0;

    for (int i = 0; i < nums.size(); i++){
        if((nums[i] & mask) == 0)
            x = x^nums[i];
        else
            y = y^nums[i];
    }
    
    vector<int> res;
    if(x < y){
        res.push_back(x);
        res.push_back(y);
    }
    else{
        res.push_back(y);
        res.push_back(x);
    }

    return res;
}
int main(){
    vector<int> nums = {1,2,3,2,1,4};
    for (auto x : singleNumber(nums)){
        cout << x << " ";
    }

    cout << endl;
    return 0;
}