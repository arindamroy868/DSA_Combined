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
    

   # (Method 1 Using set) Time Complexity - O(n) and Space Complexity - O(n)
    def detectAndRemoveloop1(self):
        nodeSet = set()
        currNode = self.headval
        if currNode is None:
            return False

        while currNode.nextval is not None:
            if currNode.nextval in nodeSet:
                break
            nodeSet.add(currNode)
            currNode = currNode.nextval

        currNode.nextval = None


    # (Method 2 Floyd's Cycle finding algorithm) Time Complexity - O(n) and Space Complexity - O(1)
    def detectAndRemoveloop2(self):
        if self.headval is not None and self.headval.nextval is not None:
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

                    while slow.nextval != fast:
                        slow = slow.nextval

                    slow.nextval = None
                    break


ll = SlinkedList()
ll.headval = Node(7)
e2 = Node(58)
e3 = Node(36)
e4 = Node(34)
e5 = Node(16)
ll.headval.nextval = e2
e2.nextval = e3
e3.nextval = e4
e4.nextval = e5
x = 1 # xth node where loop is created from the end.
e5.nextval = ll.headval
ll.printlist()
ll.detectAndRemoveloop1()
ll.printlist()
ll.detectAndRemoveloop2()
ll.printlist()



