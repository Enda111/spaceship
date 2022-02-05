package spaceship

class Blackhole(
    var position: Vec2,
    var velocity: Vec2,
    var radius: Double
) extends GameObject
    with SphericalBody
    with HasDistanceToPlayer {
  val density: Double = 0.005

  override def draw(game: Game): Unit = {
    import game._
    strokeWeight(1.5)
    stroke(225, 30, 225)
    noFill()
    ellipse(position.x, position.y, radius, radius)
  }

  override def update(game: Game): Unit = {
    velocity = velocity + Gravity.acceleration(this)
    position = position + velocity
  }

  def shouldMergeWith(bh: Blackhole): Boolean =
    distance(bh) <= (radius + bh.radius)
}
