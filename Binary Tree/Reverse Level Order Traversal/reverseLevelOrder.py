from collections import deque

class Node:

    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data

    # Method 1 (Depth First Search) Time Complexity - O(n) and Space Complexity - O(n)
    def reverse(self):
        res = deque()
        if self.data:
            q = []
            q.append(self)
            
            while len(q):
                temp = q[0]
                res.appendleft(temp.data)
                q.pop(0)

                if temp.right:
                    q.append(temp.right)
                if temp.left:
                    q.append(temp.left)

        return res


node = Node(10)
node.left = Node(20)
node.right = Node(30)
node.left.left = Node(40)
node.left.right = Node(60)
for i in node.reverse():
    print(i, end = ' ')
