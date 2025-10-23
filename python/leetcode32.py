class Solution:
    def longestValidParentheses(self, s: str) -> int:
        l, r = 0
        max_len = 0
        for i in range(len(s)):
            if s[i] == "(":
                l = l + 1
            else:
                r = r + 1

            if l == r:
                max_len = max(max_len, l + r)
            elif r > l:
                l = 0
                r = 0

        l = 0
        r = 0
        for i in range(len(s) - 1, -1, -1):
            if s[i] == ")":
                r = r + 1
            else:
                l = l + 1

            if l == r:
                max_len = max(max_len, l + r)
            elif l > r:
                l = 0
                r = 0


        return max_len


