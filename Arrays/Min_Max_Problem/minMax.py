arr = input("Enter the input elements : ").split()

# Method 1 (Iterative Approach)

arrMax = arr[0]
arrMin = arr[0]

for i in arr:
    if i > arrMax:
        arrMax = i
    if i < arrMin:
        arrMin = i

print("Max and Min are (Method 1): ", arrMax, arrMin)


# Method 2 (Compare in pairs using class in python)

class minMax:

    def __init__(self):
        self.max = 0
        self.min = 0

    def findMinMax(self, arr):
        if len(arr)&1:                      #bitwise operation to check length of an array is even or odd.
            self.min = self.max = arr[0]
            startIndex = 1
        else:                               # Initializing the min and max variable
            if arr[0] < arr[1]:
                self.min, self.max = arr[0], arr[1]
            else:
                self.min, self.max = arr[1], arr[0]
            startIndex = 2

        for i in range(startIndex, len(arr), 2):
            if arr[i] < arr[i+1]:
                self.min = self.min if self.min < arr[i] else arr[i]
                self.max = self.max if self.max > arr[i+1] else arr[i+1]
            else:
                self.min = self.min if self.min < arr[i+1] else arr[i+1]
                self.max = self.max if self.max > arr[i] else arr[i]

        return self.min, self.max


Obj = minMax()
arrMin, arrMax = Obj.findMinMax(arr)

print("Max and Min are (Method 2): ", arrMax, arrMin)