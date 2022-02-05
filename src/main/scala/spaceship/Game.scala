package spaceship

import processing.core._
import processing.event.KeyEvent

import scala.util.Random

class Game extends PApplet {
  Universe.game = this
  override def settings(): Unit = {
    size(800, 600)
  }

  override def draw(): Unit = {

    noStroke()
    this.fill(15, 15, 15)
    this.rect(0, 0, width, height)

    pushMatrix()
    translate(
      width / 2 - Universe.spaceship.position.x,
      height / 2 - Universe.spaceship.position.y
    )
    Universe.allThings.foreach(gameObject => gameObject.draw(this))
    popMatrix()

    pushMatrix()
    scale(.1)
    translate(
      width - Universe.spaceship.position.x,
      height - Universe.spaceship.position.y
    )
    Universe.allThings.foreach(gameObject => gameObject.draw(this))
    popMatrix()

    Universe.allThings.foreach(gameObject => gameObject.update(this))

    Universe.bullets = Universe.bullets.filterNot(bullet => bullet.dead)

    Universe.blackholes = Universe.blackholes.filterNot(blackhole =>
      blackhole.distanceToPlayer > 1500.0
    )
    if (Universe.blackholes.length < 10) {
      if (respawn > 0) {
        respawn = respawn - 1
      } else {
        respawn = 50
        val rad = Random.nextInt(30) + 20
        val vel = Universe.spaceship.velocity
        val randangle = Random.between(0.0, Math.PI * 2)
        val radius = 600.0
        val pos = (Vec2(
          Math.cos(randangle),
          Math.sin(randangle)
        ) * radius) + Universe.spaceship.position
        Universe.blackholes =
          new Blackhole(pos, vel, rad) :: Universe.blackholes
      }
    }

    Universe.asteroids = Universe.asteroids.filterNot(asteroid =>
      asteroid.distanceToPlayer > 1500.0
    )
    if (Universe.asteroids.length < 20) {
      if (respawn > 0) {
        respawn = respawn - 1
      } else {
        respawn = 50
        val rad = Random.nextInt(20) + 10
        val vel = Universe.spaceship.velocity
        val randangle = Random.between(0.0, Math.PI * 2)
        val radius = 600.0
        val pos = (Vec2(
          Math.cos(randangle),
          Math.sin(randangle)
        ) * radius) + Universe.spaceship.position
        Universe.asteroids = new Asteroid(pos, vel, rad) :: Universe.asteroids
      }
    }

  }

  var respawn = 50

  override def mouseClicked(): Unit = {
    println("CLic")
    Universe.bullets = new Bullet(Vec2(0, 0), Vec2(20, 20)) :: Universe.bullets
  }

  override def keyPressed(event: KeyEvent): Unit = Controls.keyPressed(event)

  override def keyReleased(event: KeyEvent): Unit = Controls.keyReleased(event)

}

object Game extends App {
  PApplet.main(classOf[Game])
}
