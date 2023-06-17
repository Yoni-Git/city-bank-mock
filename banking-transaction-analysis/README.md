# CityBank Interview - Banking Transaction Analysis

This project implements a banking transaction analysis application for the CityBank interview.

## Structure

The project follows the following structure:

- `service.TransactionAnalyzer.java`: Contains the implementation of the `service.TransactionAnalyzer` class. This class handles the analysis of banking transactions and applies security measures based on annotations.
- `dao.TransactionRepository.java`: Contains the implementation of the `dao.TransactionRepository` class. This class handles the persistence and retrieval of banking transactions.
- `security.SecureTransactionAnalysis.java`: Contains the implementation of the `security.SecureTransactionAnalysis` annotation. This custom annotation is used to annotate methods in the `service.TransactionAnalyzer` class to indicate that security measures should be applied to those methods.
- `domain.User.java`: Contains the implementation of the `domain.User` class. This class represents a user with a username, password, and role.
- `MainApplication.java`: Contains the implementation of the main application class. This class demonstrates the usage of the `service.TransactionAnalyzer` class for analyzing transactions.
- `TransactionAnalyzerTest.java`: Contains the unit tests for the `service.TransactionAnalyzer` class. This class includes test cases to verify the behavior and correctness of the `service.TransactionAnalyzer` methods.
- `application.properties`: Contains the application-specific configuration properties. This file can be used to configure various properties related to the application.

## Usage

To use the application, run the `MainApplication` class, which provides an example usage of the `service.TransactionAnalyzer` class.

## Contributing

Feel free to contribute to this project by opening pull requests or reporting issues.

## License

This project is licensed under the [MIT License](LICENSE).
