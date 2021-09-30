#include<bits/stdc++.h>
using namespace std;
// DSA450 47: Reverse a String 

void reverseString(vector<char>& s) {
    int n = s.size();
    int i = 0;
    int j = n-1;

    while (j>i){
        swap(s[i++], s[j--]);
    }
    
    return;
}

int main(){
    vector<char> s = {'h','e','l','l','o'};
    reverseString(s);

    for (auto x : s){
        cout << x;
    }
    
    cout << endl;
    return 0;
}