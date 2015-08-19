(ns clojure-playground)

(def portfolio [{:ticker "AAPL", :last-trade 203.25M, :open 204.50M, :shares 100}
  {:ticker "MSFT", :last-trade 29.12M, :open 29.08M, :shares 50}
  {:ticker "ORCL", :last-trade 21.90M, :open 21.83M, :shares 200}])

(println portfolio)
;; => [{:ticker AAPL, :last-trade 203.25M, :open 204.50M, :shares 100} {:ticker MSFT, :last-trade 29.12M, :open 29.08M, :shares 50} {:ticker ORCL, :last-trade 21.90M, :open 21.83M, :shares 200}]

(println (map :open portfolio))
;; => (204.50M 29.08M 21.83M)

(println (apply + (map #(* (:last-trade %) (:shares %)) portfolio)))
;; => 26161.00M

(println (map #(assoc % :delta (- (% :last-trade) (% :open))) portfolio))
;; =>
;; ({:ticker AAPL, :last-trade 203.25M, :open 204.50M, :shares 100, :delta -1.25M}
;; {:ticker MSFT, :last-trade 29.12M, :open 29.08M, :shares 50, :delta 0.04M}
;; {:ticker ORCL, :last-trade 21.90M, :open 21.83M, :shares 200, :delta 0.07M})

;; Note: :open acts as a function
(println (map :open portfolio))
;; => (204.50M 29.08M 21.83M)

(defn last-trade-value
  "Get the last traded value"
  [stock]
  (* (:last-trade stock) (:shares stock)))

(println (map last-trade-value portfolio))
;; => (20325.00M 1456.00M 4380.00M)

;; Laziness is a virtue
(println (take 20 (iterate inc 1)))
;; => (1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20)

(println (take 20 (map * (iterate inc 1) (iterate inc 1))))
;; => (1 4 9 16 25 36 49 64 81 100 121 144 169 196 225 256 289 324 361 400)

;; Note: the nth seqs -> n parameters
(println (map #(assoc %1 :sort-index %2)
              (reverse (sort-by :last-trade portfolio))
              (iterate inc 0)))
;; => ({:ticker AAPL, :last-trade 203.25M, :open 204.50M, :shares 100, :sort-index 0}
;;     {:ticker MSFT, :last-trade 29.12M, :open 29.08M, :shares 50, :sort-index 1}
;;     {:ticker ORCL, :last-trade 21.90M, :open 21.83M, :shares 200, :sort-index 2})

(println (map #(* (% :last-trade) (% :shares)) portfolio))
;; => (20325.00M 1456.00M 4380.00M)

(println (reduce +(map #(* (% :last-trade) (% :shares)) portfolio)))
;; => 2616.00M

(def input-string "Clojure is a fascinating language with unique capabilities and total integration with Java.")
(println (seq input-string))
;; => (C l o j u r e   i s   a   f a s c i n a t i n g   l a n g u a g e   w i t h   u n i q u e   c a p a b i l i t i e s   a n d   t o t a l   i n t e g r a t i o n   w i t h   J a v a .)

(println (reduce
  (fn [m k] (update-in m [k] #(inc (or % 0))))
  {} ;; optional intial value
  (seq input-string)))
;; => {  12, a 12, b 1, C 1, c 2, d 1, e 5, f 1, g 4, h 2, i 11, J 1, j 1, l 4, . 1, n 7, o 3, p 1, q 1, r 2, s 3, t 8, u 4, v 1, w 2}
