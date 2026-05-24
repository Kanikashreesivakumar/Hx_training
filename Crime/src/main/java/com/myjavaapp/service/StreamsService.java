package com.myjavaapp.service;

import com.myjavaapp.enums.IncidentStatus;
import com.myjavaapp.enums.IncidentType;
import com.myjavaapp.model.Incident;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsService {

    public List<Incident> sampleData(){
        Incident incident1 = new Incident(1, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);
        Incident incident2 = new Incident(2, IncidentType.THEFT, "Security footage under review.", IncidentStatus.ACTIVE);
        Incident incident3 = new Incident(3, IncidentType.MISSING_PERSON, "Statement confirmed.", IncidentStatus.VERIFIED);
        Incident incident4 = new Incident(4, IncidentType.MURDER, "Documentation finalized.", IncidentStatus.CLOSED);
        Incident incident5 = new Incident(5, IncidentType.THEFT, "Interviews in progress.", IncidentStatus.ACTIVE);
        Incident incident6 = new Incident(6, IncidentType.THEFT, "Initial report logged.", IncidentStatus.INITIATED);
        Incident incident7 = new Incident(7, IncidentType.ABUSE, "Evidence verified.", IncidentStatus.VERIFIED);
        Incident incident8 = new Incident(8, IncidentType.MURDER, "Task force assigned.", IncidentStatus.INITIATED);
        Incident incident9 = new Incident(9, IncidentType.THEFT, "Recovery complete.", IncidentStatus.CLOSED);
        Incident incident10 = new Incident(10, IncidentType.MISSING_PERSON, "Active search ongoing.", IncidentStatus.ACTIVE);
        Incident incident11 = new Incident(11, IncidentType.ABUSE, "Formal report recorded.", IncidentStatus.ACTIVE);
        Incident incident12 = new Incident(12, IncidentType.MURDER, "Forensic data verified.", IncidentStatus.VERIFIED);
        Incident incident13 = new Incident(13, IncidentType.THEFT, "Lead tracking in progress.", IncidentStatus.ACTIVE);
        Incident incident14 = new Incident(14, IncidentType.MISSING_PERSON, "Subject located.", IncidentStatus.CLOSED);
        Incident incident15 = new Incident(15, IncidentType.ABUSE, "Case resolution logged.", IncidentStatus.CLOSED);
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

    public List<Incident> filterByIncidentType(List<Incident> list , IncidentType incidentType) {
        // 1. Convert to Stream
        Stream<Incident> stream =  list.stream();
        // 2. Perform Ops : filter
        /*
         * filter needs a boolean criteria:
         * in this case it is: incident.getIncidentType().equals(incidentType)
         * For those incidents, who satisfy this criteria, they stay in the stream.
         * But those, who do not satisfy yhe criteria, they are moved out of the stream.
         * */
        stream = stream.filter(incident -> incident.getIncidentType().equals(incidentType));
        // 3. Reconvert back to List
        List<Incident> filteredList =  stream.toList();
        return filteredList;
    }

    public List<Incident> filterByIncidentTypeV2(List<Incident> list, IncidentType incidentType) {
        return list
                .stream()
                .filter(incident -> incident.getIncidentType().equals(incidentType))
                .toList();
    }

    public List<IncidentType> getAllIncidentTypes(List<Incident> list) {
        return list
                .stream()
                .map(Incident :: getIncidentType)
                .distinct()
                .toList();
    }

    public Map<IncidentType, Integer> getIncidentStatByType(List<Incident> list) {
        Map<IncidentType,Integer> mapOutput = new HashMap<>();
        Map<IncidentType, List<Incident>> map =  list
                .stream()
                .collect(Collectors.groupingBy(Incident :: getIncidentType));

        map.forEach((key, value) -> mapOutput.put(key, value.size()));

        return mapOutput;
    }
}
/*
streams
-------
group by stats tasks:
We do not have group by directly in streams so we use Collectors class which has groupingBy in it.

How do we use it?
in Group by, we first select the key(anchor) - IncidentType
Incident :: getIncidentType

After this, what u get is your key and the records associated with this key.

KEY: ABUSE
        Incident incident1 = new Incident(1, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);
        Incident incident7 = new Incident(7, IncidentType.ABUSE, "Evidence verified.", IncidentStatus.VERIFIED);
KEY: THEFT
        Incident incident2 = new Incident(2, IncidentType.THEFT, "Security footage under review.", IncidentStatus.ACTIVE);
KEY: MISSING_PERSON
        Incident incident3 = new Incident(3, IncidentType.MISSING_PERSON, "Statement confirmed.", IncidentStatus.VERIFIED);

map = Map<IncidentType, List<Incident>>

If u need only the count of List<Incident>
Map<IncidentType, Integer> mapOutput <-- I want this
map.entryset().forEach(
    entry-> mapOutput.put(entry.getKey(), entry.getValue().size())
)

AI Copilot :
* */