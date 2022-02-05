package spaceship

trait HasGravity {
  def mass: Double
  def position: Vec2

  def distance(o: HasGravity): Double = position.distance(o.position)
}
