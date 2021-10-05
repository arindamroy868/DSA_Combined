# Method 1 (Naive Approach) -  Time Complexity - O(m*nlog(n)) and Space Complexity - O(n)
def shuffleCheck1(first, second, result):
    if len(first) + len(second) != len(result):
        return False
    
    first = ''.join(sorted(first))
    second = ''.join(sorted(second))
    result = ''.join(sorted(result))
    i = 0
    j = 0
    k = 0
    while k < len(result):
        
        if (i < len(first) and  first[i] == result[k]):
            i += 1
            k += 1
        elif (j < len(second) and second[j] == result[k]):
            j += 1
            k += 1
        else:
            return False
    
    return True


# Method 2 (Efficient Approach) -  Time Complexity - O(n) and Space Complexity - O(n)
# n :- length of a result
def shuffleCheck2(first, second, result):
    if len(first) + len(second) != len(result):
        return False
    
    map1 = {}
    map2 = {}
    for i in first+second:
        if map1.get(i) is not None:
            map1[i] += 1
        else:
            map1[i] = 1


    for j in result:
        if map2.get(j) is not None:
            map2[j] += 1
        else:
            map2[j] = 1

    for key, value in map2.items():
        if map1.get(key) is None or map1[key] != value:
            return False
    
    return True



first = input("Enter the string 1 : ")
second = input("Enter the string 2 : ")
result = input("Enter the original string : ")
print(result,' is a valid shuffle of ', first, ' and ', second, ' : ', shuffleCheck2(first, second, result))

