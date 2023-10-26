class Node:

    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data

    def treeHeight(self, root):
        if root:
            height = max(self.treeHeight(root.left), self.treeHeight(root.right))
            return height+1
        return 0


node = Node(2)
node.right = Node(1)
node.right.left = Node(3)
print(node.treeHeight(node))
