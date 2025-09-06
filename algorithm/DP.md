# Dynamic Programming
DP is a method for solving complex problems by breaking them down into simpler subproblems.  
Instead of solving the same subproblem multiple times, DP stores results in a table(memoization or tabulation) and resues them.
  
`It's mainly used for optimization problems (e.g., maximum, minimum, shortest path, number of ways)`

## Two Approaches
1. Bottom-up (Tabulation)
    - Build a table iteratively from the smallest subproblems to the original problem.
    - Usually more efficient (no recursion overhead)
2. Top-down (Memoization)
    - Solve recursively, but store results of subproblems in a dictionary/array so they're not recomputed.
    - Usually easier to write, looks like recursion.

## General Steps
1. Identify subproblems
    - Break the problem into smaller parts.
2. Define state variables
    - E.g., dp[i] might mean "best solution up to index i"
3. Define recurrence relation
    - Formula that relates a state to previous states.
4. Initialize base cases
    - Smallest subproblems (like dp[0] or dp[1])
5. Decide the order of computation
    - Bottom-up(table filling) or top-down(recursion with memo)
6. Extract the final answer
    - Often dp[n] or dp[n][m]

## Examples
### Fibonacci
* Recurrence  
  `F(n) = F(n - 1) + F(n - 2), with F(0) = 0 and F(1) = 1`
* code
1. Bottom-up
```python
def fib(n):
    dp = [0, 1]
    for i in range(2, n + 1):
        dp.append(dp[i - 1] + dp[i - 2])
    return dp[n]
```

```java
public int fib(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```


2. Top-down
```python
def fib(n, memo = {}):
    if n in memo:
        return memo[n]
    if n <= 1:
        return n
    memo[n] = fib(n - 1, memo) + fib(n - 2, memo)
    return memo[n]
    
```
```java
public int fib(int n, Map<Integer, Integer> memo) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    int result = fib(n - 1, memo) + fib(n - 2, memo);
    memo.put(n, result);
    return result;
}
```

### 0/1 Knapsack
* Problem: Given n items with weights and values, maximize total value without exceeding weight capacity W.
* State: dp[i][w] = max value using first i items with weight limit w
* Recurrence  
  &nbsp; if you don't take item i --> dp[i - 1][w]  
  &nbsp; if you take item i --> dp[i - 1][w - weight[i]] + values[i]  

    ```python 
    if weight[i] < w:
        dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i])  
    else:  
        dp[i][w] = dp[i - 1][w]
    ```

* code  
```python
def knapsack(weights, values, W):
    n = len(weights)
    dp = [[0] * (W + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        for w in range(W + 1):
            if weights[i - 1] <= w:
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
            else:
                dp[i][w] = dp[i - 1][w]
    return dp[n][W]
```

```java
public int knapsack(int[] weights, int[] values, int W) {
    int n = weights.length;
    int[][] dp = new int[n + 1][W + 1];

    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }
    return dp[n][W];
}
```
