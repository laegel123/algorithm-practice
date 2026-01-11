class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        len_s1 = len(s1)
        len_s2 = len(s2)
        s1 = sorted(s1)

        for i in range(len_s2 - len_s1 + 1):
            substr = s2[i : i + len_s1]
            substr = sorted(substr)
            if substr == s1:
                return True

        return False

