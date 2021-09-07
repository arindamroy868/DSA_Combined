#include<bits/stdc++.h>
using namespace std;
// Union of Two Arrays 

// 2nd Method using set where we insert all the elements from both array in set and print its size
int main(){
    int n, m;
    cin >> n >> m;
    int arr1[n], arr2[m];

    for (int i = 0; i < n; i++){
        cin >> arr1[i];
    }

    set<int> st(arr1, arr1+n);

    for (int i = 0; i < m; i++){
        cin >> arr2[i];
        st.insert(arr2[i]);     // We can't use st(arr2, arr2+m) becoz it'll treat st() as some custom function not the stl one
    }

    cout << st.size() << endl;
    for (auto itr = st.begin(); itr != st.end(); itr++){
        cout << *itr << " ";
    }
    
    cout << endl;
    return 0;
}