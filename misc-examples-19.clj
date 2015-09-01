(ns clojure-playground)

(def who-atom (atom :caterpillar))
(prn @who-atom)
;; => :caterpillar

(prn (reset! who-atom :chrysalis))
;; => :chrysalis

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(prn (swap! who-atom change))
;; => :butterfly
