package spaceship

class Bullet(
    var position: Vec2,
    var velocity: Vec2
) extends GameObject
    with HasGravity {
  override def mass: Double = 50

  override def draw(game: Game): Unit = {
    import game._
    strokeWeight(1.5)
    stroke(225, 195, 30)
    noFill()
    ellipse(position.x, position.y, 5, 5)
  }

  override def update(game: Game): Unit = {
    velocity = velocity + Gravity.acceleration(this)
    position = position + velocity
  }

  def dead: Boolean = {
    false
  }
}
