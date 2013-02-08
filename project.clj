(defproject web-audio-project "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring "1.1.6"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild { 
    :builds {
      :main {
        :source-paths ["src-cljs"]
        :compiler
        {
          :output-to "resources/public/js/cljs.js"
          :optimizations :simple
          :pretty-print true
          :externs ["resources/public/js/buffer-loader.js", "resources/public/js/spectrum.js"]
        }
        :jar true
      ;https://github.com/emezeske/lein-cljsbuild/blob/master/example-projects/advanced/project.clj
        ;:repl-listen-port 9000
      }
    }}
  }
  :main web-audio-project.server)

