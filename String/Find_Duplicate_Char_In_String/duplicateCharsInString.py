# Method 1 (Using dictionary) - Time Complexity - O(n) and Space Complexity - O(k)  where 0<=k>=n

def findDuplicateChars(s):
    charMap = {}
    for i in range(len(s)):
        if charMap.get(s[i]) is not None:
            charMap[s[i]] += 1
        else:
            charMap[s[i]] = 1

    for key, value in charMap.items():
        if value > 1:
            print(key, end=' ')

    print()



s = 'test string'
print("Duplicate Charactes in String : ", end=' ')
findDuplicateChars(s)