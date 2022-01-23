package spaceship

class Blackhole(
    var x: Double,
    var y: Double,
    var r: Double,
    var dx: Double = 0.0,
    var dy: Double = 0.0
) {
  val density: Double = 0.05
  val mass: Double = Math.PI * Math.pow(r, 2) * density

  def draw(game: Game): Unit = {
    import game._
    noStroke()
    fill(120, 1, 96)
    ellipse(x, y, r, r)

  }

}
