(ns clojure-playground)

(def counter (atom 0))

(defn inc-print [val]
  (println val)
  (inc val))

(prn (swap! counter inc-print))
;; =>
;; 0
;; 1
