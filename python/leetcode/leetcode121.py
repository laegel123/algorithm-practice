from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mini = None;
        prof = 0;

        for n in prices:
            if mini is None:
                mini = n
            elif n < mini:
                mini = n
            else:
                prof = max(prof, n - mini)

        return prof
