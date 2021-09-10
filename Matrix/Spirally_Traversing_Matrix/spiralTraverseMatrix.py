matrix = [[6, 6, 2, 28, 2], [12, 26, 3, 28, 7], [22, 25, 3, 4, 23]]
r = 3
c = 5

# Method 1 (Optimal Solution) Time Complexity - O(r*c) Space Complexity - O(1)

rowStart = 0
rowEnd = r
columnStart = 0
coulumnEnd = c

while rowStart < rowEnd and columnStart <  coulumnEnd:
    for i in range(columnStart, coulumnEnd):
        print(matrix[rowStart][i], end=' ')
    rowStart += 1

    for i in range(rowStart, rowEnd):
        print(matrix[i][coulumnEnd-1], end=' ')
    coulumnEnd -= 1

    if rowStart < rowEnd:
        for i in range(coulumnEnd-1, columnStart-1, -1):
            print(matrix[rowEnd-1][i], end=' ')
        rowEnd -= 1
    
    if columnStart < coulumnEnd:
        for i in range(rowEnd-1, rowStart-1, -1):
            print(matrix[i][columnStart], end=' ')
        columnStart += 1
        