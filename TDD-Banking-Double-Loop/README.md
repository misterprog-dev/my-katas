### Principe

C'est une technique qui consiste à écrire d'abord un test d'acceptation pour une fonctionnalité 
et par la suite implémenter en TDD les composants nécessaire à l'implémentation de cette fonctionnalité.

### Projet exemple
Mini projet banking. 
Nous avons un compte qui doit pouvoir:
- imprimer son rélévé
- effectuer un dépôt
- effectuer un retrait <br>

> NB: On ne doit pas connaître le format d'impression d'un rélévé car cela est lié au rélévé lui même.<br>
> => Il va falloir créer une dépendance vers une classe qui représente le rélévé et qui sera mocké dans ces tests.

### Etapes:
1. Réflechir aux dépendances de chaque composant

