# Method 1 (Using Extra Space) Time complexity - (rc)log(rc) and Space Complexity - O(r+c)
def medianOfMatrix1(matrix, r, c):
    stack = []
    for i in range(r):
        for j in range(c):
            stack.append(matrix[i][j])
    stack.sort()
    median = (r*c)//2
    return stack[median]


# Method 2 (Nested Binary Search) Time complexity - O(log(2^32)*r*log(c)) and Space Complexity - O(1)
def medianOfMatrix2(matrix, r, c):
    low = float('inf')
    high = 0
    for i in range(r):
        for j in range(c):
            if matrix[i][0] < low:
                low = matrix[i][0]
            if matrix[i][c-1] > high:
                high = matrix[i][c-1]

    while low <= high:
        mid = (low + high) >> 1
        count = 0
        for i in range(r):
            l = 0
            h = c-1
            while l <= h:                  # This part of code is the implementaion of upper_bound or bisec_right in python
                _mid = (l + h) >> 1
                if matrix[i][_mid] <= mid:
                    l = _mid + 1
                else:
                    h = _mid - 1

            count += l
        
        if count <= (r*c)//2:
            low = mid + 1
        else:
            high = mid - 1

    return low



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


print("Median of the matrix Method 1 : ", medianOfMatrix1(matrix, row, col))
print("Median of the matrix Method 2 : ", medianOfMatrix2(matrix, row, col))