package spaceship

class Blackhole(
    var position: Vec2,
    var velocity: Vec2,
    var mass: Double
) extends GameObject
    with SphericalBody
    with HasDistanceToPlayer {
  val density: Double = 0.005

  override def draw(game: Game): Unit = {
    import game._
    strokeWeight(1.5)
    stroke(225, 30, 225)
    noFill()
    val r = radius
    ellipse(position.x, position.y, r * 2, r * 2)
  }

  override def update(game: Game): Unit = {
    //velocity = velocity + Gravity.acceleration(this)
    //position = position + velocity
  }

  def shouldMergeWith(sb: SphericalBody): Boolean =
    distance(sb) <= (radius + sb.radius)

  def consume(other: Asteroid): Unit = {
    this.mass = this.mass + other.mass
  }
}
