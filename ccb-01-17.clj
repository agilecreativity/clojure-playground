(ns clojure-playground)

(defn fuzzy= [tolerance x y]
  (let [diff (Math/abs (- x y))]
    (< diff tolerance)))

(println (fuzzy= 0.01 10 10.000000001))
;; -> true

(println (fuzzy= 0.01 10 10.1))
;; -> false

(println (- 0.22 0.23))
;; -> -0.010000000000000009

(def equal-within-ten? (partial fuzzy= 10))

(println (equal-within-ten? 100 109))
;; -> true

(println (equal-within-ten? 100 110))
;; -> false

(defn fuzzy-comparator [tolerance]
  (fn [x y]
    (if (fuzzy= tolerance x y)
    0
    (compare x y))))

(println (sort (fuzzy-comparator 10) [100 11 150 10 9]))
;; -> (11 10 9 100 150)
