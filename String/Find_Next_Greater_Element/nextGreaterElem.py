# Method 1 (Efficient Apporach) - Time Complexity - O(n) and Space Complexity - O(1)
def nextGreaterElem(arr):
    n = len(arr)
    if n == 1:
        return arr
    elif n == 2:
        if arr[0] < arr[1]:
            arr[0], arr[1] = arr[1], arr[0]
            return arr
        else:
            return arr
    else:
        i = n-2
        j = n-1
        while i >= 0:
            if arr[i] < arr[i+1]:
                if arr[i] < arr[j]:
                    break
                else:
                    j -= 1
            else:
                i -= 1
        
        if i > -1:
            arr[i], arr[j] = arr[j], arr[i]
            for j, k in enumerate(range(n-1, (1+n)//2, -1), i+1):
                arr[j], arr[k] = arr[k], arr[j]
        else:
            for j, k in enumerate(range(n-1, (n//2)-1, -1), 0):
                arr[j], arr[k] = arr[k], arr[j]

    return arr

arr = list(map(int, input("Enter the elements : ").split()))
print("Next greater element using same elements : ", nextGreaterElem(arr))