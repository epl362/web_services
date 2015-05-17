CREATE TABLE IF NOT EXISTS `allergies` (
  `PatientID` int(6) NOT NULL,
  `AllergiesName` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `clinic` (
  `ClinicID` varchar(7) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `consultation` (
  `PatientID` int(6) NOT NULL,
  `DoctorID` varchar(15) NOT NULL,
  `Date` date NOT NULL,
  `Time` int(2) NOT NULL,
  `ShowedUp` bit(1) NULL,
  `DroppedIn` bit(1) NULL,
  `Updated` bit(1) NULL,
  `IgnoredWarnings` bit(1) NULL,
  `DiagnosisID` int(20) NULL,
  `TreatmentID` varchar(10) NOT NULL,
  `Comments` varchar(255) NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `consultation`
 ADD PRIMARY KEY (`PatientID`, `DoctorID`, `Date`);


CREATE TABLE IF NOT EXISTS `drugs` (
  `DrugID` varchar(10) NOT NULL,
  `sideEffects` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `drugs`
 ADD PRIMARY KEY (`DrugID`);

CREATE TABLE IF NOT EXISTS `patient` (
  `PatientID` varchar(6) NOT NULL,
  `Username` varchar(12) NOT NULL,
  `Password` varchar(12) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `Address` varchar(60) NOT NULL,
  `Status` int(2) NOT NULL,
  `Dead` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `selfharmful` (
  `PatientID` int(6) NOT NULL,
  `isHarmful` bit(1) NOT NULL,
  `Overdose` bit(1) NOT NULL,
  `Underdose` bit(1) NOT NULL,
  `Details` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `users` (
  `Username` varchar(8) NOT NULL,
  `Password` varchar(12) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Role` int(1) DEFAULT NULL,
  `ClinicID` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `treatment` (
  `TreatmentID` int(6) NOT NULL,
  `DrugID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `treatment`
 ADD PRIMARY KEY (`TreatmentID`);

CREATE TABLE IF NOT EXISTS `condition` (
  `DiagnosisID` int(20) NOT NULL,
  `Description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `condition`
 ADD PRIMARY KEY (`DiagnosisID`);



ALTER TABLE `allergies`
 ADD PRIMARY KEY (`PatientID`,`AllergiesName`);


ALTER TABLE `clinic`
 ADD PRIMARY KEY (`ClinicID`);



ALTER TABLE `patient`
 ADD PRIMARY KEY (`PatientID`);


ALTER TABLE `selfharmful`
 ADD PRIMARY KEY (`PatientID`);
 
 
 ALTER TABLE `users`
 ADD PRIMARY KEY (`Username`);
 

 