# Method 1 (Cyclic approach) Time complexity - O(n^2) and Space Complexity - O(1)
def rotateMatrix(mat, n):
    for i in range(n//2):
        for j in range(i, n-i-1):
            temp = mat[i][j]
            mat[i][j] = mat[n-1-j][i]
            mat[n-1-j][i] = mat[n-1-i][n-1-j]
            mat[n-1-i][n-1-j] = mat[j][n-1-i]
            mat[j][n-1-i] = temp

    return mat


# Method 2 (Transpose + Flip approach) Time complexity - O(n^2) and Space Complexity - O(1)
def rotateMatrix1(mat, n):
    for i in range(n):
        for j in range(i+1, n):
            mat[i][j], mat[j][i] = mat[j][i], mat[i][j]

    for i in range(n):
        for j in range(n//2):
            mat[i][j], mat[i][n-1-j] = mat[i][n-1-j], mat[i][j]

    return mat    


row = int(input("Enter the no. of rows : "))
col = row
matrix = []

for i in range(1, row+1):
    temp = []
    for j in map(int, input("Enter the entries for "+str(i)+" row : ").split()):
        temp.append(j)
    matrix.append(temp)

print("Initial Matrix : ")

for i in range(row):
    for j in range(col):
        print(matrix[i][j], end=' ')
    print()

print("Matrix after rotate 90 degree : ")

matrix = rotateMatrix1(matrix, row)

for i in range(row):
    for j in range(col):
        print(matrix[i][j], end=' ')
    print()