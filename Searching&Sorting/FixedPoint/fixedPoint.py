# Method 1 - Time complexity - O(N) and Space complexity - O(1)
def valueEqualToIndex(arr, n):
    res = []
    for i in range(n):
        if i+1 == arr[i]:
            res.append(arr[i])
            
    return res


arr = map(int, input("Enter the elements in array : ").split())
print("Elements having same value as indices : ", end =' ')
for i in valueEqualToIndex(arr, len(arr)):
    print(i, end=' ')

