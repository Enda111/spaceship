package spaceship

class Asteroid(
    var position: Vec2,
    var velocity: Vec2,
    var radius: Double
) extends GameObject
    with SphericalBody
    with HasDistanceToPlayer {
  val density = 0.00001

  override def draw(game: Game): Unit = {
    import game._
    strokeWeight(1.0)
    stroke(240.0)
    noFill()
    ellipse(position.x, position.y, radius, radius)
  }

  override def update(game: Game): Unit = {
    velocity = velocity + Gravity.acceleration(this)
    position = position + velocity

  }
}
