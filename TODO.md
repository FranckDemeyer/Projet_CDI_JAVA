---
# Choses faites
- liste des Use Case utilisateur
- Use Case Utilisateur
- diagrammes d'activité utilisateur
- maquettes utilisateur
- déscription des Use Case utilisateur
- liste des Use Case admnistrateur
- Use Case administrateur
- diagrammes d'activité administrateur
- maquettes administrateur
---
# Choses restantes a faire
- cahier des charges
- déscription des Use Case administrateur
- faire les Use Case, les diagrammes d'activités et les maquettes et déscription textuel des Use Case pour les profils "urgence"
- Demande nouvelle fonctionnalité : Ajout bouton urgence : sélection certaines catégories (médecin, plombier, électriciens, pompiers, police ...) ->Envoi requête sur tous les éléments proches, le premier qui prend supprime pour les autres.
- identification des entités et de leur données
	- MCD
	- diagramme de classe

---

Urgence :
- Utilisateur : bouton urgence avec type service + contact + geoloc ou adresse + rayon de recherche -> envoie
- Professionel : 
	- s'enregistrer comme professionel : info, coordonnées, horaires d'ouvertures ...
	- login : téléphone
	- se loguer sur l'appli
	- envoie geoloc sinon position adresse par défaut
	- si logué et si il est sur un rayon d'une demande d'urgence, il voit la notif et peut la prendre
	- si un professionel prend une urgence, elle est marquée comme prise et ne peut plus être prise par un autre
	- si prend la garde, vois infos + lien géoloc + lien téléphone
