package org.eclipse.papyrus.infra.nattable.common.dataprovider;

import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;


public class BodyDataProvider implements IDataProvider {


	//	private final Table table;

	private final INattableModelManager modelManager;

	public BodyDataProvider(final INattableModelManager tableModelManager) {
		this.modelManager = tableModelManager;
		//		this.table = rawModel;
	}

	public Object getDataValue(int columnIndex, int rowIndex) {
		IDataProvider provider = this.modelManager.getBodyDataProvider();
		return provider.getDataValue(columnIndex, rowIndex);
		//		IAxis axis = table.getHorizontalContentProvider().getAxis().get(rowIndex);
		//		EObject current = null;
		//		EStructuralFeature feature = null;
		//		if(axis instanceof EObjectAxis) {
		//			current = (EObject)axis.getElement();
		//		}
		//
		//		IAxisContentsProvider verticalContentProvider = table.getVerticalContentProvider();
		//		if(verticalContentProvider instanceof TransientContentProvider) {
		//			IAxis featureAxis = ((TransientContentProvider)verticalContentProvider).getTransientAxis().get(columnIndex);
		//			if(featureAxis instanceof EObjectAxis) {
		//				final EObject el = (EObject)featureAxis.getElement();
		//				if(el instanceof EStructuralFeature) {
		//					feature = (EStructuralFeature)el;
		//				}
		//			}
		//		}
		//
		//		if(current.eClass().getEAllStructuralFeatures().contains(feature)) {
		//			return current.eGet(feature);
		//		}

//		return "N/A";
	}

	public void setDataValue(int columnIndex, int rowIndex, Object newValue) {
		// TODO Auto-generated method stub
	}

	public int getColumnCount() {
		return modelManager.getColumnCount();
	}

	public int getRowCount() {
		return modelManager.getRowCount();
	}

}
