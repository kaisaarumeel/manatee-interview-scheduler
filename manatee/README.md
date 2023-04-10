# Manatee API

The following API is made for educational purposes only and does not provide any meaningful functionalities.

## Getting started

This project requires Java 17 or a newer version to be installed on the machine.
For developers, Amazon Coretta or Eclipse Termium are recommended JDKs.

For development purposes only, the relational H2 database is initialized in the local runtime.
On the shutdown, the database is torn down. There is no other option to set a persistent database.

### For Linux users (bash)

```bash
./gradlew build # Generates OpenAPI models, builds the application and runs tests.
./gradlew bootRun # Starts the application on a local network. 
```

### For Windows users

```bash
gradlew build # Generates OpenAPI models, builds the application and runs tests.
gradlew bootRun # Starts the application on a local network. 
```


# Summary
| Question                                 | Answer                                                                                                                                                                                                                                                                                                                                                             |
|------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Time  spent (h)                          | 8h                                                                                                                                                                                                                                                                                                                                                                 |
| Hardest task, (with reasoning)           | For me, the most difficult was modifying the GET / applications endpoint to also retrieve the scheduled interviews. I needed to create a relationship between the interviews and applications which included changing the code in many classes. I had little experience with writing mappings for Dto so this task forced me to research and experiment on my own. |
| Uncompleted tasks, if any                | Bonus task                                                                                                                                                                                                                                                                                                                                                         |
| Additional dependencies (with reasoning) | The application class was modified to have a dependency with the interviews. In order to retrieve information about interviews inside an application, the application has to store a list of its interviews. Moreover, the interview also stored a candidate, which means an additional dependency between the candidate and interview classes.                    | 


In summary, describe your overall experience with the topic, what you learned,
and any technical challenges you encountered. Your answer should be
between 50-100 words.

SUMMARY

What I loved most about this assignment is that I did not only do it to apply for the job position. I was genuinely 
interested in completing these tasks as they were quite challenging, yet rewarding. Implementing the scheduling interview 
feature required me to carefully consider the system's architecture and design, which allowed me to get deeper understanding 
of Springboot, APIs and DTOs. I especially enjoyed writing unit tests which helped me to ensure that the system was 
functioning correctly. Overall, I found the assignment quite challenging as my university courses have not yet covered 
all the topics. Thus, it was a great opportunity to learn and improve my coding skills, 
and I'm excited to see how it will be graded.

Kaisa Arumeel

