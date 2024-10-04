# Mission EasyTrain
## Fall Mouhamad, 04/10/2024

### Modele relationnel

### Utilisateur
Utilisateur(id: int(3), login: varchar(50), mdp: varchar(50), nom: varchar(50), prenom: varchar(50), dateEmbauche: datetime, role: enum('ADMIN', 'EMPLOYE'))
Clé primaire : id 
Clé étrangère : --

### Arret
Arret(id: int(3), nom: varchar(30)) 
Clé primaire : id 
Clé étrangère : --

### Trajet
Trajet(code: varchar(10), tempsDepart: datetime, tempsArrivee: datetime, arretDepartId: int(3), arretArriveeId: int(3))
Clé primaire : code 
Clé étrangère : arretDepartId référence à Arret.id, arretArriveeId référence à Arret.id
Champs unique : --


### Role
Role(enum: 'ADMIN', 'EMPLOYE') 
Clé primaire : -- 
Clé étrangère : --