(ns clojure-playground)

;; -------------------------------------------------------- ;;
(defn my-sum [total vals]
  (if (empty? vals)
    total
    (my-sum (+ (first vals) total) (rest vals))))
(println (my-sum 0 [1 2 3 4])) ;;=> 10

;; -------------------------------------------------------- ;;
(defn my-sum
  ([vals] (my-sum 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (my-sum (+ (first vals) total) (rest vals)))))
(println (my-sum [1 2 3 4])) ;; => 10

;; -------------------------------------------------------- ;;
(defn my-sum
  ([vals] (my-sum 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (recur (+ (first vals) total) (rest vals)))))
(println (my-sum [1 2 3 4])) ;; => 10

;; -------------------------------------------------------- ;;
(defn my-sum [vals]
  (loop [total 0 vals vals]
    (if (empty? vals)
      total
      (recur (+ (first vals) total) (rest vals)))))

(println (my-sum [0 1 2 3 4]))

;; -------------------------------------------------------- ;;
(println (reduce (fn [total vals] (+ total vals)) 0 [0 1 2 3 4]))

;; -------------------------------------------------------- ;;
(defn summer [total vals]
  (+ total vals))

(println (reduce summer 0 [1 2 3 4])) ;; => 10

(println (reduce + 0 [1 2 3 4]))      ;; => 10

(println (reduce + [1 2 3 4]))        ;; => 10

(defn filter-even [acc next-val]
  (if (even? next-val)
    (conj acc next-val)
    acc))

(println (reduce filter-even [] [0 1 2 3 4 5 6])) ;;=> [0 2 4 6]

(println (filter even? [0 1 2 3 4 5 6])) ;;=> (0 2 4 6)

(defn map-inc [acc next-val]
  (conj acc (inc next-val)))

(println (reduce map-inc [] [0 1 2 3 4 5 6])) ;;=> [1 2 3 4 5 6 7]

(println (map inc [0 1 2 3 4 5 6])) ;;=> [1 2 3 4 5 6 7]

(defn group-even [acc next-val]
  (let [key (if (even? next-val) :even :odd)]
    (update-in acc [key] #(conj % next-val))))

(println (reduce group-even {} [0 1 2 3 4 5 6]))

;; Or using built-in function
(println (group-by #(if (even? %) :even :odd) [0 1 2 3 4 5 6]))
