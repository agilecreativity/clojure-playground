(ns clojure-playground)
;; From - The Joy of Clojure

(prn (if true :truthy :falsey))
;; => :truty

(prn (if [] :truthy :falsey))
;; => :truty

(prn (if nil :truthy :falsey))
;; => :falsey

(prn (if false :truthy :falsey))
;; => :falsey

(defn print-seq [s]
  (when (seq s)
    (prn (first s))
    (recur (rest s))))

(print-seq [])
;; => nil

(print-seq [1 2])
;; => 1
;; => 2

(def guys-whole-name ["Guy" "Lewis" "Steele"])
(prn (str (nth guys-whole-name 2) ", "
     (nth guys-whole-name 0) " "
     (nth guys-whole-name 1)))
;; => "Steele, Guy Lewis"

;; Using destructuring
(prn (let [[f-name m-name l-name] guys-whole-name]
  (str l-name ", " f-name " " m-name)))
;; => "Steele, Guy Lewis"

;; Positional destructuring

(def date-regex #"(\d{1,2})\/(\d{1,2})\/(\d{4})")

(prn (let [rem (re-matcher date-regex "12/02/1975")]
       (when (.find rem)
         (let [[_ m d] rem]
           {:month m :day d}))))
;; => {:month "12", :day "02"}
