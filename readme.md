ASTEROIDS
==========
(by Josie Bealle and Chet Aldrich)

     |     | |
    / \    | |
   |--o|===|-|
   |---|   |d|
  /     \  |w|
 | U     | |b|
 | S     |=| |
 | A     | | |
 |_______| |_|
  |@| |@|  | |
___________|_|_

A basic asteroids scroller-ish type  game.

Currently the game has a start menu, and then goes into a game where the player attempts to destroy the asteroids coming from the
right side of the screen. We currently have functionality to play the game, associated sounds and music and explosions, a
scoring mechanism , and also the ability to toggle the music if you so choose.

There were some odd issues we had with timers that made it easier to add another timer inside our animation timer.
For the most part though, the code seems to be behaving.

Code Structure
----------------
Currently, the program is structured with view fxml files + core classes
(listed below). The initial menu view is launched via the Main class,
and each of the controllers can initialize each other to instantiate a different view.

Additionally, each of the core classes other than Scoreboard inherits from Sprite.

Core classes:
Spaceship
Asteroid
Bullet
Scoreboard

TODO:
-----------------
0) Make asteroids more sensitive to bullets, less sensitive to spaceship.
1) Add feature where there are simple math problems on the bottom, and user must shoot asteroid with correct answer.
    -Minus points for hitting asteroid with wrong answer.
2) Add a basic physics engine so that the spaceship could move more quickly and slow down when movement key is not depressed.
3) Add visual and sound effects for when the asteroid blows up.
4) Add high score feature.
5) Add Game Over animations
6) Add level system that increases difficulty as score goes up
7) Potentially try 3D rendering at some point?
8) FINAL ALIEN BOSS



Links we found helpful:
https://carlfx.wordpress.com/tag/collision-detection/
http://stackoverflow.com/questions/17226948/switching-scene-in-javafx
https://www.youtube.com/watch?v=djZFHTa6TfA


spaceship:
http://scratch.mit.edu/projects/2229196/

Space Alien:
https://twitter.com/8bitAlien

Asteroid:
http://astroempires.wikia.com/wiki/Asteroid

SpaceBackground:
by Chet Aldrich

Explosion:
http://download.amplific.org/download/fnf001/
