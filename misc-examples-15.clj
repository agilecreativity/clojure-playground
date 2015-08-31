(ns clojure-playground)

(prn (#(filter string? %) ["a" 5 "b" 6]))
;; => ("a" "b")

(prn (#(filter % ["a" 5 "b" 6]) string?))
;; => ("a" "b")

(prn (#(filter % ["a" 5 "b" 6]) number?))
;; => (5 6)

(prn (#(map * %1 %2 %3) [1 2 3] [4 5 6] [7 8 9]))
;; => (28 80 162)

(defn negated-sum-str
  [& numbers]
  (str (- (apply + numbers))))

(prn (negated-sum-str 10 12 3.4))
;; => "-25.4"

(def negated-sum-str (comp str - +))
(prn (negated-sum-str 10 12 3.4))
;; => "-25.4"

(require '[clojure.string :as str])
(def camel->keyword (comp keyword
                          str/join
                          (partial interpose \-)
                          (partial map str/lower-case)
                          #(str/split % #"(?<=[a-z])(?=[A-Z])")))

(prn (camel->keyword "CamelCase"))
;; => :camel-case

(prn (camel->keyword "lowerCamelCase"))
;; => :lower-camel-case

(def camel-pairs->map (comp (partial apply hash-map)
                            (partial map-indexed (fn [i x]
                                                   (if (odd? i)
                                                     x
                                                     (camel->keyword x))))))
(prn (camel-pairs->map ["CamelCase" 5 "lowerCamelCase" 3]))
;; => {:camel-case 5, :lower-camel-case 3}
