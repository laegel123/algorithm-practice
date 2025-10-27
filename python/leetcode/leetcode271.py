from typing import List


class Solution:

    def encode(self, strs: List[str]) -> str:
        if not strs:
            return ""

        res = ""
        for s in strs:
            res += str(len(s))
            res += ","
        res += "#"
        for s in strs:
            res += s
        return res

    def decode(self, s: str) -> List[str]:
        if not s:
            return []

        res = []
        sizes = []
        idx = 0
        while s[idx] != '#':
            cur = ""
            while s[idx] != ',':
                cur += s[idx]
                idx += 1
            sizes.append(int(cur))
            idx += 1

        idx += 1
        for sz in sizes:
            res.append(s[idx:idx + sz])
            idx += sz
        return res

if __name__ == "__main__":
    s = Solution()
    print(s.encode(["we","say",":","yes","!@#$%^&*()"]))
    print(s.decode("2,3,1,3,10,#wesay:yes!@#$%^&*()"))




