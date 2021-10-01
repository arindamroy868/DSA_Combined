#include<bits/stdc++.h>
using namespace std;
// DSA450 48: Is Palindrome

int isPalindrome(char S[]){
    int n = strlen(S);
    for (int i = 0, j=n-1; i < n/2; i++,j--){
        if(S[i] != S[j])
            return 0;
    }
    return 1;
}

int main(){
    char s[] = "yemen";
    cout << isPalindrome(s);

    cout << endl;
    return 0;
}