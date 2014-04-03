/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.bindinghelpers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.FCM.Template;
import org.eclipse.papyrus.FCM.util.IBindingHelper;
import org.eclipse.papyrus.qompass.designer.core.acceleo.AcceleoDriverWrapper;
import org.eclipse.papyrus.qompass.designer.core.listeners.PostCopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Instantiate (bind Acceleo template) the text within a C++Include stereotype.
 * 
 * Difference to InstantiateCppInclude: This function does not obtain the actual from a template
 * binding. Instead it takes the classifier having the Template stereotype as actual.
 * TODO: What's the use of this function. The classifier is known at this time - unless in a template?
 * 
 * Note: this function is C++ specific, but many parts of the model library are C++ specific as well
 * 
 */
@Deprecated
public class InstantiateCppIncludeWithItSelf implements PostCopyListener, IBindingHelper {

	public void postCopyEObject(LazyCopier copy, EObject targetEObj) {
		// if (copy.get(sourceEObj) isWithinTemplate)
		if(targetEObj instanceof Classifier) {
			// TODO: C++ specific code!
			Classifier targetCl = (Classifier)targetEObj;
			Template template = UMLUtil.getStereotypeApplication(targetCl, Template.class);
			// apply, in case of pass-classifier
			if((template != null) && (template.getHelper() == null)) {
				try {
					Include cppInclude = UMLUtil.getStereotypeApplication(targetCl, Include.class);
					TransformationContext.classifier = targetCl;
					String newBody = AcceleoDriverWrapper.evaluate(cppInclude.getBody(), targetCl, null);
					String newPreBody = AcceleoDriverWrapper.evaluate(cppInclude.getPreBody(), targetCl, null);
					String newHeader = AcceleoDriverWrapper.evaluate(cppInclude.getHeader(), targetCl, null);
					cppInclude.setBody(newBody);
					cppInclude.setPreBody(newPreBody);
					cppInclude.setHeader(newHeader);
				} catch (TransformationException e) {
					// create nested exception
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	public void handleElement(TemplateBinding binding, Element object) {
		// don't need to handle binding
	}
}
