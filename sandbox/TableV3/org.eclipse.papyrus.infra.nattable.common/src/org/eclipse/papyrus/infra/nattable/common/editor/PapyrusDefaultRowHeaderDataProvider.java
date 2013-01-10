/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.editor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.model.nattablepackage.Table;

public class PapyrusDefaultRowHeaderDataProvider implements IDataProvider {

	protected final IDataProvider bodyDataProvider;

	Table table;

	String aString = "a";

	String[][] value = { { aString, "b", "c" }, { aString, "b", "c" } };

	public PapyrusDefaultRowHeaderDataProvider(Table table, IDataProvider bodyDataProvider) {
		this.bodyDataProvider = bodyDataProvider;
		this.table = table;
	}

	public int getColumnCount() {
		return 1;
	}

	public int getRowCount() {
		return table.getContext().eContents().size();
	}

	public Object getDataValue(int columnIndex, int rowIndex) {
		//		return value[columnIndex][rowIndex];
		EList<EObject> contents = table.getContext().eContents();
		EObject current = contents.get(rowIndex);
		EStructuralFeature feature = current.eClass().getEStructuralFeature("name");
		if(feature != null) {
			return current.eGet(feature);
		}
		return contents.get(rowIndex).toString();
	}

	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		throw new UnsupportedOperationException();
	}

}
