(ns clojure-playground)

(def x "Hello Clojure")
(let [x "Steve"]
  (println "Hello, " x))

(println (str x))

(if (empty? x)
  (println "X is empty")
  (println "X is not empty"))

;; the first version
(if (empty? x)
  nil
  (do
    (println "if ok")
      :ok))

;; better version
(if-not (empty? x)
  (do
    (println "if-not ok")
      :ok))

(when-not (empty? x)
  (println "when-not ok")
  :ok)

(when (not (empty? x))
  (println "when then not")
  :ok)

(def x "Hello")

(def y (case x
  "Goodbye" :goodby
  "Hello" :hello
  :nothing))

(print y)

(cond
  (= x "Goodbye") :goodbye
  (= (apply str (reverse x)) "olleH") :olleh
  :otherwise :nothing)
