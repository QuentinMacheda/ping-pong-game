# Ping Pong Game

This is a simple Ping Pong game developed in Java with JavaFX.

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
- [How to Run the App](#how-to-run-the-app)
- [How to Generate JavaDoc](#how-to-generate-javadoc)
- [License](#license)


## Requirements

- **Java Development Kit (JDK):**
  - Download and install the latest version of JDK from the official Oracle website: [Oracle JDK Downloads](https://www.oracle.com/java/technologies/javase-downloads.html).

- **JavaFX SDK:**
  - Download the JavaFX SDK version 21.0.2 from the official JavaFX website: [JavaFX SDK Downloads](https://gluonhq.com/products/javafx/).
  - Extract the downloaded archive to a location on your machine.

- **Gradle Build Tool:**
  - Download and install Gradle from the official Gradle website: [Gradle Installation](https://gradle.org/install/).


## Installation

1. **Clone the repository:**
   - Run:
     ```bash
     git clone [repository_url]
     ```
     
     Replace ```bash [repository_url]``` with the actual URL of your Git repository.

3. **Open the project directory:**
   - Run:
     ```bash
     cd ping-pong-game
     ```

4. **Configure JavaFX SDK in `build.gradle`:**
   - Open the `build.gradle` file.
   - Make sure JavaFX is included in the project with the following code : 
    ```bash
    plugins {
        // Apply the application plugin to add support for building a CLI application in Java.
        application
    
        id("org.openjfx.javafxplugin") version "0.1.0"
    }
    
    javafx {
        modules("javafx.controls", "javafx.fxml", "javafx.media")
    }
    ```

5. **Build and run the project:**
   - Run: `gradle run`
     This will build and run the Ping Pong game. Ensure you have configured paths and dependencies correctly.


## How to Run the App

To run the application, use the following Gradle command:

```bash
gradle run
```

This command will build and run the Ping Pong game. Make sure you have Gradle installed on your machine.


## How to Generate JavaDoc

To generate JavaDoc documentation for the project, use the following command:

```bash
javadoc -d docs -sourcepath app/src/main/java -classpath "C:\Program Files\Java\javafx-sdk-21.0.2\lib\*" -subpackages pingPongGame
```

This command will generate JavaDoc documentation for all packages and subpackages under pingPongGame and place the output in the docs directory.


## License

This project is licensed under the MIT License.
