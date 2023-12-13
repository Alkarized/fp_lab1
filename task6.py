def fast_find_diff(n: int) -> int:
    def find_sum_squares(n: int) -> int:
        return n * (n + 1) * (2*n + 1) / 6
    
    def find_squares_sum(n: int) -> int:
        return pow((1 + n) * n / 2, 2)
    
    return int(find_squares_sum(n) - find_sum_squares(n))

def long_find_diff(n: int) -> int:
    sum1 = 0
    sum2 = 0
    for x in range(1, n + 1):
        sum1 += x
        sum2 += pow(x, 2)
    
    sum1 = pow(sum1, 2)
    
    return sum1 - sum2


print(fast_find_diff(100))
print(long_find_diff(100))
