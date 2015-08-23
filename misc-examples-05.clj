(ns clojure-playground)
(def animals [:mouse :duck :dodo :lory :eaglet])
(println (#(str %) :mouse))

(println (map #(str %) animals))
(class (map #(str %) animals))

(defn retry? [n]
  (if (<= n 0)
    (cons false (lazy-seq (retry? 0)))
    (cons true  (lazy-seq (retry? (dec n))))))

(println (take 7 (retry? 5)))
;; => true true true true true false false)

(loop [r (retry? 5)]
  (if-not (first r)
    (println "No more retries")
    (do
      (println 'Retrying...)
      (recur (rest r)))))
;; =>
;; Retrying...
;; Retrying...
;; Retrying...
;; Retrying...
;; Retrying...
;; No more retries

(defn count-down [n]
  (if (<= n 0)
    '(0)
    (cons n (lazy-seq (count-down (dec n))))))

(println (count-down 8))
;; => (8 7 6 5 4 3 2 1 0)
