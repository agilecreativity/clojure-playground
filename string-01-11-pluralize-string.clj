(ns clojure-playground)
;; try
;; lein try inflections

(require '[inflections.cor :as inf])

(println (inf/pluralize 1 "monkey"))
;; -> "1 monkey"

(println (inf/pluralize 12 "monkey"))
;; -> "12 monkeys"

(println (inf/pluralize 1 "box" "boxen"))
;; -> "1 box"

(println (inf/pluralize 3 "box" "boxen"))
;; -> "3 boxen"

;; convert "snake_case" to "CamelCase"
(println (inf/camelize "my_object"))
;; -> "MyObject"

;; Clean strings for usage as URL
(println (inf/parameterize "My most favorite URL"))
;; -> "my-most-favorite-url"

;; Turn number into ordinal numbers
(println (inf/ordinalize 42))
;; -> "42nd"
