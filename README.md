# DISSENY D'ESTRUCTURES DE DADES (DED - 05613)

**UOC - Universitat Oberta de Catalunya**

**ACTIVITAT: Exercici Pràctic #2** 

**ALUMNE: Bericat Ruz, Jordi** 

**SEMESTRE: Tardor-2020/21** 

**GITHUB REPO: UOC-Assignments/uoc.ded.ep2** 


## DOCUMENTACIÓ DEL CODI:

Pel que fa als detalls d'implementació, degut a la "grandaria" del projecte s'ha cregut convenient afegir els comentaris que expliquen cada decisió d'implementació als fitxers font adjunts en la entrega, en comptes d'incloure-l's en aquest fitxer README.md. De la mateixa manera, el fitxer de test "Trial4C19EP2TestExtended.java" esmentat seguidament també inclou un seguit de comentaris amb el màxim de detall possible. 
 
## JOCS DE PROVES:

Per a comprovar que les implementacions realitzades al projecte són fidels als requisits establerts a l'enunciat, s'ha dissenyat un joc de proves JUNIT4 addicional als proporcionats:

 #1 - Fitxer /src/test/java/FactoryTrial4C19Extended.java
 
 #2 - Fitxer /src/test/java/Trial4C19EP2TestExtended.java 

 Tant pel que fa al jocs de proves proporcionats al enunciat, com al especificat a dalt, cal destacar que la implementació del TAD "Trial4C19Impl.java" realitzada (així com de les estructures que aquest inclou)  **superen totes les proves**.

## CONSIDERACIONS ADDICIONALS:

 La implementació necessària per a obtenir "mostActiveUser" i "mostActiveTrial" s'ha realitzat de manera que cada cop que s'afegeix una resposta al sistema es calculen aquestes dues dades. Per assolir aquest objectiu s'han definit dos mètodes auxiliars a Trial4C19Impl.java; "establirUsuariMesActiu" i "establirAssaigMesActiu". Pel que fa la resta d'implementacions demanades, s'ha realitzat tant una depuració exahustiva, 
 com una sèrie de test que validen el seu correcte funcionament (centrant-me sobretot en el testeig de les implementacions "OrderedVector" i "DiccionariOrderedVector", així com en la implementació de la cua de preguntes, la qual he cregut adient fer amb una estructura "circular").
