package spaceship

trait GameObject {
  def draw(game: Game): Unit
  def update(game: Game): Unit
}
