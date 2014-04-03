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
import org.eclipse.papyrus.qompass.designer.core.listeners.PostCopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Template instantiation is implemented by means of a PostCopyListener that
 * evaluates the template stereotype.
 */

public class PostTemplateInstantiationListener implements PostCopyListener {

	public static PostTemplateInstantiationListener getInstance() {
		if(postTemplateInstantiationListener == null) {
			postTemplateInstantiationListener = new PostTemplateInstantiationListener();
		}
		return postTemplateInstantiationListener;
	}

	public void init(LazyCopier copy, TemplateBinding binding, Object[] args) {
		this.binding = binding;
	}

	private TemplateBinding binding;

	private static PostTemplateInstantiationListener postTemplateInstantiationListener;

	public void postCopyEObject(LazyCopier copy, EObject targetEObj) {
		if(targetEObj instanceof Element) {
			
			Template template = UMLUtil.getStereotypeApplication((Element)targetEObj, Template.class);
			if((template != null)) {
				BindingHelper helper = template.getHelper();
				if (helper != null) {
					BindingHelperExt.applyPostHelper(helper, copy, binding, targetEObj);
				}
			}
		}
	}
}
