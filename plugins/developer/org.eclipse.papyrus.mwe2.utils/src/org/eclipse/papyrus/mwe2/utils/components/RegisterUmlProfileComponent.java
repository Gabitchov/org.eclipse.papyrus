/*******************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Juan Cadavid <juan.cadavid@cea.fr> implementation
 ******************************************************************************/
package org.eclipse.papyrus.mwe2.utils.components;


import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.papyrus.mwe2.utils.messages.Messages;
import org.eclipse.uml2.uml.Profile;

/**
 * This MWE component registers the EPackage definition of a UML profile in the global EPackage registry.
 * An example of its usage is:
 * <blockquote>
 * component = org.eclipse.papyrus.mwe.utils.components.RegisterUmlProfile {
		profileSlot = 'ecoreprofile'
	} 
	</blockquote>
 * where profileSlot is a slot that contains the uml Profile object to register.
 */
public class RegisterUmlProfileComponent extends AbstractWorkflowComponent {
	private org.apache.commons.logging.Log log = LogFactory.getLog(getClass());


	private String profileSlot;
	
	public String getProfileSlot() {
		return profileSlot;
	}

	public void setProfileSlot(String profileSlot) {
		this.profileSlot = profileSlot;
	}

	public void checkConfiguration(Issues issues) {
		if(profileSlot == null || profileSlot.equals("")){ //$NON-NLS-1$
			issues.addError(Messages.RegisterUmlProfile_1);
		}
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		EObject eObject = (EObject) ctx.get(profileSlot);
		if(!(eObject instanceof Profile)){
			log.error(Messages.RegisterUmlProfile_2);
			return;
		}
		Profile profile = (Profile) eObject;
		EPackage definition = profile.getDefinition();
		if(definition == null){
			log.error(Messages.RegisterUmlProfile_3);
			return;
		}
		EPackage.Registry.INSTANCE.put(definition.getNsURI(), definition);
	}



}
