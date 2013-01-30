# Web Audio API project using Clojure and Clojurescript

Because doing it in Javascript would be too easy... but no, seriously. I want Clojure Overtone integrating with the browser to do musical hackery, I don't know what shape, form that will take. Clojurescript is just another piece of the puzzle.


## How to run?

* Install Leiningen 2.0 from https://github.com/technomancy/leiningen

* run in different shells

    # Runs the embedded Jetty/Ring server
    lein run
    
    # Updates the Clojurescript file(s) as needed
    lein cljsbuild auto 
    
    # Gives you a shell to the browser (bREPL)
    lein trampoline cljsbuild repl-listen


Now in the third shell you can run commands as you want.. it will be executed on the browser.
