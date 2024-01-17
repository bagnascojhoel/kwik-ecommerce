![Kwik-Ecommerce Management UI Logo](../docs/theme/management_ui_logo.svg)

## Overview

Welcome to Kwik-Ecommerce Management UI, a powerful Flutter application designed to simplify and streamline the
management of your e-commerce platform. This app provides a user-friendly interface to efficiently handle various
aspects of your online store, including product management, order processing, and customer interactions.

## Features

- **Product Management**: Easily add, edit, or remove products from your catalog. Update product details, images, and
  pricing with just a few taps.

## Getting Started

Follow these steps to get the Kwik-Ecommerce Management UI up and running on your development environment:

1. Clone this repository to your local machine:

   ```bash
   git clone git@github.com:bagnascojhoel/kwik-ecommerce.git
   ```

2. Navigate to the project directory:

   ```bash
   cd kwik-ecommerce/management-ui
   ```

3. Install dependencies:

   ```bash
   flutter pub get
   ```

4. Run the app:

   ```bash
   flutter run --dart-define-from-file=dev.env
   ```

## Configuration

The project uses compile-time variables for any data that is relevant to be
changed depending on external sources (e.g. the API URL).

- These variables are stored into `compile_time_variables.json` files.
- To use them you need to pass it to `flutter run --dart-define-from-file=<file name>`.
- Files `compile_time_varialbes.json` that are suffixed with `_local` are ignored by git.

## Running with IntelliJ

To run the Kwik-Ecommerce Management UI using IntelliJ, follow these steps:

1. **Open the Project in IntelliJ:**
    - Launch IntelliJ IDEA.
    - Choose "Open" from the welcome screen and navigate to the project directory (`Kwik-Ecommerce-Management-UI`).

2. **Install Flutter and Dart Plugins:**
    - Make sure you have the Flutter and Dart plugins installed in IntelliJ.
    - If not, go to `Settings/Preferences -> Plugins -> Marketplace` and search for "Flutter" and "Dart" to install the
      plugins.

3. **Configure Flutter SDK:**
    - Open the project settings by going to `File -> Project Structure`.
    - In the Project Settings dialog, navigate to `Project -> Project SDK`.
    - Select the Flutter SDK. If it's not installed, click on "New" and add the Flutter SDK path.

4. **Run the Application:**
    - Open the `main.dart` file in the `lib` directory.
    - Right-click on the file and choose "Run main.dart" or use the green triangle button in the top-right corner.

5. **Access the App:**
    - Once the app is successfully compiled and running, access it in your preferred web browser
      at `http://localhost:3000`.

Now you can enjoy running and developing the Kwik-Ecommerce Management UI using the powerful features of IntelliJ IDEA.

## Support and Contribution

If you encounter any issues or have suggestions for improvement,
please [create an issue](https://github.com/your-username/Kwik-Ecommerce-Management-UI/issues). Contributions are
welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Happy managing your e-commerce business with Kwik-Ecommerce Management UI!**