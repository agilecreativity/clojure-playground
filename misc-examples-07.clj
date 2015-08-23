(ns clojure-playground)
(defn swap-pairs
  [sequential]
  (into (empty sequential)
        (interleave
          (take-nth 2 (drop 1 sequential))
          (take-nth 2 sequential))))

(println (swap-pairs (apply list (range 10))))
;; => (8 9 6 7 4 5 2 3 0 1)

(defn map-map
  [f m]
  (into (empty m)
        (for [[k v] m]
          [k (f v)])))

(println (map-map inc (hash-map :z 5 :c 6 :a 0)))
;; => {:z 6, :c 7, :a 1}

(println (map-map inc (sorted-map :z 5 :c 6 :a 0)))
;; => {:a 1, :c 7, :z 6}
