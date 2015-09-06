(ns clojure-playground)
(defn simple-range [i limit]
  (lazy-seq
    (when (< i limit)
      (cons i (simple-range (inc i) limit)))))

(prn (simple-range 0 9))
;;=> (0 1 2 3 4 5 6 7 8)

(prn (let [r (range 1e9)]
       (first r)
       (last r)))
;; => 999999999
