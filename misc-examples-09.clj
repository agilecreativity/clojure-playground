(ns clojure-playground)

(def animals
  ["mouse" "duck" "dodo" "lory" "eaglet"])

(def colors
  ["brown" "black" "blue" "pink" "gold"])

(defn gen-animal-string
  [animal color]
  (str color "-" animal))

(prn (map gen-animal-string animals colors))
;; => ("brown-mouse" "black-duck" "blue-dodo" "pink-lory" "gold-eaglet")

(def colors
  ["brown" "black"])
(prn (map gen-animal-string animals colors))
;; => ("brown-mouse" "black-duck")

;; Use map with infinitelist
(prn (map gen-animal-string animals (cycle ["brown" "black"])))
;; => ("brown-mouse" "black-duck" "brown-dodo" "black-lory" "brown-eaglet")
