(ns clojure-playground)
;; split string into parts
(println (clojure.string/split "HEADER1,HEADER2,HEADER3", #","))
(println (clojure.string/split "Spaces Newlines\n\n", #"\s+"))
(println (clojure.string/split "field1 field2 field3  " #"\s+"))
(println (clojure.string/split "sam,semanta,john," #",", -1))

(def data-limiters #"[ :-]")
(def sample-input "2015-08-17 14:39")

(println "Sample input:" sample-input)

;; no limit split on any delimiter
(println "No limit  :" (clojure.string/split sample-input data-limiters))

(println "Limit of 1  :" (clojure.string/split sample-input data-limiters 1))

(println "Limit of 2  :" (clojure.string/split sample-input data-limiters 2))

(println "Limit of 100:" (clojure.string/split sample-input data-limiters 100))
