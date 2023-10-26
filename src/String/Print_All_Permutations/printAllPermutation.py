# Method 1 (Recursion) - Time Complexity - O(n * n!) and Space Complexity - O(n+n!)
# **I didn't include the time complexity to print result as it itself takes O(n) time.
class printAllPermutation1():
    
    def printPermutations(self, s):
        freq = [0 for i in range(len(s))]
        stack = []
        result = []
        self.findPermutation(s, stack, result, freq)
        print("All possible permutation of string Method 1: ", end = ' ')
        for i in result:
            print(''.join(i), end =' ')
        print()


    def findPermutation(self, s, stack, result, freq):
        if len(stack) == len(s):
            result.append(stack[:])
            return
        
        for i in range(len(s)):
            if not freq[i]:
                freq[i] = 1
                stack.append(s[i])
                self.findPermutation(s, stack, result, freq)
                stack.pop()
                freq[i] = 0


# Method 2 (Swapping appraoch) - Time Complexity - O(n * n!) and Space Complexity - O(n)
class printAllPermutation2():
    
    def printPermutations(self, s):
        result = []
        self.findPermutation(0, list(s), result)
        print("All possible permutation of string Method 2: ", end = ' ')
        result.sort()           # sort the permutations lexicographically
        for i in result:
            print(''.join(i), end =' ')
        print()


    def findPermutation(self, index, s, result):
        if index == len(s):
            result.append(''.join(s[:]))
            return
        
        for i in range(index, len(s)):
            s[i], s[index] = s[index], s[i]
            self.findPermutation(index+1, s, result)
            s[i], s[index] = s[index], s[i]


s = input("Enter the string : ")
obj1 = printAllPermutation1()
obj1.printPermutations(s)
obj2 = printAllPermutation2()
obj2.printPermutations(s)