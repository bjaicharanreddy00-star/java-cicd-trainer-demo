# Trainer Demo Guide

## What this project demonstrates

This is a small Java 21 application with a Maven build, an automated JUnit 5 test, and a GitHub Actions pipeline. The goal is to show how a code change can be checked automatically before it is merged.

```text
Push or pull request to main
          ↓
GitHub Actions checks out the code and sets up Java 21
          ↓
Maven compiles the app and runs the JUnit test
          ↓
Maven packages the app as a JAR
          ↓
GitHub Actions saves the JAR as a downloadable artifact
```

## Suggested 5-minute walkthrough

1. **Introduce the app** — Open `src/main/java/com/example/App.java`. It returns a greeting, keeping the example small so the pipeline is the focus.
2. **Show the automated check** — Open `src/test/java/com/example/AppTest.java`. The test checks that the app returns the expected greeting.
3. **Explain the build** — Open `pom.xml`. It identifies the project, targets Java 21, and includes JUnit 5 plus Maven compiler and test plugins.
4. **Walk through CI** — Open `.github/workflows/java-ci.yml`. It runs for pushes and pull requests targeting `main`, sets up Java 21, runs `mvn clean verify`, then uploads the packaged JAR.
5. **Show the result** — In GitHub, open **Actions**, select the latest successful run, and download the `java-cicd-pipeline` artifact.

## Optional live change

Change the greeting in `App.java` and update the expected value in `AppTest.java` to match. Run the build locally, then commit and push the change to see GitHub Actions run again.

```sh
mvn clean verify
```

If you change the greeting in only one file, the test should fail. This is a simple way to show how CI catches a mismatch before the change is accepted.

## Explain the project files

| File | Demo purpose |
| --- | --- |
| `src/main/java/com/example/App.java` | The Java application |
| `src/test/java/com/example/AppTest.java` | Automated behavior check |
| `pom.xml` | Java version, dependency, and build plugins |
| `.github/workflows/java-ci.yml` | Automated build, test, and artifact upload |
| `.gitignore` | Keeps generated build output and editor files out of Git |
| `README.md` | Setup and GitHub push instructions |

## Security and next steps

The current pipeline does not need credentials and grants the job read-only repository contents access. Do not commit secrets. If a future deployment or SonarQube step needs a token, store it in GitHub Actions secrets and make it available only to the step that needs it. SonarQube and deployment are follow-on enhancements, not required for this basic demo.
