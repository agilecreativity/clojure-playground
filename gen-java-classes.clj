(ns clojureplayground)

(gen-class
  :name clojureplayground.MyClass
  :prefix "my-"
  :method [[getName [] String]])

(defn my-getName [this]
  "MyClass's Name")
