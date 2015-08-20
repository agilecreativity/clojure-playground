(ns clojure-playground)
(use 'clojure.pprint)
(pprint '(1 2 "jam" :bee))

(pprint (first '(:rabbit :pocket-watch :marmalade :door)))
;; => :rabbit

(pprint (first (rest '(:rabbit :pocket-watch :marmalade :door))))
;; => :pocket-watch

(pprint (first (rest (rest '(:rabbit :pocket-watch :marmalade :door)))))
;; => :marmalade

(pprint (first (rest (rest (rest '(:rabbit :pocket-watch :marmalade :door))))))
;; => :door

(pprint (first (rest (rest (rest (rest '(:rabbit :pocket-watch :marmalade :door)))))))
;; => nil

(pprint (cons 5 '()))
;; => (5)

(pprint (cons 5 nil))
;; => (5)

(pprint (cons 4 (cons 5 nil)))
;; => (4 5)

(pprint (list 1 2 3 4 5))
;; => (1 2 3 4 5)

;; == vectors
(pprint [:jar1 1 2 3 :jar2])
;; => [:jar1 1 2 3 :jar2]

(pprint (first [:jar1 1 2 3 :jar2]))
;; => :jar1

(pprint (rest [:jar1 1 2 3 :jar2]))
;; => (1 2 3 :jar2)

(pprint (nth [:jar1 1 2 3 :jar2] 0))
;; => :jar1

(pprint (nth [:jar1 1 2 3 :jar2] 2))
;; => 2

(pprint (last [:jar1 1 2 3 :jar2]))
;; => jar2

(pprint (last '(:jar1 1 2 3 :jar2)))
;; => jar2

(pprint (count [1 2 3 4]))
;; => 4

(pprint (conj [:toast :butter] :jam))
;; => [:toast :butter :jam]

;; multiple elements added on the end of vectors
(pprint (conj [:toast :butter] :jam :honey))
;; => [:toast :butter :jam :honey]

;; conj adds to the front of lists
(pprint (conj '(:toast :butter) :jam))
;; => (:jam :toast :butter)

;; multiple elements added to the front of lists
(pprint (conj '(:toast :butter) :jam :honey))
;; => (:honey :jam :toast :butter)
