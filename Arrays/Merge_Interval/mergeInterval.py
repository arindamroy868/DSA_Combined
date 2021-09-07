intervals = [[1,3],[2,6],[8,10],[15,18]]

#  Method 1 (Brute force approach) Time Complexity - O(nlogn) and Space Complexity - O(n)


intervals.sort(key=lambda x: x[0])
result = []
result.append(intervals[0])
i = 1
while i < len(intervals):
    if result[-1][1] >= intervals[i][0]:
        result[-1] = [result[-1][0], max(result[-1][1],intervals[i][1])]
    else:
        result.append(intervals[i])
    i += 1

print(result)


# Method 2 (Optimal Approach) Time Complexity - O(nlogn) and Space Complexity - O(1)
# Mutation performed in this approach

def mergeInterval(intervals):
    intervals.sort(key=lambda x: x[0])
    indx = 0
    n = len(intervals)
    for i in range(1, n):
        if intervals[indx][1] >= intervals[i][0]:
            intervals[indx][1] = max(intervals[indx][1], intervals[i][1])
        else:
            indx += 1
            intervals[indx][0], intervals[indx][1] = intervals[i][0], intervals[i][1]
    
    for _ in range(n-1, indx, -1):
        intervals.pop()

    print(intervals)
        

mergeInterval(intervals)