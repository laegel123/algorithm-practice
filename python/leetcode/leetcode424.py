class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        res = 0
        for i in range(len(s)):
            cnt, max_f = {}, 0

            for j in range(i, len(s)):
                cnt[s[j]] = 1 + cnt.get(s[j], 0)
                max_f = max(max_f, cnt[s[j]])

                if (j - i + 1) - max_f <= k:
                    res = max(res, j - i + 1)

        return res


if __name__ == "__main__":
    s = Solution()
    print(s.characterReplacement("AAABABB", 1))
