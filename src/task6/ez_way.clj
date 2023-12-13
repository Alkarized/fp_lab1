(ns task6.ez-way)

(defn find_sum_squares [y]
  (/ (apply * [y (+ y 1) (+ (* 2 y) 1)]) 6))

(defn find_squares_sum [y]
  (Math/pow (/ (* y (+ y 1)) 2) 2))

(defn find_diff_ez [n]
  (- (int (find_squares_sum n)) (int (find_sum_squares n)) ))

(find_diff_ez 100)
