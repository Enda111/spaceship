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
    fill(30, 225, 225)
    text(
      "x position: " + Universe.spaceship.position.x,
      Universe.spaceship.position.x + 200,
      Universe.spaceship.position.y + 200
    )
    text(
      "y position: " + Universe.spaceship.position.y,
      Universe.spaceship.position.x + 200,
      Universe.spaceship.position.y + 220
    )
    text(
      "velocity: " + Universe.spaceship.velocity.magnitude,
      Universe.spaceship.position.x + 200,
      Universe.spaceship.position.y + 240
    )

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
    Universe.updateBlackholes()

    Universe.asteroids = Universe.asteroids.filterNot(asteroid =>
      asteroid.distanceToPlayer > 1500.0
    )
    if (Universe.asteroids.length < 20) {
      if (respawn > 0) {
        respawn = respawn - 1
      } else {
        respawn = Constants.maxAsteroids
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
    val bulletVelocity = Universe.spaceship.velocity + Vec2(
      math.cos(Universe.spaceship.rotation),
      math.sin(Universe.spaceship.rotation)
    )
    val bulletSpawnPos = Universe.spaceship.position + Vec2(
      math.cos(Universe.spaceship.rotation) * 15,
      math.sin(Universe.spaceship.rotation) * 19
    )
    Universe.bullets = new Bullet(
      bulletSpawnPos,
      bulletVelocity
    ) :: Universe.bullets
    println(Universe.spaceship.position)
    println(Universe.spaceship.velocity)
    println()
  }

  override def keyPressed(event: KeyEvent): Unit = Controls.keyPressed(event)

  override def keyReleased(event: KeyEvent): Unit = Controls.keyReleased(event)

}

object Game extends App {
  PApplet.main(classOf[Game])
}
