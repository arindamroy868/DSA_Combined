from collections import Counter

arr1 = [85,25,1,32,54,6]
arr2 = [85, 2]

# Method 1 (Using inbuilt library)

count1 = Counter(arr1)
count2 = Counter(arr2)
print("Union of two array ", list((count1|count2).keys()))
print("Intersection of two array ", list((count1&count2).keys()))


# Metho 2 (Using dictionary in python) Time Complexity - O(n+m) where n --- len(arr1) and m ---- len(arr2)


def unionArr(arr1, arr2):
    unionMap = {}
    for i in arr1:
        if unionMap.get(i) == None:
            unionMap[i] = 1
    
    for j in arr2:
        if unionMap.get(i) == None:
            unionMap[i] = 1

    print("Union of two array ", list(unionMap.keys()))


def intersectoinArr(arr1, arr2):
    intersectionMap = {}
    print("Intersection of two array ", end='')
    if len(arr1) < len(arr2):
        for i in arr1:
            intersectionMap[i] = 1
        for j in arr2:
            if intersectionMap.get(j) != None:
                print(j, end=' ')
    else:
        for i in arr2:
            intersectionMap[i] = 1
        for j in arr1:
            if intersectionMap.get(j) != None:
                print(j, end=' ')
    print()
    

unionArr(arr1, arr2)
intersectoinArr(arr1, arr2)