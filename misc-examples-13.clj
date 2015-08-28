(def about-me "My favorite color is green!")

(prn (clojure.string/replace about-me "green" "red"))
;; => "My favorite color is red!"
