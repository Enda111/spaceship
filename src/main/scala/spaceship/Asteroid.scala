package spaceship

class Asteroid(
    var position: Vec2,
    var velocity: Vec2,
    var mass: Double
) extends GameObject
    with SphericalBody
    with HasDistanceToPlayer {
  val density = 0.00001

  override def draw(game: Game): Unit = {
    import game._
    strokeWeight(1.0)
    stroke(240.0)
    noFill()
    val r = radius
    ellipse(position.x, position.y, r * 2, r * 2)
  }

  override def update(game: Game): Unit = {
    velocity = velocity + Gravity.acceleration(this)
    position = position + velocity

  }
}
