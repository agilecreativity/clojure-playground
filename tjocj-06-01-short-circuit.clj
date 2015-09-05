(ns clojure-playground)
;; section: 6.3.2

(defn if-chain [x y z]
  (if x
    (if y
      (if z
        (do
          (println "Made it!")
          :all-truthy)))))

(prn (if-chain () 42 true))
;; => "Made it!"
;; => :all-truthy

(prn (if-chain true true false))
;; => nil

(defn and-chain [x y z]
  (and x y z (do (println "Made it!") :all-truthy)))

(prn (and-chain () 42 true))
;; => "Made it!"
;; => :all-truthy

(prn (and-chain true false true))
;; => false

;; 6.3.2: lazy-seq

(defn lz-rec-step [s]
  (lazy-seq
    (if (seq s)
      [(first s) (lz-rec-step (rest s))])))

(prn (lz-rec-step [1 2 3 4]))
;; => (1 (2 (3 (4 ())))))

(prn (class (lz-rec-step [1 2 3 4])))
;; => clojure.lang.LazySeq

(prn (dorun (lz-rec-step (range 200000))))
;; => nil
