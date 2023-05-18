# -Package-Measurement-Conversion-API
# Package Measurement Conversion

The Package Measurement Conversion project provides functionality to convert a string input into a list of package measurements based on a specific conversion rule. It includes classes for input validation, measurement conversion, and package measurement calculation.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Dockerization](#dockerization)



## Features

- Converts a string input into an array of numbers based on a specific conversion rule.
- Calculates package measurements based on the converted numbers.
- Validates the input string for correctness.

## Prerequisites

To run this project, make sure you have the following prerequisites:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Docker (optional)
- Docker Compose (optional)

## Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/yourusername/package-measurement-conversion.git
Build the project using Maven:

    cd package-measurement-conversion
    mvn clean install
## API Endpoints
The Package Measurement Conversion project exposes an API endpoint for converting string inputs into package measurements.

Convert Measurements
Endpoint: /api/measurePackage/convert-measurements

Method: GET

Parameters:

input (required): The string input to be converted into package measurements.
Response:

If the input is valid, the API returns a JSON response with the converted package measurements.
If the input is invalid, the API returns a JSON response with an error message.

## Dockerization
If you prefer to run the application in a Docker container, follow these steps:

Build the Docker image:

```shell

docker build -t package-measurement-conversion .

Run the Docker container:

docker run -p 8080:8080 package-measurement-conversi