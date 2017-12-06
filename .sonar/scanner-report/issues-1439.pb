o
squidS2975SRemove this "clone" implementation; use a copy constructor or copy factory instead. 2mm ý
squidS3824NReplace this "Map.get()" and condition with a call to "Map.computeIfAbsent()". 2
·· +:Ž
6Ÿ
»» "%'Map.put()' is invoked with same key.
*Ÿ
¸¸ Implies 'cm' can be null.
(Ÿ
·· #'Map.get()' is invoked.d
squidS1182HUse super.clone() to create and seed the cloned instance to be returned. 2mm 