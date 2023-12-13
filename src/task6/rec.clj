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