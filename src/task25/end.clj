(ns task25.end)

(defn generate_inf_seq [f1 f2]
  (lazy-seq
   (cons f1
         (generate_inf_seq (+ f1 f2) f1))))

(defn get_index [n]
  (let [nums (take 5000 (generate_inf_seq 0 1))]
    (->> nums
         (map #(count (str %)))
         (map-indexed (fn [idx itm] [idx itm]))
         (filter #(== (second %) n))
         first 
         first
         )
  ))

(get_index 1000)