package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Workplace;

import java.util.List;

public interface WorkplaceService {
    List<Workplace> getAllWorkplaces();

    void saveWorkplace(Workplace workplace);


}
