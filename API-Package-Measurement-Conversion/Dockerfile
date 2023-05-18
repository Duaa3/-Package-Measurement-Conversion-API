FROM openjdk:17-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Set the working directory to /app
WORKDIR /app

# Copy the application to the container
COPY . /app
# Build the application
RUN mvn clean package

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/API-Package-Measurement-Conversion-0.0.1.jar"]
