(ns clojure-playground)

(defn prime?
  [n]
  (cond
    (== 1 n) false
    (== 2 n) true
    (even? n) false
    :else (->> (range 3 (inc (Math/sqrt n)) 2)
               (filter #(zero? (rem n %)))
               empty?)))

(time (prime? 1125899906842679))
;; => "Elapsed time: 777.828747 msecs"

(let [m-prime? (memoize prime?)]
  (time (m-prime? 1125899906842679))
  (time (m-prime? 1125899906842679)))
;; =>
;; "Elapsed time: 665.174795 msecs"
;; "Elapsed time: 0.054086 msecs"
