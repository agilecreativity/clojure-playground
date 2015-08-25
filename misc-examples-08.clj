(ns clojure-playground)
(def animals
  [:mouse :duck :dodo :lory :eaglet])

(prn (#(str %) :mouse))
;; => ":mouse"

(prn (map #(str %) animals))
;; => (":mouse" ":duck" ":dodo" ":lory" ":eaglet")

(prn (class (map #(str %) animals)))
;; => clojure.lang.LazySeq

(prn (take 3 (map #(str %) (range))))
;; => ("0" "1" "2")

(prn (take 10 (map #(str %) (range))))
;; => ("0" "1" "2" "3" "4" "5" "6" "7" "8" "9")

(prn (def animal-print (map #(println %) animals)))
;; => #'clojure-playground/animal-print

(def animal-print (doall (map #(println %) animals)))
;; =>
;; :mouse
;; :duck
;; :dodo
;; :lory
;; :eaglet

(println animal-print)
;; => (nil nil nil nil nil)
