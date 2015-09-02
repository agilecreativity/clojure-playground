(ns clojure-playground)

(def counter (atom 0))

(defn inc-print [val]
  (println val)
  (inc val))

(let [n 2]
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print))))

;; =>
;; 0
;; 1
;; 2
;; 3
;; 4
;; 5

(prn @counter)
;; => 6
