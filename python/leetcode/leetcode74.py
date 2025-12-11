from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        idx = 0
        arr = []
        for i in range(len(matrix)):
            arr = matrix[i]

            if arr[0] <= target <= arr[-1]:
                idx = i
                break

        l = 0
        r = len(arr) - 1

        while l <= r:
            m = l + (r - l)//2
            if arr[m] == target:
                return True
            elif arr[m] < target:
                l = l + 1
            else:
                r = r - 1

        return False


if __name__ == "__main__":
    s = Solution()
    print(s.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13))


