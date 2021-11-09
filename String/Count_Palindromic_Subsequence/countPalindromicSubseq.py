# Method 1 (Using DP) - Time Complexity - O(n*n) and Space Complexity - O(n*n)
def countPS(str):
    n = len(str)
    dp = [[-1 for _ in range(n)] for i in range(n)]
    m = 1000000007

    for gap in range(n):
        for i, j in enumerate(range(gap, n), 0):
            if gap == 0:
                dp[i][j] = 1
            elif gap == 1:
                dp[i][j] = 3 if str[i] == str[j] else 2
            else:
                if str[i] == str[j]:
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1
                else:
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]

    return dp[0][n-1]%m


string = input("Enter the string : ")
print("No. of Palindromic subsequence in the string : ", countPS(string))