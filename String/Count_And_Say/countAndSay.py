# Method 1

def countAndSay1(n):
    if n == 1:
        return '1'

    num = '1'
    for i in range(n-1):
        list = []
        j = 0
        k = -1
        while j < len(num):
            if j == 0 or num[j] != num[k]:
                list.append({num[j]: 1})
            elif num[j] == num[k]:
                list[-1][num[j]] += 1
            j += 1
            k += 1

        temp = ''
        for item in list:
            key = next(iter(item))
            temp = ''.join([temp, str(item[key]), key])
        
        num = temp

    return num


# Method 2

def countAndSay2(n):
    if n == 1:
        return '1'

    num = '1'
    for i in range(n-1):
        curr = 1
        prev = 0
        count = 1
        tmp = ''
        while curr < len(num):
            if num[curr] == num[prev]:
                count += 1
            else:
                tmp += str(count)
                tmp += num[prev]
                prev = curr
                count = 1
            curr += 1

        tmp += str(count)
        tmp += num[prev]
        num = tmp

    return num

print("Method 1 result : ", countAndSay1(6))
print("Method 2 result : ", countAndSay2(6))