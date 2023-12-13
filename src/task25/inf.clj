(ns task25.inf
  (:use [task25.fib_seq]))

(defn get_indexed [n]
  (->> (generate_inf_seq 0 1)
       (map str)
       (map count)
       (map-indexed (fn [idx itm] [idx itm]))
       (filter #(== (second %) n))
       first
       first
       ))

(get_indexed 30)
