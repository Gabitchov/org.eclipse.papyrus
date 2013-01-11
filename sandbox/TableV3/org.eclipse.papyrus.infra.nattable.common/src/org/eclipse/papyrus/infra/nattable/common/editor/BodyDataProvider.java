package org.eclipse.papyrus.infra.nattable.common.editor;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;


public class BodyDataProvider implements IDataProvider {

	private final Table table;

	public BodyDataProvider(Table rawModel) {
		this.table = rawModel;
	}

	public Object getDataValue(int columnIndex, int rowIndex) {
		// TODO Auto-generated method stub
		return "valazzue";
	}

	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		// TODO Auto-generated method stub

	}

	public int getColumnCount() {
		Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		EList<EObject> contents = table.getContext().eContents();
		long before = System.currentTimeMillis();
		for(EObject eObject : contents) {
			features.addAll(eObject.eClass().getEStructuralFeatures());
			//			return features.size();
		}
		long after = System.currentTimeMillis();
		System.out.println("refresh");
		System.out.println(after - before + "ms");
		return features.size();
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return table.getContext().eContents().size();
	}

}
