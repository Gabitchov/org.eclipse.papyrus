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
import org.eclipse.papyrus.FCM.BindingHelper;
import org.eclipse.papyrus.FCM.Template;
import org.eclipse.papyrus.qompass.designer.core.extensions.BindingHelperExt;
import org.eclipse.papyrus.qompass.designer.core.listeners.PreCopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Template instantiation is implemented by means of an CopyListener that
 * evaluates the template stereotype.
 */

public class PreTemplateInstantiationListener implements PreCopyListener {

	public static PreTemplateInstantiationListener getInstance() {
		if(preTemplateInstantiationListener == null) {
			preTemplateInstantiationListener = new PreTemplateInstantiationListener();
			preTemplateInstantiationListener.treatTemplate = false;
		}
		return preTemplateInstantiationListener;
	}

	public void init(LazyCopier copy, TemplateBinding binding, Object[] args) {
		this.binding = binding;
	}

	private TemplateBinding binding;

	private boolean treatTemplate;

	private static PreTemplateInstantiationListener preTemplateInstantiationListener;

	public EObject preCopyEObject(LazyCopier copy, EObject sourceEObj) {
		if(treatTemplate) {
			return sourceEObj;
		}
		treatTemplate = true;
		EObject targetEObj = checkEObject(copy, sourceEObj);
		treatTemplate = false;
		return targetEObj;
	}

	protected EObject checkEObject(LazyCopier copy, EObject sourceEObj) {
			
		// Specific treatment of OpaqueBehaviors: Template instantiations are typically managed
		// by the associated operation which instantiates operation and behavior. In this case, the
		// behavior should not be instantiated.
		if(sourceEObj instanceof OpaqueBehavior) {
			OpaqueBehavior behavior = (OpaqueBehavior)sourceEObj;
			BehavioralFeature bf = behavior.getSpecification();
			if(bf != null) {
				Template template = UMLUtil.getStereotypeApplication(bf, Template.class);
				if(template != null) {
					return null;
				}
			}
		}
		
		if(sourceEObj instanceof Element) {
		
			Template template = UMLUtil.getStereotypeApplication((Element)sourceEObj, Template.class);
			if((template != null)) {
				BindingHelper helper = template.getHelper();
				if (helper != null) {
					return BindingHelperExt.applyPreHelper(helper, copy, binding, sourceEObj);
				}
			}
		}
		return sourceEObj;
	}
}
