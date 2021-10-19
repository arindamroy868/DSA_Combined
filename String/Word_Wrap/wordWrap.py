# Method 1 (Dynamic Programming) - Time Complexity - O(n^2) and Space Complexity - O(n^2)
def solveWordWrap(nums, k):
    n = len(nums)
    dp = [[-1 for j in range(n)] for i in range(n)]
    cost = [float('inf')]*n
    p = [0]*n

    for i in range(n):
        dp[i][i] = (k - nums[i])**2

    for i in range(n):
        wordSum = nums[i]
        for j in range(i+1, n):
            wordSum += nums[j]
            if wordSum+j-i <= k:
                if j != n-1:
                    dp[i][j] = (k - (wordSum+j-i))**2
                else:
                    dp[i][j] = 0
            else:
                dp[i][j] = -(k - (wordSum+j-i))**2

    for j in range(n):
        for i in range(j+1):
            if dp[i][j] >=0:
                if i > 0:
                    if cost[i-1] + dp[i][j] < cost[j]:
                        cost[j] = cost[i-1] + dp[i][j]
                        p[j] = i+1
                elif dp[i][j] < cost[j]:
                    cost[j] = dp[i][j]
                    p[j] = i+1

    return cost[-1]
 

# Method 2 (Efficient approach) - Time Complexity - O(n^2) and Space Complexity - O(n)
def solveWordWrap2(nums, n, k):
 
    dp = [0] * n
 
    for i in range(n - 2, -1, -1):
        wordlen = -1
        dp[i] = float('inf')
        for j in range(i, n):
            wordlen += (nums[j] + 1)
            if (wordlen > k):
                break
            if (j == n - 1):
                cost = 0
            else:
                cost = ((k - wordlen) *
                        (k - wordlen) + dp[j + 1])

            if (cost < dp[i]):
                dp[i] = cost

    return dp[0]


l = [10,6,5,3,1,10,8,2]
n = len(l)
M = 12
print("Minimum cost using method 1 : ", solveWordWrap(l,M))
print("Minimum cost using method 2 : ", solveWordWrap2(l, n, M))
