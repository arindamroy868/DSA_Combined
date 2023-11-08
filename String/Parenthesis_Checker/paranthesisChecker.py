# Method 1 - Time Complexity - O(n) and Space Complexity - O(n)
# n - length of brackets
def ispar(brackets):
    if len(brackets) < 2:
        return False
    pair = {']':'[', '}':'{', ')':'('}
    stack = []
    for i in brackets:
        if pair.get(i):
            if stack and stack[-1] == pair[i]:
                stack.pop()
            else:
                return False
        else:
            stack.append(i)

    if stack:
        return False
    else:
        return True


brackets = input("Input the brackets : ")
print("Brackets are balanced : ", ispar(brackets))