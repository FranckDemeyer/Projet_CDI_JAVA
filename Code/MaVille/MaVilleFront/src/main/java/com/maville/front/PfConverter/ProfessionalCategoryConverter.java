package com.maville.front.PfConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.factories.ServiceFactory;

@FacesConverter("proCatConverter")
public class ProfessionalCategoryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() >0) {
			try {
				return ServiceFactory.getInstance().getProfessionalCategoryService().getProfessionalCategoryById(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) return String.valueOf(((ProfessionalCategoryDTO) object).getProfessionalCategoryId());
		return null;
	}

}
