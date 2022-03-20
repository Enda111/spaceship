package spaceship

class Bullet(
    var position: Vec2,
    var velocity: Vec2
) extends GameObject {

  override def draw(game: Game): Unit = {
    import game._
    strokeWeight(1.5)
    stroke(225, 195, 30)
    noFill()
    ellipse(position.x, position.y, 5, 5)
  }

  override def update(game: Game): Unit = {
    position = position + velocity
  }

  def dead: Boolean = {
    false
  }
}
