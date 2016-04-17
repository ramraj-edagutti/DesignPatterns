## Factory method design pattern

1. Factory method pattern is an object creational pattern - it's used to create an object in a way that it is decoupled from its implementing system.
2. Definition of Factory Method provided in the original Gang of Four book
> Define an interface for creating an object, but let the subclasses decide which class to instantiate. The Factory method lets a class defer instantiation to subclasses
3. The Creator (Factory) hides the creation/instantiation of an Object from the client. This way client is decoupled or insulated from any future changes.
4. Client does not need to know the concrete implementation of Factory(creator) and an Object, he just needs to know the interfaces of both Factory (creator) and an Object.
5. This pattern encourages to program to an interface, i.e. polymorphism.


## When to use Factory method pattern

1. Client does not know what concrete class needs to be created at runtime, but just want to get a calss that will do the required job.


## Where Factory method patter is used

1. Logging frameworks