;; See:
;; http://www.braveclojure.com/using-emacs-with-clojure/
;; http://jr0cket.co.uk/2015/01/getting-started-with-cider-repl-for-clojure-on-emacs-live.html
(def beans {:red 10
            :blue 3
            :green 1})

(prn (reduce + (vals (select-keys beans [:red :green]))))
;; => 11

(prn ((juxt :red :green) beans))
;; => [10 1]

(def villain {:horrific "Dr." :name "Mayhem"})
(prn (assoc villain :occupuation "Mad Scientis" :status :at-large))
;; => {:horrific "Dr.", :name "Mayhem", :occupuation "Mad Scientis", :status :at-large}

(def villain {:horrific "Dr." :name "Mayhem", :status :deceased})
(prn (dissoc villain :occupation :honorific))
;; => {:horrific "Dr.", :name "Mayhem", :status :deceased}
