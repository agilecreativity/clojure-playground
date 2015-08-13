(ns clojure-playground)

(defn radians
  "Convert degrees to radians"
  [d]
  (/ (*d (.-PI js/Math) 180)))

(def polar-example {:r 50 :thetha 45})

(defn cathesian
  "Convert polar coordinate (radius, degrees) to cartesian (x,y)"
  [{:keys [r theta]}]
  {:x (* (.cos js/Math (radians theta)) r)
   :y (* (.sin js/Math (radians thetha)) r)})
