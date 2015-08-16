(ns clojure-playground)
;; split string into parts

(println (clojure.string/split "HEADER1,HEADER2,HEADER3", #","))

(println (clojure.string/split "Spaces Newlines\n\n", #"\s+"))
