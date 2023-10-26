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


    # (Method 1 Using Extra space) Time Complexity - O(n+m) and Space Complexity - O(min(n,m))
    def intersectionLL(self, head1, head2):
        temp1 = head1
        temp2 = head2
        final = self.headval
        while temp1 is not None and temp2 is not None:
            if temp1.dataval == temp2.dataval:
                if final:
                    newNode = Node(temp1.dataval)
                    final.nextval = newNode
                    final = final.nextval
                else:
                    final = Node(temp1.dataval)
                    self.headval = final

                temp1 = temp1.nextval
                temp2 = temp2.nextval
            elif temp1.dataval < temp2.dataval:
                temp1 = temp1.nextval
            else:
                temp2 = temp2.nextval

        return self.headval


ll1 = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll1.atLast(i)

ll2 = SlinkedList()
for i in map(int, input("Enter the elements of 2nd Linked List : ").split()):
    ll2.atLast(i)

ll3 = SlinkedList()

print("Linked list 1st : ", end = ' ')
ll1.printlist()
print("Linked list 2nd : ", end = ' ')
ll2.printlist()
ll3.intersectionLL(ll1.headval, ll2.headval)
print("Intersection of two linked list : ", end = ' ')
ll3.printlist()