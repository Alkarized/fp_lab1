(ns task6.ez-way)

(defn find_diff_ez [n]
  (defn find_sum_squares [y]
    (/ (apply * [y (+ y 1) (+ (* 2 y) 1)]) 6))

  (defn find_squares_sum [y]
    (Math/pow (/ (* y (+ y 1)) 2) 2))

  ;;  (println (find_squares_sum n))
  ;;(println (find_sum_squares n))
  (- (find_squares_sum n) (find_sum_squares n)))

  
(find_diff_ez 100)


  
  

  
