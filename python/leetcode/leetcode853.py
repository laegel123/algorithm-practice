from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = [(p, s) for p, s in zip(position, speed)]

        pair.sort(reverse=True)

        stack = []

        for p, s in pair:
            stack.append((target - p) / s)
            if len(stack) >= 2 and stack[-2] >= stack[-1]:
                stack.pop()

        return len(stack)






if __name__ == "__main__":
    s = Solution()
    print(s.carFleet(100, [0, 2, 4], [4, 2, 1]))







