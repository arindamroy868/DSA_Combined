matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 13
m = len(matrix)
n = len(matrix[0])

# Method 1 (Brute Force Approach) Time Complexity - O(m*n) Space Complexity - O(1)

found = False

for i in range(m):
    for j in range(n):
        if matrix[i][j] == target:
            found = True
            break
    if found:
        break

print(found)



# Method 2 (Binary Search) Time Complexity - m*log(n) Space Complexity - O(1)

def searchMatrix1(matrix):
    i = 1
    while i < m+1:
        h = n*i-1
        l = h - (n -1)
        while l <= h:
            mid = (l+h)//2
            if matrix[i-1][mid%n] == target:
                return True
            elif matrix[i-1][mid%n] < target:
                l = mid + 1
            else:
                h = mid - 1
        i += 1
    return False
        
searchMatrix1(matrix)


# Method 3 (Binary Search) Time Complexity - log(m*n) Space Complexity - O(1)

def searchMatrix2(matrix):
    i = 0
    j = n-1
    while i < m and j >= 0:
        print(matrix[i][j])
        if matrix[i][j] == target:
            print(True)
            return True
        elif matrix[i][j] < target:
            i += 1
        else:
            j -= 1
    print(False)
        
searchMatrix2(matrix)




# Method 4 (Binary Search) Time Complexity - log(mn) Space Complexity - O(1)

def searchMatrix3(matrix):
    l = 0
    h = (m*n)-1
    while l <= h:
        mid = (l+h)//2
        row = mid // n
        column = mid % n
        if matrix[row][column] == target:
            return True
        elif matrix[row][column] < target:
            l = mid + 1
        else:
            h = mid - 1
    return False

searchMatrix3(matrix)
