# Ping Pong Game

This is a simple Ping Pong game developed in Java with JavaFX.

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
- [JavaDoc](#javadoc)
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
     
     Replace `[repository_url]` with the actual URL of your Git repository.

2. **Open the project directory:**
   - Run:
     ```bash
     cd ping-pong-game
     ```

3. **Build and run the project:**
   - Run:
     ```bash
     gradle run
     ```
     
     This will build and run the Ping Pong game. Ensure you have configured paths and dependencies correctly.


## JavaDoc

To generate JavaDoc documentation for the project, use the following command:

```bash
javadoc -d docs -sourcepath app/src/main/java -classpath "C:\Program Files\Java\javafx-sdk-21.0.2\lib\*" -subpackages pingPongGame
```

This command will generate JavaDoc documentation for all packages and subpackages under pingPongGame and place the output in the docs directory.


## License

This project is licensed under the MIT License.
