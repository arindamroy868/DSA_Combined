class Node:

    def __init__(self, dataval = None):
        self.dataval = dataval
        self.nextval = None


class SlinkedList():

    def __init__(self):
        self.headval = None

    
    def printlist(self):
        currNode = self.headval
        while currNode is not None:
            print(currNode.dataval, end = ' ')
            currNode = currNode.nextval
        print()

    def atLast(self, newdata):
        NewNode = Node(newdata)
        currNode = self.headval
        if currNode is None:
            self.headval = NewNode
            return
        while currNode.nextval is not None:
            currNode = currNode.nextval
        
        currNode.nextval = NewNode
        NewNode.nextval = None
    

    # (Method 1) Time Complexity - O(n) and Space Complexity - O(1)
    def moveElemToFirst(self):
        if self.headval is not None:
            prevNode = None
            currNode = self.headval
            while currNode.nextval is not None:
                prevNode = currNode
                currNode = currNode.nextval

            if currNode == self.headval:
                pass
            else:
                prevNode.nextval = currNode.nextval
                currNode.nextval = self.headval
                self.headval = currNode


ll = SlinkedList()
for i in map(int, input("Enter the elements of Linked List : ").split()):
    ll.atLast(i)

print("Linked list : ", end = ' ')
ll.printlist()
ll.moveElemToFirst()
print("After moving last node to first : ", end = ' ')
ll.printlist()
