(ns clojure-playground)

(defn mean [coll]
  "Find the mean (average) of a collection"
  (let [sum (apply + coll)
        count (count coll)]
    (if (pos? count)
      (/ sum count)
      0)))

(println (mean [1 2 3 4]))
;; -> 5/2

(println (mean [1 1.6 7.4 10]))
;; -> 5.0

(println (mean []))
;; -> 0

(defn median [coll]
  (let [sorted (sort coll)
        cnt (count sorted)
        halfway (int (/ cnt 2))]
    (if (odd? cnt)
      (nth sorted halfway)
      (let [bottom (dec halfway)
            bottom-val (nth sorted bottom)
            top-val (nth sorted halfway)]
        (mean [bottom-val top-val])))))

(println (median [5 2 4 1 3]))
;; -> 3

(println (median [7 0 2 3]))
;; -> 5/2 ; The average of 2 and 3

(defn mode [coll]
  (let [freqs (frequencies coll)
        occurrences (group-by second freqs)
        modes (last (sort occurrences))
        modes (->> modes
                   second
                   (map first))
        ] modes))

(println (mode [:alan :bob :alan :greg]))
;; -> (:alan)

(println (mode [:smith :carpenter :doe :smith :doe]))
;; -> (:smith :doe)

(defn standard-deviation [coll]
  (let [avg (mean coll)
        squares (for [x coll]
                  (let [x-avg (- x avg)]
                    (* x-avg x-avg)))
        total (count coll)]
    (-> (/ (apply + squares)
           (- total 1))
        (Math/sqrt))))

(println (standard-deviation [4 5 2 9 5 7 4 5 4]))
;; -> 2.0

(println (standard-deviation [4 5 5 4 4 2 2 6]))
;; -> 1.4142135623730951
