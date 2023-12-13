(ns task6.map)


(defn pow2 [x]
  (* x x))

(defn find_squares_sum [n]
  (pow2 (reduce + (range 1 (+ n 1)))))

(defn find_sum_squares [n]
  (reduce + (map pow2 (range 1 (+ n 1)))))

(defn find_diff_map [n]
   (- (find_squares_sum n) (find_sum_squares n)))

(find_diff_map 100)