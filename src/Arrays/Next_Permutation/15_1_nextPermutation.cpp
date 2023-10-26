#include<bits/stdc++.h>
using namespace std;
// DSA450 : Next Permutation

// Logic : First we'll find an element from back which is just smaller than its next higher index value (as from back every elements arrange in
// increasing order till mid element) - that's called a breakpoint and if there is no
// breakpoint than we'll simply reverse the array as the given array must comes last in lexicographically order and we'll return the first order element
// After finding breakpoint we'll find an element from back which is just greater than previous breakpoint element and swap both of them with each other
// in order to get next permutation than we'll reverse the rest elements which comes after swapped element from start 
void nextPermutation(vector<int>& nums) {
    int n = nums.size();
    // Getting the index for breakpoint
    int i;
    for (i = n-2; i >= 0; i--){
        if (nums[i]<nums[i+1])
            break;
    }

    // If we couldn't find a breakpoint that means nums come in last lexicographical order
    if(i<0)
        reverse(nums.begin(), nums.end());
    else{
        // find an index just greater than breakpoint index value
        int j;
        for (j = n-1; j >= 0; j--){
            if(nums[j] > nums[i])
                break;
        }
        swap(nums[j], nums[i]);
        // After swap we'll reverse the rest element after first swapped element from start
        reverse(nums.begin()+i+1, nums.end());
    }    
}

int main(){
    vector<int> nums = {3,2,1};

    cout << "Next Permutation : ";

    nextPermutation(nums);

    for (auto x : nums)
        cout << x << " ";

    cout << endl;
    return 0;
}