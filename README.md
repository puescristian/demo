# Test automation in serenity

To run this test, you must have Gradle installed 

https://gradle.org/install/

the test creates a business unit with its parent with random values, and also schedules a meeting with this unit

## Use Gradle

Open a command window and run:

    gradle test -Denvironment=qa
    gradle test -Denvironment=pre



## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity/index.html` directory. Go take a look!

