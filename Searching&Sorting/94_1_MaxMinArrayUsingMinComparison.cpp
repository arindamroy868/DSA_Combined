#include<bits/stdc++.h>
using namespace std;
// DSA450 94: Max & Min no. of an Array using min comparison 

int middle(int A, int B, int C){
    return (A>B&&A<C)||(A<B&&A>C)? A : (B>A && B<C)||(B<A && B>C)?B:C;
}

int main(){
    cout << middle(20,30,25);

    cout << endl;
    return 0;
}