/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.properties.modelelement;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;
import org.eclipse.papyrus.infra.table.efacet.properties.providers.ContextFeatureContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;


public class TableModelElement extends EMFModelElement {

	private final PapyrusTable sourceTable;

	public TableModelElement(final PapyrusTable source, final EditingDomain domain) {
		super(source, domain);
		this.sourceTable = source;
	}

	@Override
	public IStaticContentProvider getContentProvider(final String propertyPath) {
		if(PapyrustablePackage.eINSTANCE.getPapyrusTable_ContextFeature().getName().equals(propertyPath)) {//TODO change this string by the string owned by the table model if it exists
			return new ContextFeatureContentProvider(this.sourceTable);
		}
		return super.getContentProvider(propertyPath);
	}

	@Override
	public ILabelProvider getLabelProvider(final String propertyPath) {
		if("table.context".equals(propertyPath)) { //$NON-NLS-1$
			//TODO when the label provider service will exisit ()warning to stereotyped element! (SysML != UML!!) 
		}
		return super.getLabelProvider(propertyPath);
	}
}
