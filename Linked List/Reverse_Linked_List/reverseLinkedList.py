class Node:

    def __init__(self, dataval = None):
        self.dataval = dataval
        self.nextval = None


class SlinkedList(Node):

    def __init__(self):
        self.headval = None

    def printlist(self):
        currNode = self.headval
        while currNode is not None:
            print(currNode.dataval, end = ' ')
            currNode = currNode.nextval
        print()

    
    def push(self, newdata):
        NewNode = Node(newdata)
        NewNode.nextval = self.headval
        self.headval = NewNode


    # Using stack Time Complexity - O(n) and Space Complexity - O(n)
    def reverse1(self):
        stack = []
        currNode = self.headval
        if currNode is None:
            return

        while currNode is not None:
            stack.append(currNode.dataval)
            currNode = currNode.nextval
        
        for i in range(len(stack)-1, -1, -1):
            print(stack[i], end= ' ')
        print()



    # Iterative method using two pointer Time Complexity - O(n) and Space Complexity - O(1)
    def reverse2(self):
        if self.headval is not None:
            curr = self.headval.nextval
            nxtptr = self.headval.nextval
            
            self.headval.nextval = None
            while curr is not None:
                nxtptr = curr.nextval
                curr.nextval = self.headval
                self.headval = curr
                curr = nxtptr

            self.printlist()



    # Recursive method Time Complexity - O(n) and Space Complexity - O(1)
    def reverse3(self, head):
        
        if head is None or head.nextval is None:
            return head

        rest = self.reverse3(head.nextval)

        head.nextval.nextval = head
        head.nextval = None

        return rest


ll = SlinkedList()
ll.push(1)
ll.push(2)
ll.push(3)
ll.push(4)
ll.push(5)
print("Given Linked List :")
ll.printlist()
print("Reverse Linked list :")
ll.reverse1()
ll.reverse2()
ll.headval = ll.reverse3(ll.headval)# This will return the output same as "Given linked list" if you will not comment the above line as in method reverse2() head is already pointing at end.
ll.printlist() 