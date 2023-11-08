arr = [3, 4, 6, 1, 2, 5]

# Method 1 (Brute Force Approach) Time Complexity - O(n^2) and Space Complexity - O(1)

count = 0
for i in range(len(arr)-1):
    for j in range(i+1, len(arr)):
        if arr[i] > arr[j]:
            count += 1

print(count)


# Method 2 (Using Merge Sort) Time Complexity - O(nlogn) and Space Complexity - O(n)

class Solution:

    def merge(self, arr, l, m, r, merge_arr):
        i = l
        j = m+1
        k = l
        invcount = 0
        while i <= m and j <= r:
            if arr[i] <= arr[j]:
                merge_arr[k] = arr[i]
                i += 1
            else:
                merge_arr[k] = arr[j]
                invcount += (m-i)+1
                j += 1
            k += 1
    
        while i <= m:
            merge_arr[k] = arr[i]
            i += 1
            k += 1
    
        while j <= r:
            merge_arr[k] = arr[j]
            j += 1
            k += 1
    
        for i in range(l, k):
            arr[i] = merge_arr[i]
     
        return invcount

    def mergeSort(self, arr, left, right, merge_arr):
        count = 0
        if left < right:
            mid = (left+right)//2
            count += self.mergeSort(arr, left, mid, merge_arr)
            count += self.mergeSort(arr, mid+1, right, merge_arr)
    
            count += self.merge(arr, left, mid, right, merge_arr)
    
        return count

    def inversionCount(self, arr, n):
        left = 0
        right = n-1
        merge_arr = [0]*len(arr)
        return self.mergeSort(arr, left, right, merge_arr)
        

obj = Solution()
print(obj.inversionCount(arr, len(arr)))