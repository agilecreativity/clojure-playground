(ns clojure-playground)
(def hello (println (fn [] "Hello")))

;; ---------------------------- ;;
;; anonymous function
(println (#(str "one - Hello")))

;; ---------------------------- ;;
(defn hello [] (println "two - Hello"))
(hello)

;; ---------------------------- ;;
(defn hello [name] (println (str "three - Hello, " name)))
(hello "Steve")

;; ---------------------------- ;;
(defn hello [name title] (str "Hello, " title " " name))
(println (hello "Frances", "Admiral"))

;; ---------------------------- ;;
;; take the optional string to make the function clear
(defn hello
  "Greets a person named <name> with thier <title>"
  [name title] (str "Hello, " title " " name))

;; ---------------------------- ;;
(println (hello "Frances", "Master"))
(require '[clojure.repl :refer [doc]])
(doc hello)

;; ---------------------------- ;;
;; variadic argument function
(defn hello [& args]
  (str "Hello, " (apply str args)))

(println (hello "Fred" "John" "Jane"))

;; ---------------------------- ;;
(defn hello
  ([] "Hello, world")
  ([name] (str "Hello, " name)))

(println (hello))
(println (hello "John Jarvis"))

;; ---------------------------- ;;
;; recursive define function
(defn hello
  ([] (hello "World"))
  ([name] (str "Hello, " name)))

(println (hello))
(println (hello "Paul"))

;; ---------------------------- ;;
(defn hello [config]
  (str "Hello, " (:name config)))

(println (hello {:name "Joe"}))

;; ---------------------------- ;;
(defn hello [{name :name}]
  (str "Hello, " name))

(println (hello {:name "John Smith"}))

;; ---------------------------- ;;
(defn hello [[ name title ]]
  (str "Hello, " title " " name))

(println (hello ["Lucy" "Admiral"]))
