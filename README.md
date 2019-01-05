
A proof of concept to shows how to have a powerful dependency injection in Kotlin leveraging the 
Kotlin 
extensions functions

Problem description:  
We want to print a report that shows if a person is registered to a course at university
A person can register at course only if it is an user of the university.  

The refactoring in the branch **a_kind_of_magic_dependencies** shows how it is possible to:

- have an high level api authorizeAndRegisterToCourse ( in  ComposedApi ) built by composition on
 two low level api AuthApi and CourseApi. This high level api is built by composition even before 
 that the underling implementations are done 
   
- Have almost all functions without parameters ( or dependencies). For example authorizationService 
and courseService are no more present as parameters in the functions _autorize_ and _registerToCourse_  

- Have the tests very simple an **_without any infrastructure or frameworks_** .
It is easy to test the main function by injecting the related in-memory implementations.

**NOTE**: the extentions functions defined in the api are not going to pollute the code.
Since they are defined in Api interfaces they are not visible outside those interfaces or 
implementing classes.

  
References:  
    
  
[Simple Inversion of Control in Kotlin without Dependency Injection frameworks](https://www.pacoworks.com/2018/02/25/simple-dependency-injection-in-kotlin-part-1/ "Simple Inversion of Control in Kotlin without Dependency Injection frameworks")
