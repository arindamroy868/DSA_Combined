# Method 1 (Binary Search) - Time Complexity - O(log n) and Space Complexity - O(1)
class Search:
    def searchInRotatedArray(self, nums, n, target):
        pivot = self.findPivot(nums, 0, n-1);
        low = 0
        high = n-1
        if pivot != -1:
            if nums[pivot] == target:
                return pivot
            elif nums[0] <= target:
                low = 0
                high = pivot-1
            else:
                low = pivot+1
                high = n-1

        while low <= high:
            mid = int((low + high)/2)
            if target == nums[mid]:
                return mid
            elif target > nums[mid]:
                low = mid+1
            else:
                high = mid-1

        return -1
    
    def findPivot(self, arr, low, high):

        if high < low:
            return -1
        if high == low:
            return low

        mid = int((low + high)/2)

        if mid < high and arr[mid] > arr[mid + 1]:
            return mid
        if mid > low and arr[mid] < arr[mid - 1]:
            return (mid-1)
        if arr[low] >= arr[mid]:
            return self.findPivot(arr, low, mid-1)
        return self.findPivot(arr, mid + 1, high)


# Method 2 (Efficient approach) - Time Complexity - O(logn) and Space Complexity - O(1)
# Reduced the no. of binary search
def searchInRotatedArray(arr, l, h, target):
    if l > h:
        return -1
    
    mid = (l+h)//2
    if arr[mid] == target:
        return mid
    
    if arr[l] <= arr[mid]:
        if target <= arr[mid] and target >= arr[l]:
            return searchInRotatedArray(arr, l, mid-1, target)
        return searchInRotatedArray(arr, mid+1, h, target)
    
    if target >= arr[mid] and target <= arr[h]:
        return searchInRotatedArray(arr, mid+1, h, target)
    return searchInRotatedArray(arr, l, mid-1, target)


arr = list(map(int, input("Enter the elements in the list : ").split()))
n = len(arr)
target = int(input("Enter the target value : "))
obj = Search()
print("Index of the element using Method 1 : ", obj.searchInRotatedArray(arr, n, target))
print("Index of the element using Method 2 : ", searchInRotatedArray(arr, 0, n-1, target))