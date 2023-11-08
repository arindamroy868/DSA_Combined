#include <iostream>
using namespace std;
// DSA450 Array Ques 2 : Finding max and min element in an array
// Calculating min and max element in an array using Iterative approach(Linear Search) which will take O(n) time

// Defining struct for returning two value i.e., min & max and struct variable i.e., Pair 'P' should be in capital
struct Pair
{
    int min;
    int max;
};

struct Pair getMinMax(int *a, int n){
    struct Pair minmax;
    // If array has only 1 element
   if (n == 1){
       minmax.min = a[0];
       minmax.max = a[0];
       return minmax;
   }

   // If array contains two elements
   if (a[0] > a[1]){
       minmax.min = a[1];
       minmax.max = a[0];
   }
   else{
       minmax.min = a[0];
       minmax.max = a[1];
   }

   // If array contains more than 2 elements
   for (int i = 2; i < n; i++)
   {
       if (a[i] > minmax.max)
           minmax.max = a[i];
       else if (a[i] < minmax.min)
           minmax.min = a[i];
   }
   return minmax;
}

int main(){
    int a[] = {6,5,4,3,2,1};
    int n = sizeof(a)/sizeof(int);
    struct Pair minmax = getMinMax(a, n);
    cout << "Minimum Element in an array = " << minmax.min;
    cout << "\nMinimum Element in an array = " << minmax.max;

    cout << endl;

    return 0;
}
