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
import org.eclipse.papyrus.qompass.designer.core.acceleo.AcceleoDriverWrapper;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Instantiate the text within a C++Include tag.
 * TODO: this function is C++ specific and should not be here
 * 
 */
public class InstantiateCppInclude implements CopyListener {

	public static InstantiateCppInclude getInstance() {
		if(instance == null) {
			instance = new InstantiateCppInclude();
		}
		return instance;
	}

	public void init(TemplateBinding binding, Object[] args) {
		this.binding = binding;
		this.args = args;
	}

	public EObject copyEObject(Copy copy, EObject targetEObj) {
		// if (copy.get(sourceEObj) isWithinTemplate)
		if(targetEObj instanceof Classifier) {
			// TODO: C++ specific code!
			Classifier targetCl = (Classifier)targetEObj;
			try {
				Classifier actual = TemplateInstantiationListener.getFirstActualFromBinding(binding, targetCl);
				if(actual != null) {
					Include cppInclude = UMLUtil.getStereotypeApplication(targetCl, Include.class);
					TransformationContext.classifier = targetCl;
					String newBody = AcceleoDriverWrapper.evaluate(cppInclude.getBody(), actual, null);
					String newPreBody = AcceleoDriverWrapper.evaluate(cppInclude.getPreBody(), actual, null);
					String newHeader = AcceleoDriverWrapper.evaluate(cppInclude.getHeader(), actual, null);
					cppInclude.setBody(newBody);
					cppInclude.setPreBody(newPreBody);
					cppInclude.setHeader(newHeader);
				}
			} catch (TransformationException e) {
				// create nested exception
				throw new RuntimeException(e);
			}
		}
		return targetEObj;
	}

	private static InstantiateCppInclude instance = null;

	private TemplateBinding binding;

	// private Copy copy;

	private Object[] args;
}
