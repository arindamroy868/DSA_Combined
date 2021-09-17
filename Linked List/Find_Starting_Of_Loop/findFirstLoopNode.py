class Node:

    def __init__(self, dataval = None):
        self.dataval = dataval
        self.nextval = None


class SlinkedList():

    def __init__(self):
        self.headval = None

    
    def printlist(self):
        temp = {}
        currNode = self.headval
        while currNode is not None:
            if temp.get(currNode) is not None:
                print(currNode.dataval, end = ' ')
                break
            print(currNode.dataval, end = ' ')
            temp[currNode] = 1
            currNode = currNode.nextval
        print()
    

    # (Method 3 Floyd's Cycle finding algorithm) Time Complexity - O(n) and Space Complexity - O(1)
    def findFirstLoopNode(self):
        if self.headval is not None:
            fast = self.headval
            slow = self.headval
            while fast is not None and fast.nextval is not None:
                slow = slow.nextval
                fast = fast.nextval.nextval
                if fast == slow:
                    fast = self.headval
                    while fast != slow:
                        fast = fast.nextval
                        slow = slow.nextval
                    
                    return fast.dataval


ll = SlinkedList()
ll.headval = Node(50)
e2 = Node(20)
e3 = Node(15)
e4 = Node(4)
e5 = Node(10)
ll.headval.nextval = e2
e2.nextval = e3
e3.nextval = e4
e4.nextval = e5
x = 3 # xth node where loop is created from the end.
e5.nextval = e3
ll.printlist()
print(ll.findFirstLoopNode())


