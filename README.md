Command Pattern
In your code, the Command pattern is used to handle different operations like adding a student, removing a classroom, scheduling an assignment, and submitting an assignment. Each of these operations is encapsulated as a command, which is processed based on user input. This approach separates the command execution from the user interface logic, making the system more flexible and easier to manage.

Singleton Pattern
The Singleton pattern is applied to the VirtualClassroomManager class, ensuring that only one instance of this class is created and used throughout the application. This design provides a global point of access to the VirtualClassroomManager, which centralizes the management of classrooms and assignments, preventing multiple instances from conflicting with each other.

Composite Pattern
The Composite pattern is demonstrated through the Classroom class, which manages students and assignments in a unified manner. Both individual students and assignments are handled uniformly, allowing you to add, retrieve, and manipulate these elements without differentiating between them. This pattern simplifies the management of collections and individual components by treating them in the same way.

SOLID Principles:
Single Responsibility Principle (SRP): Each class in the code has a single responsibility. For instance, `VirtualClassroomManager` handles classroom management, while `Student` manages student-related data.
Open/Closed Principle (OCP): The code is designed to be extended without modifying existing code. For example, adding new command types does not require changes to the core logic.
Liskov Substitution Principle (LSP): The implementation of commands and handling operations ensures that subclasses or extended functionalities can replace the base class without affecting the system’s correctness.
Interface Segregation Principle (ISP): Commands are processed through specific methods, avoiding unnecessary methods in interfaces.
Dependency Inversion Principle (DIP): High-level modules (like `Main` class) depend on abstractions (like command processing), rather than on concrete implementations.

Design Patterns:
Command Pattern: Used to handle various operations through command objects.
Singleton Pattern: Ensures only one instance of `VirtualClassroomManager` is created and used.

The terminal-based application is fully functional and effectively handles various classroom operations such as:
- Adding and removing classrooms and students.
- Scheduling and submitting assignments.
- Managing late submissions and assignment rescheduling.
The application is capable of performing all specified tasks and provides appropriate feedback based on user input.

Readability:  The code is organized with clear class names, method names, and comments that explain functionality.
Maintainability:  Each class and method has a clear, focused purpose, making the code easier to understand and modify.
File Structure:  Each class is placed in a separate file, adhering to standard Java conventions for file organization.

The CustomLogger class in the code handles logging by providing methods to record informational messages and errors. For instance, when a classroom is created or an assignment is scheduled, these events are logged for tracking purposes. Errors are logged with detailed messages and exception information, which helps in diagnosing issues and ensuring that significant events and errors are documented.When a classroom is added, the log entry might be: "Created classroom: Math101". If an error occurs while scheduling an assignment due to invalid input, the log entry will include: "Error: Invalid input format for scheduling. Details: [exception details]".

Exception handling is implemented with try-catch blocks throughout the code to manage errors effectively. For example, if a user inputs a command in the wrong format, the exception is caught, logged using CustomLogger, and a user-friendly message is displayed to guide the user on the correct format. This ensures that the application can handle unexpected situations gracefully without crashing.If a user inputs an invalid command like schedule_assignment Math "Homework", an exception is caught, logged, and the user is informed with: "Invalid format. Correct format: schedule_assignment <class_name> <assignment_details> <deadline(yyyy-mm-dd)>".

Transient errors, such as invalid inputs or late assignment submissions, are managed by providing clear and specific feedback to users. The application informs users when an assignment cannot be accepted due to a missed deadline or if the input format is incorrect, ensuring that users understand what went wrong and how to correct it, thereby maintaining application stability and usability.If a student tries to submit an assignment past the deadline, the application will show: "Submission deadline has passed. No longer accepting assignments." If the input format is incorrect, the error message will guide the user with the correct format to use.

Main Class:Manages user input and delegates tasks to the `VirtualClassroomManager`.
VirtualClassroomManager Class: Handles core functionalities like adding students, scheduling assignments, and submitting assignments.
Student, Classroom, and Assignment Classes: Handle their respective data and operations, demonstrating a clear separation of concerns.





