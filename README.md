# ToDo List App 📝

Welcome to the **ToDo List App**! This Android application is designed to help users manage their daily tasks efficiently. Below, you'll find a detailed explanation of the app's purpose, functionalities, and the technologies used to build it.

---

## 📋 Purpose

The **ToDo List App** is a simple and intuitive task management application. It allows users to create, edit, and delete tasks, helping them stay organized and productive.

---

## ✨ Features

### 1. **Task Management**
   - Add new tasks with a description.
   - Edit existing tasks to update their details.
   - Delete tasks when they are no longer needed.

### 2. **Task Display**
   - View all tasks in a scrollable list using a **RecyclerView**.
   - Each task displays its description and creation date.

### 3. **User-Friendly Interface**
   - Modern design using **Material Design 3** principles.
   - Floating Action Button (FAB) for quick task addition.
   - Toolbar for navigation and app branding.

### 4. **Data Persistence**
   - Tasks are stored locally using **SQLite** for offline access.

### 5. **Edge-to-Edge Design**
   - Seamless integration with system UI for a modern look.

---

## 🛠️ Technologies and Frameworks

### 1. **Programming Language**
   - **Kotlin**: The app is fully developed in Kotlin, a modern and concise language for Android development.

### 2. **Android SDK**
   - **Minimum SDK**: 26 (Android 8.0 Oreo)
   - **Target SDK**: 36 (Future Android version)

### 3. **Libraries**
   - **AndroidX Core KTX**: Simplifies common Android tasks.
   - **AppCompat**: Ensures compatibility with older Android versions.
   - **Material Components**: Provides Material Design UI components.
   - **ConstraintLayout**: Used for flexible and efficient UI design.
   - **RecyclerView**: Displays the list of tasks efficiently.

### 4. **Database**
   - **SQLite**: Used for local data storage.
   - **SQLiteOpenHelper**: Manages database creation and version management.

### 5. **Build System**
   - **Gradle (Kotlin DSL)**: Manages dependencies and builds the project.

### 6. **View Binding**
   - Simplifies interaction with UI components.

---

## 🚀 How It Works

1. **Main Screen**: Displays a list of tasks with options to edit or delete.
2. **Add Task Screen**: Allows users to add a new task or edit an existing one.
3. **Database Operations**: All tasks are stored in an SQLite database, ensuring data persistence.

---

## 📂 Project Structure

- **MainActivity**: Handles the main screen and task list.
- **AddTaskActivity**: Manages task creation and editing.
- **TaskDAO**: Provides database operations (CRUD).
- **RecyclerView Adapter**: Displays tasks in a list format.
- **SQLite Database**: Stores task data locally.

---

## 🌟 Future Enhancements

- Add task reminders and notifications.
- Implement task categories or priorities.
- Sync tasks with cloud storage for multi-device access.

---

Thank you for exploring the **ToDo List App**! 🎉