(ns clojure-playground)
(prn (rand))
;; => 0.07708221076205368

;; Emulating a six-sided die
(defn roll-d6 []
  (inc (rand-int 6)))

(prn (roll-d6))

(prn (roll-d6))

(prn (rand-nth [1 2 3]))

(prn (rand-nth '(:a :b :c)))

(prn (shuffle [1 2 3 4 5 6]))
