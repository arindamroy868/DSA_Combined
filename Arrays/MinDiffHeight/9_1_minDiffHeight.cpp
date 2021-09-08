#include<bits/stdc++.h>
using namespace std;
// DSA450 Arrays 9 : Minimize the Maximum Difference between heights

int getMinDiff(vector<int> v, int k){
    // First sort the given array
    sort(v.begin(), v.end());

    int n = v.size();

    // Get the result i.e., Difference btw min amd max tower height
    int result = v[n-1] - v[0];
    //int minE = v[0]+k; // a - min element
    //int maxE = v[v.size()-1]-k; // b - max element

    for (int i = 0; i < n-1; i++){
        int a = v[i];
        int b = v[i+1];

        int minE = min(b-k, v[0]+k)<0? -100000 : min(b-k, v[0]+k);   // trying to minimize b by K
        int maxE = max(a+k, v[n-1]-k); // trying to maximize a by K

        result = min(result, maxE-minE);
    }

    return result;
}

int main(){
    vector<int> v = {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
    int k = 5;

    cout << "Minimum Height : " << getMinDiff(v, k);

    cout << endl;
    return 0;
}