#include<bits/stdc++.h>
using namespace std;
// DSA450 444: Find position of only set bit 

int findPosition(int N) {
    if(N == 0)
        return -1;
    int count = 0;
    while(N > 0 && (N&1) == 0){ // Use as much as bracket to avoid incorrect output
        N = N >> 1;
        count++;
    }

    return (N==1)? count+1 : -1;
}

int main(){
    int n = 5;
    cout << findPosition(n);

    cout << endl;
    return 0;
}