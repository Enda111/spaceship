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
      World.blackholes.foreach(blackhole => blackhole.draw(this))
    }

    noStroke()
    this.fill(15, 15, 15)
    this.rect(0, 0, width, height)

    drawWorld()
    World.spaceship.update(this)
  }

  override def mouseClicked(): Unit = {
    println("CLic")
  }

  override def keyPressed(event: KeyEvent): Unit = Controls.keyPressed(event)

  override def keyReleased(event: KeyEvent): Unit = Controls.keyReleased(event)

}

object Game extends App {
  PApplet.main(classOf[Game])
}
