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

    def atBegining(self, newdata):
        NewNode = Node(newdata)
        NewNode.nextval = self.headval
        self.headval = NewNode

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


    # (Method 1 Using Extra space) Time Complexity - O(n+m) and Space Complexity - O(n+m)
    def addTwoNum(self, head1, head2):
        # Store head1 data in arr1
        currNode = head1
        arr1 = []
        while currNode is not None:
            arr1.append(currNode.dataval)
            currNode = currNode.nextval

        # Store head2 data in arr2
        currNode = head2
        arr2 = []
        while currNode is not None:
            arr2.append(currNode.dataval)
            currNode = currNode.nextval
            
        n = len(arr1)
        m = len(arr2)
        arr3 = []           # Store sum of arr1 and arr2
        carry = 0
        while arr1 or arr2:
            if arr1 and arr2:
                value  = arr1.pop()+arr2.pop()+carry
                arr3.append(value%10)
                carry = value//10
            elif arr1:
                value = arr1.pop()+carry
                arr3.append(value%10)
                carry = value//10
            elif arr2:
                value = arr2.pop()+carry
                arr3.append(value%10)
                carry = value//10

        if carry != 0:
            arr3.append(carry)

        for i in arr3:
            self.atBegining(i)
                
    

    # (Method 2 Without extra space) Time Complexity - O(n+m) and Space Complexity - O(1)
    # First linked list will be the resultant linked list by using this approach (Mutation performed).
    def addTwoll(self, head1, head2):
        head1 = self.reverse(head1)
        head2 = self.reverse(head2)
        carry = 0
        
        n = 0
        currNode = head1
        while currNode is not None:
            n += 1
            currNode = currNode.nextval
        
        m = 0
        currNode = head2
        while currNode is not None:
            m += 1
            currNode = currNode.nextval

        list1 = head1
        list2 = head2
        prev = None

        while list1 is not None or list2 is not None:
            data1 = 0 if list1 is None else list1.dataval
            data2 = 0 if list2 is None else list2.dataval

            value = data1+data2+carry
            if n>m:
                list1.dataval = value%10
                carry = value//10
            else:
                list2.dataval = value%10
                carry = value//10

            if list1 is not None:
                prev = list1
                list1 = list1.nextval
            if list2 is not None:
                prev = list2
                list2 = list2.nextval

            
        if carry != 0:
            newNode = Node(carry)
            prev.nextval = newNode
        
        if n>m:
            self.headval = head1
        else:
            self.headval = head2

        self.headval = self.reverse(self.headval)
        return self.headval


    def reverse(self, head):
        curr = head.nextval
        nxtptr = head.nextval
        head.nextval = None
        while curr is not None:
            nxtptr = curr.nextval
            curr.nextval = head
            head = curr
            curr = nxtptr

        return head
    



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
ll3.addTwoNum(ll1.headval, ll2.headval)
print("Sum of two linked list Method 1: ", end = ' ')
ll3.printlist()
ll1.addTwoll(ll1.headval, ll2.headval)
print("Sum of two linked list Method 2: ", end = ' ')
ll1.printlist()