CREATE TABLE Credit(
    id INT PRIMARY KEY AUTO_INCREMENT, 
    libelle VARCHAR(100), 
    montant FLOAT
);
CREATE TABLE Depense(
    id INT PRIMARY KEY AUTO_INCREMENT, 
    libelle VARCHAR(100), 
    montant FLOAT, 
    credit INT,
    FOREIGN KEY(credit) REFERENCES Credit(id)
);
