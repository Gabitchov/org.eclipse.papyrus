/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.queries;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.ImageUtils;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.custompt.ImageWrapper;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.query.ImageQuery;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/** Create a basic label based on element name */
public class GetImageQuery implements IJavaQuery2<Element, IImage> {

	//public static final String sysml_plugin_path = "platform:/plugin/org.eclipse.papyrus.sysml/";


	//@Override
	public IImage evaluate(Element source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		ParameterValue parameterValue= (ParameterValue)parameterValues.getParameterValueByName("eObject");
		if(parameterValue.getValue() instanceof EStructuralFeature){
			return ImageQuery.getEObjectImage((EStructuralFeature)parameterValue.getValue()); 
		}
		
		String iconPath = "";
		if(!source.getAppliedStereotypes().isEmpty()) {
			Stereotype first_stereotype = source.getAppliedStereotypes().get(0);

			if(!first_stereotype.getIcons().isEmpty()) {
				org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(source, first_stereotype, "icon");
				if(icon != null) {
					iconPath = icon.getLocation();
				}
			}
		}

		String imagePath = "";

		if(iconPath != null && !"".equals(iconPath)) {
			URI iconURI = URI.createURI(iconPath);
//			if(iconURI.isRelative()) {
//				imagePath = sysml_plugin_path + iconPath;
//			} else {
				imagePath = iconURI.toString();
		//	}
		}
		if("".equals(imagePath)){
			return ImageQuery.getEObjectImage(source);
		}
		return ImageUtils.wrap(imagePath);
	}
}
