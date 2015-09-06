;; See:
;; http://www.braveclojure.com/using-emacs-with-clojure/
;; http://jr0cket.co.uk/2015/01/getting-started-with-cider-repl-for-clojure-on-emacs-live.html
(def beans {:red 10
            :blue 3
            :green 1})

(println "Hello World")
;; (reduce + (vals (select-keys beans [:red :green])))

(+ 2 3 4 8)
