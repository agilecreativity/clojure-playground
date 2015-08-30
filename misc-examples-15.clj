(ns clojure-playground)

(prn (#(filter string? %) ["a" 5 "b" 6]))
;; => ("a" "b")

(prn (#(filter % ["a" 5 "b" 6]) string?))
;; => ("a" "b")

(prn (#(filter % ["a" 5 "b" 6]) number?))
;; => (5 6)

(prn (#(map * %1 %2 %3) [1 2 3] [4 5 6] [7 8 9]))
;; => (28 80 162)

(defn negated-sum-str
  [& numbers]
  (str (- (apply + numbers))))

(prn (negated-sum-str 10 12 3.4))
;; => "-25.4"
