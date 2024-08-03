## Debugging and Testing

@org.jnit.test

rather than writing all the program, it's better to write tests for every unit and get every unit right

that will save you a lot of time

### Corretness Tool->Test Driven Development

idea: Write tests for every unit

### Junit Instructions

#### JUNIT Syntax

First import all the JUNIT methods you need.

```java
import static org.junit.Assert.*;
import org.junit.Test;
```

These methods follow the format below

```java
import static org.junit.Assert.*;
import org.junit.Test;

@Test
public void TestMethod(){
  assertEquals(<expected>,<actual>);
}
```

When creating JUnit test files, you should precede each test method with a @Test annotation.

All the tests should be **non-static**
