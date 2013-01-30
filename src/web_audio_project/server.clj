(ns web-audio-project.server
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :as resources]
            [ring.util.response :as response]
            )
  (:gen-class))


(defn render-app []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body
   (str "<!DOCTYPE html>"
        "<html>"
        "<head>"
        "<link rel=\"stylesheet\" href=\"css/page.css\" />"
        "</head>"
        "<body>"
        "<div>"
        "<button id=\"play\" >Play/Graph</button>"
        "<canvas id=\"fftbox\"> </canvas>"
        "<canvas id=\"wavebox\"> </canvas>"
        "</div>"
        "<script src=\"js/buffer-loader.js\"></script>"
        "<script src=\"js/spectrum.js\"></script>"
        "<script src=\"js/cljs.js\"></script>"
        "</body>"
        "</html>")})

(defn handler [request]
      (render-app))

(def app 
  (-> handler
    (resources/wrap-resource "public")))



(defn -main [& args]
  (jetty/run-jetty app {:port 3000}))

