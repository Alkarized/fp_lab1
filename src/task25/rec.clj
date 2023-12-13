(ns task25.rec)

(defn fib_iter [fib1 fib2 index digits]
  (if (== digits (count (str fib1)))
    index
    (fib_iter (+ fib1 fib2) fib1 (inc index) digits)))

(defn fib_start [digits]
  (fib_iter 1 1 2 digits))

(fib_start 100)
