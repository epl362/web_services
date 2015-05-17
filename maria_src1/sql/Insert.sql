patientpatientINSERT INTO `allergies` (`PatientID`, `AllergiesName`) VALUES
(944444, 'drug1'),
(944444, 'drug2'),
(955555, 'drug2'),
(955555, 'drug3'),
(966666, 'drug1'),
(977777, 'drug1');


INSERT INTO `clinic` (`ClinicID`, `Name`, `Location`) VALUES
('clinic1', 'Geniko', 'Larnaka'),
('clinic2', 'AgiosTherissos', 'Lemeso'),
('clinic3', 'Makario', 'Lefkosia');


INSERT INTO `consultation` (`ConsultationID`, `PatientID`, `Doctor`, `Date`, `ShowedUp`, `DroppedIn`, `Updated`, `IgnoredWarnings`, `Diagnosis`, `TreatmentID`, `PreTreatment`, `Clinic`, `Comments`) VALUES
(3600, 944444, 'tpapak01', '2015-04-01 05:15:29', b'1', b'1', b'1', b'1', 'illness 1', 1, 0, '0', 'none'),
(4590, 944444, 'tchara02', '2015-04-03 12:14:06', b'0', b'0', b'0', b'0', 'illness 1', 2, 1, 'clinic2', 'none'),
(9666, 955555, 'tpapak01', '2015-04-03 03:14:09', b'1', b'1', b'1', b'0', 'illness 3', 1, 0, 'clinic3', 'none\r\n'),
(5450, 955555, 'tpapak01', '2015-04-02 12:12:20', b'0', b'0', b'0', b'1', 'illness5', 2, 1, 'clinic2', 'none'),
(9545, 966666, 'tchara02', '2015-04-03 03:19:23', b'1', b'1', b'1', b'1', 'illness 6', 1, 0, 'clinic3', 'none\r\n'),
(6030, 977777, 'tchara02', '2015-04-01 11:19:00', b'1', b'1', b'1', b'1', 'illness 3', 1, 0, 'clinic3', 'none');


INSERT INTO `drugs` (`DrugID`, `sideEffects`) VALUES
('drug1', 'description'),
('drug2', 'description'),
('drug3', 'description');

INSERT INTO `patient` (`PatientID`, `Username`, `Password`, `Name`, `Surname`, `Address`, `Status`, `Dead`) VALUES
('944444', 'afrang01', 'Andreas', 'Andreas', 'Frangou', '9 Georgiou Griva Digeni ,Strovolos', 10, b'0'),
('955555', 'ppavli02', 'Panayiotis', 'Panayiotis', 'Pavlides', '15 John Kennedy,Lefkosia', 9, b'0'),
('966666', 'akkous01', 'Andria', 'Andria', 'Kkoushi', 'kandaras12,Aradippou', 8, b'0'),
('977777', 'epapak02', 'Irene', 'Irene', 'Papacosta', 'Mixalaki Karaoli 36,Aradippou', 7, b'0');


INSERT INTO `selfharmful` (`PatientID`, `isHarmful`, `Overdose`, `Underdose`, `Details`) VALUES
(944444, b'0', b'0', b'0', 'none'),
(955555, b'1', b'1', b'0', 'none'),
(966666, b'1', b'0', b'1', 'none'),
(977777, b'0', b'0', b'0', 'none');


INSERT INTO `users` (`Username`, `Password`, `Name`, `Role`) VALUES
('paziz001', '123123', 'Philippos', 2),
('dpash01', '234234', 'Jimmys', 3),
('eandre02', '345345', 'Evanthia', 1),
('ctheod01', '456456', 'Theodoros', 1),
('tpapak01', '567567', 'Thekla', 1),
('safxen01', '678678', 'Sotiroula', 3);