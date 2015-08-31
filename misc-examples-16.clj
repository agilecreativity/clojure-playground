(ns clojure-playground)

(defn adder
  [n]
  (fn [x] (+ n x)))

(prn ((adder 5) 18))
;; => 23


(defn doubler
  [f]
  (fn [& args]
    (* 2 (apply f args))))

(def double-+ (doubler +))
(prn (double-+ 1 2 3))
;; => 12

(defn print-logger
  [writer]
  #(binding [*out* writer]
     (println %)))

(def *out*-logger (print-logger *out*))

(*out*-logger "hello")
;; => hello

(def writer (java.io.StringWriter.))
(def retained-logger (print-logger writer))

(prn (retained-logger "hello"))
;; => nil

(prn (str writer))
;; => "hello\n"

(require 'clojure.java.io)
(defn file-logger
  [file]
  #(with-open [f (clojure.java.io/writer file :append true)]
     ((print-logger f) %)))

(def log->file (file-logger "messages.log"))
(log->file "hello")
;; => cat message.log
;; hello

(defn multi-logger
  [& logger-fns]
  #(doseq [f logger-fns]
     (f %)))

(def log (multi-logger
           (print-logger *out*)
           (file-logger "messages.log")))

(prn (log "hello again"))
;; cat messages.log =>
;; hello
;; hello again

(defn timestamped-logger [logger]
  #(logger (format "[%1$tY-%1$tm-%1$te %1$tH:%1$tM:%1$tS] %2$s" (java.util.Date.) %)))

(def log-timestamped (timestamped-logger (multi-logger
                                           (print-logger *out*)
                                           (file-logger "messages.log"))))
(log-timestamped "goodbye, now")
;; => [2015-08-31 08:58:03] goodbye, now
;; [2015-08-31 09:00:11] goodbye, now
