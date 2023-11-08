#include<bits/stdc++.h>
using namespace std;

// int maxSumSubarray(vector<int> A) {
//     int cs = 0;
//     int ms = 0;
//     for (int i = 0; i < A.size(); i++){
//         cs += A[i];
//         if(cs < 0)
//             cs = 0;
//         ms = max(ms, cs);
//     }
//     return ms;
// }

int maxSumSubarray(vector<int> A) {
    bool f =true;
    int rr=INT_MIN;
    for(auto x : A){
        if(x >0 ) f = false;
        if(x > rr) rr = x;
    }
    if(f) return rr;
    
    int finalAnswer = 0;
    int temporary  = 0;
    
    int arraySize = A.size();
    for (int i = 0; i < arraySize; i++) {
        temporary = temporary + A[i];
        if (temporary < A[i]) {
            temporary = A[i];
        }
        finalAnswer = max(finalAnswer, temporary);
    }
    return finalAnswer;
    
}


int main(){
    vector<int> arr = {-5,-1,1,-2,-1};
    int sum = maxSumSubarray(arr);
    cout << "Largest Subarray Sum = " << sum;

    cout << endl;
    return 0;
}