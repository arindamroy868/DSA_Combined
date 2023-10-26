#include<bits/stdc++.h>
using namespace std;
// DSA450 49: Find duplicates and there count in String

void duplicate(string s){
    int n = s.length();
    map<char, int> dup;
    for (int i = 0; i < n; i++){
        dup[s[i]]++;
    }
    
    for (auto x : dup){
        if(x.second > 1)
            cout << x.first << " = " << x.second << endl;
    }
}

int main(){
    string s;
    getline(cin, s);
    duplicate(s);

    cout << endl;
    return 0;
}