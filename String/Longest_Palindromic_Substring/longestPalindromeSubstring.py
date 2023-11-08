# Method 1 (Naive Apporach) - Time Complexity - O(N^3) and Space Complexity - O(1)
def longestPlaindrome1(s):
    if s is None or len(s) < 1:
        return ''
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


# Method 2 (Dynamic Programming) - Time Complexity - O(N^2) and Space Complexity - O(N^2)
def longestPalindrome2(s):
    if s is None or len(s) < 1:
        return ''
    n = len(s)
    maxLength = 0
    maxPlaindrome = s[0]
    dp = [[1 if i == j else 0 for i in range(n)] for j in range(n)]

    # check string of length 2
    for i in range(n-1):
        if s[i] == s[i+1]:
            dp[i][i+1] = 1
            if 2 > maxLength:
                maxLength = 2
                maxPlaindrome = s[i:i+2]
        else:
            dp[i][i+1] = 0

    j = 2
    while j < n:
        i = 0
        while i < j-1:
            if dp[i+1][j-1] == 1 and s[i] == s[j]:
                dp[i][j] = 1

                if j-i+1 > maxLength:
                    maxLength = j-i+1
                    maxPlaindrome = s[i:j+1]   
            i += 1
        j += 1

    return maxPlaindrome


# Method 3 (Expand Around Center) - Time Complexity - O(N^2) and Space Complexity - O(1)
def longestPalindrome3(s):
    if s is None or len(s) < 1:
        return ''
    n = len(s)
    maxLength = 1
    maxPlaindrome = s[0]
    for i in range(n):
        len1 = expandAroundCenter(s, i, i)
        len2 = expandAroundCenter(s, i, i+1)

        if max(len1, len2) > maxLength:
            maxLength = max(len1, len2)
            start = i - (maxLength -1) // 2
            end = i + maxLength // 2
            maxPlaindrome = s[start : end+1]

    return maxPlaindrome
        

def expandAroundCenter(s, left, right):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1

    return right - left - 1


s = input("Enter the string : ")
print("Longest palindrome in the string is : ",longestPalindrome3(s))