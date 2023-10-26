arr = input("Enter array element: ").split()
print("Array before reverse : ", arr)
n = len(arr)

# Method 1 (slicing)

arr = arr[::-1]
print("Array after reverse method 1 : ", arr)


# Method 2 (Iteration using enumerate)

for en, i in enumerate(range(n-1, (n-1)//2, -1)):
    arr[en], arr[i] = arr[i], arr[en]

print("Array after reverse method 2 : ", arr)


# Method 3 (Iteration using 3rd variable)
# we can also use mathematical operatoins instead of 3rd variable but that won't work with strings.

for i in range(n//2):
    temp = arr[i]
    arr[i] = arr[n-i-1]
    arr[n-i-1] = temp

print("Array after reverse method 3 : ", arr)
