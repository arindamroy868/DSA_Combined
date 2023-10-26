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
                print(currNode.dataval, end = ' ')
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
    def checkCircularLL1(self):
        if self.headval is None:
            return 0
        if self.headval.nextval is None:
            return 0
        
        currNode = self.headval.nextval
        while currNode is not None:
            if currNode == self.headval:
                return 1
            
            currNode = currNode.nextval

        return 0
        

    # (Method 2 Using 2 pointer) Time Complexity - O(n) and Space Complexity - O(1)
    def checkCircularLL2(self):
        if self.headval is None:
            return 0
        if self.headval.nextval is None:
            return 0
        
        slow = self.headval
        fast = self.headval
        while fast is not None and fast.nextval is not None:
            slow = slow.nextval
            fast = fast.nextval.nextval
            if slow == fast:
                return 1

        return 0


ll = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll.atLast(i)

decision = input("Do you want to make list circular (y/n) : ")
if decision.lower() == 'y':
    currNode = ll.headval
    while currNode.nextval is not None:
        currNode = currNode.nextval

    currNode.nextval = ll.headval

print("Linked list : ", end = ' ')
ll.printlist()
print("Is this circular linked list : ", end= ' ')
# print(ll.checkCircularLL1())
print(ll.checkCircularLL2())