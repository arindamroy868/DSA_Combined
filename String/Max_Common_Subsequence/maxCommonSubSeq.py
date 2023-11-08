from collections import deque

# Method 1 (Dynamic Programming) - Time Complexity(n1^n2) and Space Complexity(n1^n2)
# n1 :- length of str1
# n2 :- length of str2
def longesRecurSubseq(s1, s2):
    n1 = len(s1)
    n2 = len(s2)
    dp = [[0 for j in range(n2+1)] for i in range(n1+1)]
    maxSubseq = 0
    for i in range(1, n1+1):
        for j in range(1, n2+1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = 1 + dp[i-1][j-1]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

            if dp[i][j] > maxSubseq:
                maxSubseq = dp[i][j]

    print("Common subsequence : ",printSeq(s1, s2, dp))
    return maxSubseq


def printSeq(s1, s2, dp):
    i = len(dp)-1
    j = len(dp[0])-1
    seq = deque()
    while dp[i][j] != 0:
        if dp[i-1][j-1] == dp[i-1][j] and dp[i-1][j] == dp[i][j-1]:
            if dp[i-1][j-1] < dp[i][j]:
                seq.appendleft(s1[i-1])
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
    if seq:
        return ''.join(seq)
    else:
        return ''

s1 = input("Enter the string1 : ")
s2 = input("Enter the string2 : ")
print("Length of maximum common subsequece :",longesRecurSubseq(s1, s2))