#include<bits/stdc++.h>
using namespace std;
// DSA450 92: Search in a rotated Sorted Array

int search(vector<int>& nums, int target) {
    // If there is no element in an array
    if(nums.size() == 0)
        return -1;
    
    int lo = 0, hi = nums.size()-1;
    while (lo <= hi){
        int mid = lo + (hi-lo)/2;
        if(nums[mid] == target)
            return mid;
        
        // checking if left part is sorted
        if(nums[lo] <= nums[mid]){
            // Checking if target element lie in left part
            if(target >= nums[lo] && target < nums[mid])
                hi = mid-1;
            else
                lo = mid+1;
        }

        // checking if right part is sorted
        else{
            // Checking if target element lie in right part
            if(target > nums[mid] && target <= nums[hi])
                lo = mid+1;
            else
                hi = mid-1;
        }
    }
    return -1;
}

int main(){
    vector<int> nums = {5,1,3};
    int target = 5;

    cout << search(nums, target);

    cout << endl;
    return 0;
}