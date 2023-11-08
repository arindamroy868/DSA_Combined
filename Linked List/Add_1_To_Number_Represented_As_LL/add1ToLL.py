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

    # (Method 1 Recursion) Time Complexity - O(n) and Space Complexity - O(n)

    def addFunction(self, head):
        if head is None:
            return 1
        carry = self.addFunction(head.nextval)
        value = head.dataval+carry
        head.dataval = value%10
        carry = value//10
        return carry

    
    def add1Toll_recursive(self, head):
        if head is not None:
            carry = self.addFunction(head)

            if carry != 0:
                newNode = Node(carry)
                newNode.nextval = head
                head = newNode

        return head


    # (Method 2 Iterative) Time Complexity - O(n) and Space Complexity - O(1)

    def reverse(self):
        curr = self.headval.nextval
        nxtptr = self.headval.nextval
        self.headval.nextval = None
        while curr is not None:
            nxtptr = curr.nextval
            curr.nextval = self.headval
            self.headval = curr
            curr = nxtptr

        return self.headval

    
    def add1Toll_iterative(self, head):
        if head is not None:
            carry = 1
            self.headval = self.reverse()
            currNode = self.headval
            while currNode is not None:
                if carry != 0:
                    value = currNode.dataval+carry
                    currNode.dataval = value%10
                    carry = value//10
                
                currNode = currNode.nextval

            if carry != 0:
                ll.atLast(carry)

            self.headval = self.reverse()



ll = SlinkedList()
for i in map(int, input("Enter the elements of Linked List : ").split()):
    ll.atLast(i)

print("Linked list : ", end = ' ')
ll.printlist()
ll.add1Toll_recursive(ll.headval)
# ll.add1Toll_iterative(ll.headval)
print("After moving last node to first : ", end = ' ')
ll.printlist()