(ns clojure-playground)

(defn label-key-val
  [[key val]]
  (str "key: " key ", val: " val))

(prn (map label-key-val {:name "Edward"
                         :lastname "Smith"}))
;; => ("key: :name, val: Edward" "key: :lastname, val: Smith")

(prn (map (fn [[key val]]
            [key (inc val)])
          {:max 30 :min 10}))
;; => ([:max 31] [:min 11])
