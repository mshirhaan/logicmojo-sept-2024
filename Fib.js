TC exponential O(2^n), SC: O(n) which is for call stack space
function fib(n) {
    if(n < 2) {
        return n;
    }
    return fib(n-1) + fib(n-2)
}

DP: Memoized, Top down approach
TC O(n), SC: O(2n) which is for call stack space + memo space
function fib(n, map) {
    if(map[n]!=undefined) {
        return map[n];
    }
    if(n < 2) {
        return n;
    }
    let ans = fib(n-1, map) + fib(n-2, map)
    map[n] = ans;
    return ans;
}

DP: Bottom Up
TC O(n), SC: O(n) which is memo(ans array) space
function fib(n) {
    let ans = [0, 1];
    for(let i = 2; i<=n; i++) {
        ans[i] = ans[i-1] + ans[i-2];
    }
    return ans[n]
}

DP: Bottom Up, Optimized space
TC O(n), SC: O(1)
function fib(n) {
    let first = 0;
    let second = 1;
    let third;

    for(let i = 2; i<=n; i++) {
        third = first + second;
        first = second;
        second = third;
    }
    return third;
}

fib(8)
