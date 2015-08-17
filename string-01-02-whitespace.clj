(ns closure-playground)

(println (clojure.string/trim " \tSome boring text.\n"))

;; Collapse whitespace into a single space
(println (clojure.string/replace "Who\t\nput
                                 all this\fwhitespace here?"
                        #"\s+" " "))

;; Replace Window-style line endings with Unix style new lines.
(println (clojure.string/replace "Line 1\r\nLine 2" "\r\n" "\n"))

(require '[clojure.string :as str])
(println (str/replace "Look Ma, no hands" "hands" "longnamespace prefix"))
