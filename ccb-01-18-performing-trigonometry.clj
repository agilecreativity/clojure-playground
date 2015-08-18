(ns clojure-playground)

;; Calculating sin(a + b). The formula for this is
;; sin(a + b) = sin a * cos b + sin b cose a

(defn sin-plus [a b]
  (+ (* (Math/sin a) (Math/cos b))
     (* (Math/sin b) (Math/cos a))))

(println (sin-plus 0.1 0.3))
;; -> 0.38941834230865047
