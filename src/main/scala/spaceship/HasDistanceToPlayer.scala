package spaceship

trait HasDistanceToPlayer {
  def position: Vec2

  def distanceToPlayer: Double =
    (Universe.spaceship.position - position).magnitude
}
