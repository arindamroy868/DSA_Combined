arr = [2, 6, 3, 4, 7, 2, 10, 3, 2, 1]
n = 10
k = 5

def getMinDiff(arr, n, k):
    arr.sort()
    print(arr)
    minelem = arr[0] + k
    maxelem = arr[-1] - k
    diff = arr[-1] - arr[0]

    for i in range(1, n-1):
        if arr[i] < k:
            continue
        prevelem = max(maxelem, arr[i-1] + k)
        currelem = min(minelem, arr[i] - k)
        print(abs(prevelem - currelem))
        diff = min(diff, abs(prevelem - currelem))

    print(diff)

getMinDiff(arr, n, k)