#include<bits/stdc++.h>
using namespace std;
// DSA 450 440: Count Total set bits from 1 to n

// Method 1 : TLE as TC is O(n)
// int countBits(int k){
//     int cnt = 0;
//     while(k > 0){
//         int lastBit = k&1;
//         cnt += lastBit;
//         k = k>>1;
//     }
//     return cnt;
// }

// int countTotalSetBits(int n){
//     int count = 0;
//     for (int i = 1; i <= n; i++){
//         count += countBits(i);
//     }
//     return count;
// }


// Method 2 : TC - O(log n)

int countPowerOf2(int n){
    int x = 0;
    // Condition : 2^x <= n
    while ((1 << x) <= n){
        x++;
    }
    return x-1;
}

int countTotalBits(int n){
    // Base Case
    if(n == 0)
        return 0;
    
    int xpow = countPowerOf2(n);
    int bitBeforeXpow = xpow * (1 << (xpow-1));     // x*(2^(x-1)) This will calculate total no. of bits before 2^3 i.e., from 0 to 7
    int bitXpowToN = n - (1 << xpow) + 1;   // n-(2^x)+1  This will calculate bits from 2^x till n
    
    return bitBeforeXpow + bitXpowToN + countTotalBits(n - (1<<xpow));      // Rec call countTotalBits(n - 2^x)
}

int main(){
    int n;
    cin >> n;
    // cout << countTotalSetBits(n);
    cout << countTotalBits(n);

    cout << endl;
    return 0;
}