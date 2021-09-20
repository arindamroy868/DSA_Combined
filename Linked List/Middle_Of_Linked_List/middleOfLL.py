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
        while currNode is not None:
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

    
    # (Method 1 By first finding lenght of linked list) Time Complexity - O(n) and Space Complexity - O(1)
    def findMiddleElem1(self):
        if self.headval is None:
            return
        if self.headval.nextval is None:
            return self.headval
        
        length = 0
        currNode = self.headval
        while currNode is not None:
            length += 1
            currNode = currNode.nextval

        currNode = self.headval
        for _ in range(length//2):
            currNode = currNode.nextval

        return currNode
        

    # (Method 2 Using 2 pointer) Time Complexity - O(n) and Space Complexity - O(1)
    def findMiddleElem2(self):
        if self.headval is None:
            return
        if self.headval.nextval is None:
            return self.headval
        
        slow = self.headval
        fast = self.headval
        while fast is not None and fast.nextval is not None:
            slow = slow.nextval
            fast = fast.nextval.nextval

        return slow


ll = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll.atLast(i)

print("Linked list : ", end = ' ')
ll.printlist()
ll.headval = ll.findMiddleElem1()
# ll.headval = ll.findMiddleElem2() # We can use any mehtod both have the same time and space compelxity.
print("Middle element of linked list : ", end = ' ')
ll.printlist()