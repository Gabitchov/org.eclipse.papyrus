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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.nattable.requirement.tester;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.nattable.tester.ITableTester;
import org.eclipse.papyrus.sysml.nattable.requirement.config.Activator;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.service.types.matcher.RequirementMatcher;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * The tester used to know if we can create requirement table
 * 
 * @author Vincent Lorenzo
 * 
 */
public class RequirementTableTester implements ITableTester {

	private static final IElementMatcher matcher = new RequirementMatcher();

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.tester.ITableTester#isAllowed(java.lang.Object)
	 * 
	 * @param context
	 * @return
	 */
	public IStatus isAllowed(Object context) {
		if(context instanceof Element) {
			Element el = (Element)context;
			boolean result = context instanceof Package || matcher.matches(el);
			if(result) {
				//doesn't work!
				final String packageQN = UMLUtil.getProfile(RequirementsPackage.eINSTANCE, el).getQualifiedName();
				result = result && el.getNearestPackage().getAppliedProfile(packageQN, true) != null;
				if(result) {
					return new Status(IStatus.OK, Activator.PLUGIN_ID, "The context allowed to create a Requirement Table");
				} else {
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, String.format("The profile {0} is not applied on the model", packageQN));
				}
			}
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The context is not an UML Element");
	}

}
