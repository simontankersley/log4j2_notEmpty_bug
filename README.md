This repository helps demonstrate a potential regression in version log4j-core version 1.21.+.

### Prerequisites

* Git
* Java 17+
* maven

### Expected behaviour

Note each app_with_log4j2_*/src/resources/log4j2 configuration file contains:

```
      <PatternLayout pattern="%notEmpty{mdcField=%X{mdcField} }%msg%n"/>
```

The expectation is that log output when the mapped diagnostic context (MDC) does not contain the mdcField should no 
contain the text within the `%notEmpty` instruction.

### Steps to observe behaviour

#### Initial steps

```
git clone git@github.com:simontankersley/log4j2_notEmpty_bug.git
cd log4j2_notEmpty_bug
```

#### To see previous behaviour (in logj42 2.20.0)

```
# in log4j2_notEmpty_bug
cd app_with_log4j2_2-20-0
mvn exec:exec
cd ..
```

Observe output like:

```
a message without mdc
mdcField=hi a message with mdc
```

which is expected for the log4j2 format configuration

#### To see new buggy behaviour (in logj42 2.21.0)

```
# in log4j2_notEmpty_bug
cd app_with_log4j2_2-21-0
mvn exec:exec
cd ..
```

Observe output like:

```
mdcField= a message without mdc
mdcField=hi a message with mdc
```

which is not expected for the log4j2 format configuration
