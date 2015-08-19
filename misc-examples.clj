(ns clojure-playground)

(defn average [& nums]
  (/ (reduce + nums)
     (count nums)))

;; Function invocation:
(println (average 4 11))
;; => 15/2

(println (average 3.0 72 9.6 33))
;; => 29.4

;; Qouted list of numbers
(println '(1 2 3))

(defn biggest
  "Find the maximum of two numbers"
  [x y]
  (if (> x y) x y))

(println (biggest 5 42))
;; => 42

;; clojure collections : Lists
(def lst '(1 2 3))
(println (first lst))
;; => 1

(println (rest lst))
;; => (2 3)

(println (conj lst 4))
;; => (4 1 2 3)

(println lst)
;; => (1 2 3)

;; Clojure collections : Vectors
(def v [:moe :lary :curly])
(println (first v))
;; => :moe

(println (rest v))
;; => (:lary :curly)

(println (conj v :shemp))
;; => (:moe :lary :curly :shemp)

(println (cons :shemp v))
;; => (:shemp :moe :lary :curly)

;; vector is a function of its indexes
(println (v 1))
;; => :larry

;; Clojure Collections: Maps
(def m {:first-name "John" :last-name "Smith"})

(println (get m :last-name))
;; => "Smith"

;; map is a functon of its keys
(println (m :last-name))
;; => "Smith"

(println (assoc m :company "John Smith & Co"))
;; { :first-name "John" :last-name "Smith" :company "John Smith & Co" }

;; keywords are functions also
(println (:first-name m))
;; => "John"

;; What about invalid key
(println (:dummy m))
;; => nil

;; Coljure Collections:Sets
(def s #{"John", "Jane", "Bob", "Alice"})
(println (contains? s "John"))
;; => true

(println (contains? s "john"))
;; => false

;; Set is a function of its elements
(println (s "John"))
;; => "John"

(println (s "Jack and Jill"))
;; => nil

(println (conj s "John"))
;; => #{Alice John Jane Bob}

(println (conj s "Mike"))
;; => #{Alice John Jane Bob Mike}

;; Functional Clojure Collections
(def names ["fred", "barney" ".hidden" "wilma" "./etc/init.conf"])

(println (filter #(not (.startsWith % ".")) names))
;; => ("fred" "barney" "wilma")

;; Closure Oriented Programming
(require '[clojure.string :as str])
(println (str/split "Clojure is awesome!" #" "))
;; => ["Clojure" "is" "awesome"]
(println (str/split "test.gz" #"\."))
;; => [test gz]

(defn require-extension [ext]
  (fn [file-name]
    (= ext (last (str/split file-name #"\.")))))

;; print item that ends with ".conf"
(println (filter (require-extension "conf") names))
;; => (./etc/init.conf)
