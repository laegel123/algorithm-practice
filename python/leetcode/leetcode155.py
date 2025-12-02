class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)

    def pop(self) -> None:
        self.stack.pop()


    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        mini = self.stack[-1]

        for i in range(0, len(self.stack)):
            mini = min(mini, self.stack[i])

        return mini


