import math

arr1 = [1, 3, 5, 7]
arr2 = [0, 2, 6, 8, 9]


n = len(arr1)
m = len(arr2)


# Method 1 (Brute force approach) Time Complexity - O((n+m)*log(n+m)), Space Complexity - O(n+m)

merge_arr = arr1 + arr2
merge_arr.sort()
print(merge_arr)


# Method 2 (Little Optimized approach) Time Complexity - O(n+m), Space Complexity - O(n+m)

merge_arr = []
i = 0
j = 0
while i < n and j < m:
    if arr1[i] < arr2[j]:
        merge_arr.append(arr1[i])
        i += 1
    else:
        merge_arr.append(arr2[j])
        j += 1

while i < n:
    merge_arr.append(arr1[i])
    i += 1

while j < m:
    merge_arr.append(arr2[j])
    j += 1

print(merge_arr)

# Method 3 (Without extra space) Time Complexity - O(n*m), Space Complexity - O(1)

def mergeArray(arr1, arr2, n, m):
    for i in range(n):
        pos = 0
        for j in range(m):
            if arr1[i] > arr2[j]:
                arr2[pos], arr2[j] = arr2[j], arr2[pos]
                pos = j
        if arr1[i] > arr2[pos]:
            arr1[i], arr2[pos] = arr2[pos], arr1[i]

    for elem in arr1:
        print(elem, end=' ')
            
    for elem in arr2:
        print(elem, end=' ')

mergeArray(arr1, arr2, n, m)



# Method 4 (GAP Algorithm) Time Complexity - (n*logn) Space Complexity - O(1)

def mergeArray1(arr1, arr2, n, m):
    gap = math.ceil((n+m)/2)
    while True:
        i = 0
        j = gap
        while j < m+n:
            if i < n and j < n:
                if arr1[i] >= arr1[j]:
                    arr1[i], arr1[j] = arr1[j], arr1[i]
            elif i < n and j >= n:
                if arr1[i] >= arr2[j-n]:
                    arr1[i], arr2[j-n] = arr2[j-n], arr1[i]
            else:
                if arr2[i-n] >= arr2[j-n]:
                    arr2[i-n], arr2[j-n] = arr2[j-n], arr2[i-n]
            
            i += 1
            j += 1
        if gap != 1:
            gap = math.ceil(gap/2)
        else:
            break
    
    print(arr1, arr2)

mergeArray1(arr1, arr2, n, m)