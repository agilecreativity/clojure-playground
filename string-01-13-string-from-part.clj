(ns clojure-playground)

(println (str "John" " " "Doe"))

(def first-name "John")
(def last-name "Doe")
(def age 42)

(println (str last-name ", " first-name " - age: " age))

(println (apply str "ROT13: " [\w \h \y \v \h \f \ \P \n \r \f \n \e]))

(def lines ["#!/ bin/bash\n", "du -a ./ | sort -n -r\n"])
(println (apply str lines))

;; the following string
(apply str ["a" "b" "c"])

;; is the same as
(str "a" "b" "c")
