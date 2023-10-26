#include<bits/stdc++.h>
using namespace std;
// DSA450 Arrays 6 : Union of Two Arrays

// Approach : Use map whose each (key, value) pairs will be each elements frequency
int main(){
    int n,m;
    cin >> n >> m;
    int arr1[n], arr2[m];

    map<int, int> mp;

    for (int i = 0; i < n; i++){
        cin >> arr1[i];
        mp[arr1[i]]++;
    }

    for (int i = 0; i < m; i++){
        cin >> arr2[i];
        mp[arr2[i]]++;
    }
    
    cout << mp.size() << endl;
    for (auto itr = mp.begin(); itr != mp.end(); itr++){
        cout << itr->first << " ";
    }
    

    cout << endl;
    return 0;
}