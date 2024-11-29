<<<<<<< HEAD
# AngryBirds

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).


This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

## SetUp, Running and Testing AngryBirds
 - The central class that is Core is the class that starts the entire project
 - The Core classes calls the openingState class which in turns calls the menuState class
 - The menuState for this deadline has only a play option which when pressed switches the screen to levelSelect State
 - The levelSelectstate has 3 level buttons initially but since the levels haven't been implemented yet, the three levelSelect buttons changes to the same static playscreen
 - There is a back option on the top left corner of levelSelectState which when pressed changes the screen to menuState.
 - In the playstate, there are 2 dummy buttons for levelCompleted and levelFailed screens which when pressed changes to those screens
 - the levelCompleted screens has a resume button which when pressed changes to the same playscreen and the rest buttons changes to menuState
 - the levelFailed screens has tryAgain which chnages to same playState screen and home button to the menuState screen
- The puase button  on the playstate screen pauses the game creen and changes to the pauseState 
- The pauseState has resume button, save and exit and exit button.
- The first button changes to the same playState screen
- and the Last 2 to the menuState button.

## Resources used from the internet:
- This project has taken help from the youtube video series of flappyBird by Brent Aureli Codes.
- This project has also taken help from the original documentations available on libgdx.com on how to extend a simple game etc.
- The assets are downloaded from spriters-resources.
- And most of the assets ar edited on figma.


## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
=======

