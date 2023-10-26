arr = [9, 8, 7, 6, 4, 2, 1, 3]

# Method 1 (Backward Iterative) Time Complexity - O(n)

# Clockwise
for i in range(len(arr)-1, 0, -1):
    arr[i], arr[i-1] = arr[i-1], arr[i]

print(arr)