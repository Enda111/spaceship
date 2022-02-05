package spaceship

import scala.util.Random

class Spaceship extends GameObject with HasGravity {
  var position: Vec2 = Vec2(10, 100)
  var velocity: Vec2 = Vec2.Zero
  var rotation: Float = 0
  var rotationalVelocity: Double = 0.00
  var rotationalAcceleration: Double = 0.00
  var thrust: Double = 0.0
  val mass: Double = 1

  override def draw(game: Game): Unit = {

    game.pushMatrix()

    game.translate(position.x, position.y)
    game.rotate(rotation)

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

    if (thrust != 0) {
      game.stroke(0, 128 + Random.nextInt(127), Random.nextInt(100))
      game.strokeWeight(5)
      game.line(-11 - 8, 0, -19 - (1000 * thrust), 0)
    }
    game.popMatrix()

  }

  override def update(game: Game): Unit = {

    val thrustVector =
      Vec2(Math.cos(rotation) * thrust, Math.sin(rotation) * thrust)

    velocity = velocity + thrustVector + Gravity.acceleration(this)
    position = position + velocity

    rotation = rotation + rotationalVelocity
    rotationalVelocity = rotationalVelocity + rotationalAcceleration

  }

}
