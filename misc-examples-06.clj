(ns clojure-playground)

(defn odd-sum1 [n]
  ;; Using iteration
  (->> (range (inc n))
              (filter odd?)
              (reduce +)))

(defn odd-sum2 [n]
  ;; Using loop-recur
  (loop [i 1 s 0]
    (if (> i n)
      s
      (recur (+ i 2) (+ s i)))))

;; Let's see how this perform
(println (time (odd-sum1 1000000)))
;; =>
;; "Elapsed time: 91.308864 msecs"
;; 250000000000

(println (time (odd-sum2 1000000)))
;; =>
;; "Elapsed time: 12.154431 msecs"
;; 250000000000
