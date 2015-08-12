(ns clojure-playground)

;; simplest version
(defn my-sum [total vals]
  (if (empty? vals)
    total
    (my-sum (+ (first vals) total) (rest vals))))
(println (my-sum 0 [1 2 3 4])) ;;=> 10

;; better, but still not optimized
(defn my-sum
  ([vals] (my-sum 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (my-sum (+ (first vals) total) (rest vals)))))
(println (my-sum [1 2 3 4])) ;; => 10

;; best, with the tail-call optimization (use of `recur`)
(defn my-sum
  ([vals] (my-sum 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (recur (+ (first vals) total) (rest vals)))))
(println (my-sum [1 2 3 4])) ;; => 10
