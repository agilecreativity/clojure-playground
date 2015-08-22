(ns clojure-playground)
(def animals [:mouse :duck :dodo :lory :eaglet])
(println (#(str %) :mouse))

(println (map #(str %) animals))
(class (map #(str %) animals))
