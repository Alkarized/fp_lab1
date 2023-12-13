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