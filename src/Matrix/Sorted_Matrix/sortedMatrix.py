# Method 1 (Naive Approach) Time complexity - O(rclog(rc)) and Space Complexity - O(rc)
def sortMatrix(matrix, r, c):
    mat = []
    for i in range(r):
        for j in range(c):
            mat.append(matrix[i][j])

    mat.sort()
    print(mat)
    i = 0
    row = 0
    while row<r:
        col = 0
        for j in range(i, c+i):
            matrix[row][col] = mat[j]
            col += 1
        i = i+r
        row += 1
        
    return matrix


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

matrix = sortMatrix(matrix, row, col)

print("Matrix after sorting")
for i in range(row):
    for j in range(col):
        print(matrix[i][j], end=' ')
    print()