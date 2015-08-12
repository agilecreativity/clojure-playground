(ns clojure-playground)

(def x (list 1 2 3))
(def v [1 2 3])

(println (cons 0 x)) ;;=> (0 1 2 3)

;; Note x is still the original valueis
(println x) ;; => (1 2 3)

(println (first v)) ;;=> 1
(println (last v))  ;;=> 3
(println (nth v 1)) ;;=> 2

(println (cons 0 v)) ;;=> (0 1 2 3)
(println (conj x 0)) ;;=> (0 1 2 3)
(println (conj v 0)) ;;=> [1 2 3 0]

(println (concat x v))        ;;=> (1 2 3 1 2 3)
(println (type (concat x v))) ;;=> clojure.lang.LazySeq

;; Mapype
(def m {:a 1 :b 2})
(println (type m))                    ;; => clojure.lang.PersistentArrayMap
(println (array-map :a 1 :b 2))       ;; => { :a 1, :b 2 }
(println (type (hash-map :a 1 :b 2))) ;; => clojure.lang.PersistenHashMap

(println (assoc {:a 1} :b 2)) ;;=> {:a 1 :b 2}
(println (assoc-in {:settings {:a 1 :b 2}} [:settings :a] "a"))
