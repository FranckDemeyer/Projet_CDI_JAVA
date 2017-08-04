package com.maville.front.PfConverter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.maville.back.dto.DirectoryHourDTO;
import com.maville.front.bean.DirectoryBean;

@FacesConverter("dirHourConverter")
public class DirectoryHourConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
//		DirectoryBean dirBean = (DirectoryBean) fc.getExternalContext().getApplicationMap().get("directory");
//		List<DirectoryHourDTO> listHours = dirBean.getListHours();
//		return listHours.get(Integer.parseInt(value));
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null){
			return String.valueOf(((DirectoryHourDTO) object).getId());
		}
		return null;
	}

}
