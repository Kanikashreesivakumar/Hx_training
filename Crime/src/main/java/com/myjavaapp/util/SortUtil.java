package com.myjavaapp.util;

import com.myjavaapp.enums.IncidentStatus;
import com.myjavaapp.enums.IncidentType;
import com.myjavaapp.model.Incident;

public class SortUtil {
    public static void main(String[] args) {
        Incident incident1 = new Incident(1, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);
        Incident incident2 = new Incident(2, IncidentType.ABUSE, "Case file created.", IncidentStatus.INITIATED);
        // == OR equals
        System.out.println(incident1 == incident2); // compares locations (100X == 600X)
        System.out.println(incident1.equals(incident2)); // equals method compares values

        System.out.println(incident1.getIncidentStatus().equals(incident2.getIncidentStatus()));
    }
}
/*
Heap & Stack
------------
Main_Stack                               Heap (Application)
Incident incident1                      100X:
                                        200X:
                                        300X:

JVM: JDK + JRE
Reference goes on the STACK
* */