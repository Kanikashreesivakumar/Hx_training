package com.myjavaapp.util;

import com.myjavaapp.enums.IncidentType;
import com.myjavaapp.model.Incident;
import com.myjavaapp.service.StreamsService;

import java.util.List;
import java.util.Map;

public class StreamsUtil {
    public static void main(String[] args) {
        StreamsService streamsService = new StreamsService();
        List<Incident> list =  streamsService.sampleData();

        List<Incident> filteredListByType =  streamsService.filterByIncidentTypeV2(list,IncidentType.THEFT);
        filteredListByType.forEach(System.out::println);

        System.out.println("Display all Incident Types ");
        List<IncidentType> types =  streamsService.getAllIncidentTypes(list);
        types.forEach(System.out::println);

        System.out.println("----Display Incidents handled by Each Officer----");
        Map<IncidentType, Integer> map = streamsService.getIncidentStatByType(list);
        map.entrySet().forEach(System.out::println);
    }

}