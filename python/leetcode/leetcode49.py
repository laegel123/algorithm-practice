from collections import defaultdict
from typing import List


class Solution:
    # O(m * nlongn)
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = defaultdict(list)
        for s in strs:
            key = "".join(sorted(s))
            dic[key].append(s)

        return list(dic.values())

    # not use sorted
    # -> O(n * m)
    def groupAnagrams2(self, strs: List[str]) -> List[List[str]]:
        dic = defaultdict(list)

        for i in range(len(strs)):
            s = strs[i]
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1

            dic[tuple(count)].append(s)

        return list(dic.values())


if __name__ == "__main__":
    s = Solution()
    print(s.groupAnagrams(["act","pots","tops","cat","stop","hat"]))
