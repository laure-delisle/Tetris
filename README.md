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
- Commandes clavier (space/left/right/down)
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

### Design patterns

| Design Pattern | Utilisation           | 
| :----- |:-------------| 
Façade	| 	Utilisé pour masquer le contrôleur dans le main. La classe Controler instancie plusieurs objets (View, Model) et lance plusieurs méthodes sur ces objets (updateScore, displayBoard, newTetrimino...). |
Listener | Utilisé par le contrôleur pour récupérer les événements au clavier. Les événements déclenchent des actions de déplacement de la pièce, en appelant des méthodes du modèle. |
Singleton | Utilisé sur le tetrimino pour s'assurer qu'une seule instance de la classe existe. Dès que le tetrimino est posé, l'instance est "recyclée" pour la pièce suivante.|




