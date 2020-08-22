package com.checkup.inspection;

import com.checkup.server.validation.exception.CloseInspectionException;

import javax.swing.text.html.Option;
import java.util.Optional;

public class InspectionValidator {

    public void validateIfInspectionCanBeClosed(final Inspection inspection) {
        if (!inspection.getDraft()) throw  new CloseInspectionException();
    }
}
