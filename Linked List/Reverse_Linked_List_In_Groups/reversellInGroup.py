class Node:

    def __init__(self, dataval = None):
        self.dataval = dataval
        self.nextval = None


class SlinkedList(Node):

    def __init__(self):
        self.headval = None

    def length(self):
        count = 0
        if self.headval:
            currNode = self.headval
            while currNode is not None:
                count += 1
                currNode = currNode.nextval
            return count
        else:
            return count
    

    def printlist(self):
        currNode = self.headval
        while currNode is not None:
            print(currNode.dataval, end = ' ')
            currNode = currNode.nextval
        print()

    
    def push(self, newdata):
        NewNode = Node(newdata)
        if self.headval:
            currNode = self.headval
            while currNode.nextval is not None:
                currNode = currNode.nextval

            currNode.nextval = NewNode
            NewNode.nextval = None
        else:
            self.headval = NewNode


    # Method 1 (Iterative Method) Time Complexity - O(n) and Space Complexity - O(1)
    def reverseInGroup(self, k):
        n = self.length()
        if n%k == 0:
            steps = n//k
        elif n > k:
            steps = (n//k)+1
        else:
            steps = 1
        headpointer = None
        prevNode = None
        currNode = self.headval.nextval
        ptr = currNode
        start = self.headval
        for i in range(steps):
            j = k
            while j > 1 and currNode is not None:
                ptr = currNode.nextval
                currNode.nextval = self.headval
                self.headval = currNode
                currNode = ptr
                j -= 1

            if i == 0:
                headpointer = self.headval

            if prevNode is not None:
                prevNode.nextval = self.headval

            self.headval = currNode
            start.nextval = currNode
            prevNode = start
            start = currNode
            if currNode is not None:
                currNode = currNode.nextval
                ptr = currNode

        self.headval = headpointer


    # Method 2 (Recursion) Time Complexity - O(n) and Space Complexity - O(n//k) or O(n//k)+1
    def reverserRecursive(self, head, k):
        if self.headval is None:
            return self
        
        currNode = head
        next = None
        prev = None
        count = 0

        while currNode is not None and count < k:
            next = currNode.nextval
            currNode.nextval = prev
            prev = currNode
            currNode = next
            count += 1


        if next is not None:
            head.nextval = self.reverserRecursive(next, k)

        return prev


ll = SlinkedList()
ll.push(3)
ll.push(8)
ll.push(7)
ll.push(2)
ll.push(5)
ll.push(3)
print("Given Linked List : ")
ll.printlist()
k = 4
print("Group size: ", k)
ll.reverseInGroup(k)
print("Rverse Linked List : ") 
ll.printlist()
ll.headval = ll.reverserRecursive(ll.headval, k)
print("Rverse Linked List using recursion : ")
ll.printlist()