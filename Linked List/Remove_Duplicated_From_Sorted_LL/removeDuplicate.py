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
    

    # (Method 1) Time Complexity - O(n) and Space Complexity - O(1)
    def removeDuplicate(self):
        if self.headval is not None:
            prevNode = None
            currNode = self.headval
            while currNode is not None:
                if prevNode and prevNode.dataval == currNode.dataval:
                    prevNode.nextval = currNode.nextval
                    currNode = currNode.nextval
                else:
                    prevNode = currNode
                    currNode = currNode.nextval


ll = SlinkedList()
ll.headval = Node(2)
e2 = Node(2)
e3 = Node(4)
e4 = Node(5)
ll.headval.nextval = e2
e2.nextval = e3
e3.nextval = e4
ll.printlist()
ll.removeDuplicate()
ll.printlist()


