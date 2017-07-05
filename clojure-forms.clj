; Some forms/expressions in clojure
; All these thing are valid forms, but they don't do anything
1
"a string"
["a" "vector" "of" "strings"]
; This is some example of expressions
(+ 1 2 3)
(str "It was the panda "
     "in the library " "with a dust buster")
; Clojure's control flow
; IF
;(if boolean-form
;  then-form
;  optional-else-form)
(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Odin Elbow!")

; DO
(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

; WHEN
(when true
  (println "Success!")
  "abra cadabra!")

; NIL
(nil? 1)

(nil? nil)

(if "bears eat beets"
  "bears beets Battlestar Galactica")


(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

; =

(= 1 1)

(= nil nil)

(= 2 1)

; OR

(or false
    nil
    :large_I_mean_venti
    :why_cant_I_just_say_large)

(or (= 0 1) (= "yes" "no"))

(or nil)

; AND

(and :free_wifi :hot_coffee)

(and :feelin_super_cool nil false)

; DEF

(def failed-protagonist-names
  ["Larry Potter"
   "Doreen the Explorer"
   "The Incredible Bulk"])

failed-protagonist-names

; Trying to "assign" a value to "variable"
; (def severity :mild)
; (def error-message "OH GOD! IT'S A DISASTER! WE'RE ")
; (if (= severity :mild)
;   (def error-message ( str error-message "MILDLY INCONVENIENCED!"))
;   (def error-message (str error-message "DOOOOOOOMED!")))

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOOOMED!")))

(error-message :mild)

; Numbers
93
1.2
1/5
; Strings
"Lord Voldemort"
"\"Great cow of Moscow!\" - Hermes Conrad"

(def name "Chewbacca")
(str "\"Uggllglglglglglglglglglll\" - " name)

; MAPS
{}
{:first-name "Charlie"
 :last-name "McFishwich"}

{"string-key" +}

{:name {:first "John" :midle "Jacob"
        :last "Jingleheimerschmidt"}}

(hash-map :a 3 :b 2 :c 1)

(get {:a 0 :b 2 :c 4} :b)

(get {:a 0 :b {:c "ho hum"}} :b)

(get {:a 1 :b 2} :c)

(get {:a 1 :b 2} :c "unicorns?")

(get-in {:a :b {:c "ho hum"}} [:b :c])

({:name "the human Coffeepot"} :name)

; KEYWORDS
:a
:rumplestiltsken
:34
:_?

(:a {:a 1 :b 2 :c 3})
; This is equivalent to
(get {:a 2 :b 2 :c 3} :a)
;also with default value
(:d {:a 1 :b 2 :c 3} "No gnome knows homes likes Noah")

; VECTORS

[1 2 3]

(get [3 2 1] 0)

(get ["a" {:name "Pugsley Winterbottom"} "c"] 1

(vector "creepy" "full" "moon")

(conj [1 2 3] 4)




