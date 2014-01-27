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
package org.eclipse.papyrus.sysml.table.allocation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.TableConfiguration2;
import org.eclipse.papyrus.infra.table.common.handlers.AbstractCreateNattableEditorCommand;
import org.eclipse.papyrus.sysml.table.allocation.editor.AllocationTableEditor;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;



/**
 * The command to create the Requirement Table
 * 
 * 
 * 
 */
public class CreateAllocationTableCommand extends AbstractCreateNattableEditorCommand {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateAllocationTableCommand() {
		super(AllocationTableEditor.EDITOR_TYPE, AllocationTableEditor.DEFAULT_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.common.handlers.AbstractCreateNattableEditorCommand#getTableConfiguration()
	 * 
	 * @return
	 */
	@Override
	protected TableConfiguration2 getTableConfiguration2() {
		ResourceSet resourceSet = new ResourceSetImpl();

		String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/allocate.tableconfiguration2", true); //$NON-NLS-1$
		Resource resource = resourceSet.getResource(uri, true);

		TableConfiguration2 tableConfiguration = null;
		if(resource.getContents().get(0) instanceof org.eclipse.emf.facet.widgets.nattable.tableconfiguration.TableConfiguration) {
			tableConfiguration = (TableConfiguration2)resource.getContents().get(0);
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
			return pack.getAppliedProfile(SysmlResource.ALLOCATIONS_ID, true) != null;
		}
		return false;
	}

}
