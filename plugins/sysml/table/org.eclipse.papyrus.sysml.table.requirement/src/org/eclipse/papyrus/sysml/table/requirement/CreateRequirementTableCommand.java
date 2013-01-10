/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.table.requirement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.widgets.nattable.internal.Messages;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.TableConfiguration2;
import org.eclipse.papyrus.infra.table.common.handlers.AbstractCreateNattableEditorCommand;
import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration;
import org.eclipse.papyrus.sysml.table.requirement.editor.RequirementTableEditor;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;



/**
 * The command to create the Requirement Table
 * 
 * 
 * 
 */
public class CreateRequirementTableCommand extends AbstractCreateNattableEditorCommand {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateRequirementTableCommand() {
		super(RequirementTableEditor.EDITOR_TYPE, RequirementTableEditor.DEFAULT_NAME);
	}

	@Override
	protected PapyrusTableConfiguration getPapyrusTableConfiguration() {
		ResourceSet resourceSet = new ResourceSetImpl();

		String symbolicName = org.eclipse.papyrus.sysml.table.requirement.Activator.getDefault().getBundle().getSymbolicName();
		URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/requirement.papyrustableconfiguration", true); //$NON-NLS-1$
		Resource resource = resourceSet.getResource(uri, true);

		PapyrusTableConfiguration tableConfiguration = null;
		if(resource.getContents().get(0) instanceof PapyrusTableConfiguration) {
			tableConfiguration = (PapyrusTableConfiguration)resource.getContents().get(0);
			return tableConfiguration;
		}
		return null; 
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.common.handlers.AbstractCreateNattableEditorCommand#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		EObject object = getTableContext();
		if(object instanceof Element) {
			Element el = (Element)object;
			Package pack = el.getNearestPackage();
			//we can create an Allocation Table only when the profile is applied
			return pack.getAppliedProfile(SysmlResource.REQUIREMENTS_ID, true) != null;
		}
		return false;
	}

	@Override
	protected List<String> getHiddenColumnName() {
		List<String> hiddenColumns = new ArrayList<String>();
		hiddenColumns.add(Messages.NatTableWidget_metaclass);
		//TODO should be externalized, currently not externalized in EMF-Facet
		hiddenColumns.add("/eContainer"); //$NON-NLS-1$
		return hiddenColumns;
	}
}
