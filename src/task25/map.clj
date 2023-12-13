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