class Node:

    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data

    def insert(self, data):
        if self.data:
            if self.data > data:
                if self.left is None:
                    self.left = Node(data)
                else:
                    self.left.insert(data)
            else:
                if self.right is None:
                    self.right = Node(data)
                else:
                    self.right.insert(data)
        else:
            self.data = data
    

    # Method 1 (Breadth First Search) Time Complexity - O(n) and Space Complexity - O(n)
    def bfs(self):
        if self.data:
            q = []
            q.append(self)
            
            while len(q):
                temp = q[0]
                q.pop(0)

                print(temp.data, end = ' ')

                if temp.left:
                    q.append(temp.left)
                if temp.right:
                    q.append(temp.right)
        else:
            return


node = Node(25)
node.insert(3)
node.insert(2)
node.insert(1)
node.insert(4)
node.insert(5)
node.bfs()