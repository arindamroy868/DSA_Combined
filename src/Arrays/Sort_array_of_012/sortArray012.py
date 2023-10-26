# Method 1 (Simple sort the array) Time Complexity - O(nlogn)

arr = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]

arr.sort()      # Use merge or quick sort
print(arr)

# Method 2 (Counting Approach) Time Complexity - O(2n) [n+count0+count1+count2]

arr = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]

def sort012(arr):
    count0 = 0
    count1 = 0
    count2 = 0

    for i in arr:
        if i == 0:
            count0 += 1
        elif i == 1:
            count1 += 1
        else:
            count2 += 1

    index = 0
    for _ in range(count0):
        arr[index] = 0
        index += 1

    for _ in range(count1):
        arr[index] = 1
        index += 1

    for _ in range(count2):
        arr[index] = 2
        index += 1 

    print(arr)

sort012(arr)


# Method 3 (Dutch National Flag Algorithm using three pointer) Time Complexity - O(n)

arr = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]

def dnfSort(arr, n):
    low = 0
    mid  = 0
    high = n

    while mid <= high:
        if arr[mid] == 0:
            arr[low], arr[mid] = arr[mid], arr[low]
            low += 1
            mid += 1
        
        elif arr[mid] == 1:
            mid += 1

        else:
            arr[mid], arr[high] = arr[high], arr[mid]
            high -= 1

    print(arr)

dnfSort(arr, len(arr)-1)


########################## Bonus Round - sort array consists 0, 1, 2, 3 (4 elements) ##################################

# Method 1 (Dutch National Flag Algorithm using three pointer) 
# Time Complexity ||Average Case - O(n)|| Worst Case - O(n^2)||
# Worst case scenario if freq of 2 is more than 60% rest of the elemnets and mainly reside in middle of the array.

arr = [2, 1, 3, 3, 2, 0, 0, 1, 3, 2, 2, 2, 2, 2]


def dnfSortfor4flags(arr, n):
    low = 0
    mid  = 0
    high = n

    while mid <= high:
        if arr[mid] == 0:
            arr[low], arr[mid] = arr[mid], arr[low]
            low += 1
            mid += 1
        
        elif arr[mid] == 1:
            mid += 1

        else:
            if arr[mid] == 2:
                if arr[high] == 2:
                    for i in range(mid, high+1):
                        if i == high:
                            mid = high+1
                            break
                        
                        if arr[mid] != arr[i]:
                            arr[mid], arr[i] = arr[i], arr[mid]
                            break
                elif arr[high] > 2:
                    high -= 1
                else:
                    arr[mid], arr[high] = arr[high], arr[mid]
            else:
                arr[mid], arr[high] = arr[high], arr[mid]
                high -= 1

    print(arr)

dnfSortfor4flags(arr, len(arr)-1)


# Method 1 (Dutch National Flag Algorithm using four pointer) Time Complexit - O(n)

arr = [2, 1, 3, 3, 2, 0, 0, 1, 3, 2, 2, 2, 2, 2]

def dnfSortfor4flags2(arr, n):
    low = 0
    mid  = 0
    mid2 = 0
    high = n

    while mid2 <= high:
        if arr[mid] == 0:
            arr[low], arr[mid] = arr[mid], arr[low]
            low += 1
            mid += 1
            mid2 += 1
        
        elif arr[mid] == 1:
            mid += 1
            mid2 += 1

        elif arr[mid] == 2:
            if arr[mid2] != 2:
                arr[mid], arr[mid2] = arr[mid2], arr[mid]
            else:
                mid2 += 1
        
        else:
            arr[mid], arr[high] = arr[high], arr[mid]
            high -= 1

    print(arr)

dnfSortfor4flags2(arr, len(arr)-1)