#include<bits/stdc++.h>
using namespace std;
// DSA450 Arrays 10 : Min no. of jumps to reach end of an array

int minJump(vector<int> v){
    int n = v.size();

    vector<int> dp(n,0);

    if(v[0] == 0)
        return -1;
    
    if(n == 1)
        return 0;

    for (int i = 1; i < n; i++){
        dp[i] = INT_MAX;
        for (int j = 0; j < i; j++){
            if(j+v[j] >= i && dp[j] != INT_MAX)
                dp[i] = min(dp[i], dp[j]+1);
        }
    }
     
    if(dp[n-1] != INT_MAX) 
        return dp[n-1];
    else
        return -1;
}

int main(){
    vector<int> v = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    cout << "Minimum no. of Jumps : " << minJump(v);

    cout << endl;
    return 0;
}