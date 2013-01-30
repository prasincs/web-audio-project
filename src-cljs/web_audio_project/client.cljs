(ns hello-clojurescript
  (:require [clojure.browser.repl :as repl]))

(repl/connect "http://localhost:9000/repl")

(defn get-audio-context []
  (try
    (js/webkitAudioContext.)
    (catch js/Error e 
      (js/alert 
        "Web Audio API is not supported in this browser!"))))

(defn process-buffers [buf-list context]
  (let [source (.createBufferSource  context)]
    (set! (.-buffer source) (get buf-list 0))
    (doto source
      (.connect (.-destination context))
      (.noteOn 0))))

(defn play-sound [& urls]
  (let [context (get-audio-context)
        buffer-loader (js/BufferLoader. 
                        context (clj->js urls) 
                        #(process-buffers % context) )]
    (.load buffer-loader)))

(play-sound "wav/ominous.wav")
