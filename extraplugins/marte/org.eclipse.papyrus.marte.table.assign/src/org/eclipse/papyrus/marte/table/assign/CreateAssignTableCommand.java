/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.TableConfiguration2;
import org.eclipse.papyrus.marte.table.assign.editor.AssignTableEditor;
import org.eclipse.papyrus.table.common.handlers.AbstractCreateNattableEditorCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;


public class CreateAssignTableCommand extends AbstractCreateNattableEditorCommand {

	/**
	 * Constructor
	 */
	public CreateAssignTableCommand() {
		super(AssignTableEditor.EDITOR_TYPE, AssignTableEditor.DEFAULT_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.table.common.handlers.AbstractCreateNattableEditorCommand#getTableConfiguration()
	 * 
	 * @return
	 */
	@Override
	protected TableConfiguration2 getTableConfiguration2() {
		ResourceSet resourceSet = new ResourceSetImpl();

		String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/assign.tableconfiguration2", true); //$NON-NLS-1$
		Resource resource = resourceSet.getResource(uri, true);

		TableConfiguration2 tableConfiguration = null;
		if(resource.getContents().get(0) instanceof org.eclipse.emf.facet.widgets.nattable.tableconfiguration.TableConfiguration) {
			tableConfiguration = (TableConfiguration2)resource.getContents().get(0);
			return tableConfiguration;
		}
		return null;
	}

	/**
	 * Checks that the context is a package.
	 * 
	 * @see org.eclipse.papyrus.table.common.handlers.AbstractCreateNattableEditorCommand#isEnabled()
	 * 
	 */
	@Override
	public boolean isEnabled() {
		return (null != getTableContext());

	}

	/**
	 * The context for a assign table should be a package.
	 */
	@Override
	protected EObject getTableContext() {
		EObject context = super.getTableContext();
		EObject result = null;
		if(context instanceof Package) {
			result = context;
		} else if(context instanceof Element) {
			Element el = (Element)context;
			Package pack = el.getNearestPackage();
			result = pack;
		}
		return result;
	}

}
