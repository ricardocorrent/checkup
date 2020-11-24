package com.checkup.inspection;

import com.checkup.inspection.information.InspectionInformationVO;
import com.checkup.inspection.vo.InspectionCompleteVO;
import com.checkup.inspection.vo.InspectionResponseVO;
import com.checkup.server.SimpleAbstractController;
import com.checkup.server.adapter.DozerAdapter;
import com.checkup.server.model.IdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/inspection")
public class InspectionController extends SimpleAbstractController<Inspection, InspectionVO> {

    private final InspectionService inspectionService;

    @Autowired
    public InspectionController(final InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    @Override
    protected String getListAllSortProperty() {
        return "title";
    }

    @Override
    public ResponseEntity<?> insert(@Valid @RequestBody final InspectionVO inspectionVO) {
        inspectionVO.getUser().setId(authenticationFacade.getLoggedUser().getId());
        return super.insert(inspectionVO);
    }

    @Override
    public ResponseEntity<?> update(@PathVariable final UUID id, @RequestBody final @Valid InspectionVO inspectionVO) {
        inspectionVO.getUser().setId(authenticationFacade.getLoggedUser().getId());
        return super.update(id, inspectionVO);
    }

    @PostMapping(path = "/{id}/close")
    public ResponseEntity<?> closeInspection(@PathVariable final UUID id) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inspectionService.closeInspection(new IdVO(id)));
    }

    @GetMapping(path = "/inspections")
    public ResponseEntity<?> getAllInspections() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DozerAdapter.parseListObjects(inspectionService.getAllInspections(authenticationFacade.getLoggedUser()), InspectionResponseVO.class));
    }

    @GetMapping(path = "/{id}/information")
    public ResponseEntity<?> getInformation(@PathVariable final UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(DozerAdapter.parseListObjects(inspectionService.getInspectionInformation(id), InspectionInformationVO.class));
    }

    @GetMapping(path = "/{id}/complete")
    public ResponseEntity<?> getCompleteInspection(@PathVariable final UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(inspectionService.getCompletedInspection(id));
    }

    @PutMapping(path = "/{id}/complete")
    public ResponseEntity<?> updateCompleteInspection(@RequestBody final InspectionCompleteVO entity) {
        return ResponseEntity.ok()
                .body(inspectionService.updateCompleteInspection(entity));
    }

    @GetMapping(path = "/{id}/print")
    public ResponseEntity<?> getPrintInspection(@PathVariable final UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(inspectionService.getPrintInspection(id));
    }

}
