;; The simple input
(def full-name ["Maria", "Linda", "Fulano"])

;; without destructuring
(let [given (first full-name)
      others (rest full-name)]
  (println "Without destructuring:")
  (println "Given name :" given)
  (println "Others info:" others))

;; with destructuring
(let [[given & others] full-name]
  (println "With destructuring:")
  (println "Given name :" given)
  (println "Others info:" others))

;; Output:
;; Without destructuring:
;; Given name : Maria
;; Others info: (Linda Fulano)
;; With destructuring:
;; Given name : Maria
;; Others info: (Linda Fulano)
