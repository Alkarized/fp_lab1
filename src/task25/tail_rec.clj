(ns task25.tail-rec)

(defn count_dig [fib] 
  (count (str fib)))

(defn fib_iter [fib1 fib2 index digits]
  (if (== digits (count_dig fib1))
    index
    (recur (+ fib1 fib2) fib1 (inc index) digits))
  )

(defn fib_start [digits]
  (fib_iter 1 1 2 digits))

(fib_start 3)
