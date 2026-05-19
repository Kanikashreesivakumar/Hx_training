package com.repository;

import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.model.Incident;

import java.util.List;

public class IncidentRepository {
        public List<Incident> sampleData(){
            Incident incident1 = new Incident(1, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);
            Incident incident2 = new Incident(2, IncidentType.THEFT, "Security footage under review.", IncidentStatus.ACTIVE);
            Incident incident3 = new Incident(3, IncidentType.MISSING_PERSON, "Statement confirmed.", IncidentStatus.VERIFIED);
            Incident incident4 = new Incident(4, IncidentType.MURDER, "Documentation finalized.", IncidentStatus.CLOSE);
            Incident incident5 = new Incident(5, IncidentType.THEFT, "Interviews in progress.", IncidentStatus.ACTIVE);
            Incident incident6 = new Incident(6, IncidentType.THEFT, "Initial report logged.", IncidentStatus.INITIATED);
            Incident incident7 = new Incident(7, IncidentType.ABUSE, "Evidence verified.", IncidentStatus.VERIFIED);
            Incident incident8 = new Incident(8, IncidentType.MURDER, "Task force assigned.", IncidentStatus.INITIATED);
            Incident incident9 = new Incident(9, IncidentType.THEFT, "Recovery complete.", IncidentStatus.CLOSE);
            Incident incident10 = new Incident(10, IncidentType.MISSING_PERSON, "Active search ongoing.", IncidentStatus.ACTIVE);
            Incident incident11 = new Incident(11, IncidentType.ABUSE, "Formal report recorded.", IncidentStatus.ACTIVE);
            Incident incident12 = new Incident(12, IncidentType.MURDER, "Forensic data verified.", IncidentStatus.VERIFIED);
            Incident incident13 = new Incident(13, IncidentType.THEFT, "Lead tracking in progress.", IncidentStatus.ACTIVE);
            Incident incident14 = new Incident(14, IncidentType.MISSING_PERSON, "Subject located.", IncidentStatus.CLOSE);
            Incident incident15 = new Incident(15, IncidentType.ABUSE, "Case resolution logged.", IncidentStatus.CLOSE);
            Incident incident16 = new Incident(16, IncidentType.MURDER, "Investigation active.", IncidentStatus.ACTIVE);
            Incident incident17 = new Incident(17, IncidentType.MISSING_PERSON, "Information verified.", IncidentStatus.VERIFIED);
            Incident incident18 = new Incident(18, IncidentType.THEFT, "Incident logged.", IncidentStatus.INITIATED);
            Incident incident19 = new Incident(19, IncidentType.ABUSE, "Information request sent.", IncidentStatus.INITIATED);
            Incident incident20 = new Incident(20, IncidentType.MURDER, "Identity verified.", IncidentStatus.VERIFIED);
            List<Incident> incidentList = List.of(
                    incident1,
                    incident2,
                    incident3,
                    incident4,
                    incident5,
                    incident6,
                    incident7,
                    incident8,
                    incident9,
                    incident10,
                    incident11,
                    incident12,
                    incident13,
                    incident14,
                    incident15,
                    incident16,
                    incident17,
                    incident18,
                    incident19,
                    incident20
            );
            return incidentList;
        }
}
