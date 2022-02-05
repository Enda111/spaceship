package spaceship

object Gravity {

  def acceleration(anObject: HasGravity): Vec2 = {
    var acceleration = Vec2.Zero
    Universe.gravitationalBodies.foreach(body => {
      if (body != anObject) {
        val distanceVector = anObject.position - body.position
        val distance = distanceVector.magnitude
        acceleration =
          acceleration - (distanceVector * body.mass / Math.pow(distance, 3))
      }
    })
    acceleration
  }
}
