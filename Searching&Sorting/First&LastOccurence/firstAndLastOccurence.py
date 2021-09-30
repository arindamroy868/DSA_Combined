# Method 1 (Naive Approach) Time complexity - O(n) and Space Complexity - O(1)
def firstAndLastOccurence1(arr, k):
    result = [-1, len(arr)-1]
    for i in range(len(arr)):
        if arr[i] == k and result[0] == -1:
            result[0] = i
        elif result[0] != -1 and arr[i] != k:
            result[1] = i-1
            break

    if result[0] != -1:
        print("First and Last occurence of ",k," : ", end = ' ')
        for i in result:
            print(i, end= ' ')
        print()
    else:
        print("Element not in the list")


arr = [1, 3, 5, 5, 5, 5, 7, 123, 125]
k = 7
firstAndLastOccurence1(arr, k)