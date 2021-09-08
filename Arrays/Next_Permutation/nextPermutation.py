arr = [62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22]

# Method 1 (Optimal Solution) Time Complexity - O(n) and Space Complexity - O(1)

def nextPermutation(arr):
    N = len(arr)
    i = N-2
    while i >=0 and arr[i] >= arr[i+1]:
        i -= 1
    if i > -1:
        j = N-1
        while arr[j] <= arr[i]:
            j -= 1
        arr[i], arr[j] = arr[j], arr[i]
        for j, k in enumerate(range(N-1, (i+N)//2, -1), i+1):
            arr[j], arr[k] = arr[k], arr[j]
    else:
        for j, k in enumerate(range(N-1, (N//2)-1, -1), 0):
            arr[j], arr[k] = arr[k], arr[j]
        
    print(arr)

nextPermutation(arr)