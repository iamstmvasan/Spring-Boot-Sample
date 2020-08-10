# Spring Boot Sample Project
---
**`Required Tool`**
* Java 
* Maven [How to install `MAVEN`](https://mkyong.com/maven/how-to-install-maven-in-windows/)
* IntelliJ
* Postman
---
**`Methods Used this Project`**
---
> createStudent()
* create a two **`Student`** object and added to List.
* @RequestMapping(value = "/student/create")

> fetchAllStudents()
* Fetch all **`Student`** object's
* @RequestMapping(value = "/allStudents")

> fetchStudentByName( @PathVariable("name") String name )
* Fetch **`Student`** object by their name
* @RequestMapping(value = "/student/name/{name}")

> fetchStudentById( @PathVariable("id") int id )
* Fetch **`Student`** object by their Id
* @RequestMapping(value = "/student/id/{id}")

> fetchStudentByLanguage( @PathVariable("language") String name )
* Fetch **`Student`** object by their language
* @RequestMapping(value = "/student/language/{language}")

> addStudent( @RequestBody Student addStudent )
* Add **`Student`** object to our data
* @RequestMapping(value = "/addStudent" , method = RequestMethod.POST)

> editStudent(@RequestBody Student editStudent)
* Edit or Update **`Student`** object in our data
* @RequestMapping(value = "/editStudent" , method = RequestMethod.PUT)

> deleteStudent(@RequestBody String id)
* Delete **`Student`** object by their id in our data
* @RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
---
