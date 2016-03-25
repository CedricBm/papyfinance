# PapyFinance
Projet Java EE de Cédric Beaumont, Iñaki Calzada, Ismail Mallasse et Yassine Ramrami.

## Installation
- Installer [Eclipse](https://eclipse.org/downloads/)
- Installer [JBoss - Wildfly](http://tools.jboss.org/downloads/jbosstools/mars/4.3.0.Final.html)
- Installer [Maven](http://www.eclipse.org/m2e/)
- Installer [xampp](https://www.apachefriends.org/fr/download.html) (pour la base de données MySQL)
- Installer [h2](http://www.h2database.com/html/download.html) (pour la base de données de tests)
- Création du projet
  - Créer un Dynamic Web Project
  - Utiliser le runtime Wildfly 8.x
  - Download and install WildFly 8.2.1 Final
  - Finish
- Configuration du projet Maven
  - Cliquer droit sur le projet > Configure > Convert to Maven Project
  - Finish
  - Skip Dependency Conversion
- Configuration git
  - Dans le dossier du projet eclipse faire:
    - git init
    - git remote add origin https://github.com/CedricBm/papyfinance.git
    - git fetch --all
    - git reset --hard origin/master
- Configuration du serveur WildFly
  - Dans l'onglet "Servers", créer un nouveau serveur
  - Choisir "WildFly 8.x"
  - Next > Next
  - Ajouter le projet PapyFinance
  - Finish

## Exécution (avec le fichier war)
- Placer le fichier war dans le dossier /standalone/deployments/ de Wildfly
- La configuration de MySQL est la suivante:
  - adresse: localhost:3306
  - nom de la base: papyfinance
  - username: root
  - password:
- Lancer MySQL
- Créer la base de données "papyfinance" (juste la base, Hibernate se chargera de créer les tables)
- Lancer le serveur Wildfly
- Se rendre sur l'url http://localhost:8080/PapyFinance/seed
- Seeder en cliquant sur la bouton
- Naviguer
- Si jamais vous ne pouviez pas utiliser l'utilisateur MySQL "root" sans mot de passe, vous pouvez changer l'utilisateur dans le fichier PapyFinance/src/hibernate.cfg.xml en modifiant ces deux lignes:
```xml
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password"></property>
```
