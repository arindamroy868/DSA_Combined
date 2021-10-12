# Method 1 (Iterative) - Time Complexity - O(n) and Space Complexity - O(1)
def maxBalancedSubstr(s):
    counter = 0
    count0 = 0
    count1 = 0
    for i in s:
        if i == '0':
            count0 += 1
        elif i == '1':
            count1 += 1

        if count0 == count1:
            counter += 1

    if counter == 0:
        return -1
    
    return counter


s = '0100110101'
print("Maximum balanced substring in string : ",maxBalancedSubstr(s))