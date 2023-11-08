# Method 1 (Linear Search) - Time Complexity - O(n) and Space Complexity - O(1)

def minMax1(arr):
    n = len(arr)
    minelem = float('inf')
    maxelem = 0
    for i in arr:
        if i > maxelem:
            maxelem = i
        elif i < minelem:
            minelem = i

    print("Minimun and Maximun in list are Mehtod 1: ", minelem, maxelem)        


# Method 2 (Compare in Pairs) - Time Complexity - O(n) and Space Complexity - O(1)

def minMax2(arr):
    n = len(arr)
    mx = 0
    mn = float('inf')
    if n%2 == 0:
        mx = max(arr[0], arr[1])
        mn = min(arr[0], arr[1])
        i = 2
    else:
        mn = mx = arr[0]
        i = 1

    while (i < n-1):
        if arr[i] > arr[i+1]:
            mx = max(arr[i], mx)
            mn = min(arr[i+1], mn)
        else:
            mx = max(arr[i+1], mx)
            mn = min(arr[i], mn)
        
        i += 2

    print("Minimun and Maximun in list are Method 2: ", mn, mx)

# arr = list(map(int, input("Enter the elements : ").split()))
arr = [1000,11,445,1,330,3000]
minMax1(arr)
minMax2(arr)