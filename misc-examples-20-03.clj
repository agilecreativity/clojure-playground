(ns clojure-playground)

(def counter (atom 0))

(let [n 5]
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc))))
(prn @counter)
;; => 15
