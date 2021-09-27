# Method 1 (Naive approach) Time complexity - O(n^4) and Space Complexity - O(1)
def findMaxValue(mat, n):
    maxValue = 0
    for a in range(n):
        for b in range(n):
            for c in range(a+1, n):
                for d in range(b+1, n):
                    if mat[c][d] - mat[a][b] > maxValue:
                        maxValue = mat[c][d] - mat[a][b]

    return maxValue


# Method 2 (Efficient approach) Time complexity - O(n^2) and Space Complexity - O(n^2)
def findMaxValue1(mat, n):
    maxValue = float('-inf')
    maxMat = [[0 for i in range(n)] for j in range(n)]
    maxMat[n-1][n-1] = mat[n-1][n-1]
    
    tempMax = mat[n-1][n-1]
    for i in range(n-2, -1, -1):
        if mat[n-1][i] > tempMax:
            tempMax = mat[n-1][i]
        maxMat[n-1][i] = tempMax

    tempMax = mat[n-1][n-1]
    for i in range(n-2, -1, -1):
        if mat[i][n-1] > tempMax:
            tempMax = mat[i][n-1]
        maxMat[i][n-1] = tempMax

    for i in range(n-2, -1, -1):
        for j in range(n-2, -1, -1):
            print(maxMat[i+1][j+1],  mat[i][j])
            if maxMat[i+1][j+1] - mat[i][j] > maxValue:
                maxValue = maxMat[i+1][j+1] - mat[i][j]

            maxMat[i][j] = max(mat[i][j], max(maxMat[i][j+1], maxMat[i+1][j]))

    return maxValue


row = int(input("Enter the no. of rows : "))
col = row
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

print("Maximum value of a pair in Matrix : ", findMaxValue1(matrix, row))