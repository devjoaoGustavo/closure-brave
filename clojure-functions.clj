; Calling functions
(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])
; (operator operand1 operand2 operand3 ... operandn)
((or + -) 1 2 3)
((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)
; Not valid calls
; (1 2 3 4)
; ("test" 1 2 3)
; High-order functions can take a function as argument and/or return a function (First-class functions)
(inc 1.1) ;=> 2.1
(map inc [0 1 2 3])

(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2)))
(+ 200 (/ 100 5))
(+ 200 20)

; --
; How functions differ from macros and special forms
; Function Calls, Macro Calls, and Special Forms
; (if boolean-form
;   then-form
;   optional-else-form)
; Defining functions
  ; defn
  ; Function name
  ; A docstring describing the function ( optional )
  ; Parameters listed in brackets
  ; Function body
(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))
(too-enthusiastci "Zelda")

; Different arities
; 0-arity
(defn no-params
  []
  "I take no parameter")
; 1-arity
(defn one-params
  [x]
  (str "I take one parameter: " x))
; 2-arity
(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smoosh them "
       "together to spite you! " x y))

; arity overloading
(defn multi-arity
  ([first-arg second-arg third-arg]
   (str "Three params: " first-arg second-arg third-arg))
  ([first-arg second-arg]
   (str "Two params: " first-arg second-arg))
  ([first-arg]
   (str "The only one param: " first-arg)))

(defn x-chop
  "describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kanye West" "slap")
(x-chop "Kanye West")

(defn weird-arity
  ([]
   (str "Destiny dressed you this morning, my friend, and now Fear is trying"
        " to pull off your pants. If you give up, if you give at your gonna end up naked with Fear just standing"
        " there laughing at your dangling unmentionables! - Tick"))
  ([number]
   (inc number)))
(weird-arity)
(weird-arity 10)

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "José" "Gum" "Shoes" "Kara-te")

; Destructuring
;; Return the first element of a collection
(defn my-first
  [[first-thing]]
  first-thing)

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Ameixa" "Abacate" "Melancia" "Carambola" "Melao" "Kiwi" "Cebola" "Limao"])

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})


(defn another-treasure-locator
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(another-treasure-locator {:lat 28.22 :lng 81.33})


(defn receive-treasure-location
  [{:keys [lat extra] :as treasure-location}]
  (println (str "Latitude: " lat))
  (println (str "Extra " extra))
  (println (str "All hash: " treasure-location)))

(receive-treasure-location {:lat 43.23 :lng 33.21 :extra 0.124})

; Function body
(defn example-of-function
  []
  (+ 1 2 3)
  30
  "joe")
(example-of-function) ;=> "joe"

(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(number-comment 30)

; Anonymous functions
(number-comment 5)
; (fn [params-list]
;   function-body)
(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Magoo"])

((fn [x] (* x 3) 8))

 (def my-special-multiplier (fn [x] (* x 3)))

 (my-special-multiplier 12)

; A more compact way to make a anonymous function
; #(* % 3)
(#(* % 3) 8)

(map #(str "Hi, " %) ["Dart Vader" "Mr. Magoo"])

(#(str %1 " and " %2) "cornbread" "butter beans")

(#(identity %&) 1 "blarg" :yip)

; Returning functions
;; Returned functions are closures
(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 14)
