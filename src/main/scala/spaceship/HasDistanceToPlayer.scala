package spaceship

trait HasDistanceToPlayer {
  def position: Vec2

  def distanceToPlayer: Double =
    position.distance(Universe.spaceship.position)
}
