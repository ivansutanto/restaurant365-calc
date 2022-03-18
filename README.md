# restaurant365-calc
** NOTE:
* Compiled and Tested with JDK8
* Default operation is addition
* Setting Max value for calculation. Any number greater than that, it will be ignored, Example
```
  -DMAX_VAL=1000
   This setting to ignore a number that is greated than 1000
```
- [ ] Testing Multiplication is in progress by passing -Dop=M

## How to Run Default
> Example
```
java -jar .\Calculator-1.0-SNAPSHOT.jar
Please enter the number(s):
1\n2,3
Answer:6

Please enter the number(s):
2,1001,6
Answer:8

Please enter the number(s):
//[*][!!][r9r]\n11r9r22*hh*33!!44
Answer:110

Please enter the number(s):
//#\n2#5
Input://#\n2#5
Answer:7

Please enter the number(s):
//,\n2,ff,100
Input://,\n2,ff,100
Answer:102
```

## Hot To Run with Max Value
> Example
```
java -DMAX_VALUE=1000 -jar .\Calculator-1.0-SNAPSHOT.jar                    
Please enter the number(s):
1,1001,2
Answer:3
```

## How to Run with No Negative Number
> Example
```
java -DACCEPT_NEG_NUMBER=N -jar .\Calculator-1.0-SNAPSHOT.jar                  
Please enter the number(s):
6,-3,-2,1
Exception in thread "main" java.lang.RuntimeException: Negative Numbers Found:[-3, -2]
        at com.restaurant365.tools.ValidationDenyNegativeNumberInSet.validate(ValidationDenyNegativeNumberInSet.java:23)
        at com.restaurant365.tools.AddOps.add(AddOps.java:28)
        at com.restaurant365.tools.CalculateUtil.calculate(CalculateUtil.java:29)
        at CalculatorMain.calculate(CalculatorMain.java:26)
        at CalculatorMain.main(CalculatorMain.java:22)
 ```
 
 ## How to Run with Maximum Number of 2 digits
 > Example
``` 
java -DMAX_NUMBER_2=Y -jar .\Calculator-1.0-SNAPSHOT.jar                       
Please enter the number(s):
1,2,3
Exception in thread "main" java.lang.RuntimeException: Maximum Accepted Set of Number is 2
        at com.restaurant365.tools.ValidationMaxSetOfNumber.validate(ValidationMaxSetOfNumber.java:14)
        at com.restaurant365.tools.AddOps.add(AddOps.java:32)
        at com.restaurant365.tools.CalculateUtil.calculate(CalculateUtil.java:29)
        at CalculatorMain.calculate(CalculatorMain.java:26)
        at CalculatorMain.main(CalculatorMain.java:22)
 ```
 
