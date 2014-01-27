/*****************************************************************************
 * Copyright (c) 2011 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/

package org.eclipse.papyrus.uml.table.defaultt.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.TableConfiguration2;
import org.eclipse.papyrus.infra.table.common.handlers.AbstractCreateNattableEditorCommand;
import org.eclipse.papyrus.uml.table.defaultt.Activator;
import org.eclipse.papyrus.uml.table.defaultt.editor.DefaultNattableEditor;

/**
 * @author dumoulin
 * 
 */
public class CreateNattableEditorCommand extends AbstractCreateNattableEditorCommand {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateNattableEditorCommand() {
		super(DefaultNattableEditor.EDITOR_TYPE, DefaultNattableEditor.DEFAULT_NAME);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected TableConfiguration2 getTableConfiguration2() {
		ResourceSet resourceSet = new ResourceSetImpl();

		String symbolicName = Activator.getInstance().getBundle().getSymbolicName();
		URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/default.tableconfiguration2", true); //$NON-NLS-1$
		Resource resource = resourceSet.getResource(uri, true);

		TableConfiguration2 tableConfiguration = null;
		if(resource.getContents().get(0) instanceof TableConfiguration2) {
			tableConfiguration = (TableConfiguration2)resource.getContents().get(0);
			return tableConfiguration;
		}
		return null;
	}
}
