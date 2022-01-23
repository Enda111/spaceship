package spaceship

class Bullet(
    var x: Double,
    var y: Double,
    var dx: Double,
    var dy: Double
) {

  def draw(game: Game): Unit = {}

  def update(game: Game): Unit = {}

  def dead: Boolean = {
    false
  }
}
