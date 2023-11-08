#include <iostream>
using namespace std;

// Problem : Count the no. of digits, alphabets & spaces
// As in this problem we don't have to store and than count as we can read one by one and than count so in this cin.get() will be in use
int main(){
    char ch;
    ch = cin.get();

    // count
    int alpha = 0;
    int digit = 0;
    int space = 0;

    while (ch != '\n'){
        if (ch >= '0' && ch <= '9')
            digit++;

        else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            alpha++;

        else if (ch == ' ' || ch == '\t')
            space++;

        ch = cin.get();
    }
    cout << "Total alphabets = " << alpha << endl;
    cout << "Total digits = " << digit << endl;
    cout << "Total space = " << space << endl;

    return 0;
}