package com.checkup.inspection;

import com.checkup.inspection.vo.InspectionFinalizeVO;
import com.checkup.server.SimpleAbstractController;
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

    @PostMapping(path = "/{id}/close")
    public ResponseEntity<?> closeInspection(@PathVariable final UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(inspectionService.closeInspection(new IdVO(id)));
    }
}
