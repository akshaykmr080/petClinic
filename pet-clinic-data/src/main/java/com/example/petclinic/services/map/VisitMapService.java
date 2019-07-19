package com.example.petclinic.services.map;

import com.example.petclinic.model.Visit;
import com.example.petclinic.services.VisitService;

import java.util.Set;

/**
 * Created by akshaykumar on 7/18/19.
 */
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private VisitService visitService;

    public VisitMapService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if( visit.getPet() == null ||
                visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
