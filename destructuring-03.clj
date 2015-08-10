(def endpoints [[5, 3], [7, 9]])

(let [[[x1 y1] [x2 y2]] endpoints]
  (println "Destructuring list example:")
  (println (list x1 y1 x2 y2))
  )

; Desstructuring maps
(def inventory {:item "pen" :price 3.49 :qty 50})

(let [{item :item price :price qty :qty} inventory]
  (println "Destructuring example 1:")
  (println (list item price qty)))

;; Using the key construct
(let [{:keys [item price qty]} inventory]
  (println "Destructuring example 2:")
  (println (list item price qty)))

;; extract from structure
(let [[a b c :as entire] [1 2 3 4 5]]
  (println "Destructuring example 3:")
  (println (list a b c entire))
  )

(let [{:keys [item price] :as whole-map} inventory]
  (println "Destructuring example 4:")
  (println (list item price whole-map)))

;; Output:
;; Destructuring list example:
;; (5 3 7 9)
;; Destructuring example 1:
;; (pen 3.49 50)
;; Destructuring example 2:
;; (pen 3.49 50)
;; Destructuring example 3:
;; (1 2 3 [1 2 3 4 5])
;; Destructuring example 4:
;; (pen 3.49 {:item pen, :price 3.49, :qty 50})
