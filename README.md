== XSD4LD

XSD4LD is a package to handle the atomic XSD datatypes (except those
specific to XML). It provides validation and production of values for valid
lexical forms.

License: Apache License v2

Notes:

* Whitespace is not allowed around lexical forms that do not 
  include whitespace in their valid inputs.

* "INF", as per spec, not "Infinity" as found in Java.

Mapping to Java: 

As for javax.util.xml 

* Precision decimal maps to BigDecimal except when it's a NaN or INF
  when it is mapped to a Double.


| Datatype | Java Type |
|==========|===========|
| xs:integer |      BigInteger |
| Derived from xs:integer |      BigInteger |
| xs:decimal |      BigDecimal|
| xs:double |       Double|
| xs:float |        Float|
| xs:date |         XMLGregorianCalendar|
| xs:dateTime |         XMLGregorianCalendar|
| xs:dateTimeStamp |    XMLGregorianCalendar|
| xs:time |         XMLGregorianCalendar|
| xs:gDay |         XMLGregorianCalendar|
| xs:gMonth |       XMLGregorianCalendar|
| xs:gMonthDay |    XMLGregorianCalendar|
| xs:gYear |        XMLGregorianCalendar|
| xs:gYearMonth |   XMLGregorianCalendar|
| xs:duration |     Duration|
| xs:dayTimeDuration |     Duration|
| xs:yearMonthDuration |   Duration     |
| xs:hexBinary |     byte[]|
| xs:base64Binary |  byte[]|
| xs;precisionDecimal | BigDecimal or Double
