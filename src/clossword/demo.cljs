(ns clossword.demo)

(def demo-simple
  {:entries [{:number    1
              :clue      "Toy on a string (2-2)"
              :x         0
              :y         0
              :solution  "YOYO"
              :direction :across}
             {:number    2
              :clue      "Have a rest (3,4)"
              :x         0
              :y         2
              :solution  "LIEDOWN"
              :direction :across}
             {:number    1
              :clue      "Colour (6)"
              :x         0
              :y         0
              :solution  "YELLOW"
              :direction :down}
             {:number    3
              :clue      "Bits and bobs (4,3,4)"
              :x         3
              :y         0
              :solution  "ODDSAND"
              :direction :down}
             {:number    4
              :clue      "See 3 down"
              :x         6
              :y         1
              :solution  "ENDS"
              :direction :down}]})

(def demo-raw
  {:date 1542326400000
   :crosswordType "quick"
   :number 1
   :entries
   [{:humanNumber "1"
     :separatorLocations {}
     :group ["1-across"]
     :number 1
     :clue "Toy on a string (2-2)"
     :id "1-across"
     :length 4
     :position {:x 0, :y 0}
     :solution "YOYO"
     :direction "across"}
    {:humanNumber "2"
     :separatorLocations {"," [3]}
     :group ["2-across"]
     :number 2
     :clue "Have a rest (3,4)"
     :id "2-across"
     :length 7
     :position {:x 0, :y 2}
     :solution "LIEDOWN"
     :direction "across"}
    {:humanNumber "1"
     :separatorLocations {}
     :group ["1-down"]
     :number 1
     :clue "Colour (6)"
     :id "1-down"
     :length 6
     :position {:x 0, :y 0}
     :solution "YELLOW"
     :direction "down"}
    {:humanNumber "3"
     :separatorLocations {}
     :group ["3-down" "4-down"]
     :number 3
     :clue "Bits and bobs (4,3,4)"
     :id "3-down"
     :length 7
     :position {:x 3, :y 0}
     :solution "ODDSAND"
     :direction "down"}
    {:humanNumber "4"
     :separatorLocations {}
     :group ["3-down" "4-down"]
     :number 4
     :clue "See 3 down"
     :id "4-down"
     :length 4
     :position {:x 6, :y 1}
     :solution "ENDS"
     :direction "down"}]
   :name "Simple Crossword 1"
   :dimensions {:cols 13, :rows 13}
   :dateSolutionAvailable 1542326400000
   :id "simple/1"
   :solutionAvailable true})
