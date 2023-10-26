#include<bits/stdc++.h>
using namespace std;
// DSA450 : Find the Fixed Point(Value Equal to index value)

vector<int> valueEqualToIndex(int arr[], int n) {
	vector<int> result;
    for (int i = 0; i < n; i++){
        if(i+1 == arr[i])
            result.push_back(arr[i]);
    }
    return result;    
}

int main(){
    //int arr[] = {15, 2, 45, 12, 7};
    int arr[] ={1};
    int n = sizeof(arr)/sizeof(arr[0]);

    for (auto x : valueEqualToIndex(arr, n))
        cout << x << " ";

    cout << endl;
    return 0;
}