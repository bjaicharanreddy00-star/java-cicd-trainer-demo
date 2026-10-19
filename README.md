# Java CI/CD Pipeline Demo

A minimal Java 21 application built with Maven. GitHub Actions builds it, runs its JUnit 5 tests, packages a JAR, and saves the JAR as a workflow artifact.

## Requirements

- JDK 21
- Apache Maven 3.9 or later

## Run locally

```sh
mvn clean verify
java -cp target/classes com.example.App
```

The application prints `Hello, CI/CD!`. Maven writes the packaged JAR to `target/`.

## CI workflow

`.github/workflows/java-ci.yml` runs on pushes to `main` and pull requests targeting `main`. It installs Java 21, caches Maven dependencies, runs `mvn clean verify` (compile, test, and package), and uploads the generated JAR for seven days. GitHub Actions uses read-only repository contents permission for this job.

## Push to GitHub

Create an empty GitHub repository, then from this project folder run:

```sh
git init
git add .
git commit -m "Add Java Maven CI pipeline"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
git push -u origin main
```

Replace the remote URL with your repository URL. GitHub will start the workflow after the push. Open the repository's **Actions** tab to see the build and download its artifact.

## Secrets and SonarQube

This starter pipeline needs no secrets. Never commit passwords, tokens, or private keys. If a later deployment or SonarQube integration requires a credential, store it in **GitHub repository Settings → Secrets and variables → Actions** and expose it to only the workflow step that needs it. SonarQube is intentionally left as a next step so the basic build remains usable without external service configuration.
