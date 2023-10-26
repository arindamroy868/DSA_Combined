# Method 1 (Using DP) - Time complexity - O(rc) and Space Complexity - O(rc)
def maxSizeSquareMat(mat, r, c):
    dp = [[0 for i in range(c)] for j in range(r)]
    maxSquare = 0
    maxi = 0
    maxj = 0

    # Store first row in the dp
    for i in range(c):
        dp[0][i] = mat[0][i]

    # Store first column in the dp
    for j in range(r):
        dp[j][0] = mat[j][0]

    # For rest of the matrix
    for i in range(1, r):
        for j in range(1, c):
            if mat[i][j]:
                dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1
                if dp[i][j] > maxSquare:
                    maxSquare = dp[i][j]
                    maxi = i
                    maxj = j

    for i in range(maxi, maxi - maxSquare, -1):
        for j in range(maxj, maxj - maxSquare, -1):
            print(mat[i][j], end=' ')
        print()


    return maxSquare


row = int(input("Enter the no. of rows : "))
col = int(input("Enter the no. of rows : "))
matrix = []

for i in range(1, row+1):
    temp = []
    for j in map(int, input("Enter the entries for "+str(i)+" row : ").split()):
        temp.append(j)
    matrix.append(temp)

for i in range(row):
    for j in range(col):
        print(matrix[i][j], end=' ')
    print()


print("Maximum size square in the matrix : ", maxSizeSquareMat(matrix, row, col))