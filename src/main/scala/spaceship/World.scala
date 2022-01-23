package spaceship

object World {

  val spaceship = new Spaceship
  var game: Game = _

  var blackholes = List(new Blackhole(500, 500, 50), new Blackhole(500, 50, 30))

}
