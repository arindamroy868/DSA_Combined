from collections import deque

# Method 1 (Dynamic Programming) - Time Complexity(n^2) and Space Complexity(n^2)
def longesRecurSubseq(s):
    n = len(s)
    dp = [[0 for i in range(n+1)] for j in range(n+1)]
    maxSubseq = 0
    for i in range(1, n+1):
        for j in range(1, n+1):
            if s[i-1] == s[j-1] and i != j:
                dp[i][j] = 1 + dp[i-1][j-1]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

            if dp[i][j] > maxSubseq:
                maxSubseq = dp[i][j]
    
    print("Longest recurring subsequence : ",printSeq(s, dp))
    return maxSubseq


def printSeq(s, dp):
    i = len(dp[0])-1
    j = len(dp)-1
    seq = deque()
    while dp[i][j] != 0:
        if dp[i-1][j-1] == dp[i-1][j] and dp[i-1][j] == dp[i][j-1]:
            if dp[i-1][j-1] < dp[i][j]:
                seq.appendleft(s[i-1])
                i -= 1
                j -= 1
            else:
                j -= 1
        else:
            if dp[i-1][j] > dp[i][j-1]:
                if dp[i-1][j-1] > dp[i-1][j]:
                    i -= 1
                    j -= 1
                else:
                    i -= 1
            else:
                if dp[i-1][j-1] > dp[i][j-1]:
                    i -= 1
                    j -= 1
                else:
                    j -= 1
    return ''.join(seq)


s = input("Enter the string :")
print("Length of longest recurring subsequence is : ", longesRecurSubseq(s))