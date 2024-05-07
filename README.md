<p align="center">
  <img src="assets/Sketchware-Pro.png" style="width: 30%;" />
</p>

# TrindadeWare
[![GitHub contributors](https://img.shields.io/github/contributors/Sketchware-Pro/Sketchware-Pro)](https://github.com/Sketchware-Pro/Sketchware-Pro/graphs/contributors)
[![GitHub last commit](https://img.shields.io/github/last-commit/Sketchware-Pro/Sketchware-Pro)](https://github.com/Sketchware-Pro/Sketchware-Pro/commits/)
[![Discord server stats](https://img.shields.io/discord/790686719753846785)](http://discord.gg/kq39yhT4rX)
[![Total downloads](https://img.shields.io/github/downloads/Sketchware-Pro/Sketchware-Pro/total)](https://github.com/Sketchware-Pro/Sketchware-Pro/releases)
[![Repository Size](https://img.shields.io/github/repo-size/Sketchware-Pro/Sketchware-Pro)](https://github.com/Sketchware-Pro/Sketchware-Pro)

Welcome to TrindadeWare! Here you'll find the source code of many classes in TrindadeWare and, most importantly, the place to contribute to TrindadeWare.

## Building the App
To build the app, you must use Gradle. It's highly recommended to use Android Studio for the best experience.

There are two build variants with different features:

- `minApi26:` This variant supports exporting AABs from projects and compiling Java 1.8, 1.9, 10, and 11 code. However, it only works on Android 8.0 (O) and above.
- `minApi21:` This variant can't produce AABs from projects and can only compile Java 1.7 code, but it supports Android 5 and above.

To select the appropriate build variant in Android Studio, use the Build Variants tab or use the appropriate Gradle build command.

### Source Code Map

| Class           | Role                                        |
| --------------- | ------------------------------------------- |
| `a.a.a.ProjectBuilder`      | Helper for compiling an entire project       |
| `a.a.a.Ix`      | Responsible for generating AndroidManifest.xml |
| `a.a.a.Jx`      | Generates source code of activities          |
| `a.a.a.Lx`      | Generates source code of components, such as listeners, etc. |
| `a.a.a.Ox`      | Responsible for generating XML files of layouts |
| `a.a.a.qq`      | Registry of built-in libraries' dependencies |
| `a.a.a.tq`      | Responsible for the compiling dialog's quizzes |
| `a.a.a.yq`      | Organizes Sketchware projects' file paths    |

> [!TIP]
> You can also check the `mod` package, which contains the majority of contributors' changes.

## Contributing

If you'd like to contribute to TrindadeWare, follow these steps:

1. Fork this repository.
2. Make changes in your forked repository.
3. Test out those changes.
4. Create a pull request in this repository.
5. Your pull request will be reviewed by the repository members and merged if accepted.

We welcome contributions of any size, whether they are major features or bug fixes, but please note that all contributions will be thoroughly reviewed.

### What Changes We're Unlikely to Accept

Most changes related to the user interface (components that already exist in vanilla Sketchware) are unlikely to be accepted. If something design-related gets changed, ideally the whole app should follow the new style too, which is challenging, especially for mods.
> [!NOTE]
> In the meantime, we don't accept UI changes in the main branch, but we do in the [redesign branch](https://github.com/Sketchware-Pro/Sketchware-Pro/tree/material-redesign) since we're actively working on a material design version of TrindadeWare.

### Commit Message

When you make changes to one or more files, you need to commit those changes with a commit message. Here are some guidelines:

- Keep the commit message short and detailed.
- Use one of these commit types as a prefix:
  - `feat:` for a feature, possibly improving something already existing.
  - `fix:` for a fix, such as a bug fix.
  - `style:` for features and updates related to styling.
  - `refactor:` for refactoring a specific section of the codebase.
  - `test:` for everything related to testing.
  - `docs:` for everything related to documentation.
  - `chore:` for code maintenance (you can also use emojis to represent commit types).

Examples:
- `feat: Speed up compiling with new technique`
- `fix: Fix crash during launch on certain phones`
- `refactor: Reformat code in File.java`

## Thanks for Contributing

Thank you for contributing to TrindadeWare! Your contributions help keep TrindadeWare alive. Each accepted contribution will be noted down in the "About Modders" activity. We'll use your GitHub name and profile picture initially, but they can be changed, of course.