keyPad = ['2','22','222','3','33','333','4','44','444','5','55','555','6','66','666','7','77','777','7777','8','88','888','9','99','999','9999']

# Method 1 (Brute force) - Time Complexity - O(n) and Space Complexity - O(1)
def printSeq(sentence):
    seq = ''
    for i in sentence:
        if i == ' ':
            seq = seq+'0'
        else:
            index = ord(i.lower()) - ord('a')
            seq = seq+keyPad[index]
    return seq


sentence = input('Enter the sentence to convert in keypad sequence : ')
print(printSeq(sentence))