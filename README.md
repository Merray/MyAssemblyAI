# MyAssemblyAI
Petit programme qui utilise l'API AssemblyAI permettant de transcrire un fichier audio en texte.


1) Enregistrer un audio au format .mp3 .mp4 .ogg .wav .wma etc...

Liste complète des formats supportés par AssemblyAI : https://docs.assemblyai.com/#supported-file-types

2) Héberger l'audio où vous voulez (ex : github)

3) Renseigner le lien de l'audio dans la classe src/main/resources/constantes/Constantes.java | attribut URL_AUDIO.

4) Renseigner le code de la langue de détection voulu dans la classe src/main/resources/constantes/Constantes.java | attribut CODE_LANGUE.

Liste complète des langues supportées par AssemblyAI : https://docs.assemblyai.com/#supported-languages

5) Lancer la classe src/main/java/mainApp/MainApp.java

6) Le résultat est pour le moment écrit dans la console en fin de traitement.

Idées d'amélioration : 

1) Stocker les résultats dans un fichier texte.
2) Interface graphique via JavaFX permettant de jouer sur les paramètres 
3) Utiliser la fonction upload intégrée dans l'API qui se chargera d'héberger le fichier audio automatiquement
