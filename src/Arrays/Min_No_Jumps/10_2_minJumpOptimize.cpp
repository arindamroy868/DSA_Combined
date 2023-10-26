#include<bits/stdc++.h>
using namespace std;
// Min Jumps to reach end of an Array

// Most Optimized approach which take O(n) time & O(1) space
int minJump(vector<int> v){
    int maxR = v[0];
    int step = v[0];
    int jump = 1;

    if(v[0] == 0)
        return -1;
    else if(v.size() == 1)
        return 0;
    else{
        for (int i = 1; i < v.size(); i++){
            if(i == v.size()-1)
                return jump;

            maxR = max(maxR, i+v[i]);
            step--;
            if(step == 0){
                jump++;
                if(i >= maxR)
                    return -1;
                step = maxR-i;
                // If last element is in range of step+i than we can return the jump as no need to check for further steps
                if(step + i >= v.size()-1)
                    return jump;
            }
        }
    }
    return -1;
}

int main(){
    vector<int> v = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    cout << "Minimum no. of Jumps : " << minJump(v);

    cout << endl;
    return 0;
}