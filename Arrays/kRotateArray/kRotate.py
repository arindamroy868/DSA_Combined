arr = [1,2,3,4,5,6,7]
k = 30

# Method 1 (Brute Force Approach) Time complexity - O(nk) ~ O(n^2)

#Clockwise Rotation
for i in range(k % len(arr)):
    for i in range(len(arr)-1, 0, -1):
        arr[i], arr[i-1] = arr[i-1], arr[i]


print(arr)


# Method 2 (Using Slicing) Time Complexity - O(n),  Space Complexity - O(n)

slice_index = k % len(arr)
arr2 = arr[-slice_index:]+arr[:len(arr)-slice_index]

print(arr2)


# Method 3 (Efficient Approach) Time Complexity - O(n), Space Complexity - O(1)

def kRotate(arr, k, n):
    start = n - k + 1
    end = (n + start) // 2

    # Reverse the array from n-k+1 to end
    for i, j in enumerate(range(n, end, -1), start):
        arr[i], arr[j] = arr[j], arr[i]


    # Reverse the array from 0 to n-k
    for i, j in enumerate(range(start-1, (start-1)//2, -1), 0):
        arr[i], arr[j] = arr[j], arr[i]


    # Reverse the complete array
    for i, j in enumerate(range(n, n//2, -1), 0):
        arr[i], arr[j] = arr[j], arr[i]

    print(arr)

kRotate(arr, k%len(arr), len(arr)-1)
