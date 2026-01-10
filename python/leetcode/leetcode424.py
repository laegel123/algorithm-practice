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

    def characterReplacementWithSlideWindow(self, s: str, k: int) -> int:
        char_set = set(s)
        res = 0

        for c in char_set:
            cnt = 0
            l = 0
            for i in range(len(s)):
                if s[i] == c:
                    cnt += 1

                while i - l + 1 - cnt > k:
                    if s[l] == c:
                        cnt -= 1
                    l += 1

                res = max(res, i - l + 1)

        return res


if __name__ == "__main__":
    s = Solution()
    print(s.characterReplacementWithSlideWindow("AABABBA", 1))
