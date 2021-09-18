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
    

    # (Method 1 Using set) Time Complexity - O(n) and Space Complexity - O(n)
    def removeDuplicate(self):
        nodeSet = set()
        if self.headval is not None:
            prevNode = None
            currNode = self.headval
            while currNode is not None:
                if currNode.dataval in nodeSet:
                    prevNode.nextval = currNode.nextval
                    currNode = currNode.nextval
                else:
                    nodeSet.add(currNode.dataval)
                    prevNode = currNode
                    currNode = currNode.nextval


ll = SlinkedList()
ll.headval = Node(5)
e2 = Node(2)
e3 = Node(2)
e4 = Node(4)
ll.headval.nextval = e2
e2.nextval = e3
e3.nextval = e4
print("Linked list with duplicates : ", end = ' ')
ll.printlist()
ll.removeDuplicate()
print("Linked list after removing duplicates : ", end = ' ')
ll.printlist()
