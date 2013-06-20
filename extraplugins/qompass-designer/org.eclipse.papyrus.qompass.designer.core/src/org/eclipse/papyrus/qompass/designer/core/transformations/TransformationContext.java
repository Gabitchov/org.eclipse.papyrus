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

package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.papyrus.qompass.designer.core.templates.TemplateInstantiation;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.TemplateBinding;

/**
 * Return information about the current values in the context of a transformation
 * e.g. the current instance, the current port (container transformation), ...
 * 
 * TODO: clean separation ContainerContext? (e.g. port should only be in the latter)
 * 
 * @author ansgar
 * 
 */
public class TransformationContext {

	public static InstanceSpecification instance;

	public static InstanceSpecification getInstance() {
		return instance;
	}

	public static Port port;

	public static Port getPort() {
		return port;
	}

	public static Package sourceRoot;

	public static Package getSourceRoot() {
		return sourceRoot;
	}

	public static Classifier formalParameter;

	public static Classifier getFormalParameter() {
		return formalParameter;
	}

	// the element, to which transformations are currently applied.
	public static Classifier classifier;

	public static Classifier getClassifier() {
		return classifier;
	}

	/**
	 * Set sat and binding context for pkgTemplateParameter function
	 * 
	 * @param sat
	 * @param binding
	 */
	public static void setTemplateInstantiation(TemplateInstantiation ti) {
		TransformationContext.ti = ti;
	}

	public static TemplateInstantiation ti;

	/**
	 * Return actual (in the current binding context) from a named package template parameter
	 * Used during template instantiation: code can access actual template parameter via formal
	 * 
	 * @param formal
	 *        the name of the formal parameter
	 * @return the actual
	 */
	public static String pkgTemplateParameter(String formal) {
		Classifier actual = TemplateUtils.getActualFromBinding(ti.binding, formal);
		if(actual != null) {
			return actual.getQualifiedName();
		}
		else {
			return "";
		}
	}

	public static TemplateBinding getBinding() {
		return ti.binding;
	}
}
