#arr = [int(x) for x in input("Enter the input element: ").split()]
arr = [10, 4, 5, 8, 6, 11, 26]
k = int(input("Enter the Kth min and max element you want : "))

if k > len(arr):
    print("Kth value cannot be greater than the lenght of an array")
    exit(0)

# Method 1 (Simple sorting approach) Time Complexity - O(nlogn)

maxCount = 0
minCount = 0

arr.sort() # Either use merge sort or quick sort.
print("kth min element : ", arr[k-1])
print("kth max element : ", arr[-k])


# Method 2 (QuickSelect Approach) Average Time complexity - O(n) || Worst Time complexity - O(n^2)

class minMax:

    def __init__(self, left, right, k):
        self.left = left
        self.right = right
        self.k = k

    def driverFunc(self, arr, flag):
        return self.kthElement(arr, flag)

    def partition(self, arr, l, r, flag):
        pivot = arr[r]
        index = l
        if flag == "min":
            for j in range(l, r):
                if arr[j] <= pivot:
                    arr[index], arr[j] = arr[j], arr[index]
                    index += 1
        else:
            for j in range(l, r):
                if arr[j] >= pivot:
                    arr[index], arr[j] = arr[j], arr[index]
                    index += 1
            
        arr[index], arr[r] = pivot, arr[index]
        return index


    def kthElement(self,arr, flag):
        if self.k > 0 and self.k < len(arr):
            index = self.partition(arr, self.left, self.right, flag)

            if index+1 == k:
                return arr[index]
            
            if index+1 < k:
                self.left = index + 1
                return self.kthElement(arr, flag)
            else:
                self.right = index - 1
                return self.kthElement(arr, flag)
        
        print("kth index out of bound.")

ObjMin = minMax(0, len(arr)-1, k)
print(ObjMin.driverFunc(arr, "min"))
ObjMax= minMax(0, len(arr)-1, k)
print(ObjMax.driverFunc(arr, "max"))