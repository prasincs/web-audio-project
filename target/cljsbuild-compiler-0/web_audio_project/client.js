goog.provide('hello_clojurescript');
goog.require('cljs.core');
goog.require('clojure.browser.repl');
clojure.browser.repl.connect.call(null,"http://localhost:9000/repl");
hello_clojurescript.get_audio_context = (function get_audio_context(){
try{return (new webkitAudioContext());
}catch (e8221){if(cljs.core.instance_QMARK_.call(null,Error,e8221))
{var e = e8221;
return alert("Web Audio API is not supported in this browser!");
} else
{if("\uFDD0'else")
{throw e8221;
} else
{return null;
}
}
}});
hello_clojurescript.process_buffers = (function process_buffers(buf_list,context){
var source = context.createBufferSource();
source.buffer = cljs.core._lookup.call(null,buf_list,0,null);
var G__8224 = source;
G__8224.connect(context.destination);
G__8224.noteOn(0);
return G__8224;
});
/**
* @param {...*} var_args
*/
hello_clojurescript.play_sound = (function() { 
var play_sound__delegate = function (urls){
var context = hello_clojurescript.get_audio_context.call(null);
var buffer_loader = (new BufferLoader(context,cljs.core.clj__GT_js.call(null,urls),(function (p1__8222_SHARP_){
return hello_clojurescript.process_buffers.call(null,p1__8222_SHARP_,context);
})));
return buffer_loader.load();
};
var play_sound = function (var_args){
var urls = null;
if (goog.isDef(var_args)) {
  urls = cljs.core.array_seq(Array.prototype.slice.call(arguments, 0),0);
} 
return play_sound__delegate.call(this, urls);
};
play_sound.cljs$lang$maxFixedArity = 0;
play_sound.cljs$lang$applyTo = (function (arglist__8225){
var urls = cljs.core.seq(arglist__8225);;
return play_sound__delegate(urls);
});
play_sound.cljs$lang$arity$variadic = play_sound__delegate;
return play_sound;
})()
;
hello_clojurescript.play_sound.call(null,"wav/ominous.wav");
