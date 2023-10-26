# Method 1 - Time complexity - O(sqrt(N)) and Space Complexity - O(1)
def countSquares(N):
    if N == 1:
        return 0
    i = 1
    result = 1
    while result < N:
        i += 1
        result = i * i
    return i-1


N = int(input("Enter the integer : "))
print("Count of perfect squares : ", countSquares(N))