(ns clojure-playground)
(prn (reduce + [1 2 3 4 5]))
;; => 15

(prn (reduce (fn [r x] (+ r (* x x)))[1 2 3]))
;; => 14

(prn (reduce (fn [r x] (if (nil? x) r (conj r x)))
             []
             [:mouse nil :duck nil :lory]
             ))
;; => [:mouse :duck :lory]

(prn ((complement nil?) nil))
;; => false

(prn ((complement nil?) 1))
;; => true

(prn (filter (complement nil?) [:mouse nil :duck nil]))
;; => [:mouse :duck]

(prn (filter keyword? [:mouse nil :duck nil]))
;; => [:mouse :duck]

(prn (for [animal [:mouse :duck :lory]]
       (str (name animal))))
;; => ("mouse" "duck" "lory")

(prn (for [animal [:mouse :duck :lory]
           color  [:red :blue]]
       (str (name color) (name animal))))
;; => ("redmouse" "bluemouse" "redduck" "blueduck" "redlory" "bluelory")

(prn (for [animal [:mouse :duck :lory]
           color [:red :blue]
           :let [animal-str (str "animal-" (name animal))
                 color-str (str "color-" (name color))
                 display-str (str animal-str "-" color-str)]]
       display-str))
;; =>
;; ("animal-mouse-color-red" "animal-mouse-color-blue" "animal-duck-color-red" "animal-duck-color-blue" "animal-lory-color-red" "animal-lory-color-blue")

(prn (for [animal [:mouse :duck :lory]
           color [:red :blue]
           :let [animal-str (str "animal-" (name animal))
                 color-str (str "color-" (name color))
                 display-str (str animal-str "-" color-str)]
           :when (= color :blue)]
       display-str))
;; => ("animal-mouse-color-blue" "animal-duck-color-blue" "animal-lory-color-blue")

(prn (flatten [[:duck [:mouse] [[:lory]]]]))
;; => (:duck :mouse :lory)

(prn (vec '(1 2 3)))
;; => [1 2 3]

(prn (into [] '(1 2 3)))
;; => [1 2 3]

(prn (sorted-map :b 2 :a 1 :z 3))
;; => {:a 1, :b 2, :z 3}

(prn (into (sorted-map) {:b 2 :c 3 :a 1}))
;; => {:a 1, :b 2, :c 3}

(prn (into {} [[:a 1] [:b 2] [:c 3]]))
;; => {:a 1, :b 2, :c 3}
