package spaceship

case class Vec2(
    x: Double,
    y: Double
) {

  def +(v: Vec2): Vec2 =
    Vec2(x + v.x, y + v.y)

  def -(v: Vec2): Vec2 =
    Vec2(x - v.x, y - v.y)

  def *(d: Double): Vec2 =
    Vec2(x * d, y * d)

  def /(d: Double): Vec2 =
    Vec2(x / d, y / d)

  def magnitude: Double = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))

}
object Vec2 {
  val Zero = Vec2(0, 0)
}
