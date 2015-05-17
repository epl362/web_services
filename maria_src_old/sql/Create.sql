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
  `ConsultationID` int(4) NOT NULL,
  `PatientID` int(6) NOT NULL,
  `Doctor` varchar(8) NOT NULL,
  `Date` datetime NOT NULL,
  `ShowedUp` bit(1) NOT NULL,
  `DroppedIn` bit(1) NOT NULL,
  `Updated` bit(1) NOT NULL,
  `IgnoredWarnings` bit(1) NOT NULL,
  `Diagnosis` varchar(255) NOT NULL,
  `TreatmentID` int(10) NOT NULL,
  `PreTreatment` int(10) NOT NULL,
  `Clinic` varchar(7) NOT NULL,
  `Comments` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `drugs` (
  `DrugID` varchar(5) NOT NULL,
  `sideEffects` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `Role` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `allergies`
 ADD PRIMARY KEY (`PatientID`,`AllergiesName`);


ALTER TABLE `clinic`
 ADD PRIMARY KEY (`ClinicID`);


ALTER TABLE `drugs`
 ADD PRIMARY KEY (`DrugID`);


ALTER TABLE `patient`
 ADD PRIMARY KEY (`PatientID`);


ALTER TABLE `selfharmful`
 ADD PRIMARY KEY (`PatientID`,`isHarmful`);
 
 