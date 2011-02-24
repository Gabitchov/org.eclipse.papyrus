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
package org.eclipse.papyrus.table.modelexplorer.providers;

import java.util.Map;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;
import org.eclipse.swt.graphics.Image;

/**
 * This Label Provider provides the names of the tables
 * 
 * 
 * 
 */
public class NavigatorTableLabelProvider extends MoDiscoLabelProvider {


	/**
	 * return the image of an element in the model browser
	 * evaluates error markers.
	 */
	@Override
	public Image getImage(Object element) {
		if(element instanceof TableInstance) {
			return getEditorRegistry().getEditorIcon(element);
		}
		return super.getImage(element);
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		if(element instanceof TableInstance) {
			Object param = ((TableInstance)element).getParameter();
			if(param instanceof Map<?, ?>) {
				return (String)((Map<?, ?>)param).get(AbstractNattableEditor.NAME_KEY); //$NON-NLS-1$
			}
		}
		return super.getText(element);
	}

}
