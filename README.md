Command Pattern
In your code, the Command pattern is used to handle different operations like adding a student, removing a classroom, scheduling an assignment, and submitting an assignment. Each of these operations is encapsulated as a command, which is processed based on user input. This approach separates the command execution from the user interface logic, making the system more flexible and easier to manage.

Singleton Pattern
The Singleton pattern is applied to the VirtualClassroomManager class, ensuring that only one instance of this class is created and used throughout the application. This design provides a global point of access to the VirtualClassroomManager, which centralizes the management of classrooms and assignments, preventing multiple instances from conflicting with each other.

Composite Pattern
The Composite pattern is demonstrated through the Classroom class, which manages students and assignments in a unified manner. Both individual students and assignments are handled uniformly, allowing you to add, retrieve, and manipulate these elements without differentiating between them. This pattern simplifies the management of collections and individual components by treating them in the same way.

SOLID Principles:
Single Responsibility Principle (SRP)
In your code, each class adheres to the Single Responsibility Principle by focusing on a single responsibility. For example, the VirtualClassroomManager class is responsible for managing classroom operations, including adding students and scheduling assignments. Similarly, the Student, Classroom, and Assignment classes manage their specific data and functionalities. This clear separation ensures that each class handles only its designated task, making the code easier to maintain and understand.

Open/Closed Principle (OCP)
Your code follows the Open/Closed Principle by allowing new features or commands to be added without modifying existing code. The Main class processes commands by delegating tasks to the VirtualClassroomManager, which handles various operations. This design makes it possible to extend the system with new functionalities or commands simply by adding new methods or classes, without altering the existing core logic, thus adhering to the principle of being open for extension but closed for modification.

Liskov Substitution Principle (LSP)
The Liskov Substitution Principle is maintained in your code by ensuring that derived types can be substituted for their base types without affecting the correctness of the program. For instance, if you were to add new types of commands or extend existing functionalities, they would adhere to the same interface or contract as the current implementations. This consistency ensures that new functionalities can replace or extend existing ones without breaking the system.

Interface Segregation Principle (ISP)
Your code implements the Interface Segregation Principle by ensuring that classes and modules are not forced to depend on methods they do not use. For instance, the VirtualClassroomManager only implements methods relevant to classroom management, and command handling is broken down into specific methods that are used as needed. This prevents any class from being burdened with unnecessary methods, thus maintaining a clean and focused interface.

Dependency Inversion Principle (DIP)
The Dependency Inversion Principle is followed in your code by ensuring that high-level modules do not depend on low-level modules directly but rather on abstractions. For example, the Main class, which is a high-level module, interacts with the VirtualClassroomManager, which acts as an abstraction layer. This design allows changes in low-level modules to be made without affecting high-level modules, promoting flexibility and maintainability in the code.

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





