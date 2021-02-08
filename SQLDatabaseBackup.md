# SQL Database Backup

## Reasons
In order to save expenses, the database will be created on a need basis.

## Main Details

The sql database link is: `viena-map.database.windows.net`

The sql database name is: `VienaDatabase`

The sql database user is: `adminISI`

The sql database pass is: `!passw0rd`

## List of tables

1. DETALII_ACTIVITATE
2. DRUMETII
3. OBIECTIVE_TURISTICE
4. PARCURI
5. PUNCT_POLILINIE
6. TRASEE_TURISTICE

## DDLs

1.  DETALII_ACTIVITATE

```sql
CREATE TABLE VienaDatabase.dbo.DETALII_ACTIVITATE (
	ID int IDENTITY(0,1) NOT NULL,
	X_min decimal(10,7) NOT NULL,
	X_max decimal(10,7) NOT NULL,
	Y_min decimal(10,7) NOT NULL,
	Y_max decimal(10,7) NOT NULL,
	CONSTRAINT Detalii_activitate_PK PRIMARY KEY (ID)
) GO;
```

2. DRUMETII

```sql
CREATE TABLE VienaDatabase.dbo.DRUMETII (
	ID int IDENTITY(0,1) NOT NULL,
	ID_detaliu int NOT NULL,
	Nume nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Lungime int NOT NULL,
	Durata int NOT NULL,
	Grad_dificultate int NOT NULL,
	CONSTRAINT DRUMETII_PK PRIMARY KEY (ID)
) GO;


-- VienaDatabase.dbo.DRUMETII foreign keys

ALTER TABLE VienaDatabase.dbo.DRUMETII ADD CONSTRAINT DRUMETII_FK FOREIGN KEY (ID_detaliu) REFERENCES VienaDatabase.dbo.DETALII_ACTIVITATE(ID) GO;
```

3. OBIECTIVE_TURISTICE

```sql
CREATE TABLE VienaDatabase.dbo.OBIECTIVE_TURISTICE (
	ID int IDENTITY(0,1) NOT NULL,
	ID_detaliu int NOT NULL,
	Nume nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Url nvarchar(400) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Descriere nvarchar(1000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT OBIECTIVE_TURISTICE_PK PRIMARY KEY (ID)
) GO;


-- VienaDatabase.dbo.OBIECTIVE_TURISTICE foreign keys

ALTER TABLE VienaDatabase.dbo.OBIECTIVE_TURISTICE ADD CONSTRAINT OBIECTIVE_TURISTICE_FK FOREIGN KEY (ID_detaliu) REFERENCES VienaDatabase.dbo.DETALII_ACTIVITATE(ID) GO;
```

4. PARCURI

```sql
CREATE TABLE VienaDatabase.dbo.PARCURI (
	ID int IDENTITY(0,1) NOT NULL,
	ID_detaliu int NOT NULL,
	Nume nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Suprafata int NOT NULL,
	Locuri_joaca nvarchar(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Spatii_animale nvarchar(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PARCURI_PK PRIMARY KEY (ID)
) GO;


-- VienaDatabase.dbo.PARCURI foreign keys

ALTER TABLE VienaDatabase.dbo.PARCURI ADD CONSTRAINT PARCURI_FK FOREIGN KEY (ID_detaliu) REFERENCES VienaDatabase.dbo.DETALII_ACTIVITATE(ID) GO;
```

5. PUNCT_POLILINIE

```sql
CREATE TABLE VienaDatabase.dbo.PUNCT_POLILINIE (
	Id_Obiect int NOT NULL,
	Numar_Secventa int NOT NULL,
	X decimal(10,7) NULL,
	Y decimal(10,7) NULL,
	Tip_Obiect nvarchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PUNCT_POLILINIE_PK PRIMARY KEY (Id_Obiect,Numar_Secventa,Tip_Obiect)
) GO;
```

6. TRASEE_TURISTICE

```sql
CREATE TABLE VienaDatabase.dbo.TRASEE_TURISTICE (
	ID int IDENTITY(0,1) NOT NULL,
	ID_detaliu int NOT NULL,
	Nume nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Lungime int NOT NULL,
	Numar_obiective int NOT NULL,
	CONSTRAINT TRASEE_TURISTICE_PK PRIMARY KEY (ID)
) GO;


-- VienaDatabase.dbo.TRASEE_TURISTICE foreign keys

ALTER TABLE VienaDatabase.dbo.TRASEE_TURISTICE ADD CONSTRAINT TRASEE_TURISTICE_FK FOREIGN KEY (ID_detaliu) REFERENCES VienaDatabase.dbo.DETALII_ACTIVITATE(ID) GO;
```

## Model Data

1.  DETALII_ACTIVITATE

```sql
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(0, 16.3972100, 16.3972100, 48.2455000, 48.2455000);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(6, 16.3630270, 16.3630270, 48.2596980, 48.2596980);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(7, 16.3174070, 16.3174070, 48.2540740, 48.2540740);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(8, 16.2910050, 16.2910050, 48.2335820, 48.2335820);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(9, 16.3115050, 16.3115050, 48.2118740, 48.2118740);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(10, 16.4205360, 16.4205360, 48.2983310, 48.2983310);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(11, 16.2624960, 16.2624960, 48.1329280, 48.1329280);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(12, 16.3906230, 16.3906230, 48.1650250, 48.1650250);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(13, 16.2307070, 16.2307070, 48.2463910, 48.2463910);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(14, 16.3930100, 16.3930100, 48.2172630, 48.2172630);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(15, 16.4821370, 16.4821370, 48.2680470, 48.2680470);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(16, 16.3435900, 16.3435900, 48.1883510, 48.1883510);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(21, 16.3397130, 16.3397130, 48.2569780, 48.2569780);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(22, 16.3413090, 16.3413090, 48.2562160, 48.2562160);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(23, 16.3376610, 16.3376610, 48.2581960, 48.2581960);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(24, 16.3376030, 16.3376030, 48.2506200, 48.2506200);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(25, 16.3592090, 16.3592090, 48.2531680, 48.2531680);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(26, 16.3580090, 16.3580090, 48.2471530, 48.2471530);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(27, 16.3332720, 16.3332720, 48.2355060, 48.2355060);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(28, 16.3120180, 16.3120180, 48.2310110, 48.2310110);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(29, 16.3145270, 16.3145270, 48.2262140, 48.2262140);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(30, 16.3261510, 16.3261510, 48.2215330, 48.2215330);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(31, 16.3064960, 16.3064960, 48.2206160, 48.2206160);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(32, 16.2828480, 16.2828480, 48.2258990, 48.2258990);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(33, 16.3196620, 16.3196620, 48.2035250, 48.2035250);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(34, 16.3555360, 16.3555360, 48.1878770, 48.1878770);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(35, 16.3404480, 16.3404480, 48.1880690, 48.1880690);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(36, 16.3341860, 16.3341860, 48.1846800, 48.1846800);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(37, 16.3584330, 16.3584330, 48.1718670, 48.1718670);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(38, 16.3537100, 16.3537100, 48.1753130, 48.1753130);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(39, 16.3553630, 16.3553630, 48.1814240, 48.1814240);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(40, 16.3587770, 16.3587770, 48.1778250, 48.1778250);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(41, 16.3496100, 16.3496100, 48.1698890, 48.1698890);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(42, 16.3519990, 16.3519990, 48.1658720, 48.1658720);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(43, 16.3677640, 16.3677640, 48.1663450, 48.1663450);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(44, 16.3881930, 16.3881930, 48.1647190, 48.1647190);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(45, 16.4852690, 16.4852690, 48.1596760, 48.1596760);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(46, 16.4759930, 16.4759930, 48.1591360, 48.1591360);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(47, 16.4720050, 16.4720050, 48.1572560, 48.1572560);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(48, 16.4716710, 16.4716710, 48.1600540, 48.1600540);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(49, 16.4681420, 16.4681420, 48.1599250, 48.1599250);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(50, 16.4700620, 16.4700620, 48.1542690, 48.1542690);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(51, 16.4703930, 16.4703930, 48.1501380, 48.1501380);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(52, 16.4659590, 16.4659590, 48.1518760, 48.1518760);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(53, 16.4626140, 16.4626140, 48.1564670, 48.1564670);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(54, 16.4609000, 16.4609000, 48.1535560, 48.1535560);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(55, 16.4553870, 16.4553870, 48.1560560, 48.1560560);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(56, 16.4499240, 16.4499240, 48.1559280, 48.1559280);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(57, 16.4426520, 16.4426520, 48.1613600, 48.1613600);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(58, 16.4403660, 16.4403660, 48.1565080, 48.1565080);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(59, 16.4248330, 16.4248330, 48.1570350, 48.1570350);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(60, 16.3933770, 16.3933770, 48.2111660, 48.2111660);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(61, 16.3955480, 16.3955480, 48.2163430, 48.2163430);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(62, 16.3955480, 16.3955480, 48.2163430, 48.2163430);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(63, 16.3816400, 16.3816400, 48.2075170, 48.2075170);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(64, 16.3809590, 16.3809590, 48.2101060, 48.2101060);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(65, 16.3727630, 16.3727630, 48.2084640, 48.2084640);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(66, 16.3731010, 16.3731010, 48.2038960, 48.2038960);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(67, 16.3692280, 16.3692280, 48.2032880, 48.2032880);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(68, 16.3614860, 16.3614860, 48.2102190, 48.2102190);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(69, 16.3571570, 16.3571570, 48.2106760, 48.2106760);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(70, 16.3597750, 16.3597750, 48.2050790, 48.2050790);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(71, 16.3798160, 16.3798160, 48.1968880, 48.1968880);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(72, 16.4013800, 16.4013800, 48.1826390, 48.1826390);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(73, 16.4103400, 16.4103400, 48.2398930, 48.2398930);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(74, 16.3055090, 16.3055090, 48.1872220, 48.1872220);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(75, 16.3128000, 16.3128000, 48.1858000, 48.1858000);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(76, 16.3661000, 16.3661000, 48.2077000, 48.2077000);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(77, 16.3673300, 16.3673300, 48.2078780, 48.2078780);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(78, 16.3699340, 16.3699340, 48.2055930, 48.2055930);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(79, 16.3664880, 16.3664880, 48.2053850, 48.2053850);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(80, 16.3718000, 16.3718000, 48.1982000, 48.1982000);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(81, 16.3586160, 16.3586160, 48.1915790, 48.1915790);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(82, 16.3747230, 16.3747230, 48.2116520, 48.2116520);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(83, 16.4061340, 16.4061340, 48.2095410, 48.2095410);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(84, 16.3064190, 16.3064190, 48.2246540, 48.2246540);
INSERT INTO VienaDatabase.dbo.DETALII_ACTIVITATE
(ID, X_min, X_max, Y_min, Y_max)
VALUES(85, 16.3608940, 16.3608940, 48.2598230, 48.2598230);
```

2. DRUMETII

```sql
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(0, 6, 'Kahlenberg-Leopoldsberg', 11, 240, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(1, 7, 'Hermannskogel', 10, 180, 2);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(2, 8, 'Hameau', 11, 210, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(3, 9, 'Jubiläumswarte-Ottakring', 17, 300, 4);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(4, 10, 'Bisamberg', 10, 200, 2);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(5, 11, 'Zugberg-Maurer Wald', 13, 270, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(6, 12, 'Laaer Berg', 15, 300, 4);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(7, 13, 'Sophienalpe', 11, 240, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(8, 14, 'Prater', 13, 180, 2);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(9, 15, 'Franz-Karl-Effenberg hiking trail', 7, 105, 1);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(10, 16, 'Urban community housing hiking trail', 4, 120, 1);
```

3. OBIECTIVE_TURISTICE

```sql
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(0, 6, 'Kahlenberg-Leopoldsberg', 11, 240, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(1, 7, 'Hermannskogel', 10, 180, 2);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(2, 8, 'Hameau', 11, 210, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(3, 9, 'Jubiläumswarte-Ottakring', 17, 300, 4);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(4, 10, 'Bisamberg', 10, 200, 2);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(5, 11, 'Zugberg-Maurer Wald', 13, 270, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(6, 12, 'Laaer Berg', 15, 300, 4);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(7, 13, 'Sophienalpe', 11, 240, 3);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(8, 14, 'Prater', 13, 180, 2);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(9, 15, 'Franz-Karl-Effenberg hiking trail', 7, 105, 1);
INSERT INTO VienaDatabase.dbo.DRUMETII
(ID, ID_detaliu, Nume, Lungime, Durata, Grad_dificultate)
VALUES(10, 16, 'Urban community housing hiking trail', 4, 120, 1);
```

4. PARCURI

```sql
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(17, 21, 'Franz-Hengl-Park', 306, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(18, 22, 'PA Ortskern Grinzing', 1373, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(19, 23, 'PA Peter-Alexander-Platz', 1041, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(20, 24, 'Anna-Ehm-Park', 4732, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(21, 25, 'Heiligenstädter Park', 50796, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(22, 26, 'PA Klabundgasse', 2871, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(23, 27, 'Türkenschanzpark', 149181, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(24, 28, 'Moriz-Mayer-Park', 2661, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(25, 29, 'GA Alszeile', 4359, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(26, 30, 'Hermine-Weinreb-Park', 740, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(27, 31, 'PA Nietzscheplatz', 1872, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(28, 32, 'PA Röntgengasse', 2159, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(29, 33, 'GA Auf der Schmelz', 4567, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(30, 34, 'Bacherpark', 6106, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(31, 35, 'GA Gaudenzdorfer Knoten', 10983, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(32, 36, 'PA Bruno-Pittermann-Platz', 3703, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(33, 37, 'Fortunapark', 10919, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(34, 38, 'Martin-Luther-King-Park', 14506, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(35, 39, 'PA Leopold-Rister-Gasse', 4604, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(36, 40, 'PA Knöllgasse', 2549, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(37, 41, 'PA Eschenallee', 3010, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(38, 42, 'Otto-Benesch-Park', 15888, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(39, 43, 'PA Migerkastraße', 504, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(40, 44, 'PA Fischhofgasse', 7132, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(41, 45, 'PA Mannswörther Straße', 1941, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(42, 46, 'PA Münnichplatz', 6262, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(43, 47, 'PA Muhrhoferweg', 7152, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(44, 48, 'Hans-Paulas-Park', 10160, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(45, 49, 'Trpinpark', 3446, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(46, 50, 'PA Flammweg', 7068, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(47, 51, 'PA Paul-Heyse-Gasse', 3236, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(48, 52, 'PA Csokorgasse', 6198, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(49, 53, 'Hofgartel', 19627, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(50, 54, 'PA Am Leberberg', 27039, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(51, 55, 'PA Herretweg', 2598, 'N', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(52, 56, 'PA Zehngrafweg', 3887, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(53, 57, 'Schloß Neugebäude - Unterer Garten', 17129, 'Y', 'Y');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(54, 58, 'GA Feuerhalle Simmering', 30656, 'Y', 'N');
INSERT INTO VienaDatabase.dbo.PARCURI
(ID, ID_detaliu, Nume, Suprafata, Locuri_joaca, Spatii_animale)
VALUES(55, 59, 'PA Pretschgasse', 6287, 'Y', 'Y');
```

5. PUNCT_POLILINIE

```sql
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 0, 16.3630270, 48.2596980, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 1, 16.3620010, 48.2600220, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 2, 16.3617160, 48.2608210, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 3, 16.3650520, 48.2628760, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 4, 16.3635700, 48.2634100, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 5, 16.3644830, 48.2644370, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 6, 16.3636570, 48.2651040, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 7, 16.3610620, 48.2653900, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 8, 16.3598370, 48.2663610, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 9, 16.3537640, 48.2663050, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 10, 16.3494020, 48.2672380, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 11, 16.3427020, 48.2692760, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 12, 16.3438110, 48.2702650, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 13, 16.3436970, 48.2721690, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 14, 16.3431840, 48.2748910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 15, 16.3440400, 48.2755000, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 16, 16.3459540, 48.2749980, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 17, 16.3476830, 48.2750100, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 18, 16.3513540, 48.2749850, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 19, 16.3517920, 48.2746400, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 20, 16.3540880, 48.2747920, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 21, 16.3549900, 48.2747050, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 22, 16.3557270, 48.2739450, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 23, 16.3559570, 48.2740060, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 24, 16.3558240, 48.2746230, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 25, 16.3551380, 48.2755920, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 26, 16.3542470, 48.2763390, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 27, 16.3542900, 48.2759010, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 28, 16.3536910, 48.2761960, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 29, 16.3523930, 48.2760820, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 30, 16.3530640, 48.2764250, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 31, 16.3518660, 48.2765010, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 32, 16.3522220, 48.2767340, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 33, 16.3504260, 48.2766350, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 34, 16.3510390, 48.2772250, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 35, 16.3496130, 48.2770150, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 36, 16.3500550, 48.2775480, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 37, 16.3485870, 48.2772910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 38, 16.3478450, 48.2774250, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 39, 16.3475740, 48.2778820, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 40, 16.3457640, 48.2782820, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 41, 16.3455640, 48.2779100, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 42, 16.3444520, 48.2779960, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 43, 16.3442520, 48.2782340, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 44, 16.3443380, 48.2785670, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 45, 16.3350300, 48.2810990, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 46, 16.3337760, 48.2804120, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 47, 16.3342210, 48.2791980, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 48, 16.3370550, 48.2769020, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 49, 16.3360570, 48.2750340, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 50, 16.3348450, 48.2752360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 51, 16.3334550, 48.2761400, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 52, 16.3322790, 48.2762590, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 53, 16.3308530, 48.2766280, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 54, 16.3294450, 48.2772350, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 55, 16.3279480, 48.2770440, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 56, 16.3228680, 48.2780080, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 57, 16.3205330, 48.2779360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 58, 16.3192140, 48.2767820, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 59, 16.3234030, 48.2758420, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 60, 16.3266290, 48.2739990, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 61, 16.3289460, 48.2736180, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 62, 16.3326710, 48.2717030, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 63, 16.3358080, 48.2692280, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 64, 16.3368230, 48.2683720, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 65, 16.3379640, 48.2672060, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 66, 16.3398880, 48.2658140, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 67, 16.3415100, 48.2637440, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 68, 16.3420970, 48.2626850, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 69, 16.3451440, 48.2610310, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 70, 16.3449660, 48.2604120, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 71, 16.3517000, 48.2590670, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 72, 16.3521810, 48.2591980, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 73, 16.3543190, 48.2586380, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 74, 16.3572950, 48.2590070, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 75, 16.3595220, 48.2594940, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 76, 16.3601100, 48.2598630, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 77, 16.3620010, 48.2600220, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 0, 16.3586160, 48.1915790, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 1, 16.3578330, 48.1912930, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 2, 16.3563920, 48.1919720, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 3, 16.3550220, 48.1927690, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 4, 16.3526200, 48.1931860, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 5, 16.3504850, 48.1947210, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 6, 16.3511260, 48.1954110, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 7, 16.3510900, 48.1955770, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 8, 16.3516420, 48.1963620, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 9, 16.3501120, 48.1982190, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 10, 16.3560030, 48.2002400, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 11, 16.3548300, 48.2023700, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 12, 16.3546160, 48.2024180, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 13, 16.3544560, 48.2029180, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 14, 16.3543490, 48.2029410, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 15, 16.3544560, 48.2024300, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 16, 16.3540470, 48.2023580, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 17, 16.3513770, 48.2022640, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 18, 16.3517330, 48.2023590, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 19, 16.3513240, 48.2041080, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 20, 16.3515200, 48.2043220, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 21, 16.3515200, 48.2053090, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 22, 16.3542610, 48.2054400, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 23, 16.3538880, 48.2066530, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 24, 16.3530870, 48.2065700, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 25, 16.3520910, 48.2098420, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 26, 16.3523050, 48.2094020, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 27, 16.3551520, 48.2092230, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 28, 16.3603320, 48.2085320, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 29, 16.3605100, 48.2093530, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 30, 16.3614180, 48.2094000, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 31, 16.3620590, 48.2097330, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 32, 16.3620950, 48.2097930, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 33, 16.3628420, 48.2088410, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 34, 16.3635470, 48.2092570, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 35, 16.3639450, 48.2092850, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 36, 16.3644010, 48.2094760, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 37, 16.3660250, 48.2101700, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 38, 16.3665800, 48.2097610, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 39, 16.3672070, 48.2101890, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 40, 16.3674920, 48.2103310, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 41, 16.3684890, 48.2115690, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 42, 16.3687310, 48.2115870, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 43, 16.3677770, 48.2104360, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 44, 16.3688730, 48.2097310, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 45, 16.3668070, 48.2082090, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 46, 16.3669060, 48.2077430, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 47, 16.3672480, 48.2074290, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 48, 16.3677320, 48.2077620, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 49, 16.3682020, 48.2074380, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 50, 16.3696270, 48.2085420, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 51, 16.3707230, 48.2081220, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 52, 16.3718900, 48.2081320, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 53, 16.3728740, 48.2091120, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 54, 16.3740980, 48.2086260, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 55, 16.3757650, 48.2104430, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 56, 16.3773740, 48.2095290, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 57, 16.3767610, 48.2092440, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 58, 16.3766190, 48.2093010, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 59, 16.3763050, 48.2090150, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 60, 16.3760060, 48.2091010, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 61, 16.3753510, 48.2087110, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 62, 16.3752090, 48.2087680, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 63, 16.3745670, 48.2082540, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 64, 16.3738410, 48.2072930, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 65, 16.3759440, 48.2063150, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 66, 16.3774830, 48.2079940, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 67, 16.3864650, 48.2055300, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 68, 16.3874050, 48.2050970, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(0, 69, 16.3889160, 48.2039920, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 0, 16.3174070, 48.2540740, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 1, 16.3167150, 48.2543430, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 2, 16.3135860, 48.2563200, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 3, 16.3128710, 48.2611170, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 4, 16.3150940, 48.2620120, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 5, 16.3145240, 48.2624310, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 6, 16.3182870, 48.2533260, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 7, 16.3145130, 48.2635630, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 8, 16.3118330, 48.2646290, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 9, 16.3099140, 48.2669050, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 10, 16.3129590, 48.2707960, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 11, 16.3031400, 48.2707940, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 12, 16.3010720, 48.2726850, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 13, 16.2971870, 48.2719580, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 14, 16.2943360, 48.2721240, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 15, 16.2915220, 48.2699220, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 16, 16.2884230, 48.2679810, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 17, 16.2859280, 48.2675520, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 18, 16.2866780, 48.2664340, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 19, 16.2912220, 48.2666500, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 20, 16.2941460, 48.2647350, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 21, 16.2933240, 48.2624390, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 22, 16.2877380, 48.2604570, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 23, 16.2918740, 48.2581360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 24, 16.3076110, 48.2563520, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 25, 16.3133410, 48.2538240, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 26, 16.3167150, 48.2543430, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 0, 16.3747230, 48.2116520, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 1, 16.3740820, 48.2118070, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 2, 16.3730140, 48.2108910, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 3, 16.3701310, 48.2121060, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 4, 16.3697350, 48.2116820, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 5, 16.3693420, 48.2118730, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 6, 16.3692850, 48.2118420, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 7, 16.3693740, 48.2117900, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 8, 16.3689430, 48.2115490, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 9, 16.3684550, 48.2115020, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 10, 16.3677110, 48.2105170, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 11, 16.3688570, 48.2097480, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 12, 16.3685540, 48.2094910, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 13, 16.3704080, 48.2082990, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 14, 16.3697130, 48.2077900, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 15, 16.3689300, 48.2068380, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 16, 16.3696270, 48.2065550, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 17, 16.3706250, 48.2082200, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 18, 16.3718170, 48.2080480, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 19, 16.3713820, 48.2059970, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 20, 16.3697170, 48.2024710, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 21, 16.3643610, 48.2036170, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 22, 16.3596460, 48.2071640, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 23, 16.3615710, 48.2135880, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 24, 16.3623370, 48.2140040, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 25, 16.3592410, 48.2172530, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 26, 16.3641020, 48.2188340, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 27, 16.3694390, 48.2134310, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 28, 16.3700090, 48.2136810, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 29, 16.3738710, 48.2127400, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 30, 16.3761490, 48.2118230, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 31, 16.3772890, 48.2130960, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 32, 16.3850330, 48.2134380, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 33, 16.3849480, 48.2137540, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 34, 16.3850260, 48.2137710, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 35, 16.3852600, 48.2128860, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 36, 16.3833450, 48.2125510, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 37, 16.3831160, 48.2116470, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 38, 16.3824940, 48.2088250, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 39, 16.3751550, 48.2016890, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 40, 16.3746140, 48.2015510, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 41, 16.3759580, 48.1993760, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 42, 16.3765910, 48.1993900, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 43, 16.3770110, 48.1990240, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 44, 16.3772460, 48.1991240, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 45, 16.3773780, 48.1990280, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 46, 16.3754060, 48.1992030, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 47, 16.3741260, 48.2014470, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 48, 16.3736070, 48.2013190, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 49, 16.3695920, 48.2021910, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 50, 16.3697060, 48.2024910, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 51, 16.3736350, 48.2016230, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 52, 16.3742190, 48.2017560, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 53, 16.3756410, 48.1992140, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 54, 16.3764660, 48.1989860, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 55, 16.3775620, 48.1981150, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 56, 16.3843640, 48.1952330, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 57, 16.3907690, 48.1935740, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 58, 16.4426100, 48.1543360, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(1, 59, 16.4532080, 48.1515700, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 0, 16.2910050, 48.2335820, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 1, 16.2907910, 48.2341060, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 2, 16.2879060, 48.2342360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 3, 16.2867080, 48.2356410, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 4, 16.2695170, 48.2449980, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 5, 16.2690600, 48.2461970, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 6, 16.2734190, 48.2472660, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 7, 16.2665180, 48.2499840, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 8, 16.2703920, 48.2518320, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 9, 16.2695630, 48.2539830, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 10, 16.2657140, 48.2544950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 11, 16.2654850, 48.2550850, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 12, 16.2701310, 48.2551830, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 13, 16.2784530, 48.2567860, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 14, 16.2858060, 48.2583880, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 15, 16.2857250, 48.2536870, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 16, 16.2845560, 48.2535150, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 17, 16.2867250, 48.2513270, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 18, 16.2884640, 48.2506800, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 19, 16.2829270, 48.2476060, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 20, 16.2835910, 48.2425500, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 21, 16.2833380, 48.2396180, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 22, 16.2836230, 48.2388950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 23, 16.2825690, 48.2387610, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 24, 16.2817520, 48.2390080, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 25, 16.2810020, 48.2388180, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 0, 16.4061340, 48.2095410, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 1, 16.4038810, 48.2066680, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 2, 16.3948520, 48.2056830, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 3, 16.3900730, 48.2109390, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 4, 16.3747240, 48.2127730, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 5, 16.3703410, 48.2174000, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 6, 16.3617080, 48.2134810, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 7, 16.3597120, 48.2070850, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 8, 16.3642660, 48.2035820, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 9, 16.3714130, 48.2018860, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 10, 16.3688200, 48.2003830, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 11, 16.3622640, 48.1850220, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 12, 16.3645970, 48.1828900, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 13, 16.3591020, 48.1808160, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 14, 16.3595000, 48.1800550, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(2, 15, 16.3543730, 48.1686720, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 0, 16.3115050, 48.2118740, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 1, 16.3117040, 48.2125970, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 2, 16.3113050, 48.2126920, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 3, 16.3108450, 48.2136820, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 4, 16.3042120, 48.2145560, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 5, 16.3009080, 48.2157920, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 6, 16.3009910, 48.2183240, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 7, 16.2863200, 48.2206220, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 8, 16.2891670, 48.2223360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 9, 16.2868000, 48.2242960, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 10, 16.2844360, 48.2237620, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 11, 16.2761160, 48.2254710, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 12, 16.2736650, 48.2265550, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 13, 16.2707610, 48.2249730, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 14, 16.2674330, 48.2213360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 15, 16.2633340, 48.2194110, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 16, 16.2632110, 48.2183020, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 17, 16.2646930, 48.2175220, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 18, 16.2636830, 48.2165220, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 19, 16.2651450, 48.2150760, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 20, 16.2622460, 48.2103630, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 21, 16.2625610, 48.2097350, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 22, 16.2642980, 48.2097460, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 23, 16.2645560, 48.2085280, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 24, 16.2662070, 48.2091470, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 25, 16.2695690, 48.2104300, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 26, 16.2684450, 48.2126300, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 27, 16.2698130, 48.2145100, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 28, 16.2719660, 48.2151780, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 29, 16.2712880, 48.2165690, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 30, 16.2735320, 48.2158330, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 31, 16.2746700, 48.2166070, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 32, 16.2750780, 48.2183090, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 33, 16.2768250, 48.2158470, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 34, 16.2786060, 48.2151810, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 35, 16.2849620, 48.2142800, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 36, 16.2917110, 48.2123680, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 37, 16.2925450, 48.2147710, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 38, 16.2947880, 48.2152600, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 39, 16.3113050, 48.2126920, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 0, 16.3064190, 48.2246540, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 1, 16.3073920, 48.2177250, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 2, 16.3268180, 48.2158630, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 3, 16.3264770, 48.2127790, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 4, 16.3387810, 48.2108000, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 5, 16.3600830, 48.2085130, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 6, 16.3596830, 48.2069900, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 7, 16.3743740, 48.2015040, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 8, 16.3824690, 48.2111710, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 9, 16.3768310, 48.2120490, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 10, 16.3778010, 48.2136090, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 11, 16.3800800, 48.2143700, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 12, 16.3835650, 48.2253710, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 13, 16.3884670, 48.2281480, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 14, 16.3770230, 48.2392320, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(3, 15, 16.3802770, 48.2447510, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 0, 16.4205360, 48.2983310, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 1, 16.4194480, 48.2984150, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 2, 16.4197880, 48.2992000, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 3, 16.4169200, 48.3009390, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 4, 16.4176710, 48.3017590, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 5, 16.4145870, 48.3025590, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 6, 16.4145020, 48.3147910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 7, 16.4129640, 48.3163530, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 8, 16.4035460, 48.3166640, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 9, 16.3908200, 48.3189170, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 10, 16.3804280, 48.3150380, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 11, 16.3805550, 48.3126300, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 12, 16.3812380, 48.3124930, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 13, 16.3817020, 48.3097410, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 14, 16.3842970, 48.3070560, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 15, 16.3860670, 48.3089020, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 16, 16.3896940, 48.3118690, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 17, 16.3901520, 48.3128780, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 18, 16.4009660, 48.3114640, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 19, 16.4009940, 48.3108550, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 20, 16.4069270, 48.3096520, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 21, 16.4104290, 48.3038250, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 22, 16.4115400, 48.3030440, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 23, 16.4110530, 48.3016740, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 24, 16.4108790, 48.2998080, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 25, 16.4173610, 48.2985950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 26, 16.4194480, 48.2984150, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 0, 16.3608940, 48.2598230, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 1, 16.3614640, 48.2598420, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 2, 16.3620630, 48.2594420, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 3, 16.3646710, 48.2595650, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 4, 16.3657260, 48.2599460, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 5, 16.3664530, 48.2600120, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 6, 16.3672660, 48.2600790, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 7, 16.3674650, 48.2593080, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 8, 16.3670650, 48.2580420, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 9, 16.3654810, 48.2547680, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 10, 16.3642260, 48.2526840, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 11, 16.3622850, 48.2479350, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 12, 16.3620420, 48.2467550, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 13, 16.3617420, 48.2446990, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 14, 16.3611560, 48.2418250, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 15, 16.3609710, 48.2414060, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 16, 16.3580480, 48.2379710, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 17, 16.3569650, 48.2362390, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 18, 16.3560380, 48.2333930, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 19, 16.3561090, 48.2330030, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 20, 16.3565220, 48.2326410, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 21, 16.3574460, 48.2295000, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 22, 16.3596110, 48.2288720, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 23, 16.3605500, 48.2258450, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 24, 16.3617040, 48.2258640, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 25, 16.3614750, 48.2230460, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 26, 16.3607050, 48.2215050, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 27, 16.3607040, 48.2207720, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 28, 16.3621000, 48.2196390, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 29, 16.3640930, 48.2189440, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 30, 16.3647620, 48.2180580, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 31, 16.3648330, 48.2177160, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 32, 16.3666410, 48.2160210, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 33, 16.3616260, 48.2135290, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 34, 16.3596870, 48.2070570, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 35, 16.3642410, 48.2035630, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 36, 16.3735660, 48.2014760, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 37, 16.3742490, 48.2015900, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 38, 16.3754860, 48.1994480, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 39, 16.3750580, 48.1979160, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 40, 16.3770770, 48.1945360, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 41, 16.3784990, 48.1929550, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 42, 16.3812140, 48.1884240, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 43, 16.3811850, 48.1881290, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 44, 16.3817390, 48.1870820, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 45, 16.3824650, 48.1863300, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 46, 16.3810550, 48.1854540, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 47, 16.3804270, 48.1836750, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(4, 48, 16.3815790, 48.1829800, 'Traseu turistic');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 0, 16.2624960, 48.1329280, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 1, 16.2624380, 48.1335370, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 2, 16.2570070, 48.1334950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 3, 16.2546180, 48.1338550, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 4, 16.2545320, 48.1341410, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 5, 16.2460830, 48.1355620, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 6, 16.2455680, 48.1376370, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 7, 16.2447150, 48.1377120, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 8, 16.2506750, 48.1450650, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 9, 16.2438940, 48.1511130, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 10, 16.2325200, 48.1489710, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 11, 16.2307590, 48.1477130, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 12, 16.2289380, 48.1479400, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 13, 16.2216680, 48.1424890, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 14, 16.2151360, 48.1384080, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 15, 16.2090500, 48.1380970, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 16, 16.2109870, 48.1368620, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 17, 16.2113040, 48.1352250, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 18, 16.2053350, 48.1339620, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 19, 16.2045410, 48.1330480, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 20, 16.2027250, 48.1315610, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 21, 16.2078250, 48.1277400, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 22, 16.2178900, 48.1280370, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 23, 16.2425630, 48.1324000, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 24, 16.2495010, 48.1325570, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 25, 16.2554420, 48.1319360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(5, 26, 16.2570070, 48.1334950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 0, 16.3906230, 48.1650250, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 1, 16.3966590, 48.1687530, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 2, 16.4028010, 48.1650950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 3, 16.4096220, 48.1593040, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 4, 16.4079140, 48.1583910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 5, 16.4105240, 48.1531350, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 6, 16.4080200, 48.1527560, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 7, 16.4067630, 48.1489500, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 8, 16.4201810, 48.1439910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 9, 16.4141370, 48.1345530, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 10, 16.3713720, 48.1433300, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 11, 16.3768430, 48.1559680, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 12, 16.3743400, 48.1568830, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 13, 16.3751390, 48.1595480, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 14, 16.3821970, 48.1613720, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 15, 16.3846990, 48.1603820, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 16, 16.3860670, 48.1619040, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 17, 16.3917550, 48.1601500, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(6, 18, 16.3906220, 48.1648710, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 0, 16.2307070, 48.2463910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 1, 16.2373290, 48.2409910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 2, 16.2420080, 48.2381770, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 3, 16.2408860, 48.2288110, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 4, 16.2408900, 48.2264500, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 5, 16.2346340, 48.2208110, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 6, 16.2178850, 48.2204900, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 7, 16.2104720, 48.2229950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 8, 16.2102300, 48.2287810, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 9, 16.2115950, 48.2300010, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 10, 16.2111300, 48.2337320, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 11, 16.2147650, 48.2387610, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 12, 16.2244480, 48.2414360, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 13, 16.2262650, 48.2446350, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 14, 16.2274040, 48.2451690, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(7, 15, 16.2307070, 48.2463910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 0, 16.3930100, 48.2172630, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 1, 16.3979050, 48.2139860, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 2, 16.4013210, 48.2126130, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 3, 16.4036010, 48.2137540, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 4, 16.4130490, 48.2087230, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 5, 16.4174810, 48.2017150, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 6, 16.4241930, 48.1972930, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 7, 16.4425240, 48.1946130, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 8, 16.4554940, 48.1891940, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 9, 16.4536720, 48.1888910, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 10, 16.4413790, 48.1914920, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 11, 16.4393280, 48.1911130, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 12, 16.4381920, 48.1921800, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 13, 16.4229320, 48.1921170, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 14, 16.4202040, 48.1950880, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 15, 16.4214580, 48.1961530, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 16, 16.4073500, 48.2065180, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 17, 16.4026830, 48.2083490, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 18, 16.4026840, 48.2097950, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(8, 19, 16.3973350, 48.2133770, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 0, 16.4821370, 48.2680470, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 1, 16.4841900, 48.2681970, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 2, 16.5021820, 48.2596440, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 3, 16.4990980, 48.2578210, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 4, 16.5027380, 48.2553790, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 5, 16.5015860, 48.2514980, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 6, 16.4930340, 48.2512810, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 7, 16.4927050, 48.2553170, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 8, 16.4855260, 48.2567740, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 9, 16.4888440, 48.2607290, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 10, 16.4804250, 48.2674400, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 11, 16.4803130, 48.2682020, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 12, 16.4790590, 48.2685840, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 13, 16.4781480, 48.2689660, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 14, 16.4786070, 48.2699540, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(9, 15, 16.4821370, 48.2680470, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 0, 16.3435900, 48.1883510, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 1, 16.3434760, 48.1873990, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 2, 16.3483710, 48.1818780, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 3, 16.3473460, 48.1814220, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 4, 16.3484850, 48.1802030, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 5, 16.3534370, 48.1803550, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 6, 16.3641410, 48.1830180, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 7, 16.3655630, 48.1815330, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 8, 16.3737610, 48.1811500, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 9, 16.3740420, 48.1771520, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 10, 16.3770020, 48.1772270, 'Drumetie');
INSERT INTO VienaDatabase.dbo.PUNCT_POLILINIE
(Id_Obiect, Numar_Secventa, X, Y, Tip_Obiect)
VALUES(10, 11, 16.3781950, 48.1743710, 'Drumetie');
```

6. TRASEE_TURISTICE

```sql
INSERT INTO VienaDatabase.dbo.TRASEE_TURISTICE
(ID, ID_detaliu, Nume, Lungime, Numar_obiective)
VALUES(0, 81, 'Atrium Houses', 7, 23);
INSERT INTO VienaDatabase.dbo.TRASEE_TURISTICE
(ID, ID_detaliu, Nume, Lungime, Numar_obiective)
VALUES(1, 82, 'Jewish Vienna', 18, 9);
INSERT INTO VienaDatabase.dbo.TRASEE_TURISTICE
(ID, ID_detaliu, Nume, Lungime, Numar_obiective)
VALUES(2, 83, 'Ring Line 1', 11, 26);
INSERT INTO VienaDatabase.dbo.TRASEE_TURISTICE
(ID, ID_detaliu, Nume, Lungime, Numar_obiective)
VALUES(3, 84, 'Ring Line 2', 13, 23);
INSERT INTO VienaDatabase.dbo.TRASEE_TURISTICE
(ID, ID_detaliu, Nume, Lungime, Numar_obiective)
VALUES(4, 85, 'Ring Line D', 10, 27);
```