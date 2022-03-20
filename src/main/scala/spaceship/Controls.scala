package spaceship

import processing.event.KeyEvent

object Controls {

  val UP = 38
  val LEFT = 37
  val DOWN = 40
  val RIGHT = 39
  val DDR = 0.001
  val DT = 0.001

  def keyPressed(event: KeyEvent): Unit = {
    //println(s"Press ${event.getKeyCode}")
    if (event.getKeyCode == UP) {
      Universe.spaceship.thrust = 0.01
    }
    if (event.getKeyCode == DOWN) {
      Universe.spaceship.thrust = 0.01
    }
    if (event.getKeyCode == LEFT) {
      Universe.spaceship.rotationalAcceleration = -DDR
    }
    if (event.getKeyCode == RIGHT) {
      Universe.spaceship.rotationalAcceleration = DDR
    }

  }

  def keyReleased(event: KeyEvent): Unit = {
    // println(s"Release ${event.getKeyCode}")
    if (event.getKeyCode == UP) {
      Universe.spaceship.thrust = 0.0
    }
    if (event.getKeyCode == DOWN) {
      Universe.spaceship.thrust = 0.0
    }
    if (event.getKeyCode == LEFT) {
      Universe.spaceship.rotationalAcceleration = 0.0
    }
    if (event.getKeyCode == RIGHT) {
      Universe.spaceship.rotationalAcceleration = 0.0
    }

  }

}
