#include<bits/stdc++.h>
using namespace std;
// Determine whether a given no. is a power of 2 or not

int main(){
    int n;
    cin >> n;

    if(n == 0)
        cout << n << " is not a power of 2";
    else if((n & (n-1)) == 0)
        cout << n << " is a power of 2";
    else
        cout << n << " is not a power of 2";

    cout << endl;
    return 0;
}