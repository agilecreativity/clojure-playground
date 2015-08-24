(ns clojure-playground)
(use 'clojure.pprint)
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

(pprint (map-map inc (sorted-map :z 5 :c 6 :a 0)))
;; => {:a 1, :c 7, :z 6}

(pprint (seq "Clojure"))
;; => (\C \l \o \j \u \r \e)

(pprint (seq {:a 5 :b 6}))
;; => ([:a 5] [:b 6])

(pprint (seq (java.util.ArrayList. (range 5))))
;; => (0 1 2 3 4)

(pprint (seq (into-array ["Clojure" "Programming"])))
;; => "Clojure" "Programming")

(pprint (seq []))
;; => nil

(pprint (map str "Clojure"))
;; => ("C" "l" "o" "j" "u" "r" "e")

(pprint (first "Clojure"))
;; => \C

(pprint (rest "Clojure"))
;; => (\l \o \j \u \r \e)

(pprint (next "Clojure"))
;; => (\l \o \j \u \r \e)

(pprint (rest [1]))
;; => ()

(pprint (next [1]))
;; => nil

(pprint (next nil))
;; => nil

(pprint (rest nil))
;; => ()

(defn same [x]
  (= (next x)
     (seq (rest x))))

(pprint (same [2]))
;; => true

(pprint (same []))
;; => true

(doseq [x (range 3)]
  (pprint x))
;; =>
;; 0
;; 1
;; 2

(let [r (range 3)
      rst (rest r)]
  (prn (map str rst))
  (prn (map #(+ 100 %) r))
  (prn (conj r -1) (conj rst 42)))
;; =>
;; ("1" "2")
;; (100 101 102)
;; (-1 0 1 2) (42 1 2)

(let [s (range 1e6)]
      (time (count s)))
;; => "Elapsed time: 112.753119 msecs"

(let [s (apply list (range 1e6))]
  (time (count s)))
;; => "Elapsed time: 0.016829 msecs"

(prn (cons 0 (range 1 5)))
;; => (0 1 2 3 4)

(prn (cons :a [:b :c :d]))
;; (:a :b :c :d)

(prn (cons 0 (cons 1 (cons 2 (cons 3 (range 4 10))))))
;; => (0 1 2 3 4 5 6 7 8 9)

(prn (list* 0 1 2 3 (range 4 10)))
;; => 0 1 2 3 4 5 6 7 8 9)

;; Lazy seqs
(prn (lazy-seq [1 2 3]))
;; => (1 2 3)

(defn random-ints
  "Returns a lazy seq of random integers in the range [0, limit]."
  [limit]
  (lazy-seq
    (cons (rand-int limit)
          (random-ints limit))))

(prn (take 10 (random-ints 50)))
;; => (32 16 35 36 40 19 45 32 9 45)

(prn (apply str (remove (set "aeiouy")
                        "vowels are useless! or maybe not...")))
;; => "vwls r slss! r mb nt..."

(prn (split-with neg? (range -5 5)))
;; => [(-5 -4 -3 -2 -1) (0 1 2 3 4)]
