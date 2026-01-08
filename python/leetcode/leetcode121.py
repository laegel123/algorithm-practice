from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        mini = None
        prof = 0

        for n in prices:
            if mini is None:
                mini = n
            elif n < mini:
                mini = n
            else:
                prof = max(prof, n - mini)

        return prof

    def maxProfit_twopointer(self, prices: List[int]) -> int:
        l, r = 0, 1
        max_price = 0

        while r < len(prices):
            if prices[l] < prices[r]:
                profit = prices[r] - prices[l]
                max_price = max(max_price, profit)
            else:
                l = r
            r = r + 1
        return max_price
