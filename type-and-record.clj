(ns clojure-playground.core)

(deftype MyPerson [name])
(println (.name (->MyPerson "Burin C")))

(defrecord MyPersonalRecord [name])
(println (:name ->MyPersonalRecord "John Jarvis"))
(println (:name (map->MyPersonalRecord {:name "John Jarvis"})))

(deftype MyRunnable [name]
  Runnable
  (run [this] (println (.name this))))

(.run (MyRunnable. "Francine"))
