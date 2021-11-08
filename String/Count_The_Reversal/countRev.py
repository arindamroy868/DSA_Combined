# Method 1 (Using Stack) - Time Complexity - O(n) and Space Complexity - O(1)
# n = len(s)
def countRev(s):
    count = 0
    stack = []
    for i in s:
        if stack:
            if i == '}' and stack[-1] == '{':
                stack.pop()
            else:
                stack.append(i)
        else:
            if i == '}':
                count += 1
                stack.append('{')
            else:
                stack.append(i)

    
    if len(stack) % 2 == 0:
        return count+len(stack)//2
    else:
        return -1


S = "}{{}}{{{"
print(countRev(S))