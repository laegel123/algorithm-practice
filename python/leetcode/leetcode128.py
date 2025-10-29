from collections import defaultdict
from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0
        store = set(nums)

        for num in nums:
            count = 0
            cur = num

            while cur in store:
                count += 1
                cur += 1
            res = max(res, count)

        return res

    # sets
    def longestConsecutive2(self, nums: List[int]) -> int:
        sets = set(nums)
        count = 0

        for num in sets:
            if (num - 1) not in sets:
                length = 1
                while (num + length) in sets:
                    length += 1
                count = max(count, length)
        return count

if __name__ == "__main__":
    s = Solution()

    test_list = [1, 2, 3, 1]
    print(s.longestConsecutive(test_list))
