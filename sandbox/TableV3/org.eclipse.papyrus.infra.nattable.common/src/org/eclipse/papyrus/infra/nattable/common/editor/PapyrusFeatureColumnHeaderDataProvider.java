package org.eclipse.papyrus.infra.nattable.common.editor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

public class PapyrusFeatureColumnHeaderDataProvider implements IDataProvider {

	//	private final String[] propertyNames;

	Table table;

	//	private Map<String, String> propertyToLabelMap;

	public PapyrusFeatureColumnHeaderDataProvider(final Table table) {
		this.table = table;
		//		propertyNames = columnLabels;
	}

	//	public DefaultColumnHeaderDataProvider(final String[] propertyNames, Map<String, String> propertyToLabelMap) {
	//		this.propertyNames = propertyNames;
	//		this.propertyToLabelMap = propertyToLabelMap;
	//	}

	public String getColumnHeaderLabel(int columnIndex) {
		Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		EList<EObject> contents = table.getContext().eContents();
		for(EObject eObject : contents) {
			features.addAll(eObject.eClass().getEStructuralFeatures());
		}
		List<EStructuralFeature> features2 = new ArrayList<EStructuralFeature>();
		features2.addAll(features);
		return features2.get(columnIndex).getName();
	}

	public int getColumnCount() {
		Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		EList<EObject> contents = table.getContext().eContents();
		for(EObject eObject : contents) {
			features.addAll(eObject.eClass().getEStructuralFeatures());
		}
		return features.size();
		//		return 3;
	}

	public int getRowCount() {
		return 1;
	}

	/**
	 * This class does not support multiple rows in the column header layer.
	 */
	public Object getDataValue(int columnIndex, int rowIndex) {
		return getColumnHeaderLabel(columnIndex);
	}

	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		//		throw new UnsupportedOperationException();
	}

}
