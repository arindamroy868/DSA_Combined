#include <iostream>
using namespace std;
// DSA450 Array Ques 2 : Finding max and min element in an array
// Calculating min and max element in an array using Tournament Method(Recursive Approach) which will take O(n) time
// In this method we'll divide the array into two parts and than compare its min & max value

struct Pair
{
    int min;
    int max;
};

struct Pair getMinMax(int *a, int low, int high){
    struct Pair minmax, mml, mmr;
    // If array has only 1 element
   if (low == high){
       minmax.min = a[low]; // or a[high]
       minmax.max = a[low]; // or a[high]
       return minmax;
   }

   // If array contains two elements
   if (high == low + 1){
        if (a[low] > a[high]){
            minmax.min = a[high];
            minmax.max = a[low];
        }
        else{
            minmax.min = a[low];
            minmax.max = a[high];
        }
        return minmax;
   }

   // If array contains more than 2 elements
   int mid = (low+high)/2;
   mml = getMinMax(a, low, mid);    // calling left part of array
   mmr = getMinMax(a, mid+1, high); // calling right part of array

   // compairing both arrays min & max element
   // for min element
   if (mml.min < mmr.min)
       minmax.min = mml.min;
   else
       minmax.min = mmr.min;
   
   // for max element
   if (mml.max > mmr.max)
       minmax.max = mml.max;
   else
       minmax.max = mmr.max;

   return minmax;
}

int main(){
    int a[] = {6,5,4,3,2,1};
    int n = sizeof(a)/sizeof(int);
    struct Pair minmax = getMinMax(a, 0, n-1);
    cout << "Minimum Element in an array = " << minmax.min;
    cout << "\nMinimum Element in an array = " << minmax.max;
    cout << endl;

    return 0;
}
