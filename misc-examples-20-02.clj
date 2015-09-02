(ns clojure-playground)

(def counter (atom 0))

(dotimes [_ 5] (swap! counter inc))
(prn @counter)
;; => 5
