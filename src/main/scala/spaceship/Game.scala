package spaceship

import processing.core._

import scala.util.Random

class Game extends PApplet {
  override def settings(): Unit = {
    size(800, 600)
  }

  override def draw(): Unit = {

    fill(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
    rect(0, 0, width, height)

  }

}

object Game extends App {
  PApplet.main(classOf[Game])
}
