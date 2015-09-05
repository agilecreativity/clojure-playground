(ns clojure-playground)
;; from : The Joy of Clojure 6.3.0
(defn xconj [t v]
  (cond
    (nil? t) {:val v, :L nil, :R nil}
    (< v (:val t)) {:val (:val t),
                    :L (xconj (:L t) v),
                    :R (:R t)}
    :else          {:val (:val t),
                    :L (:L t),
                    :R (xconj (:R t) v)}))

(def tree1 (xconj nil 5))
(prn tree1)
;; => {:val 5, :L nil, :R nil}

(def tree1 (xconj tree1 3))
(prn tree1)
;; => {:val 5, :L {:val 3, :L nil, :R nil}, :R nil}

(def tree1 (xconj tree1 2))
(prn tree1)
;; => {:val 5, :L {:val 3, :L {:val 2, :L nil, :R nil}, :R nil}, :R nil}

(defn xseq [t]
  (when t
    (concat (xseq (:L t)) [(:val t)] (xseq (:R t)))))
(prn (xseq tree1))
;; => 2 3 5)

(def tree2 (xconj tree1 7))
(prn (xseq tree2))
;; => (7 2 3 5)

(prn (identical? (:L tree1) (:L tree2)))
;; => true
