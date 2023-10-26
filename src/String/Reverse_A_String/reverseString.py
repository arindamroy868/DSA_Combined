# Method 1 -- Time Complexity - O(n) and Space Complexity - O(1)
def reverseString(s):
    for i, j in enumerate(range(len(s)-1, (len(s)//2)-1, -1)):
        s[i], s[j] = s[j], s[i]
    return s

s = list(map(str,input("Enter the string : ")))
print(reverseString(s))