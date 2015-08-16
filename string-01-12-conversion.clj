(ns clojure-playground)

;; string to symbol
(println (symbol "valid?"))
;; -> valid?

;; symbol to a string
(println (str 'valid?))
;; -> "valid?"

;; if you like leading colon
(println (name :trimph))
;; -> "triumph"

;; or to include the leading colon
(println (str :trimph))
;; -> ":triumph"

;; symbol to string
(println (keyword "fantastic"))
;; -> :fantastic

(println (keyword 'fantastic))
;; -> :fantastic

(println (symbol (name :wonderful)))
;; -> wonderful

;; if you want only the name part of a keyword
(println (name :user/valid?))
;; -> "valid?"

;; if you want the namespace
(println (namespace :user/valid?))
;; -> "user"

(println (str :user/valid?))
;; -> ":user/valid?"

(println (keyword 'produce/onions))
;; -> :produce/onions

(println (symbol (.substring (str :produce/onions) 1)))
;; -> "produce/onions"

(def shopping-area "bakery")
(println (keyword shopping-area "bagels"))
;; -> :bakery/bagels

(println (symbol shopping-area "cakes"))
;; -< bakery/cake
