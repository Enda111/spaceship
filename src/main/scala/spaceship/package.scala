import scala.language.implicitConversions

package object spaceship {
  implicit def floater(d: Double): Float = d.floatValue
}
