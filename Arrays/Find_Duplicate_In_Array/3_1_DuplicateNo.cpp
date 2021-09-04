#include<bits/stdc++.h>
using namespace std;
// Leetcode 287. Find the Duplicate Number

int duplicate(vector<int> a){
    int i = 0;
    while (a[i] > 0){
        int temp = a[i];
        a[i] = -a[i];
        i = temp;
    }
    if(i == a.size())
        return -1;
    return i;
}

int main(){
    vector<int> a = {1,2,2,4,3};
    if(duplicate(a) == -1)
        cout << "Duplicate No does not exist"<< endl;
    else
        cout << "Duplicate No = " << duplicate(a);

    cout << endl;
    return 0;
}