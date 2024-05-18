# project-management-task


### Prerequisites: 
Java Development Kit (JDK): Make sure you have a recent version of JDK installed. You can download it from https://www.oracle.com/java/technologies/downloads/.

Maven (or Gradle): A build automation tool is required to manage dependencies and build your project. You can download and install Maven from https://maven.apache.org/download.cgi

### Project setup(Bash): 
#### 1.Clone Repository
git clone https://github.com/RohhaanMane/project-management-task.git

#### 2. Navigate to the project directory:
cd project-management-task/project-management

#### 3. Install dependencies
mvn install


### REST API usage:
#### 1. Add New Project : 
The POST request is used to create a new project with the specified details. The request should include the project name, description, start date, and end date.

http://localhost:8080/projects/

![Screenshot 2024-05-18 143813](https://github.com/RohhaanMane/project-management-task/assets/53623115/04a1edc4-248c-403b-8c69-6c049d4314c1)


#### 2. Retrive All Projects : 
The GET request is used to retrieve the list of projects.

http://localhost:8080/projects/

![Screenshot 2024-05-18 143838](https://github.com/RohhaanMane/project-management-task/assets/53623115/da79046a-05e5-47c6-b960-c81b0bf5a49f)

#### 3. Retrive Project by Id : 
The GET request is used to retrieve a single project.

http://localhost:8080/projects/1

![Screenshot 2024-05-18 143849](https://github.com/RohhaanMane/project-management-task/assets/53623115/71dd8473-3cb7-492c-970e-8dce20b07988)

#### 4. Update Project : 
The PUT request is used to update the project.The request should include the fields that you want to update.

http://localhost:8080/projects/1

![Screenshot 2024-05-18 143933](https://github.com/RohhaanMane/project-management-task/assets/53623115/0a905ae4-3c09-459a-9553-1c1faa2b83ed)

#### 5. Delete Project : 
The DELETE request is used to delete the project.

http://localhost:8080/projects/1

![Screenshot 2024-05-18 143951](https://github.com/RohhaanMane/project-management-task/assets/53623115/85685286-e3cb-4d6f-99d7-d20b57d3fcb8)

