/**
 * Copyright (c) 2012, 2013 Fraunhofer Institute FOKUS
 *
 * This file is part of Open Data Platform.
 *
 * Open Data Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Open Data Plaform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with Open Data Platform.  If not, see <http://www.gnu.org/licenses/agpl-3.0>.
 */

/**
 * @author msg
 */

package de.fhg.fokus.odp.portal.managedatasets.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("formatConverter")
public class FormatConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// Return String value in lower case
		return value.toString().toLowerCase();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		// Return String value in lower case
		return value.toString().toLowerCase();
	}

}
