from collections import defaultdict

arr = [1,3,4,2,2]


# Method 1 (Brute force approach) Time Complexity - O(n^2)

def findDuplicate1(arr):
    for i in range(len(arr)-1):
        elem = arr[i]
        for j in range(i+1, len(arr)):
            if arr[j] == elem:
                return elem


print(findDuplicate1(arr))


# Method 2 (Using hashTable) Time Complexity - O(n) and Space complexity - O(n)

def findDuplicate2(arr):
    elemMap = defaultdict(None)
    for i in range(len(arr)):
        if elemMap.get(arr[i]) != None:
            return arr[i]
        else:
            elemMap[arr[i]] = 1

print(findDuplicate2(arr))


# Method 3 (Optimal Approach) Time Complexity - O(n) and Space Complexity - O(1)

def findDuplicate3(arr):
    i = 0
    while True:
        if arr[i] < 0:
            return i
        else:
            arr[i] = -arr[i]
            i = abs(arr[i])

print(findDuplicate3(arr))