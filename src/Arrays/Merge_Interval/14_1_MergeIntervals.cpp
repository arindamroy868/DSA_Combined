#include<bits/stdc++.h>
using namespace std;
// DSA450 : Merge Intervals

vector<vector<int>> merge(vector<vector<int>>& intervals){
    if(intervals.size() <= 1)
        return intervals;

    vector<vector<int>> output;
    // Inserting first element in output
    output.push_back(intervals[0]);
    // Now inserting rest of the intervals element by compairing its 2nd index value with next element first index value 
    for (int i = 1; i < intervals.size(); i++){
        if (output.back()[1] >= intervals[i][0])
            output.back()[1] = max(output.back()[1], intervals[i][1]);
        else
            output.push_back(intervals[i]);
    }
    return output;
}

int main(){
    vector<vector<int>> intervals = {{1,3}, {2,6}, {8,10}, {15,18}};

    // Function call
    vector<vector<int>>output = merge(intervals);

    // Print vector
    for (int i = 0; i < output.size(); i++){
        for (int j = 0; j < 2; j++){
            cout << output[i][j] << ",";
        }
        cout << "\n";
    }
    
    cout << endl;
    return 0;
}