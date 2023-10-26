class Node:

    def __init__(self, dataval = None):
        self.dataval = dataval
        self.nextval = None


class SlinkedList():

    def __init__(self):
        self.headval = None
        temp = None
    
    def printlist(self):
        currNode = self.headval
        i = 0
        while currNode is not None:
            if currNode == self.headval and i != 0:
                # print(currNode.dataval, end = ' ')
                break
            i += 1
            print(currNode.dataval, end = ' ')
            currNode = currNode.nextval
        print()

    def atLast(self, newdata):
        NewNode = Node(newdata)
        currNode = self.headval
        if currNode is None:
            self.headval = NewNode
            self.temp = self.headval
        else:
            self.temp.nextval = NewNode
            self.temp = self.temp.nextval
        

    # (Method 1) Time Complexity - O(n) and Space Complexity - O(1)
    def checkPalindrome(self):
        if self.headval is None or self.headval.nextval is None:
            return 1
        
        slow = self.headval
        fast = self.headval
        while fast.nextval is not None and fast.nextval.nextval is not None:
            slow = slow.nextval
            fast = fast.nextval.nextval

        prev = slow
        tail =  slow.nextval
        while tail.nextval != None:
            temp = tail.nextval
            tail.nextval = prev
            prev = tail
            tail = temp

        tail.nextval = prev

        
        fast = self.headval
        while fast != slow.nextval:
            if fast.dataval != tail.dataval:
                return 0
            else:
                fast = fast.nextval
                tail = tail.nextval
        
        return 1


ll = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll.atLast(i)

print("Linked list : ", end = ' ')
ll.printlist()
print(ll.checkPalindrome())