# Method 1 (Brute Force Approach) - Time Complexity - O(m*2^n) and Space Complexity - O(n)
# n - length of the word
# m - length of dictionary
def wordBreak1(A, B):
    if len(A) == 0:
        return True
    
    for word in B:
        flag = False
        if A[0:len(word)] == word:
            flag = wordBreak1(A[len(word):], B)
        
        if flag:
            return True

    return False

# Method 2 (Dynamic Programming Top-Down Approach) - Time Complexity - O(m*n^2) and Space Complexity - O(n)
class wordBreak():

    def wordBreak(self, A, B):
        memo = {}
        return self.helper(A, B, memo)

    def helper(self, A, B, memo):
        if len(A) == 0:
            return True
        elif memo.get(A) is not None:
            return memo[A]

        for word in B:
            if A[0:len(word)] == word and self.helper(A[len(word):], B, memo):
                memo[A] = True
                return True
        
        memo[A] = False
        return False


# Method 3 (Dynamic Programming Bottom-Up Approach) - Time Complexity - O(n^2) and Space Complexity - O(n)
def wordBreak2(A, B):
    dp = [False for i in range(len(A)+1)]
    dp[0] = True
    for i in range(1, len(A)+1):
        for j in range(i-1, -1 , -1):
            if dp[j] and A[j:i] in B:
                dp[i] = True
    
    return dp[len(A)]



word = input("Enter the word : ")
dictionary = list(input("Enter the words in dictionary : ").split())
print("Word break possible Method 1 : ", wordBreak1(word, dictionary))
obj = wordBreak()
print("Word break possible Method 2 : ", obj.wordBreak(word, dictionary))
print("Word break possible Method 3 : ", wordBreak2(word, dictionary))