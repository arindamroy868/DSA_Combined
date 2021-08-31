#include <iostream>
using namespace std;
// DSA450 Array Ques 2 : Finding max and min element in an array
// Calculating min and max element in an array using Compare in Pairs which will take O(n) time
// In this method we divide the array into two parts and than compare its min & max value

struct Pair
{
    int min;
    int max;
};

struct Pair getMinMax(int *a, int n){
    struct Pair minmax;
    int i = 0;
    // If array has even no of element than initialize first 2 elements with max min value and inc i by 2
    if (n%2 == 0){
       if (a[0] > a[1]){
           minmax.max = a[0];
           minmax.min = a[1];
       }
       else{
           minmax.max = a[1];
           minmax.min = a[0];
       }
       i=2;
    }
    // If array has odd no of element than initialize first element with max min value and inc i by 1
    else{
        minmax.max = a[0];
        minmax.min = a[0];
        i=1;
    }

    while (i < n-1){
        if (a[i] > a[i+1]){
            if (a[i] > minmax.max)
                minmax.max = a[i];
            if (a[i+1] < minmax.min)
                minmax.min = a[i+1];
        }
        else{
            if (a[i+1] > minmax.max)
                minmax.max = a[i+1];
            if (a[i] < minmax.min)
                minmax.min = a[i];
        }
        i+=2;
    }

   return minmax;
}

int main(){
    int a[] = {6,5,4,3,2,1};
    int n = sizeof(a)/sizeof(int);
    struct Pair minmax = getMinMax(a, n);
    cout << "Minimum Element in an array = " << minmax.min;
    cout << "\nMinimum Element in an array = " << minmax.max;

    return 0;
}
