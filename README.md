3DEV - Luca DELARUE et Martin PREVOT - TP API


    Rôles

Il y a deux rôles principaux dans l'application :

1. Utilisateur
    - Possibilité de se connecter et de s'inscrire
    - Possibilité d'acheter des billets pour soi-même ou pour un groupe de personnes
    - Une réduction est appliquée lors de l'achat de billets pour un groupe
    - Un historique des commandes est créé pour l'utilisateur
    - Lorsqu'une personne achète un billet, elle est inscrite à une épreuve. Lorsqu'une personne achète un lot de billets, elle doit inscrire toutes les personnes. (L'ID des personnes sera leur numéro de téléphone, et chaque billet aura un ID unique.)

2. Admin
    - Possibilité d'ouvrir et de fermer la réservation pour une épreuve
    - Possibilité d'ajouter et de supprimer des billets (il y a un nombre limité de billets disponibles)
    - Possibilité de créer une épreuve
    - Possibilité de modifier, d'annuler ou de supprimer une épreuve

    Points importants à retenir / Règles logiques et métier

- Un état est ajouté à chaque billet (indiquant si l'épreuve aura lieu ou non). Si une épreuve est annulée, l'état est défini sur "false". Si une épreuve est supprimée, les billets associés sont également supprimés.
- CRUD (Créer, Lire, Mettre à jour, Supprimer) est disponible pour Stade, Utilisateur, Épreuve, et Billet.
- Un utilisateur ne peut pas prendre un billet pour une épreuve à la même date s'il a déjà un billet pour cette date.

    Interaction

L'application peut être accessible via l'API suivante :

- API : `http://localhost:8080`

 ## UserController Routes
- GET /users
- GET /users/{id}
- POST /users
- PUT /users/{id}
- DELETE /users/{id}

## TicketController Routes
- GET /tickets
- GET /tickets/{id}
- PUT /tickets/{id}
- DELETE /tickets/{id}
- GET /tickets/user/{userId}
- POST /tickets

## StadiumController Routes
- GET /stadiums
- GET /stadiums/{id}
- POST /stadiums
- PUT /stadiums/{id}
- DELETE /stadiums/{id}

## EventController Routes
- GET /events
- GET /events/{id}
- POST /events
- PUT /events/{id}
- DELETE /events/{id}

## EpreuveController Routes
- GET /epreuves
- GET /epreuves/{id}
- POST /epreuves
- PUT /epreuves/{id}
- DELETE /epreuves/{id}
- GET /epreuves/event/{eventId}
