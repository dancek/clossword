(ns clossword.ui
  (:require [reagent.dom :as dom]
            ["react-crossword" :default Crossword]
            ["./demo.js" :default demo]))

(defn xw-demo []
  [:> Crossword
   {:data demo}])

(defn init
  []
  (dom/render
   [xw-demo]
   (js/document.getElementById "app")))

(init)
