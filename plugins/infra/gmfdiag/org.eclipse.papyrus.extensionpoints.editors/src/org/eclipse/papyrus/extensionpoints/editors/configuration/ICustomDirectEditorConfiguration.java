/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.extensionpoints.editors.configuration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author andreas muelder
 * 
 */
public interface ICustomDirectEditorConfiguration extends IDirectEditorConfiguration {

	public DirectEditManager createDirectEditManager(ITextAwareEditPart host);

	public IParser createParser(EObject host);
	
	public CellEditor createCellEditor(Composite parent, EObject object);
	
}
