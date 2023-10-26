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


    # (Method 1 Hashing) It only works if all node's data is positive.
    # Time Complexity - O(n) and Space Complexity - O(1)
    def detectloop(self):
        currNode = self.headval
        if currNode is None or currNode.nextval is None:
            return False

        while currNode is not None:
            if currNode.dataval < 0:
                return True
            currNode.dataval = -(currNode.dataval)
            currNode = currNode.nextval

        return False

    
    # (Method 2 Using set) Time Complexity - O(n) and Space Complexity - O(n)
    def detectloop1(self):
        nodeSet = set()
        currNode = self.headval
        if currNode is None:
            return False

        while currNode.nextval is not None:
            if currNode in nodeSet:
                return True
            else:
                nodeSet.add(currNode)
            currNode = currNode.nextval

        return False
    

    # (Method 3 Floyd's Cycle finding algorithm) Time Complexity - O(n) and Space Complexity - O(1)
    def detectloop2(self):
        if self.headval is not None:
            fast = self.headval
            slow = self.headval
            while fast is not None and fast.nextval is not None:
                slow = slow.nextval
                fast = fast.nextval.nextval
                if fast == slow:
                    return True
        
        return False


ll = SlinkedList()
ll.headval = Node(1)
e2 = Node(3)
e3 = Node(4)
e4 = Node(5)
ll.headval.nextval = e2
e2.nextval = e3
e3.nextval = e4
x = 2 # xth node where loop is created from the end.
e4.nextval = e2
print(ll.detectloop())
print(ll.detectloop1())
print(ll.detectloop2())

