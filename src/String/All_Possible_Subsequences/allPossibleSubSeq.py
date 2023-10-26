from itertools import combinations

# Method 1 (Recursion) - Time Complexity - O(2^n) and Space Complexity - O(n)
def allPossibleSubSeq1(s, subSeq):
    if len(s) == 0:
        print(subSeq, end=' ')
        return
    
    allPossibleSubSeq1(s[1:], subSeq+s[0])
    allPossibleSubSeq1(s[1:], subSeq)


# Method 2 (Power Set approach) - Time Complexity - O(n*2^n) and Space Complexity - O(1)
def allPossibleSubSeq2(s):
    print("All subsequence of string using power set approach : ")
    for i in range(2**len(s)):
        for j in range(len(s)):
            if (i & (1 << j)) != 0:
                print(s[j], end ='')
        print("", end=' ')
    print()

    
# Method 3 (Using Combinations) 
def allPossibleSubSeq3(s):
    print("All subsequence of string using combination : ")
    for i in range(0,len(s)+1):
        for j in combinations(s,i):
            print(''.join(j), end= ' ')
    print()


s = input("Enter the String : ")
res = ''
print("All subsequence of string using recursion : ") 
allPossibleSubSeq1(s, res)
print()
allPossibleSubSeq2(s)
allPossibleSubSeq3(s)