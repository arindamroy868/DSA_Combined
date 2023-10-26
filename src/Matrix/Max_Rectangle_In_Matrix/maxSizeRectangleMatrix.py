'''
Here I have implemented 3 ways to find the maximum Area in histogram.
1. Brute Force Approach (find left and right index for each bar in histogram and then calculate the area)
2. Using extra space (first store the left and right indexes in a respective list by traversing histogram array two times then finally compute the area)
3. Optimal Solution (Traverse histogram array single time and compute the area of previous largest bar and finally calcualte area of the bars left in the stack)
'''


# Method 1 (Naive Approach)
def maxArea1(row):
    n = len(row)
    area = 0
    max_area = 0
    for i in range(n):
        left_index = -1
        right_index = -1
        j = i
        while j > -1:
            if row[j] >= row[i]:
                left_index = j
            else:
                break

            j -= 1

        j = i
        while j < n:
            if row[j] >= row[i]:
                right_index = j+1
            else:
                break

            j += 1
        
        area = (right_index-left_index) * row[i]
        max_area = max(area, max_area)

    return max_area


# Method 2 Using two list stores the left smaller index and right smaller index
def maxArea2(row):
    n = len(row)
    area = 0
    max_area = 0
    left_index = []
    right_index = []
    stack = []
    i = 0
    while i < n:
        if stack:
            if  row[i] <= row[stack[-1]]:
                stack.pop()
            else:
                left_index.append(stack[-1]+1)
                stack.append(i)
                i += 1
        else:
            stack.append(i)
            left_index.append(0)
            i += 1

    stack *= 0
    i = n-1
    while i > -1:
        if stack:
            if  row[i] <= row[stack[-1]]:
                stack.pop()
            else:
                right_index.append(stack[-1]-1)
                stack.append(i)
                i -= 1
        else:
            stack.append(i)
            right_index.append(n-1)
            i -= 1
    

    for i in range(n):
        area = (right_index[n-i-1] - left_index[i] + 1) * row[i]
        max_area = max(area, max_area)

    return max_area


# Method 3 (Optimized approach) Time complexity - O(rc) and Space Complexity - O(c)
def maxArea3(row):
    stack = []
    top = 0
    max_area = 0
    area = 0
    i = 0

    while i<len(row):
        if not stack or row[stack[-1]] <= row[i]:
            stack.append(i)
            i += 1
        else:
            top = row[stack.pop()]
            left_index = -1 if not stack else stack[-1]
            right_index = i
            area = top * (right_index - left_index - 1)
            max_area = max(area, max_area)

    while stack:
        top = row[stack.pop()]
        left_index = -1 if not stack else stack[-1]
        right_index = i
        area = top * (right_index - left_index - 1)
        max_area = max(area, max_area)

    return max_area


def maxSizeRectangle(matrix, r, c):
    res = maxArea3(matrix[0])

    for i in range(1, r):
        for j in range(c):
            if matrix[i][j]:
                matrix[i][j] += matrix[i-1][j]

        res = max(res, maxArea3(matrix[i]))

    return res


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

print("Maximum Rectangle area : ", maxSizeRectangle(matrix, row, col))