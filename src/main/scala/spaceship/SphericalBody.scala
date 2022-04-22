package spaceship

trait SphericalBody extends HasGravity {
  def density: Double
  def radius: Double = Math.pow(mass / density * 3 / 4 / Math.PI, 1.0 / 3.0)

  // mass = 4/3 pi r^3
  // r^3 = mass * 3  / 4pi
  // r = (...) * 1/3
  // override def mass: Double = 4 / 3 * Math.PI * Math.pow(radius, 3) * density
}
