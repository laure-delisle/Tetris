# TETRIS
###### par [Jules Baud](https://github.com/JBaud) & [Laure Delisle](https://github.com/laure-delisle)


### Projet Architecture Logicielle 4A ESIEA

 Le but de ce projet est de coder le jeu Tetris en appliquant les principes d'architecture logicielle 

>[Consignes du TP](https://github.com/MLabusquiere/TP_4A_ESIEA_Tetris)

### Building

Pour lancer le projet :
```
mvn clean install && java -jar ./target/*.jar
```

### Features
- Interface graphique (swing)
- Commandes clavier (tourner/gauche/droite/descendre)
- 7 pièces originales (I,O,T,S,Z,J,L) en couleur
- Détection et suppression de ligne pleine
- Score
- Fin de jeu

### Play

Lancer le projet (cf Building) puis:
> 
- SPACE = tourner
- LEFT ARROW = déplacer à gauche
- RIGHT ARROW = déplacer à droite
- DOWN ARROW = déplacer vers le bas

### Architecture

Nous avons choisi d'implémenter l'architecture MVC. L'ensemble du projet est packagé afin de respecter cette architecture : 
- fr.esiea.tetris --> main
- fr.esiea.tetris.controler --> contrôleur
- fr.esiea.tetris.model --> modèle
- fr.esiea.tetris.view --> vue

Voici un UML simplifié du projet :
![Alt text](mvc.png?raw=true "MVC UML")

Cette architecture a permis une implémentation complètement indépendante du Model et de la View. Le Controler est la pierre angulaire de cette architecture. Il reçoit les événements de l'utilisateur (grâce à un listener), et transmet les modifications au Model. Celui-ci indique en retour si des changements sont à prévoir sur la View. Le Controler transmet les modifications visuelles à la View, lors du mouvement des pièces, du changement de score, de ligne complétée, de nouvelle pièce, et de fin de jeu.

Au sein de la View comme du Model, la classe mère agit sur des objets auxiliaires (par exemple la Board, le Tetrimino et le Score pour le Model) et appelle leurs méthodes au besoin selon les informations reçues du Controler.

### Design patterns

| Design Pattern | Utilisation           | 
| :----- |:-------------| 
Façade	| 	Utilisé pour masquer le contrôleur dans le main. La classe Controler instancie plusieurs objets (View, Model) et lance plusieurs méthodes sur ces objets (updateScore, displayBoard, newTetrimino...). |
Listener | Utilisé par le contrôleur pour récupérer les événements au clavier. Les événements déclenchent des actions de déplacement de la pièce, en appelant des méthodes du modèle. |
Singleton | Utilisé sur le tetrimino pour s'assurer qu'une seule instance de la classe existe. Dès que le tetrimino est posé, l'instance est "recyclée" pour la pièce suivante.|

### Static analysis & Code coverage

Outils utilisés:

| Outil | Utilisation           | 
| :----- |:-------------| 
FindBugs | Analyse statique. Identification du code redondant, du code non utilisé. |
EclEmma | Code coverage. Identification du code utilisé lors de l'exécution de l'application Java, et du code peu utilisé qui a été factorisé de façon inutile. Identification du code couvert par les tests JUnit. |
JUnit | Code Coverage = 74%. |
