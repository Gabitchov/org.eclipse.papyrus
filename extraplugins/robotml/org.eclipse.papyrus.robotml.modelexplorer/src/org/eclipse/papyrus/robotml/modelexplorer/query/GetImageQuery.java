/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.modelexplorer.query;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

public class GetImageQuery implements IJavaModelQuery<Element, String> {



	public static String ROBOTML_ID = "RobotML";

	public static final String robotML_plugin_path = "/org.eclipse.papyrus.robotml/";

	public String evaluate(final Element context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {

		String icon_relative_path = "";

		if(!context.getAppliedStereotypes().isEmpty()) {


			Stereotype first_stereotype = context.getAppliedStereotypes().get(0);
			Profile robotML = first_stereotype.getProfile();


			if(robotML != null && robotML.getName().equals(ROBOTML_ID)) {
				if(!first_stereotype.getIcons().isEmpty()) {
					org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(context, first_stereotype, "icon");
					if(icon != null) {
						icon_relative_path = icon.getLocation();
					}
				}
			}
		}

		String image_path = "";
		if(!"".equals(icon_relative_path)) {
			image_path = robotML_plugin_path + icon_relative_path;
		}
		return image_path;
	}
}
