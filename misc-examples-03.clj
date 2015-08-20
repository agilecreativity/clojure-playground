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

;; maps examples
(pprint {:jam1 "strawberry" :jam2 "blackberry"})
;; => {:jam1 "strawberry" :jam2 "blackberry"}

(pprint (get {:jam1 "strawberry" :jam2 "blackberry"} :jam2))
;; => "blackberry"

(pprint (get {:jam1 "strawberry" :jam2 "blackberry"} :jam3 "not found"))
;; => "not found"

;; getting using the key as the function
(pprint (:jam2 {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmarlade"}))
;; => "blackberry"

;; the keys function
(pprint (keys {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmarlade"}))
;; => (:jam1 :jam2 :jam3)

;; the vals function
(pprint (vals {:jam1 "strawberry" :jam2 "blackberry" :jam3 "marmarlade"}))
;; => ("strawberry" "blackberry" "marmarlade")

(pprint (assoc {:jam1 "strawberry" :jam2 "blackberry"} :jam1 "orange"))
;; => {:jam1 "orange", :jam2 "blackberry"}

(pprint (dissoc {:jam1 "strawberry" :jam2 "blackberry"} :jam1))
;; => {:jam2 "blackberry"}

(pprint (merge {:jam1 "red" :jam2 "black"}
               {:jam1 "orange" :jam3 "red"}
               {:jam4 "blue"}))
;; => {:jam1 "orange", :jam2 "black", :jam3 "red", :jam4 "blue"}

;; set examples
(pprint #{:red :blue :white :pink})
;; => #{:white :red :blue :pink}

;; No duplicates allowed in the set at creation
;;(pprint #{:red :blue :white :pink :pink})
;; => java.lang.IllegalArgumentException: Duplicate key: pink

(use 'clojure.set)
(pprint (clojure.set/union #{:r :b :w} #{:w :p :y}))
;; => #{:y :r :w :b :p}

(pprint (clojure.set/difference #{:r :b :w} #{:w :p :y}))
;; => #{:r :b}

(pprint (clojure.set/intersection #{:r :b :w} #{:w :p :y}))
;; => #{:w}

;; convert other type of collection to set
(pprint (set [:rabbit :rabbit :watch :door]))
;; => #{:door :watch :rabbit}

(pprint (set {:a 1 :b 2 :c 3}))
;; => #{[:c 3] [:b 2] [:a 1]}

(pprint (get #{:rabbit :door :watch} :rabbit))
;; => :rabbit

(pprint (get #{:rabbit :door :watch} :jar))
;; => nil

;; access directly using the keyword
(pprint (:rabbit #{:rabbit :door :watch}))
;; => :rabbit

;; if it is not in the set
(pprint (:dummy #{:rabbit :door :watch}))
;; => nil

;; Or use set itself to be used as a function
(pprint (#{:rabbit :door :watch} :rabbit))
;; => :rabbit

;; Some useful funtions
(pprint (contains? #{:rabbit :door :watch} :rabbit))
;; => true

(pprint (contains? #{:rabbit :door :watch} :jam))
;; => false

;; Add elements onto a set
(pprint (conj #{:rabbit :door} :jam))
;; => #{:door :rabbit :jam}

;; Remove element from set
(pprint (disj #{:rabbit :door} :door))
;; => #{:jams}
