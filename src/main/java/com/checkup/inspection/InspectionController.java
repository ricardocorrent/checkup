package com.checkup.inspection;

import com.checkup.inspection.information.InspectionInformationVO;
import com.checkup.inspection.vo.InspectionCompleteVO;
import com.checkup.inspection.vo.InspectionResponseVO;
import com.checkup.server.SimpleAbstractController;
import com.checkup.server.adapter.DozerAdapter;
import com.checkup.server.model.IdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .body(DozerAdapter.parseListObjects(inspectionService.getAllInspections(), InspectionResponseVO.class));
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


}
