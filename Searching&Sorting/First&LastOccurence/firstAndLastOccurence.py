# Method 1 (Naive Approach) Time complexity - O(n) and Space Complexity - O(1)
def firstAndLastOccurence1(arr, k):
    result = [-1, -1]
    for i in range(len(arr)):
        if arr[i] == k and result[0] == -1:
            result[0] = i
            result[1] = i
        elif arr[i] == k:
            result[1] = i

    if result[0] != -1:
        print("First and Last index of ",k," using naive approach : ", end =' ')
        for i in result:
            print(i, end= ' ')
        print()
    else:
        print("Element not in the list")
            

# Method 2 (Efficient Approach) Time Complexity - O(logn) and Space Complexity - O(1)
def firstAndLastOccurence2(arr, k):
    l = 0
    h = len(arr) - 1
    first = -1
    last = -1
    result = []

    # First Occurence Logic
    while (l <= h):
        mid = (l + h) // 2

        if arr[mid] > k:
            h = mid - 1
        elif arr[mid] < k:
            l = mid + 1
        else:
            first = mid
            h = mid - 1
    
    result.append(first)
    l = 0
    h = len(arr) - 1

    # Last Occurence Logic
    while(l <= h):
        mid = (l + h) // 2
         
        if arr[mid] > k:
            h = mid - 1
        elif arr[mid] < k:
            l = mid + 1
        else:
            last = mid
            l = mid + 1

    result.append(last)
    if result[0] != -1:
        print("First and Last index of ",k," using efficient approach : ", end=' ')
        for i in result:
            print(i, end= ' ')
        print()
    else:
        print("Element not in the list")


arr = list(map(int, input("Enter the elements in the list : ").split()))
k = int(input("Enter the element whose occurence need to find : "))
firstAndLastOccurence1(arr, k)
firstAndLastOccurence2(arr, k)