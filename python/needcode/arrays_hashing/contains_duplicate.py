from typing import List


class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) < len(nums)


if __name__ == "__main__":
    s = Solution()

    test_list = [1, 2, 3, 1]
    print(s.hasDuplicate(test_list))
