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
package org.eclipse.papyrus.uml.nattable.editor;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;

/**
 * CellEditor for multivalued references
 * 
 * @author Vincent Lorenzo
 * 
 */
public class MultiReferenceCellEditor extends AbstractUMLMultiValueCellEditor {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param axisElement
	 * @param elementProvider
	 */
	public MultiReferenceCellEditor(Object axisElement, ITableAxisElementProvider elementProvider) {
		super(axisElement, elementProvider);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.celleditor.AbstractUMLMultiValueCellEditor#getFactory()
	 * 
	 * @return
	 */
	@Override
	protected ReferenceValueFactory getFactory() {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.celleditor.AbstractUMLMultiValueCellEditor#getElementSelector(boolean,
	 *      org.eclipse.jface.viewers.ILabelProvider, org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider)
	 * 
	 * @param isUnique
	 * @param labelProvider
	 * @param contentProvider
	 * @return
	 */
	@Override
	protected IElementSelector getElementSelector(final boolean isUnique, final ILabelProvider labelProvider, final IStaticContentProvider contentProvider) {
		final ReferenceSelector selector = new ReferenceSelector(isUnique);
		selector.setContentProvider(contentProvider);
		selector.setLabelProvider(new UMLLabelProvider());
		return selector;
	}



}
