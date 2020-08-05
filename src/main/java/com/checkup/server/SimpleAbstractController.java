package com.checkup.server;

import com.checkup.server.model.BaseModel;
import com.checkup.server.model.BaseVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.UUID;

public abstract class SimpleAbstractController<T extends BaseModel, Z extends BaseVO> {

    @Inject
    private SimpleAbstractService<T, Z> simpleAbstractService;

    @PostMapping
    private ResponseEntity<?> insert(@Valid @RequestBody final Z z) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(simpleAbstractService.insert(z));
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<?> delete(@PathVariable final UUID id) {
        this.simpleAbstractService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> getEntityById(@PathVariable("id") final UUID id) {
        final Z z = simpleAbstractService.getById(id);
        return ResponseEntity.ok(z);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable final UUID id, @Valid @RequestBody final Z z) {
        z.setId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(simpleAbstractService.update(z));
    }

    @GetMapping(path = "/list-all")
    public ResponseEntity<?> listAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "limit", defaultValue = "4") int limit,
                                     @RequestParam(value = "direction", defaultValue = "asc") String direction,
                                     PagedResourcesAssembler<Z> assembler) {
        final Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        final Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, getListAllSortProperty()));
        final Page<Z> listOfEntities = simpleAbstractService.list(pageable);

        return ResponseEntity.ok(listOfEntities);
    }


    protected abstract String getListAllSortProperty();
}
