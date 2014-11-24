ASTEROIDS README!
(by Josie Bealle and Chet Aldrich)

A basic asteroids scroller-ish type  game.

Currently the game has a start menu, and then goes into a game where the player attempts to destroy the asteroids coming from the
right side of the screen. We currently have functionality to play the game, associated sounds and music and explosions, a
scoring mechanism , and also the ability to toggle the music if you so choose.

There were some odd issues we had with timers that made it easier to add another timer inside our animation timer.
For the most part though, the code seems to be behaving.

Code Structure:
Currently, the program is structured with view fxml files + core classes (listed below). The initial menu view is launched via the Main class,
and each of the controllers can initialize each other to instantiate a different view.

Additionally, each of the core classes other than Scoreboard inherits from Sprite.

Core classes:
Spaceship
Asteroid
Bullet
Scoreboard

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


				
				                   A
                                   M
                                   M
                                   M
                                   M
                                   M
                                   M
                                   M
                                  /M\
                                 '[V]'
                                  [A]
                                 [,-']
                                 [/"\]
                                 / _ \
                                / / | \
                               / /_O_| \
                              /______|__\
                              |=_==_==_=|
                              |  |   |  |
                             V|  |.V.|__|V
                             A|  |'A'| =|A
                              |__|___|= |
                              |__|___| =|
                              |####|####|
                             |    o|     |
                             |     |     |
                             |     |     |
                            |      |      |
                            |      |      |
                            |      |      |
                           |       |       |
                           |       |       |
                           |-------|-------|
                          |        |        |
                          |        |        |
                          |___.____|____.___|
                         |                   |
                         |___________________|
                        /|HH|      |HH][HHHHHI
                        [|##|      |##][#####I
                        [|##|      |#########I
                        [|##|______|#######m#I
                        [I|||||||||||||||||||I
                        [I|||||||||||||||||||I
                        [|                   |
                        [|    H  H          H|
                        [|    H  H          H|
                        [|    \hdF          V|
                        [|     `'            |
                        [|    d##b          d|
                        [|    #hn           #|
                        [|     ""#          }|
                        [|    \##/          V|
                        [|                   |
                        [|     dh           d|
                        [|    d/\h          d|
                        [|    H""H          H|
                        [|    "  "          "|
                        [|________.^.________|
                        [I########[ ]########I
                        [I###[]###[.]########I
                        [I###|||||[_]####||||I
                        [####II####|        n |
                       /###########|         " \
                       ############|           |
                      /############|            \
                      ######"######|            |
                     /             |####### #####\
                     |             |#######.######
                    /              |##############\
                    |              |###############
                   /_______________|###############\
                   I|||||||||||||||||||||||||||||||I
                   I|||||||||||||||||||||||||||||||I
                   I|||||||||||||||||||||||||||||||I
                   I|||||||||||||||||||||||||||||||I
                   |                               |
                   |-------------------------------|
                   |                               |
                   | [                  U          |
                   | [                  N          |
                   | !                  I          |
                   | [                  T          |
                   | [                  E          |
                   | }                  D          |
                   |                               |
                   |                               |
                   | {                  S          |
                   | [                  T          |
                   | :                  A          |
                   | [                  T          |
                   | [                  E          |
                  /| {  /|              S    |\    |
                 | |   | |                   | |   |
                 | |   | |                   | |   |
                 | |   | |                   | |   |
                 |_|___|_|___________________|_|___|
                 | |   | |                   | |   |\
                 | |___| |___________________| |___|]
                 | |###| |###################| |###|]
                 | |###| |###################| |###|]
                 | |###| |""""""""""#########| |"""|]
                 | |###| |         |#########| |   |]
                  \|####\|---------|#########|/----|]
                   |#####|         |#########|     |/
                   |#####|         |#########|     |
                  /]##### |        | ######## |    [\
                  []##### |        | ######## |    []
                  []##### |        | ######## |    []
                  []##### |        | ######## |    []
                  []##### |        | ######## |    []
                   |#####|---------|#########|-----|
                   |#####|         |#########|     |
                   |#####|         |##H######|     |
                   |#####|         |##H######|     |
                   |#####|         |##H######|     |
                   |#####|_________|##H######|_____|
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |     ####"""""""  H            |
                   |     ####"""""""  H            |
                   |     """""""""""  H            |
                   |     """""""""""  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |                  H            |
                   |__________________H____________|
                   |                  H            |
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   I||||||||||||||||||H||||||||||||I
                   |#####|         |##H######|     |
                   |#####|         |##H######|     |
                   |#####|  H   H  |##H######|   H |
                   |#####|  H   H  |##H######|   H |
                   |#####|  H   H  |##H######|   H |
                   |#####|  \h_dF  |##H######|   Vm|
                   |#####|   `"'   |##H######|    "|
                   |#####|         |##H######|     |
                   |#####|  /###\  |##H######|   /#|
                   |#####|  #   '  |##H######|   # |
                   |#####|  \###\  |##H######|   \#|
                   |#####|  .   #  |##H######|   . |
                   |#####|  \###/  |##H######|   \#|
                   |#####|         |##H######|     |
                   |#####|    H    |##H######|     [
                   |#####|   dAh   |##H######|    H|
                   |#####|  dF qL  |##H######|   dF|
                   |#####|  HhmdH  |##H######|   Hm|
                   |#####|  H   H  [%]H#apx##|   H |
                   |#####|         |##H######|     |
                   |#####A         |##H######A     |
                   |####| |        |##H#####|#|    |
                   |####| |        |##H#####|#|    |
                   |###|   |       |##H####|###|   |
                   |###|   |       |##H####|###|   |
                   |##|     |      |##H###|#####|  |
                   |#-|     |      |##H###|#####|-_|
                _-"==|       |     |##H##|#######|=="-_
             _-"=[]==|       |     |##H##|#######|==[]="-_
            |========|_______|_____|##H##|#######|========|
            !=======|=========|____|##H#|=========|=======!
                    !=========! /#####\ !=========!
                     /#######\ /#######\ /#######\
                    d#########V#########V#########h
                    H#########H#########H#########H
                   |###########H#######H###########|
                   |###########|"""""""|###########|
                    """""""""""         """""""""""
 
                            Apollo Saturn V
                             (c) apx 2000

citation: http://www.chris.com/ascii/index.php?art=transportation/space%20ships

OH LOOK THERE IS A MOOSE IN SPACE

                                     _.--"""--,
                                    .'          `\
  .-""""""-.                      .'              |
 /          '.                   /            .-._/
|             `.                |             |
 \              \          .-._ |          _   \
  `""'-.         \_.-.     \   `          ( \__/
        |             )     '=.       .,   \  
       /             (         \     /  \  /
     /`               `\        |   /    `'
     '..-`\        _.-. `\ _.__/   .=.
          |  _    / \  '.-`    `-.'  /
          \_/ |  |   './ _     _  \.'
               '-'    | /       \ |  
                      |  .-. .-.  |
                      \ / o| |o \ /
                       |   / \   |
                      / `"`   `"` \
                     /             \
                    | '._.'         \
                    |  /             |
                     \ |             |
                      ||    _    _   /
                      /|\  (_\  /_) /
              jgs     \ \'._  ` '_.'
                       `"

http://www.chris.com/ascii/index.php?art=animals/moose
