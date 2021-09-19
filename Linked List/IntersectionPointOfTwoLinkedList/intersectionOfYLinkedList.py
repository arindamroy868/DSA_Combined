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
    

    # (Method 1 Using 2 pointer) Time Complexity - O(m+n) and Space Complexity - O(1)
    def intersetPoint(self, head1, head2):
        intersectPoint = -1
        if head1 is not None and head2 is not None:
            ptr1 = head1
            ptr2 = head2
            if ptr1.nextval is None or ptr2.nextval is None:
                return intersectPoint
            while ptr1 != ptr2:
                ptr1 = ptr1.nextval
                ptr2 = ptr2.nextval

                if ptr1 == ptr2:
                    intersectPoint = ptr1.dataval

                if ptr1.nextval is None:
                    ptr1 = head2
                if ptr2.nextval is None:
                    ptr2 = head1
                
        return intersectPoint


    # (Method 2 Floyd's Cycle finding algorithm) Time Complexity - O(m+n) and Space Complexity - O(1)
    def intersetPoint1(self, head1, head2):
        intersectPoint = -1
        if head1 is not None and head2 is not None:
            currNode = head1
            while currNode.nextval is not None: # create a loop to apply floyd's algorithm
                currNode = currNode.nextval
                
            currNode.nextval = head1
            fast = head2
            slow = head2
            while fast is not None and fast.nextval is not None:
                slow = slow.nextval
                fast = fast.nextval.nextval
                if fast == slow:
                    fast = head2
                    while fast != slow:
                        fast = fast.nextval
                        slow = slow.nextval
                    
                    intersectPoint = fast.dataval
                    break
                
        return intersectPoint


ll1 = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll1.atLast(i)

ll2 = SlinkedList()
for i in map(int, input("Enter the elements of 2nd Linked List : ").split()):
    ll2.atLast(i)

common_nodes = list(map(int, input("Enter common nodes : ").split()))
commonLL = SlinkedList()

for i in range(len(common_nodes)):
    commonLL.atLast(common_nodes[i])

currNode = ll1.headval

if currNode is not None:
    while currNode.nextval is not None:
        currNode = currNode.nextval
    currNode.nextval = commonLL.headval

currNode = ll2.headval
if currNode is not None:
    while currNode.nextval is not None:
        currNode = currNode.nextval
    currNode.nextval = commonLL.headval

print("Linked list 1st : ", end = ' ')
ll1.printlist()
print("Linked list 2nd : ", end = ' ')
ll2.printlist()
print("Intersection point Method 1 : ",ll1.intersetPoint(ll1.headval, ll2.headval))
print("Intersection point Method 2 : ",ll1.intersetPoint1(ll1.headval, ll2.headval))


