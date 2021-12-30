package org.orig.WebLab3333.MainPage.Validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validatorX")
public class ValidatorX implements Validator<Double> {
    private final FacesMessage outOfBoundsExceptionMessage = new FacesMessage("Число выходит за допустимые пределы");
    @Override
    public void validate(FacesContext context, UIComponent component, Double value) throws ValidatorException {
        double lowerBound = -4;
        double upperBound = 4;
        if (value < lowerBound || value > upperBound) {
            ((UIInput) component).setValid(false);
            outOfBoundsExceptionMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(component.getClientId(context), outOfBoundsExceptionMessage);
            throw new ValidatorException(outOfBoundsExceptionMessage);
        }

    }
}