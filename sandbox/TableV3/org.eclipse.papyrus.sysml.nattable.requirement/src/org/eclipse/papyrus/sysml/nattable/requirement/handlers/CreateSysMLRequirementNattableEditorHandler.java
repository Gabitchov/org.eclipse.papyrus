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
package org.eclipse.papyrus.sysml.nattable.requirement.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.nattable.requirement.Activator;
import org.eclipse.papyrus.sysml.nattable.requirement.editor.SysMLRequirementNattableEditor;
import org.eclipse.papyrus.sysml.service.types.matcher.RequirementMatcher;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.nattable.common.handlers.AbstractCreateUMLNattableEditorHandler;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class CreateSysMLRequirementNattableEditorHandler extends AbstractCreateUMLNattableEditorHandler {

	private static final String CONFIGURATION_PATH = "/resources/requirement.nattableconfiguration";

	private static final IElementMatcher matcher = new RequirementMatcher();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateSysMLRequirementNattableEditorHandler() {
		super(SysMLRequirementNattableEditor.EDITOR_TYPE, SysMLRequirementNattableEditor.DEFAULT_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.handlers.AbstractCreateNattableEditorHandler#getTableEditorConfigurationURI()
	 * 
	 * @return
	 */
	@Override
	protected URI getTableEditorConfigurationURI() {
		final String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		final URI uri = URI.createPlatformPluginURI(symbolicName + CONFIGURATION_PATH, true); //$NON-NLS-1$
		return uri;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.messages.handlers.AbstractCreateUMLNattableEditorHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		if(super.isEnabled()) {
			final EObject context = getSelection().get(0);
			boolean result = context instanceof Package || matcher.matches(context);
			Element el = (Element)context;
			return result && el.getNearestPackage().getAppliedProfile(SysmlResource.REQUIREMENTS_ID, true) != null;
		}
		return false;
	}
}
