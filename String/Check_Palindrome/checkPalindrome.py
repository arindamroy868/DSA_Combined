# Method 1 -- Time Complexity - O(n) and Space Complexity - O(1)
def checkPalindrome(s):
    for i, j in enumerate(range(len(s)-1, (len(s)//2)-1, -1)):
        if s[i] != s[j]:
            return 0
    return 1

s = input("Enter the string : ")
print(checkPalindrome(s))