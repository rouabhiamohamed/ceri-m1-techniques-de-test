# UCE Génie Logiciel Avancé : Techniques de tests

## Informations Personnelles

- **Nom et Prénom** : Rouabhia Mohamed
- **Groupe** : 1 CLA

## Badges
[![CircleCI](https://circleci.com/gh/rouabhiamohamed/ceri-m1-techniques-de-test.svg?style=shield)](https://circleci.com/gh/rouabhiamohamed/ceri-m1-techniques-de-test)
[![codecov](https://codecov.io/gh/rouabhiamohamed/ceri-m1-techniques-de-test/graph/badge.svg?token=WSX5HZDM4U)](https://codecov.io/gh/rouabhiamohamed/ceri-m1-techniques-de-test)
[![Checkstyle](https://img.shields.io/badge/Checkstyle-Report-blue)](https://rouabhiamohamed.github.io/ceri-m1-techniques-de-test//target/site/checkstyle.html)
## Documentation

[Javadoc documentation ](https://rouabhiamohamed.github.io/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html)

Ces badges indiquent respectivement :

- **CircleCI** : Le statut des tests et de l'intégration continue de votre projet.
- **Codecov** : La couverture des tests du projet.
- **Checkstyle** : Consultez le rapport de style du code.
---

## Introduction

Dans ce projet, vous allez mettre en application plusieurs concepts abordés en cours sur les techniques de tests. L’objectif est de développer un petit projet logiciel tout en suivant les étapes clés du processus de développement agile, en mettant l'accent sur les tests unitaires, l'intégration continue, et le développement dirigé par les tests.

Le projet suit la roadmap suivante :

1. Setup du projet
2. Mise en place des outils d’intégration continue
3. Écriture des tests unitaires
4. Écriture des mocks et validation des tests
5. Développement dirigé par les tests (TDD)
6. Documentation et conventions de style
7. Test d'une implémentation donnée

### Outils

- **Git** : Un gestionnaire de version distribué. Vous allez utiliser Git intensivement au cours de ce projet, notamment sur GitHub. Si vous ne maîtrisez pas encore Git, nous vous conseillons de consulter [ce guide](http://rogerdudler.github.io/git-guide/).

- **Outils de CI** : Vous allez configurer des outils d’intégration continue comme **CircleCI** pour automatiser les tests et faciliter l'intégration de nouvelles fonctionnalités.

---

## Sujets

Les sujets à traiter sont répartis dans le dossier `TPs`. Ce dossier contient l'ensemble des interfaces et des spécifications à implémenter dans ce projet. Le dossier `src` contient la définition des interfaces et classes que vous devrez compléter.

## Rendus

Les rendus des TPs se feront à chaque séance selon le calendrier suivant :

- **TP1** : 2ème séance
- **TP2** : 2ème séance
- **TP3** : 3ème séance
- **TP4** : 5ème séance
- **TP5** : dernière séance
- **TP6** : dernière séance

Pour chaque rendu, vous devez créer un tag à partir du commit correspondant à la complétion du TP. Si aucun tag n'est spécifié, le dernier commit à la date et l'heure de la fin de la séance sera utilisé.

---

## Choix Techniques d'Implémentation

### 1. **Outils et Technologies**

- **Java** : Langage utilisé pour développer l'application, car il est couramment utilisé dans le domaine de la programmation orientée objet et est bien adapté aux tests unitaires et à l'intégration continue.

- **JUnit 5** : Framework de test utilisé pour les tests unitaires. Il permet une grande flexibilité pour organiser les tests et les assertions.

- **Mockito** : Utilisé pour le mock de dépendances et le contrôle des comportements dans les tests unitaires. Cela permet de tester les composants isolément.

- **CircleCI** : Outil d'intégration continue utilisé pour automatiser les builds et les tests. Il assure que les tests sont exécutés à chaque changement effectué dans le code.

- **Codecov** : Outil de couverture de tests qui aide à analyser la couverture de votre code et fournit un badge que vous pouvez afficher dans votre `README`.

### 2. **Stratégie de Tests**

- **Tests unitaires** : Chaque composant du projet est testé de manière isolée pour garantir son bon fonctionnement. Les tests sont automatisés et doivent être exécutés lors de chaque commit grâce à CircleCI.

- **Mocking** : Certaines classes externes et services sont simulées à l'aide de **Mockito** pour éviter de tester des dépendances non pertinentes et permettre de se concentrer uniquement sur la logique métier.

- **Tests d'intégration** : Des tests sont également écrits pour valider l'intégration des différents composants, mais la majorité du travail porte sur les tests unitaires.

### 3. **Structure du Projet**

Le projet est organisé de manière classique avec des packages séparés pour :

- **Interfaces** : Définition des contrats (par exemple, `IPokedex`, `IPokemonFactory`).
- **Implémentations** : Classes concrètes qui implémentent les interfaces.
- **Tests** : Tous les tests unitaires et d'intégration sont regroupés dans ce package.

---

## Conclusion

Ce projet est une excellente occasion d'appliquer les bonnes pratiques de développement, en particulier le **Test-Driven Development (TDD)**, l'intégration continue, et la gestion de la couverture des tests. N'oubliez pas de consulter les badges pour suivre la progression de votre projet et assurez-vous que tous les tests sont en vert avant de soumettre.

---

## Remarque

Assurez-vous de respecter les conventions de style, de gestion de code et de rédaction de tests tout au long du projet. Cela inclut l'utilisation de noms de variables et méthodes explicites, la couverture adéquate des tests et la documentation claire de votre code.

---

### Remarques supplémentaires sur les badges :

1. **CircleCI Badge** :
    - Pour obtenir le badge CircleCI, vous devez avoir configuré un projet CircleCI pour ce dépôt GitHub. Vous pouvez obtenir le lien du badge depuis l'interface CircleCI (généralement en suivant le chemin de votre projet → `Project Settings` → `Badges`).

2. **Codecov Badge** :
    - Vous devez connecter votre projet à Codecov. Une fois cela fait, vous pouvez obtenir le badge Codecov sur votre tableau de bord de Codecov.
