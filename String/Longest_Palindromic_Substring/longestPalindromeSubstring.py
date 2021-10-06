# Method 1 (Naive Apporach) - Time Complexity - O(N^3) and Space Complexity - O(1)
def longestPlaindrome(s):
    n = len(s)
    maxLength = 0
    maxPlaindrome = s[0]
    for i in range(n):
        for j in range(i, n):
            flag = 1
            for k in range(0, (j-i+1)//2):
                if s[i+k] != s[j-k]:
                    flag = 0
            
            if flag and (j-i+1) >  maxLength:
                maxLength = j-i+1
                maxPlaindrome = s[i:j+1]
    
    return maxPlaindrome

s = input("Enter the string : ")
print("Longest palindrome in the string is : ",longestPlaindrome('aaaabbaa'))