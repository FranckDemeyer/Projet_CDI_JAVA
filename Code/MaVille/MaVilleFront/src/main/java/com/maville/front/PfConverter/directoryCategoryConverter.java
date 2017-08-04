package com.maville.front.PfConverter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.factories.ServiceFactory;

@FacesConverter("dirCatConverter")
public class directoryCategoryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				return ServiceFactory.getInstance().getDirectoryCategoryService()
						.getDirectoryCategoryById(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"La catégorie n'est pas valide."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((DirectoryCategoryDTO) object).getDirectoryCategoryId());
		} else {
			return null;
		}
	}

}
