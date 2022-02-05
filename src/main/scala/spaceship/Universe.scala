package spaceship

object Universe {

  var game: Game = _

  val spaceship = new Spaceship

  var blackholes = List(
    new Blackhole(Vec2(500, 500), Vec2(-2, 0), 50),
    new Blackhole(Vec2(500, 50), Vec2.Zero, 30)
  )

  var asteroids: List[Asteroid] = List(
    new Asteroid(Vec2(100, 100), Vec2.Zero, 30.0)
  )

  var bullets: List[Bullet] = Nil

  def allThings: List[GameObject] =
    spaceship :: blackholes ::: asteroids ::: bullets

  def gravitationalBodies: List[HasGravity] =
    allThings.collect { case hasGravity: HasGravity =>
      hasGravity
    }
}
