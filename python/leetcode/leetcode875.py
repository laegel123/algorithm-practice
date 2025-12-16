import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        speed = 1
        while True:
            totalTime = 0
            for pile in piles:
                totalTime += math.ceil(pile/speed)

            if totalTime > h:
                speed += 1
            else:
                return speed

    def minEatingSpeedWithBinarySearch(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        res = 0

        while l <= r:
            totalTime = 0
            m = l + (r - l)//2

            for p in piles:
                totalTime += math.ceil(p/m)

            if totalTime <= h:
                res = m
                r = m - 1
            else:
                l = m + 1

        return res



if __name__ == "__main__":
    s = Solution()
    print(s.minEatingSpeedWithBinarySearch([3, 6, 7, 11], 8))


