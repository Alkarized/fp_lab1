# def fiban_rec(n: int) -> int:
#     if n < 3:
#         return 1
#     return fiban_rec(n - 1) + fiban_rec(n - 2)

def fiban_iter(digits: int) -> int:
    fib1 = 1
    fib2 = 1

    n: int = 2
    
    while True:
        if (len(str(fib1)) == digits):
            return n
        n += 1
        fib1, fib2 = fib2 + fib1, fib1

# n: int = 100

# print(fiban_rec(30))
print(fiban_iter(22))