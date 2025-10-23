from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dif_map = {}

        for i in range(len(nums)):
            dif = target - nums[i]
            if nums[i] in dif_map:
                return [dif_map.get(nums[i]), i]

            dif_map[dif] = i

        return []


if __name__ == "__main__":
    s = Solution()

    print(s.twoSum([3, 4, 5, 6], 7))
