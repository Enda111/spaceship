package spaceship

trait SphericalBody extends HasGravity {
  def density: Double
  def radius: Double

  override def mass: Double = 4 / 3 * Math.PI * Math.pow(radius, 3) * density
}
