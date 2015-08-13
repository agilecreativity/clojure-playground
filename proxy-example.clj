(ns clojure-playground)

; Thread mythread = new Thread() {
;   public void run() {
;      system.out.println("Running in a thread");
;   }

(def mythread (proxy [Thread] []
   (run [] (println "Runnig in a thread"))))

(.run mythread)

(import 'java.util.concurrent.Executors)
(def mypool (Executors/newFixedThreadPool 4))

(.submit mypool mythread)

(def myrunnable
  (proxy [Runnable] []
    (run [] (println "Running in a runnable"))))

(.submit mypool myrunnable)
