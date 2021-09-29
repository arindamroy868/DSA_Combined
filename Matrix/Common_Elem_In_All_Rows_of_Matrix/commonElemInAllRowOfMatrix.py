# Method 1 (Using Hashing) Time complexity - O(rc) and Space Complexity - O(c)
def commonElemInMatrix(mat, r, c):
    hashMap = {}
    for i in range(c):
        hashMap[mat[0][i]] = 1
    
    print("Common elements in all rows of matrix : ", end= ' ')
    for i in range(1, r):
        for j in range(c):
            if hashMap.get(mat[i][j]) is not None and hashMap[mat[i][j]] == i:
                hashMap[mat[i][j]] += 1
                if i == r-1:
                    print(mat[i][j], end=' ')
    print()


row = int(input("Enter the no. of rows : "))
col = int(input("Enter the no. of columns : "))
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

commonElemInMatrix(matrix, row, col)