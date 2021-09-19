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

    
    # (Method 1 Recursion) Time Complexity - O(n+m) and Space Complexity - O(n)
    def merge(self, first, second):
        '''
        This merge method work same as we see in the merge sort algorithm
        the only differnce is here we are using recursion
        '''
        if not first:
            return second
        if not second:
            return first
        
        temp = Node()
        if first.dataval < second.dataval:
            temp = first
            temp.nextval = self.merge(first.nextval, second)
        else:
            temp = second
            temp.nextval = self.merge(first, second.nextval)

        return temp


    def mergeSort(self, head):
        if head is not None and head.nextval is not None:
            first = head
            mid = self.findMid(head)
            second = mid.nextval
            mid.nextval = None
            first = self.mergeSort(first)
            second = self.mergeSort(second)
            head = self.merge(first, second)
        return head

    def findMid(self, head):
        '''
        As we know we find the mid index in merge sort algorithm 
        but here we find the mid node of the linked list
        '''
        slow = head
        fast = head.nextval
        while fast is not None and fast.nextval is not None:
            slow = slow.nextval
            fast = fast.nextval.nextval

        return slow



ll = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll.atLast(i)

print("Linked list : ", end = ' ')
ll.printlist()
ll.headval = ll.mergeSort(ll.headval)
print("Linked list after merge sort : ", end = ' ')
ll.printlist()