(ns clojure-playground)

;; Modeling a subset of Unix filesystem flags in asingle integer
(def fs-flags [:owner-read :owner-write
               :group-read :group-write
               :global-read :global-write])

;; Fold flags into a map of flag -> bit
(def bitmap (zipmap fs-flags
                    (map (partial bit-shift-left 1) (range))))
;; -> {:owner-read 1, :owner-write 2, :group-read 4, ...}

(defn permissions-int [& flags]
  (reduce bit-or 0 (map bitmap flags)))

(def owner-only (permissions-int :owner-read :owner-write))
(println (Integer/toBinaryString owner-only))
;; -> "11"

(def read-only (permissions-int :owner-read :group-read :global-read))
(println (Integer/toBinaryString read-only))
;; -> "10101"

(defn able-to? [permissions flag]
  (not= 0 (bit-and permissions (bitmap flag))))
(println (able-to? read-only :global-read))
;; -> true

(println (able-to? read-only :global-write))
;; -> false
