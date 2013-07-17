VizHash4j
=========

A Java version of VizHash, a visual hash library
(thanks to [sebsauvage](https://github.com/sebsauvage) for the original PHP version, see [the dedicated repository](https://github.com/sebsauvage/VizHash) for more information).
It has been made to be compatible with the original version of [sebsauvage](https://github.com/sebsauvage), however the compatibility is not guaranteed.

## Use it

Copy file VizHashPanel.java in your project (you will probably need to adjust the package name to your own).
Then you just need to instantiate the panel and give it a String value to hash.
```java
VizHashPanel pane = new VizHashPanel();
pane.setValue("valueToHash");
```
For an example in a real program, have a look at the content of VizHashFrame.java

## Try it

Retrieve the sources, compile the program and launch the demo !
``` bash
git clone https://github.com/inouire/VizHash4j
javac *.java
java VizHashFrame
```


