from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        while l < r:
            m = l + (r - l)//2
            if nums[m] > nums[r]:
                l = m + 1
            else:
                r = m

        pivot = l
        res = self.binary_search(0, pivot - 1, nums, target)
        if res != -1:
            return res

        return self.binary_search(pivot, len(nums) - 1, nums, target)


    def binary_search(self, l:int, r:int, nums: List[int], target:int) -> int:

        while l <= r:
            m = l + (r - l)//2
            if nums[m] == target:
                return m
            elif nums[m] < target:
                l = m + 1
            else:
                r = m - 1

        return -1



if __name__ == "__main__":
    s = Solution()
    print(s.search([3, 1], 1))
