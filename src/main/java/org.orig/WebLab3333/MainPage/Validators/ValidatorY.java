package org.orig.WebLab3333.MainPage.Validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validatorY")
public class ValidatorY implements Validator<Object> {

    private final FacesMessage numberFormatExceptionMessage = new FacesMessage("Введите число");
    private final FacesMessage outOfBoundsExceptionMessage = new FacesMessage("Число выходит за допустимые пределы");

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        double y;
        try {
            y = Double.parseDouble(value.toString());
        } catch (Exception ex) {
            ((UIInput) component).setValid(false);
            ((UIInput) component).setValue(0);
            numberFormatExceptionMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(component.getClientId(context), numberFormatExceptionMessage);
            throw new ValidatorException(numberFormatExceptionMessage);
        }
        double upperBound = 5D;
        double lowerBound = -3D;
        if (y < lowerBound || y > upperBound) {
            ((UIInput) component).setValid(false);
            ((UIInput) component).setValue(0);
            outOfBoundsExceptionMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(component.getClientId(context), outOfBoundsExceptionMessage);
            throw new ValidatorException(outOfBoundsExceptionMessage);

        }
    }
}
