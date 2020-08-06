package com.checkup.target;

import com.checkup.server.SimpleAbstractService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class TargetService extends SimpleAbstractService<Target, TargetVO> {

    private final TargetRepository targetRepository;

    @Inject
    public TargetService(final TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }

    @Override
    public Class<TargetVO> getClazz() {
        return TargetVO.class;
    }

    @Override
    public Class<Target> getEntityClazz() {
        return Target.class;
    }
}
