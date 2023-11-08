#include <iostream>
#include <vector>
using namespace std;
// Striver SDE Sheet DAy 1 Ques 6 : Leetcode(medium)-287 : Find the duplicate number

// Basic approach is to sort the given array and if two consecutive index value encounter same result than that's the duplicate no.
// The basic approach will change the order of original array & optimized method without changing its order is using Linked List Cycle Method

// Vector follows pass by value approach, to make it pass by reference we'll use '&' in parameter declaration
int duplicate(vector<int>& a){
    // Taking two pointer and initialize it to 0th index value;
    int slow = a[0];
    int fast = a[0];
    // 1st Collision
    do
    {
        slow = a[slow]; // Incrementing slow by 1 step
        fast = a[a[fast]];  // Incrementing fast by 2 step
    } while (slow != fast);

    // 2nd Collision
    // After 1st collision again initializing fast pointer to 0th index value and let slow pointer as it is 
    fast = a[0];
    while (slow != fast){
        fast = a[fast];
        slow = a[slow];
    }
    return slow; // or fast both are equal after coliision
}

int main(){
    vector<int> a = {1,2,3,4,3};
    cout << "Duplicate No = " << duplicate(a) << endl;

    return 0;
}