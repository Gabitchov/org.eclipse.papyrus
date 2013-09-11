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

package org.eclipse.papyrus.qompass.designer.core.templates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.FCM.Template;
import org.eclipse.papyrus.FCM.TemplateKind;
import org.eclipse.papyrus.qompass.designer.core.acceleo.AcceleoDriverWrapper;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Instantiate the text within a C++Include tag.
 * Difference to InstantiateCppInclude: This function does not obtain the actual from a template
 * binding.
 * 
 * TODO: this function is C++ specific and should not be here
 * 
 */
public class InstantiateCppIncludeWOB implements CopyListener {

	public static InstantiateCppIncludeWOB getInstance() {
		if(instance == null) {
			instance = new InstantiateCppIncludeWOB();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject targetEObj) {
		// if (copy.get(sourceEObj) isWithinTemplate)
		if(targetEObj instanceof Classifier) {
			// TODO: C++ specific code!
			Classifier targetCl = (Classifier)targetEObj;
			Template template = UMLUtil.getStereotypeApplication(targetCl, Template.class);
			// apply, in case of pass-classifier
			if((template != null) && (template.getKind() == TemplateKind.PASS_CLASSIFIER)) {
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
		return targetEObj;
	}

	private static InstantiateCppIncludeWOB instance = null;
}
