package spaceship

import jdk.internal.util.xml.impl.Input

class Spaceship {
  var x: Double = 10
  var y: Double = 100
  var r: Float = 0
  var dx: Double = 0.0
  var dy: Double = 0.0
  var dr: Double = 0.00
  var ddr: Double = 0.00
  var t: Double = 0.0
  var dt: Double = 0.0

  def draw(game: Game): Unit = {
    game.pushMatrix()

    game.translate(x, y)
    game.rotate(r)

    game.stroke(255, 0, 0)

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

    game.popMatrix()

    dx = dx + Math.cos(r) * t
    dy = dy + Math.sin(r) * t

    x = x + dx
    y = y + dy
    r = r + dr
    dr = dr + ddr
    t = t + dt

    if (x > game.width) {
      x -= game.width
    }
    if (x < 0) {
      x += game.width
    }
    if (y > game.height) {
      y -= game.height
    }
    if (y < 0) {
      y += game.height
    }

  }

}
