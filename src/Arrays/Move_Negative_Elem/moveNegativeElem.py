arr = [-1, 2, -3, 4, 5, 6, -7, 8, 9]

# Method 1 (Two pointer) Time complexity - O(n)
a = 127
b = 127
a==b

def moveNegativeElem(arr, n):
    ptr1 = 0
    ptr2 = 0

    while ptr1 <= n:
        if arr[ptr1] < 0:
            arr[ptr1], arr[ptr2] = arr[ptr2], arr[ptr1]
            ptr1 += 1
            ptr2 += 1
        else:
            ptr1 += 1

    print(arr)

moveNegativeElem(arr, len(arr)-1)