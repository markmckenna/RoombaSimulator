# RoombaSimulator
Visual simulation of a Roomba, for improving its brain power.


## Details

Currently, it's a skeleton project with a static scene.  There's a mobile head as well as a desktop one, 
but only the desktop head works right now.


## Architecture

Trying to use a top-down design style, with a bit of looking ahead to keep it streamlined.  I started with the
JavaFX canvas in a single file, and made that call down to a Simulator object for action.  This ended up putting
the renderer too much in control over the simulation; so instead I wrote a rendering interface on the Simulator
class.  The JavaFX renderer passes an implementation of this into the simulator for each draw action, and the simulator
fills it out from its interior entities.

Need to define a scale for simulator callback values, which the renderer can modify appropriate for to make nice
looking.  Otherwise this approach should remain fairly scalable and avoid too much unwanted object orientation, etc.

Also need to think about automated tests at some point, but for now I think we're looking pretty safe.
