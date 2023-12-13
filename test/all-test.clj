(ns all-test
  (:require [clojure.test :refer [deftest testing is]]
            [task6.ez-way :refer [find_diff_ez]]
            [task6.inf :refer [find_diff_inf]]
            [task6.map :refer [find_diff_map]]
            [task6.rec :refer [diff_rec]]
            [task6.tail-rec :refer [find_diff_tail]]
            ))

(def n1 2)
(def n2 100)
(def ans1 4)
(def ans2 25164150)

(deftest testings
  (testing "ez_way"
    (is (= ans1 (find_diff_ez n1)))
    (is (= ans2 (find_diff_ez n2))))
  (testing "inf"
    (is (= ans1 (find_diff_inf n1)))
    (is (= ans2 (find_diff_inf n2))))
  (testing "map"
    (is (= ans1 (find_diff_map n1)))
    (is (= ans2 (find_diff_map n2))))
  (testing "rec"
    (is (= ans1 (diff_rec n1)))
    (is (= ans2 (diff_rec n2))))
  (testing "tail_rec"
    (is (= ans1 (find_diff_tail n1)))
    (is (= ans2 (find_diff_tail n2)))) 
)