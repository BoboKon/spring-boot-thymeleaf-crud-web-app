package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Workplace;
import net.javaguides.springboot.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceServiceImpl implements WorkplaceService {
    @Autowired
    private WorkplaceRepository workplaceRepository;

    @Override
    public List<Workplace> getAllWorkplaces() {return workplaceRepository.findAll();}

    @Override
    public void saveWorkplace(Workplace workplace) {
        workplaceRepository.save(workplace);
    }
}
