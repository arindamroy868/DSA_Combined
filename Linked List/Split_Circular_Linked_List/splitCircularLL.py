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
        

    # (Method 1 Using 2 pointer) Time Complexity - O(n) and Space Complexity - O(1)
    def splitList(self, head, first, second):
        if self.headval is None:
            return
        if head.nextval == head:
            first.headval = head
            first.headval.nextval = head
            return
        
        slow = head
        fast = head
        while fast.nextval is not head and fast.nextval.nextval is not head:
            slow = slow.nextval
            fast = fast.nextval.nextval

        if fast.nextval.nextval == head:
            fast = fast.nextval

        first.headval = head
        second.headval = slow.nextval
        fast.nextval = slow.nextval
        slow.nextval = head


ll = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll.atLast(i)

currNode = ll.headval
while currNode.nextval is not None:
    currNode = currNode.nextval

currNode.nextval = ll.headval

print("Linked list : ", end = ' ')
ll.printlist()
first = SlinkedList()
second = SlinkedList()
ll.splitList(ll.headval, first, second)
first.printlist()
second.printlist()