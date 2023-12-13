(ns task25.fib_seq)

(defn generate_inf_seq [f1 f2]
  (lazy-seq
   (cons f1
         (generate_inf_seq (+ f1 f2) f1))))
