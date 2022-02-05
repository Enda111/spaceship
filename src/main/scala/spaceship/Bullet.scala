package spaceship

class Bullet(
    var position: Vec2,
    var velocity: Vec2
) extends GameObject {

  override def draw(game: Game): Unit = {}

  override def update(game: Game): Unit = {}

  def dead: Boolean = {
    false
  }
}
