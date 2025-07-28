# How JavaBeans Work

This diagram illustrates the core principles of a JavaBean and how an external client (like a JSP or another Java class) interacts with it. The client can only access the bean's properties through its public getter and setter methods, not directly.

```mermaid
graph TD
    subgraph Client [Client / Framework (e.g., JSP, Servlet)]
        direction LR
        A[Instantiate] --> B{product.setName("Laptop")}
        B --> C{product.getName()}
    end

    subgraph JavaBean [ProductBean]
        direction TB
        D(Public no-arg constructor<br> `ProductBean()`)
        E(Private properties<br> `private String name;`)
        F(Public getter/setter<br> `getName()` / `setName()`)
    end

    A -- "1. Creates instance via" --> D
    B -- "2. Writes data via" --> F
    C -- "3. Reads data via" --> F
    
    E -.-> F
    
    style Client fill:#dae8fc,stroke:#6c8ebf,stroke-width:2px
    style JavaBean fill:#d5e8d4,stroke:#82b366,stroke-width:2px
```
