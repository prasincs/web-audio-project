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
  (let [source (.createBufferSource  context)
        frequency-box (js/SpectrumBox. 2048 30 "fftbox" context)
        frequency-node (.getAudioNode frequency-box)
        wave-box (js/SpectrumBox. 2048 1000 "wavebox" context)
        wave-node (.getAudioNode wave-box)
        ]
    (.setValidPoints frequency-box 500)
    (set! (.-fillStyle (.getCanvasContext frequency-box)) 
      "rgb(150, 150, 150)")

    (set! (.-buffer source) (get buf-list 0))
    (doto source
      (.connect frequency-node)
      (.connect (.-destination context))
      (.noteOn 0))
      (do
        (.connect frequency-node wave-node) 
        (.connect wave-node (.-destination context))
        (.enable wave-box)
        (.enable frequency-box)
      )
))


(defn play-sound [& urls]
  (let [context (get-audio-context)
        buffer-loader (js/BufferLoader. 
                        context (clj->js urls) 
                        #(process-buffers % context) )
              ]
    (.load buffer-loader)))


(let [btn (.getElementById js/document "play")]
    (.addEventListener btn "click" (fn [] 
(play-sound "wav/ominous.wav"))))

