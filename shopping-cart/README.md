taxes
=====

Story: Calcul de taxes
======================

Enonc�
------
Aucun taxe n'est appliqu�e sur les produits de premi�res n�cessit�s, � savoir la nourriture et les m�dicaments.
Une taxe sur la valeur ajout�e de 10% est appliqu�e sur les livres.
Une taxe sur la valeur ajout�e de 20% est appliqu�e sur tous les autres produits.

Une taxe additionnelle de 5% est appliqu�e sur les produits import�s, sans exception.

Le montant de chacune des taxes est arrondi aux 5 centimes sup�rieurs, selon la r�gle suivante :

| Taxe calcul�e | Taxe imput�e |
|---------------|--------------|
|          0.99 |         1.00 |
|          1.00 |         1.00 |
|          1.01 |         1.05 |
|          1.02 |         1.05 |

Lorsque l'on passe une commande, une facture est �mise listant chacun des produits ainsi que leur
prix TTC ; au bas de la facture figurent le montant total (TTC) ainsi que le montant total des taxes.
Le montant TTC est calcul� comme suit :
Pttc = Pht + somme(arrondi(Pht*t/100))
Pttc: Prix TTC
Pht : Prix hors taxes
t : taxe applicable

Ecrire une application, ex�cutable sur une JVM 1.8, qui imprime la facture d�taill�e pour chacun des
paniers suivants :

 
### INPUT

#### Input 1

* 2 livres � 12.49�
* 1 CD musical � 14.99�
* 3 barres de chocolat � 0.85�

#### Input 2

* 2 bo�tes de chocolats import�e � 10�
* 3 flacons de parfum import� � 47.50�

#### Input 3

* 2 flacons de parfum import� � 27.99�
* 1 flacon de parfum � 18.99�
* 3 bo�tes de pilules contre la migraine � 9.75�
* 2 bo�tes de chocolats import�s � 11.25�

### OUTPUT

#### Output 1

* 2 livres � 12.49� : 27,5� TTC
* 1 CD musical � 14.99� : 18� TTC
* 3 barres de chocolat � 0.85� : 2.55� TTC

Montant des taxes : 5.53�
Total : 48.05�

#### Output 2

* 2 bo�tes de chocolats import�e � 10� : 21�
* 3 flacons de parfum import� � 47.50� : 178,15�

Montant des taxes : 36.65�
Total : 199.15�

#### Output 3

* 2 flacons de parfum import� � 27.99� : 70�
* 1 flacon de parfum � 18.99� : 22.8�
* 3 bo�tes de pilules contre la migraine � 9.75� : 29.25�
* 2 bo�tes de chocolats import�s � 11.25� : 23.65�

Montant des taxes : 18.98
Total : 145,7
