(ns clojure-playground)

;; Modeling a subset of Unix filesystem flags in asingle integer
(def fs-flags [:owner-read :owner-write
               :group-read :group-write
               :global-read :global-write])

;; Fold flags into a map of flag -> bit
(def bitmap (zipmap fs-flags
                    (map #(.indexOf fs-flags %) fs-flags)))

(def no-permissions 0)
(def owner-read (bit-set no-permissions (:owner-read bitmap)))

(println (Integer/toBinaryString owner-read))
;; -> 1

;; Granting global permissions
(def anything (reduce #(bit-set %1 (bitmap %2)) no-permissions fs-flags))
(println (Integer/toBinaryString anything))
;; -> "111111"
