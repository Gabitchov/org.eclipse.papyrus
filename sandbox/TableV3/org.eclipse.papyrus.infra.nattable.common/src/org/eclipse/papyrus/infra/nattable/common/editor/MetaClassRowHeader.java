package org.eclipse.papyrus.infra.nattable.common.editor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.model.nattablepackage.Table;


public class MetaClassRowHeader implements IDataProvider {

	protected final IDataProvider bodyDataProvider;

	Table table;

	public MetaClassRowHeader(Table table, IDataProvider bodyDataProvider) {
		this.bodyDataProvider = bodyDataProvider;
		this.table = table;
	}

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return bodyDataProvider.getRowCount();
	}

	public Object getDataValue(int columnIndex, int rowIndex) {
//		EList<EObject> contents = table.getContext().eContents();
//		EObject current = contents.get(rowIndex);
//		EStructuralFeature feature = current.eClass().getEStructuralFeature("name");
//		if(feature != null) {
//			return current.eGet(feature);
//		}
//		return contents.get(rowIndex).toString();
		return "myOwnHeader";
	}

	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		throw new UnsupportedOperationException();
	}

}
