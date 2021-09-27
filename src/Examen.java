import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examen {
    public List<Boolean> question1(){
        /*
        Pondération: 15%
        Pour réussir cette question, vous devez retourner le résultat d'un appel à Collider.getColliderList().
        Collider.getColliderList() prend un seul paramètre, une expression lambda, qui prend elle même deux paramètres:
        un Point et un Rect. Référez-vous à ces classes pour connaître leur structure. Notez que les rectangles
        sont définis par le point en haut à gauche et le point en bas à droite, et non par la largeur et la hauteur.

        Votre expression lambda doit déterminer s'il y a collision entre le point et le rectangle qui lui sont passés
        en paramètres, en retournant un booléen.

        Il y a collision si le point respecte toutes les conditions suivantes:
            - Il est sous le côté en haut du rectangle
            - Il est au-dessus du côté en bas du rectangle
            - Il est à droite du côté gauche du rectangle
            - Il est à gauche du côté droit du rectangle

         Vous pouvez consulter "collision.png" pour vous aider
         */

        return Collider.getColliderList((o1, o2) -> {
            if (o1.getY() > o2.getY1())
                if (o1.getY() < o2.getY2())
                    if (o1.getX() > o2.getX1())
                        if (o1.getX() < o2.getX2()){
                            return true;
                        }
            return false;

        });
    }

    public String question2(List<String> contenu){
        /*
        Pondération: 15%
        Pour réussir cette question, vous devez utiliser les streams sur la liste en paramètre (contenu) pour réaliser
        les actions suivantes:
         - Mettre les chaînes de caractères en minuscule
         - Retirer la sous-chaîne "null" de toutes les chaînes
            (indice: utilisez String.replaceAll. Remplacez par la chaîne vide "" pour retirer)
         - Garder seulement les chaînes contenant la chaîne "password" (indice: utilisez String.contains)
         - Retourner une chaîne de caractères avec un élément par ligne
         */
        return contenu.stream().map((s)-> s.toLowerCase(Locale.ROOT)).map((s) -> s.replaceAll("null","")).map((s)->s.contains("password")).collect(Collectors.toList()).toString();

    }

    public List<Integer> question3(){
        /*
        Pondération: 15%
        Pour réussir cette question, vous devez utiliser un Infinite Stream pour trouver les 10 premiers cubes
        parfaits pairs.
        Pour rappel, un cube parfait est un entier dont la racine cubique est aussi un entier.
        Indice: Pour générer les cubes parfaits, transformez les nombres de 2 à ... en leur cube
         */
        List<Integer>integerList;
        integerList = IntStream.iterate(2,(n) -> n+1).map((n)->n*n).filter((n)->!(n==0)).limit(10).boxed().collect(Collectors.toList());
        return integerList;
    }

    public void question4(Stage stage){
        /*
        Pondération: 20%
        Pour réussir cette question, vous devez implémenter un "Pile ou Face".
        Le Stage vous est fourni en paramètre. Vous devez afficher un Label et deux boutons.
        Lors du clic sur un bouton, le programme doit piger au hasard si le résultat est pile ou face.
        Le label doit afficher si l'utilisateur a choisi le bon.
        Le Stage vous est passé tel quel et aucune modification n'a été apportée.
         */
        stage.setTitle("Pile ou face");
        stage.setWidth(1000);
        stage.setHeight(700);
        Button button2 = new Button("Pile");
        Button button = new Button("Face");
        Label texte1 = new Label();
        String reponse;
        Group group = new Group();


        texte1.setScaleX(3);
        texte1.setScaleY(3);
        texte1.setTranslateX(400);
        texte1.setTranslateY(100);

        button.setScaleY(5);
        button.setScaleX(5);
        button2.setScaleX(5);
        button2.setScaleY(5);

        button.setTranslateY(300);
        button.setTranslateX(200);
        button2.setTranslateX(700);
        button2.setTranslateY(300);

        Double tirageAuSort;

        tirageAuSort = Math.random()*100;

        if (tirageAuSort<50){
            reponse = "Pile est le bon";
        }else
            reponse = "Face est le bon";


        button.setOnMouseClicked(mouseEvent -> {texte1.setText(reponse);});
        button2.setOnMouseClicked(mouseEvent -> {texte1.setText(reponse);});
        group.getChildren().addAll(button,button2,texte1);
        stage.setScene(new Scene(group));
        stage.show();



    }

    public void question5(Stage stage){
        /*
        Pondération: 35%
        Pour réussir cette question, vous devez recréer le dessin animé que vous trouverez dans le fichier
        "question5_resultat.PNG" dans le Stage qui vous est fourni en paramètre.
        Voici une liste des couleurs utilisées:
         - BLACK
         - GREY
         - DARKRED
         - DARKCYAN
         - DARKBLUE
         - DARKGREEN
         - DARKORANGE
         - DARKMAGENTA
         - DARKOLIVEGREEN
         */

        stage.setTitle("Train");
        stage.setHeight(700);
        stage.setWidth(1000);
        Group trainComplet = new Group();
        Rectangle rectanglePrincipal = new Rectangle(200,300,Color.DARKRED);
        Rectangle fenetre = new Rectangle(150,75,Color.DARKCYAN);
        Rectangle rectangleDuBas = new Rectangle(600,200,Color.BLACK);
        Rectangle rectangleDuMilieu = new Rectangle(400,150,Color.DARKBLUE);
        Polygon triangle = new Polygon(700,400,700,600,900,600);
        Arc arc = new Arc(100,100,100,100,-50,100);
        Rectangle chemine = new Rectangle(50,100,Color.DARKGREEN);
        Circle roue1 = new Circle();
        Circle roue2 = new Circle();
        Circle roue3 = new Circle();
        Circle roue4 = new Circle();


        roue1.setFill(Color.GRAY);
        roue2.setFill(Color.GRAY);
        roue3.setFill(Color.GRAY);
        roue4.setFill(Color.GRAY);

        roue1.setRadius(50);
        roue1.setTranslateY(600);
        roue1.setTranslateX(150);

        roue2.setRadius(50);
        roue2.setTranslateY(600);
        roue2.setTranslateX(300);

        roue3.setRadius(50);
        roue3.setTranslateY(600);
        roue3.setTranslateX(450);

        roue4.setRadius(50);
        roue4.setTranslateY(600);
        roue4.setTranslateX(600);

        arc.setType(ArcType.CHORD);
        arc.setFill(Color.DARKOLIVEGREEN);
        arc.setTranslateY(225);
        arc.setTranslateX(535);

        rectanglePrincipal.setTranslateY(100);
        rectanglePrincipal.setTranslateX(100);

        fenetre.setTranslateX(125);
        fenetre.setTranslateY(120);

        rectangleDuBas.setTranslateX(100);
        rectangleDuBas.setTranslateY(400);

        rectangleDuMilieu.setTranslateX(300);
        rectangleDuMilieu.setTranslateY(250);

        triangle.setFill(Color.DARKMAGENTA);

        chemine.setTranslateY(150);
        chemine.setTranslateX(500);


        trainComplet.getChildren().addAll(rectanglePrincipal,fenetre,rectangleDuBas,rectangleDuMilieu,triangle,arc,chemine,roue1,roue2,roue3,roue4);
        stage.setScene(new Scene(trainComplet));
        stage.show();

    }
}