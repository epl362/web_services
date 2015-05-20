INSERT INTO `allergies` (`PatientID`, `AllergiesName`) VALUES
(944444, 'drug1'),
(944444, 'drug2'),
(955555, 'drug2'),
(955555, 'drug3'),
(966666, 'drug1'),
(977777, 'drug1'),
(999999, 'drug700'),
(999999, 'drug701');


INSERT INTO `clinic` (`ClinicID`, `Name`, `Location`) VALUES
('clinic1', 'Geniko', 'Larnaka'),
('clinic2', 'AgiosTherissos', 'Lemeso'),
('clinic3', 'Makario', 'Lefkosia');


INSERT INTO `consultation` (`PatientID`, `DoctorID`, `Date`, `Time`, `ShowedUp`, `DroppedIn`, `Updated`, `IgnoredWarnings`, `DiagnosisID`, `TreatmentID`, `Comments`) VALUES
(944444, 'tpapak01', '2015-04-01', 14 , b'1', b'1', b'1', b'1', '1', 'drug1', 'none'),
(944444, 'tchara02', '2015-04-03', 09, b'0', b'0', b'0', b'0', '1', 'drug3', 'none'),
(955555, 'tpapak01', '2015-04-02', 10,b'1', b'1', b'1', b'0', '3', 'drug700', 'none'),
(955555, 'tpapak01', '2015-04-03', 13,b'0', b'0', b'0', b'1', '5', 'drug2', 'none'),
(966666, 'tchara02', '2015-04-03', 17,b'1', b'1', b'1', b'1', '6', 'drug3', 'none'),
(977777, 'tchara02', '2015-04-01', 19,b'1', b'1', b'1', b'1', '3', 'drug1', 'none');

INSERT INTO `condition_` (`DiagnosisID`, `Description`) VALUES
('1', 'illness 1'),
('2', 'illness 2'),
('3', 'illness 3'),
('4', 'illness 4'),
('5', 'illness 5'),
('6', 'illness 6');


INSERT INTO `drugs` (`DrugID`, `sideEffects`) VALUES
('drug1', 'confusion'),
('drug2', 'dizziness'),
('drug3', 'sweating'),
('drug700', 'Blurred vision'),
('drug701', 'chest pain'),
('drug702', 'ear congestion'),
('drug703', 'nausea'),
('drug704', 'sneezing'),
('drug705', 'chills');


INSERT INTO `patient` (`PatientID`, `Username`, `Password`, `Name`, `Surname`, `Address`, `Status`, `Dead`, `Relative`) VALUES
('944444', 'afrang01', 'Andreas', 'Andreas', 'Frangou', '9 Georgiou Griva Digeni ,Strovolos', 10, b'0', 'giorgkou@hotmail.com'),
('955555', 'ppavli02', 'Panayiotis', 'Panayiotis', 'Pavlides', '15 John Kennedy,Lefkosia', 9, b'0', 'panais@hotmail.com'),
('966666', 'akkous01', 'Andria', 'Andria', 'Kkoushi', 'kandaras12,Aradippou', 8, b'0', 'kokos@hotmail.com'),
('977777', 'epapak02', 'Irene', 'Irene', 'Papacosta', 'Mixalaki Karaoli 36,Aradippou', 7, b'0', 'antrikkos@hotmail.com'),
('988888', 'epapak02', 'Irene', 'Irene', 'Papacosta', 'Mixalaki Karaoli 36,Aradippou', 7, b'0', 'antrikkos@hotmail.com'),
('988889', 'ageorg99', 'Andreas', 'Andreas', 'Georgiou', 'Griva Digeni 3,Lemesos', 7, b'0', 'ageorg@gmail.com'),
('999999', 'inikol03', 'Iasonas', 'Iasonas', 'Nicolaou', '9 Oute j pou kserw ,Egkomi', 10, b'0', 'marulla@hotmail.com');


INSERT INTO `selfharmful` (`PatientID`, `isHarmful`, `Overdose`, `Underdose`, `Details`) VALUES
(944444, b'0', b'0', b'0', 'none'),
(955555, b'1', b'1', b'0', 'none'),
(966666, b'1', b'0', b'1', 'none'),
(977777, b'0', b'0', b'0', 'none');

INSERT INTO `selfharmful` (`PatientID`, `isHarmful`, `Overdose`, `Underdose`, `Details`) VALUES
(988888, b'0', b'0', b'0', 'none'),
(999999, b'1', b'1', b'0', 'none');


INSERT INTO `users` (`Username`, `Password`, `Name`, `Role`, `ClinicID`) VALUES
('paziz001', '123123', 'Philippos', 2, 'clinic1'),
('dpash01', '234234', 'Jimmys', 3, 'clinic2'),
('eandre02', '345345', 'Evanthia', 1, 'clinic1'),
('mpapae', '555555', 'Maria', 2, 'clinic2'),
('tchara02', '456456', 'Theodoros', 1, 'clinic3'),
('tpapak01', '567567', 'Thekla', 1, 'clinic2'),
('safxen01', '678678', 'Sotiroula', 3, 'clinic1');
