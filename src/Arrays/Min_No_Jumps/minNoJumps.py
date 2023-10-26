arr = [2, 3, 1, 1, 2, 4, 2, 0, 1, 1]
n = 4

# Method 1 (Efficient Approach)  Time Complexity - O(n)

def minJumps(arr, n):
    if arr[0] == 0:
        return -1
    nextStop = 0
    jump = 0
    maxdistance = 0
    for i in range(n):
        maxdistance = max(maxdistance, arr[i]+i)
        if arr[i]+i >= n-1:
            jump += 1
            break
        if i == nextStop:
            if arr[i] == 0:
                break
            else:
                jump += 1
                nextStop = maxdistance
    
    if maxdistance >= n-1:
        print(jump)
    else:
        print(-1)


minJumps(arr, n)