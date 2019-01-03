
A proof of concept to shows how to have a powerful dependency injection in Kotlin levaraging the 
Kotlin 
extensions functions

Problem description:  
A person can register at university course if it is an user of university.  

The refactoring in the branch **a_kind_of_magic_dependencies** show how it is possible to:

- have an high level api authorizeAndRegisterToCourse ( in  ComposedApi ) is build by composition on
 two low level api AuthApi and CourseApi. This high level api is build even before that the 
 implementations are ready 
   
- The arguments authorizationService and courseService are no more present in the functions 
autorize() and registerToCourse  

- It is easy to test the main function by injecting the in-memory implementations
  
References:    
  
[Simple Inversion of Control in Kotlin without Dependency Injection frameworks](https://www.pacoworks.com/2018/02/25/simple-dependency-injection-in-kotlin-part-1/ "Simple Inversion of Control in Kotlin without Dependency Injection frameworks")
