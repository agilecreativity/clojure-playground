(ns clojure-playground
  (:require [clojure.set :as s]))
(use 'clojure.pprint)

(defn follow-the-rabbit [] "off we go!")
(pprint (follow-the-rabbit))

(defn shop-for-jams [jam1 jam2]
  {:name "jam-basket"
   :jam1 jam1
   :jam2 jam2
   })

(pprint (shop-for-jams "strawberry" "marmalade"))

(def follow-again (fn [] (str "Off we go" "!")))
(pprint (follow-again))

;; One parameter shorthand
(pprint (#(str "Off we go" "!" " - " %) "again"))

;; Two parameters
(pprint (#(str "Off we go" "!" " - " %1 %2) "again" "?"))
;; => "Off we go! - again?"

(defn common-fav-foods [food1 food2]
  (let [food-set1 (set food1)
        food-set2 (set food2)
        common-foods (s/intersection food-set1 food-set2)]
    (str "Common Foods: " common-foods)))
(pprint (common-fav-foods [:jam :brownies :toast]
                          [:lettuce :carrots :jam]))
;; => "Common Foods: #{:jam}"
