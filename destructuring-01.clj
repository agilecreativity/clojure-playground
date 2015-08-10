(def full-name ["Maria", "Linda", "Fulano"])

; without destructuring
(let [given (first full-name)
      middle (second full-name)
      surname (last full-name)]
  (println (str surname ", " given " " middle)))

;; positional destructuring
(let [[given middle surname] full-name]
  (println (str surname ", " given " " middle)))

;; Ignore what we don't use/care with underscore
(let [[given _ surname] full-name]
  (println (str surname " " surname)))

;; Output:
;; Fulano, Maria Linda
;; Fulano, Maria Linda
;; Fulano Fulano
