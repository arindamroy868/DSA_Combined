# Method 1 (Using Extra Space and Sorting) Time complexity - O(n^2logn^2) and Space Complexity - O(n^2)
def kthSmallestElem(mat, n, k):
    if k >= 1 and k <= n*n:
        tempMat = []
        for i in range(n):
            for j in range(n):
                tempMat.append(mat[i][j])

        tempMat.sort()
        return tempMat[k -1]
    return -1


# Method 1 (Binary Search) Time complexity - O(nlogn) and Space Complexity - O(n)
def getElemLessThanK(mat, n, mid):
    count = 0
    for i in range(n):
        l = 0
        h = n-1
        while l<=h:
            _mid = l+h >> 1
            if mat[i][_mid] <= mid:
                l = _mid + 1
            else:
                h = _mid - 1

        count += l

    return count


def kthSmallestElem1(mat, n, k):
    if k >= 1 and k <= n*n:
        l = mat[0][0]
        h = mat[n-1][n-1]
        while l<=h:
            mid = (l+h)//2
            count = getElemLessThanK(mat, n, mid)

            if count < k:
                l = mid + 1
            else:
                 h = mid - 1

        return l
    return -1


row = int(input("Enter the no. of rows : "))
col = row
matrix = []

for i in range(1, row+1):
    temp = []
    for j in map(int, input("Enter the entries for "+str(i)+" row : ").split()):
        temp.append(j)
    matrix.append(temp)

k = int(input("Enter the value of k : "))

for i in range(row):
    for j in range(col):
        print(matrix[i][j], end=' ')
    print()

print("Kth smallest element in Matrix : ", kthSmallestElem1(matrix, row, k))