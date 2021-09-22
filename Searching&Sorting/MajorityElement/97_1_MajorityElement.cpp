#include<bits/stdc++.h>
using namespace std;
// DSA450 97: Find Majority Element

// An element in an array is a majority element if no. of counts of that element is > floor_of[n/2]
// BruteForce Approach : Take freq array which wll store frequency of each element and whose frequency is > [n/2] will be majority element
// TC - O(n), SC - O(n)

// Optimized Approach : Using Moore's Voting Algorithm, TC-O(n), SC-O(1)
int majorityElement(int a[], int size){
    int count = 0;
    int majE = 0;

    for (int i = 0; i < size; i++){
        if(count == 0)
            majE = a[i];
        if(majE == a[i])
            count++;
        else
            count--;
    }

    count = 0;
    for (int i = 0; i < size; i++){
        if(majE == a[i])
            count++;
    }
    
    if(count > size/2)
        return majE;
    return -1;
}

int main(){
    int a[] = {1,2,3};
    int size = sizeof(a)/sizeof(a[0]);
    cout << "Majority Element = " << majorityElement(a, size);

    cout << endl;
    return 0;
}