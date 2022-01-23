package spaceship

import processing.core._
import processing.event.KeyEvent

import scala.util.Random

class Game extends PApplet {
  World.game = this
  override def settings(): Unit = {
    size(800, 600)
  }

  override def draw(): Unit = {
    def drawWorld(): Unit = {
      World.spaceship.draw(this)
      World.bullets.foreach(bullet => bullet.draw(this))
      World.blackholes.foreach(blackhole => blackhole.draw(this))
    }

    noStroke()
    this.fill(15, 15, 15)
    this.rect(0, 0, width, height)

    translate(width / 2 - World.spaceship.x, height / 2 - World.spaceship.y)

    drawWorld()
    World.spaceship.update(this)
    World.bullets.foreach(bullet => bullet.update(this))
    World.bullets = World.bullets.filterNot(bullet => bullet.dead)
  }

  override def mouseClicked(): Unit = {
    println("CLic")
    World.bullets = new Bullet(0, 0, 20, 20) :: World.bullets
  }

  override def keyPressed(event: KeyEvent): Unit = Controls.keyPressed(event)

  override def keyReleased(event: KeyEvent): Unit = Controls.keyReleased(event)

}

object Game extends App {
  PApplet.main(classOf[Game])
}
