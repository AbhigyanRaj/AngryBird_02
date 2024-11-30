# Angry Birds Game in Java

This **Angry Birds** project is a **libGDX-based game** inspired by the classic Angry Birds gameplay. The project provides a modular structure for developing and testing various game states like menus, levels, and pause screens. Below is a detailed overview of the functionality and setup:

---

## Description
- **Core Functionality**: 
  - Launches the application via the `Core` class, which initializes the game states.
  - The game progresses through multiple states:
    1. **OpeningState**: The initial loading screen.
    2. **MenuState**: Contains the play button leading to the `LevelSelectState`.
    3. **LevelSelectState**: Currently has 3 buttons, all pointing to a static play screen. Includes a back button to return to the `MenuState`.
    4. **PlayState**: Features dummy buttons for `LevelCompleted` and `LevelFailed` screens.
    5. **LevelCompleted & LevelFailed**:
       - Resume or retry options to return to the `PlayState`.
       - Home button to navigate back to the `MenuState`.
    6. **PauseState**: Includes options to resume, save and exit, or quit to the `MenuState`.

- **Gameplay Features**:
  - Pause and resume functionality.
  - Transition between screens based on user actions.
  - Edited game assets designed using **Figma**.
  
---

## Resources Used
- **Tutorials**:
  - Brent Aureli's Flappy Bird series on YouTube.
- **Documentation**:
  - Official **libGDX** documentation for game design.
- **Assets**:
  - Sprites downloaded from [The Spriters Resource](https://www.spriters-resource.com) and modified in Figma.

---

## Setup and Testing

### Running the Game
- The `Core` module is the entry point for the game.
- Use the following commands for development and testing:

#### Gradle Commands
- **Build**: `./gradlew build`
- **Run**: `./gradlew lwjgl3:run`
- **Clean**: `./gradlew clean`

### Platform Modules
- `core`: Contains the application logic shared across platforms.
- `lwjgl3`: Desktop platform module using LWJGL3.

### Assets
- Assets are stored in the `assets` folder, optimized for performance and edited for seamless integration.

---

## Features Overview

### Game States
- **Menu**: Play and navigate options.
- **Level Selection**: Choose levels (currently static screens).
- **Gameplay**: Core game mechanics, dummy success/fail screens, and pause functionality.

### Gradle Integration
- Fully integrated with **Gradle** for dependency management and builds.
- Gradle wrapper included for platform-independent builds.

---

## Languages and Technologies Used
- **Java**: 62.9%
- **Ragel**: 21.4%
- **GLSL**: 15.7%

---

**Made with ❤️ by Abhigyann**
