# Keylog & Viewer App

This repository contains a pair of Android applications: **Keylog** and **Viewer**. The **Keylog** app captures input data by utilized the accessibility's feature on android phone, while the **Viewer** app is used to review the collected information. Follow the instructions below to set up, build, and run both applications.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Project Structure](#project-structure)
3. [Setup Instructions](#setup-instructions)
   - [Adding `google-services.json`](#adding-google-servicesjson)
   - [Running Keylog App](#running-keylog-app)
   - [Running Viewer App](#running-viewer-app)
4. [Permissions and Accessibility](#permissions-and-accessibility)
5. [Troubleshooting](#troubleshooting)
6. [License](#license)

---

## Prerequisites

- **Android Studio**: Latest version recommended
- **Firebase Account**: To configure `google-services.json`
- **Android Device**: Required for testing permissions and features

---

## Project Structure

- **/Keylog**: Contains the source code for the Keylog app.
- **/Viewer**: Contains the source code for the Viewer app.
- **/common**: Shared assets and configuration files (if applicable).

---

## Setup Instructions

### Step 1: Adding `google-services.json`

Both apps require a `google-services.json` file for Firebase integration.

1. **Obtain `google-services.json`**:
   - Visit the [Firebase Console](https://console.firebase.google.com/).
   - Create a new Firebase project (or use an existing one).
   - Add both Keylog and Viewer apps to the project.
   - Download the `google-services.json` file for each app.

2. **Add `google-services.json` to Each App**:
   - Place the Keylog app's `google-services.json` in the `Keylog/app` directory.
   - Place the Viewer app's `google-services.json` in the `Viewer/app` directory.
   - Sync the Gradle files in Android Studio after adding the configuration files.

---

## Step 2: Running Keylog App

1. **Open Keylog Project**:
   - In Android Studio, open the `Keylog` folder.

2. **Build and Run**:
   - Build and create apk for **Keylog App** and **Viewer App**.
   - Install or sideload the **Keylog App** to the target phone.

3. **Grant Accessibility Permission**:
   - Navigate to **Settings > Accessibility** on your device.
   - Find the **...** app in the list of downloaded services.
   - Tap on the app and toggle the switch to **ON**.
   - Confirm any prompts to grant the required permissions.

---

## Step 3: Running Viewer App

1. **Open Viewer Project**:
   - In Android Studio, open the `Viewer` folder.

2. **Build and Run**:
   - Build and create apk for **Viewer App** and **Viewer App**.
   - Install or sideload the **Viewer App** to the user phone.

---

## Permissions and Accessibility

- The **Keylog App** requires Accessibility permissions to monitor and capture data. Make sure to grant all permissions when prompted.
- The **Viewer App** may require network permissions if data transfer is involved.

---

## Troubleshooting

- **Firebase Configuration Issues**: Double-check your `google-services.json` files and ensure they are correctly placed.
- **Gradle Sync Problems**: Try cleaning the project (**Build > Clean Project**) and then syncing again.
- **Permissions Not Working**: Check the device's settings and ensure the app has all the required permissions.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.
