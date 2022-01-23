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
    println(s"Press ${event.getKeyCode}")
    if (event.getKeyCode == UP) {
      World.spaceship.dt = DT
    }
    if (event.getKeyCode == DOWN) {
      World.spaceship.dt = DT
    }
    if (event.getKeyCode == LEFT) {
      World.spaceship.ddr = -DDR
    }
    if (event.getKeyCode == RIGHT) {
      World.spaceship.ddr = DDR
    }

  }

  def keyReleased(event: KeyEvent): Unit = {
    println(s"Release ${event.getKeyCode}")
    if (event.getKeyCode == UP) {
      World.spaceship.dt = 0.0
    }
    if (event.getKeyCode == DOWN) {
      World.spaceship.dt = 0.0
    }
    if (event.getKeyCode == LEFT) {
      World.spaceship.ddr = 0.0
    }
    if (event.getKeyCode == RIGHT) {
      World.spaceship.ddr = 0.0
    }

  }

}
