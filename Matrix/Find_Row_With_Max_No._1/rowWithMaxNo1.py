# Method 1 (Naive Approach) Time complexity - O(rc) and Space Complexity - O(1)
def findRow1(matrix, r, c):
    maxNo1 = 0
    rowIndex = -1
    for i in range(r):
        current1 = 0
        for j in range(c):
            if matrix[i][j] == 1:
                current1 += 1

        if current1 > maxNo1:
            maxNo1 = current1
            rowIndex = i

    return rowIndex


# Method 2 (Binary Search) Time complexity - O(rlogc) and Space Complexity - O(1)
def findRow2(matrix, r, c):
    maxNo1 = 0
    rowIndex = -1
    for i in range(r):
        l = 0
        h = c-1
        while l <= h:                  # This part of code is the implementaion of upper_bound or bisec_right in python
            mid = (l + h) >> 1
            if matrix[i][mid] < 1:
                l = mid + 1
            else:
                h = mid - 1
        
        if c-l > maxNo1:
            maxNo1 = c-l 
            rowIndex = i

    return rowIndex


# Method 3 (Efficient Approach) Time complexity - O(r+c) and Space Complexity - O(1)
def findRow3(matrix, r, c):
    rowIndex = -1
    index = c-1
    for i in range(r):
        while index >= 0 and matrix[i][index] == 1:
            index -= 1
            rowIndex = i
    return rowIndex



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

print("Row with max no. of 1 (Method 1) : ", findRow1(matrix, row, col))
print("Row with max no. of 1 (Method 2) : ", findRow2(matrix, row, col))
print("Row with max no. of 1 (Method 2) : ", findRow3(matrix, row, col))