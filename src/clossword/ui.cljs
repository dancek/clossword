(ns clossword.ui
  (:require [reagent.dom :as dom]
            ["react-crossword" :default Crossword]
            [clossword.demo :refer [demo-raw demo-simple]]
            [clossword.guardian :refer [guardian-crossword]]))

(defn init
  []
  (dom/render
   [:div
    [guardian-crossword :demo demo-simple]]
   (js/document.getElementById "app")))

(init)
