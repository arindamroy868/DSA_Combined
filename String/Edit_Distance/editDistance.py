# Method 1 (Dynamic Programming) - Time Complexity - O(mn) and Space Complexity - O(mn)
# m - length of string 1
# n - length of string 2

def editDistance(s1, s2):
    m = len(s1)
    n = len(s2)
    dp = [[0 for j in range(n+1)] for i in range(m+1)]
    for i in range(m+1):
        dp[i][0] = i

    for j in range(n+1):
        dp[0][j] = j

    for i in range(1, m+1):
        for j in range(1, n+1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else:
                dp[i][j] = 1 + min(dp[i][j-1], min(dp[i-1][j], dp[i-1][j-1]))

    return dp[m][n]


# Method 1 (Dynamic Programming with efficient space complexity) - Time Complexity - O(mn) and Space Complexity - O(n)
# m - length of string 1
# n - length of string 2
def editDistance2(s1, s2):
    m = len(s1)
    n = len(s2)
    dp = [[0 for j in range(n+1)] for i in range(2)]

    for j in range(n+1):
        dp[0][j] = j

    for i in range(1, m+1):
        for j in range(0, n+1):
            if j == 0:
                dp[i % 2][0] = i
            elif s1[i-1] == s2[j-1]:
                dp[i % 2][j] = dp[(i-1)%2][j-1]
            else:
                dp[i % 2][j] = 1 + min(dp[i % 2][j-1], min(dp[(i-1) % 2][j], dp[(i-1) % 2][j-1]))

    return dp[m%2][n]


s1 = input("Enter word1 : ")
s2 = input("Enter word2 : ")
print("Minimum operation to convert word1 to word 2 : ", editDistance2(s1, s2))