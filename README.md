# Лабораторная работа №1

## Цель работы:
 Освоить базовые приёмы и абстракции функционального программирования: функции, поток управления и поток данных, сопоставление с образцом, рекурсия, свёртка, отображение, работа с функциями как с данными, списки.

 В рамках лабораторной работы вам предлагается решить несколько задач [проекта Эйлер](https://projecteuler.net/archives).

 ## Вариант:

 6. Sum Square Difference
 25. 1000-digit Fibonacci Number

 ## 6. Sum Square Difference

 ### Условие:

The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 55^2 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 
3025 - 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

***Ответ к задаче:*** 25164150

### Хвостовая рекурсия

```clojure
(ns task6.tail-rec)

(defn tail_sum_of_sqr [n acc]
  (if (zero? n)
      acc
      (recur (dec n) (+ acc (* n n)))))

(defn tail_sqr_sum [n acc]
  (if (zero? n)
    (* acc acc)
    (recur (dec n) (+ acc n))))

(defn find_diff_tail [n]
 (- (tail_sqr_sum n 0) (tail_sum_of_sqr n 0)))

(find_diff_tail 100)

```
### Обычная рекурсия

```clojure
(ns task6.rec)

(defn rec_sum_sqr [n]
  (if (zero? n)
    0
    (+ (* n n) (rec_sum_sqr (dec n))))
  )

(defn rec_sqr_sum [n]
  (if (zero? n)
    0
    (+ n (rec_sqr_sum (dec n)))))

(defn diff_rec [n] 
  (- ((fn [n] (* n n)) (rec_sqr_sum n))  (rec_sum_sqr n) ))

(diff_rec 100)
```

### Бесконечные списки

```clojure
(ns task6.inf)

(defn generate_inf_seq [start]
  (lazy-seq 
   (cons start  
    (generate_inf_seq (inc start)))))

(defn sum_of_sqaures [nums]
  (reduce + (map (fn [n] (* n n)) nums)))

(defn squares_sum [nums]
  (let [sum (reduce + nums)]
     (* sum sum)))

(defn find_diff_inf [n]
  (let [nums (take n (generate_inf_seq 1))
        sum_square (sum_of_sqaures nums)
        square_sum (squares_sum nums)]
    (- square_sum sum_square)))

(find_diff_inf 100)
```

### Формулками

```clojure
(ns task6.ez-way)

(defn find_sum_squares [y]
  (/ (apply * [y (+ y 1) (+ (* 2 y) 1)]) 6))

(defn find_squares_sum [y]
  (Math/pow (/ (* y (+ y 1)) 2) 2))

(defn find_diff_ez [n]
  (- (int (find_squares_sum n)) (int (find_sum_squares n)) ))

(find_diff_ez 100)
```

### На Python

```python
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
```

 ## 6. 1000-digit Fibonacci Number

 ### Условие:

The Fibonacci sequence is defined by the recurrence relation:

F_n = F_n-1 + F_n-2, where F1 = 1 and F2 = 1.

Hence the first 12 terms will be:
F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144

 
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

***Ответ к задаче:*** 4782

### Хвостовая рекурсия

```clojure
(ns task25.tail-rec)

(defn fib_iter [fib1 fib2 index digits]
  (if (== digits (count (str fib1)))
    index
    (recur (+ fib1 fib2) fib1 (inc index) digits))
  )

(defn fib_start [digits]
  (fib_iter 1 1 2 digits))

(fib_start 100)
```

### Обычная рекурсия

```clojure
(ns task25.rec)

(defn fib_iter [fib1 fib2 index digits]
  (if (== digits (count (str fib1)))
    index
    (fib_iter (+ fib1 fib2) fib1 (inc index) digits)))

(defn fib_start [digits]
  (fib_iter 1 1 2 digits))

(fib_start 100)
```

### Бесконечные списки

```clojure
(ns task25.inf)

(defn generate_inf_seq [f1 f2]
  (lazy-seq
   (cons f1
         (generate_inf_seq (+ f1 f2) f1))))


(defn get_indexed [n]
  (->> (generate_inf_seq 0 1)
       (map str)
       (map count)
       (map-indexed (fn [idx itm] [idx itm]))
       (filter #(== (second %) n))
       first
       first
       ))

(get_indexed 100)
```

### Альтернативное решение

```clojure
(ns task25.end)

(defn generate_inf_seq [f1 f2]
  (lazy-seq
   (cons f1
         (generate_inf_seq (+ f1 f2) f1))))

(defn get_index [n]
  (let [nums (take 5000 (generate_inf_seq 0 1))]
    (->> nums
         (map #(count (str %)))
         (map-indexed (fn [idx itm] [idx itm]))
         (filter #(== (second %) n))
         first 
         first
         )
  ))

(get_index 1000)
```

### Генерация через map

```clojure
(ns task25.map)

(defn fibonacci-sequence []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))


(defn fib_search [n]
  (let [index (atom 1)
        fib_seq (fibonacci-sequence)]
    (loop [seq fib_seq]
      (let [num (first seq)]
        (if (== (count (str num)) n)
          @index
          (do 
            (swap! index inc)
            (recur (rest seq)))
           )))))


(fib_search 25)
```

### На Python

```python
def fiban_iter(digits: int) -> int:
    fib1 = 1
    fib2 = 1

    n: int = 2
    
    while True:
        if (len(str(fib1)) == digits):
            return n
        n += 1
        fib1, fib2 = fib2 + fib1, fib1

print(fiban_iter(22))

```

### Заключение

Выполняя данную лабораторную работу, я познакомился с функциональным программированием вцелом, а конкретно с новым для себя языком Clojure. Изучил основной синтаксис, научился базовым возможностям языка: работа с последовательностями, их генерацией, сверткой и т.д.
