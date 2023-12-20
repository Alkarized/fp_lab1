(ns task6.inf)

(defn generate_inf_seq [start]
  (lazy-seq
   (cons start
         (generate_inf_seq (inc start)))))

(defn sum_of_sqaures [nums]
  (reduce + (map #(* % %) nums)))

(defn squares_sum [nums]
  (let [sum (reduce + nums)]
    (* sum sum)))

(defn find_diff_inf [n]
  (let [nums (take n (generate_inf_seq 1))
        sum_square (sum_of_sqaures nums)
        square_sum (squares_sum nums)]
    (- square_sum sum_square)))

(find_diff_inf 100)