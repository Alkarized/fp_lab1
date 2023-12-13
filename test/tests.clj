(ns tests)
(require '[clojure.test :refer [is deftest]])
(require '[task6.ez-way :refer [find_diff_ez]])
(require '[task6.inf :refer [find_diff_inf]])
(require '[task6.map :refer [find_diff_map]])
(require '[task6.rec :refer [diff_rec]])
(require '[task6.tail-rec :refer [find_diff_tail]])

(deftest test-ez
  (is (= 4 (+ 2 2)))
  (is (= (int (find_diff_ez 100)) 25164150))
  (is (= (int (find_diff_ez 2)) 4))
  )

(deftest test-inf
  (is (= 4 (+ 2 2)))
  (is (= (int (find_diff_inf 100)) 25164150))
  (is (= (int (find_diff_inf 2)) 4)))

(deftest test-map
  (is (= 4 (+ 2 2)))
  (is (= (int (find_diff_map 100)) 25164150))
  (is (= (int (find_diff_map 2)) 4)))

(deftest test-rec
  (is (= 4 (+ 2 2)))
  (is (= (int (diff_rec 100)) 25164150))
  (is (= (int (diff_rec 2)) 4)))

(deftest test-tail
  (is (= 4 (+ 2 2)))
  (is (= (int (find_diff_tail 100)) 25164150))
  (is (= (int (find_diff_tail 2)) 4)))

