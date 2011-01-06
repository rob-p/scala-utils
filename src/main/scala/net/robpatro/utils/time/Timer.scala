package net.robpatro.utils.time {

  class Timer {
    var _tstart = 0L
    var _telapsed = 0L

    def start = { _tstart = System.currentTimeMillis }
    def stop = { 
      val e = if(_tstart > 0L) { System.currentTimeMillis - _tstart } else { 0L } 
      _telapsed += e
    }
    def reset = { _telapsed = 0L; _tstart = 0L }
    def elapsed = _telapsed
  }

}
