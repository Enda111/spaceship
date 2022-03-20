package spaceship

import scala.util.Random

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

  var respawn = 50

  def updateBlackholes(): Unit = {
    killDistantBlackholes()
    spawnBlackholes()
    mergeBlackholes()
  }

  def killAllBlackholes(): Unit = {
    blackholes = blackholes
  }
  def killDistantBlackholes(): Unit = {
    blackholes =
      blackholes.filterNot(blackhole => blackhole.distanceToPlayer > 2500.0)
  }

  def spawnBlackholes(): Unit = {
    if (blackholes.length < 10) {
      if (respawn > 0) {
        respawn = respawn - 1
      } else {
        respawn = Constants.maxBlackHoles
        val rad = Random.nextInt(30) + 20
        val vel = spaceship.velocity
        val randangle = Random.between(0.0, Math.PI * 2)
        val radius = 600.0
        val pos = (Vec2(
          Math.cos(randangle),
          Math.sin(randangle)
        ) * radius) + spaceship.position
        blackholes = new Blackhole(pos, vel, rad) :: blackholes
      }
    }
  }

  def mergeBlackholes(): Unit = {
    blackholes
      .combinations(2)
      .find(pair => pair.head.shouldMergeWith(pair(1))) match {
      case Some(List(b1, b2)) =>
        val nb = new Blackhole(
          (b1.position + b2.position) / 2,
          (b1.velocity + b2.velocity) / 2,
          b1.radius + b2.radius
        )
        blackholes = nb :: blackholes.filter(b => (b ne b1) && (b ne b2))

      case _ =>
    }
  }
}
