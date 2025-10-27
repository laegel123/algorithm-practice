from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}

        for num in nums:
            count[num] = count.get(num, 0) + 1

        arr = []
        for num, count in count.items():
            arr.append([count, num])
        arr.sort()

        res = []
        while len(res) < k:
            res.append(arr.pop()[1])
        return res

    # bucket sort
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt_dict = {}
        for num in nums:
            n = cnt_dict.get(num, 0) + 1
            cnt_dict[num] = n

        sort_list = [[] for i in range(len(nums) + 1)]

        for n, c in cnt_dict.items():
            sort_list[c].append(n)

        result_list = []
        for i in range(len(sort_list) - 1, 0, -1):
            for num in sort_list[i]:
                result_list.append(num)
                if len(result_list) == k:
                    return result_list


        return result_list

if __name__ == "__main__":
    s = Solution()

    print(s.topKFrequent2([1,2], 2))
