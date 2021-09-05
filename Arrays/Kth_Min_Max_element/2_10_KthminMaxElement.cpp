#include<bits/stdc++.h>
using namespace std;
// DSA 450 Arrays 3 : Kth Max & Min element

// Method 1 : Using Sorting which takes O(nlogn)
int kthminMaxUsingSort(vector<int> v, int k){
    sort(v.begin(), v.end());
    return v[k-1];
}

// Method 2 : Using set which is implemented using BST and takes O(log n) in avg and O(n) in worst case
int kthminMaxUsingSet(vector<int> v, int k){
    set<int> s(v.begin(), v.end());
    set<int>::iterator itr = s.begin(); // Initializing set type iterator itr
    advance(itr, k-1);  // Advances the iterator to point to (k-1)th index
    return *(itr);
}

// Method 3 : Using Map(key, value) where key is element and Value is elements frequency
int kthminMaxUsingMap(vector<int> v, int k){
    map<int, int> m;
    // Populating map each key as element value with its frequency
    for (int i = 0; i < v.size(); i++){
        m[v[i]] += 1;
    }
    
    int freq = 0;
    for (auto itr = m.begin(); itr != m.end(); itr++){
        freq += itr->second;
        if(freq >= k)
            return itr->first;
    }
    return -1;
}


int main(){
    vector<int> v = {40,30,10,70,80};
    int k = 3;
    cout << k << "rd smallest element = " << kthminMaxUsingSet(v, k) << endl;

    cout << k << "rd smallest element = " << kthminMaxUsingSort(v, k) << endl;

    cout << k << "rd smallest element = " << kthminMaxUsingMap(v, k) << endl;

    cout << endl;
    return 0;
}