from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        sum = 1
        cnt_zero = 0
        res = [0] * len(nums)

        for num in nums:
            if num != 0:
                sum *= num
            else:
                cnt_zero += 1

        if cnt_zero >= 2:
            return res
        elif cnt_zero == 1:
            for i, n in enumerate(nums):
                if n == 0:
                    res[i] = sum
        else:
            for i, n in enumerate(nums):
                res[i] = int(sum / n)

        return res


if __name__ == "__main__":
    s = Solution()
    print(s.productExceptSelf([1,2,3,4]))
