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

package de.fhg.fokus.odp.portal.managedatasets.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.portlet.PortletRequest;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.language.LanguageUtil;

import de.fhg.fokus.odp.portal.managedatasets.controller.ManageController;

@FacesValidator("dateTemporalCoverageValidator")
public class DateTemporalCoverageValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        LiferayFacesContext lfc = LiferayFacesContext.getInstance();
        PortletRequest request = (PortletRequest) lfc.getExternalContext().getRequest();

        SimpleDateFormat sdf = new SimpleDateFormat(ManageController.DATE_PATTERN);

        UIInput startInput = (UIInput) component.getAttributes().get("temporal_coverage_from");
        UIInput endInput = (UIInput) component.getAttributes().get("temporal_coverage_to");

        try {

            if (startInput != null && endInput != null) {

                Date startDate = sdf.parse((String) startInput.getSubmittedValue());
                Date endDate = sdf.parse((String) endInput.getSubmittedValue());

                if (!startDate.before(endDate)) {
                    FacesMessage msg = new FacesMessage(LanguageUtil.get(request.getLocale(), "od.date.temporal.relation.error"),
                            LanguageUtil.get(request.getLocale(), "od.date.temporal.relation.error"));
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msg);
                }
            }

        } catch (ParseException e) {
            FacesMessage msg = new FacesMessage(LanguageUtil.get(request.getLocale(), "od.date.invalid"), LanguageUtil.get(
                    request.getLocale(), "od.date.invalid"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }

}
