# Method 1 (Naive Approach) - Time Complexity - O(M*(N-M+1)) and Space Complexity - O(N)
# N :- length of s1
# M :-  length of s2

def checkRotation(s1, s2):
    if len(s1) != len(s2):
        return False
    temp = s1+s1
    if s2 in temp:
        return True
    else:
        return False


# Method 2 (KMP Algorithm) - Time Complexity - O(N) and Space Complexity - O(M)
# N :- length of s
# M :- length of goal

class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        shiftTable = self.generateLPS(goal)
        i = 0
        j = 0
        s = s+s
        N = len(s)
        M = len(goal)
        while i<N:
            if s[i] == goal[j]:
                i += 1
                j += 1
            else:
                if j != 0:
                    j = shiftTable[j-1]
                else:
                    i += 1

            if j == M:
                return True
            
        return False
                
                
    def generateLPS(self, goal):
        lps = [0]*len(goal)
        shift = 0
        i = 1
        while i<len(goal):
            if goal[i] == goal[shift]:
                lps[i] = shift+1
                shift += 1
                i += 1
            else:
                if shift != 0:
                    shift = lps[shift-1]
                else:
                    lps[i] = shift
                    i += 1
        return lps


s1 = input("Enter the string : ")
s2 = input("Enter the rotated string : ")
print("String 2 is a rotation of String 1 Method 1: ",checkRotation(s1, s2))
obj = Solution()
print("String 2 is a rotation of String 1 Method 2: ",obj.rotateString(s1, s2))