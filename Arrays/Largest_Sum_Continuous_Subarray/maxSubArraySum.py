arr = [15, 7, -23, 28, -24, -18, 18, 29, 11, 20, -17, -29, 1, 23, -1, -6, 29, -29, -24, -10, -3, 28, 16, 17, 30, -26, 30, 2, -15, -21, -25, 12, 18, 0, -8, -11, 27, 17, -23, -4, -15, 0, 30, -2, -6, -11, -6, -22, 1, 22]

# Method 1 (Bruteforce Approach) Time Complexity - O(n^2)


def maxSubArray1(arr, n):
    maxSum = 0
    startIndex = 0
    endIndex = 0
    for i in range(0, n):
        for j in range(i, n):
            currSum = 0
            for k in range(i, j+1):
                currSum += arr[k]

            if currSum > maxSum:
                maxSum = currSum
                startIndex = i
                endIndex = j+1
    print("Maximum Sum : ", maxSum)
    print(arr[startIndex:endIndex])

maxSubArray1(arr, len(arr))


# Method 2 (Kadane’s Algorithm) Time Complexity - O(n)

arr = [1,2,3,-2,5]

def maxSubArray2(arr, n):
    currentMax = arr[0]
    globalMax = arr[0]
    startIndex = 0
    endIndex = 0

    for i in range(1, n):
        currentMax = max(arr[i], currentMax+arr[i])

        if currentMax > globalMax:
            globalMax = currentMax
            endIndex = i
    
    print("Maximum Sum : ", globalMax)

    for k in range(endIndex, -1, -1):
        if globalMax == 0:
            startIndex = k+1
            break
        else:
            globalMax -= arr[k]
            k -= 1

    print(arr[startIndex:endIndex+1])

maxSubArray2(arr, len(arr))