package spaceship

import com.sun.javafx.geom.Vec2d

import scala.util.Random

class Spaceship {
  var x: Double = 10
  var y: Double = 100
  var r: Float = 0
  var vx: Double = 0.0
  var vy: Double = 0.0
  var vr: Double = 0.00
  var ar: Double = 0.00
  var t: Double = 0.0
  var dt: Double = 0.0

  def draw(game: Game): Unit = {

    game.pushMatrix()

    game.translate(x, y)
    game.rotate(r)

    game.stroke(255, 0, 0)
    game.strokeWeight(0)

    // game.rect(x - 5, y - 5, 10, 10)
    game.line(-11, 0, -11 + 30, 0)
    game.line(-11 + 30, 0, -11 + 10, 0 - 15)
    game.line(-11 + 30, 0, -11 + 10, 0 + 15)
    game.line(-11 + 10, 0 - 15, -11 + 5, 0 - 10)
    game.line(-11 + 10, 0 + 15, -11 + 5, 0 + 10)
    game.line(-11 + 5, 0 - 10, -11, 0 - 12.5)
    game.line(-11 + 5, 0 + 10, -11, 0 + 12.5)
    game.line(-11, 0 - 12.5, -11 - 5, 0 - 8.5)
    game.line(-11, 0 + 12.5, -11 - 5, 0 + 8.5)
    game.line(-11 - 5, 0 - 8.5, -11 - 7.5, 0 - 2.5)
    game.line(-11 - 5, 0 + 8.5, -11 - 7.5, 0 + 2.5)
    game.line(-11 - 7.5, 0 - 2.5, -11 - 8, 0)
    game.line(-11 - 7.5, 0 + 2.5, -11 - 8, 0)

    if (t != 0) {
      game.stroke(0, 128 + Random.nextInt(127), Random.nextInt(100))
      game.strokeWeight(5)
      game.line(-11 - 8, 0, -19 - (1000 * t), 0)
    }
    game.popMatrix()

  }

  def update(game: Game): Unit = {

    vx = vx + Math.cos(r) * t
    vy = vy + Math.sin(r) * t

    World.blackholes.foreach(blackhole => {
      val dx = x - blackhole.x
      val dy = y - blackhole.y
      val r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2))
      vx -= blackhole.mass * dx / Math.pow(r, 3)
      vy -= blackhole.mass * dy / Math.pow(r, 3)

    })

    x = x + vx
    y = y + vy
    r = r + vr
    vr = vr + ar
    // t = t + dt

//    if (x > game.width) {
//      x -= game.width
//    }
//    if (x < 0) {
//      x += game.width
//    }
//    if (y > game.height) {
//      y -= game.height
//    }
//    if (y < 0) {
//      y += game.height
//    }
  }

  def printHello(): Unit = {
    println("HELLO")
  }
}
