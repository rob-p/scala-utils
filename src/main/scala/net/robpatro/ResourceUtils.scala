package net.robpatro
import scala.util.continuations._

// class AsResource[A <: {def close():Unit}]( resource: A) {
//   def as[B]( block: A => B ) : B = { 
//     block(resource) 
//   }
// }


object ResourceUtils {

  /** Manages a closeable resource (i.e. a resource with a close() method).
   *
   *
   * Example
   * {{{
   * using( Source.fromFile("filename.txt") ) {
   *   fn => while( fn.hasNext ) { println(fn.next) }
   * }
   * }}}
   * @param res The passed in resource
   * @param block A function wich uses the resource
   */
  def using[A <: {def close():Unit}](res: A)(block: A => Unit) = {
    try{
      block(res)
    } finally {
      res.close()
    }
  }

}
