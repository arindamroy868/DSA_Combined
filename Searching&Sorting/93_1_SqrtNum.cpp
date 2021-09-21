#include<bits/stdc++.h>
using namespace std;
// DSA450 93: Squareroot of an Integer

int countSquares(int N) {
    int count = 0;
    for(int i = 1;i<sqrt(N); i++){
        if(i*i < N)
            count++;
    }
    return count;
}

int main(){
    cout << countSquares(25);

    cout << endl;
    return 0;
}