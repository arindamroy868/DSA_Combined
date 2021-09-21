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

    
    # (Method 1) Time Complexity - O(nlogn) and Space Complexity - O(n)
    def partition(self, start, end):
        if start is None or end is None or start == end:
            return start

        pivot_prev = start
        curr = start
        pivot = end.dataval

        while start != end:
            if start.dataval < pivot:
                pivot_prev = curr
                temp = curr.dataval
                curr.dataval = start.dataval
                start.dataval = temp
                curr = curr.nextval

            start = start.nextval
        
        temp = curr.dataval
        curr.dataval = pivot
        end.dataval = temp

        return pivot_prev


    def quickSort(self, head, last):
        if head is None or head == last or head == last.nextval:
            return head

        pivot_prev = self.partition(head, last)
        self.quickSort(head, pivot_prev)

        if pivot_prev is not None and pivot_prev == head:
            self.quickSort(pivot_prev.nextval, last)
        elif pivot_prev is not None and pivot_prev.nextval is not None:
            self.quickSort(pivot_prev.nextval.nextval, last)


ll = SlinkedList()
for i in map(int, input("Enter the elements of 1st Linked List : ").split()):
    ll.atLast(i)


last = ll.headval
while last.nextval is not None:
    last = last.nextval

print("Linked list : ", end = ' ')
ll.printlist()
ll.quickSort(ll.headval, last)
print("Linked list after quick sort : ", end = ' ')
ll.printlist()