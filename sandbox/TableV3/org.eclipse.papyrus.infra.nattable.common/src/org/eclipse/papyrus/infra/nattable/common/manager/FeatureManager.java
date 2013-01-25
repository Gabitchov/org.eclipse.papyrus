package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;


public class FeatureManager extends AbstractAxisManager {

	//	protected Set<?> getAllPossibleContent() {
	//		final Set<EStructuralFeature> alreadyManagedFeatures = new LinkedHashSet<EStructuralFeature>();
	//		for(final IAxis current : getTable().getHorizontalContentProvider().getAxis()) {
	//			if(current instanceof EObjectAxis) {
	//				final EObject eobject = ((EObjectAxis)current).getElement();
	//				alreadyManagedFeatures.addAll(eobject.eClass().getEAllStructuralFeatures());
	//			}
	//		}
	//		return alreadyManagedFeatures;
	//	}


	public Object getDataValue(final int columnIndex, final int rowIndex) {
		final List<Object> list = new ArrayList<Object>(getAllExistingAxis());
		return list.get(columnIndex);
	}


	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}


	public int getColumnCount() {
		return getAllExistingAxis().size();
	}


	public int getRowCount() {
		return getAllExistingAxis().size();
	}


	public Object getHeaderDataValue(final int columnIndex, final int rowIndex) {
		final List<Object> list = new ArrayList<Object>(getAllExistingAxis());
		final Object current = list.get(columnIndex);
		if(current instanceof EStructuralFeature) {
			return ((EStructuralFeature)current).getName();
		}
		return null;
	}


	public int getHeaderColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeaderRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}


	public List<?> getAllVisibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<?> getAllCurrentPossibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	long time = 0;

	int nbCall = 0;

	public List<?> getAllExistingAxis() {
		this.time = 0;
		final long before = System.currentTimeMillis();
		final Set<EStructuralFeature> alreadyManagedFeatures = new LinkedHashSet<EStructuralFeature>();
		if(isUsedVertically()) {
			for(final IAxis current : getTable().getHorizontalContentProvider().getAxis()) {
				if(current instanceof EObjectAxis) {
					final EObject eobject = ((EObjectAxis)current).getElement();
					alreadyManagedFeatures.addAll(eobject.eClass().getEAllStructuralFeatures());
				}
			}
		} else {
			for(final IAxis current : getTable().getVerticalContentProvider().getAxis()) {
				if(current instanceof EObjectAxis) {
					final EObject eobject = ((EObjectAxis)current).getElement();
					alreadyManagedFeatures.addAll(eobject.eClass().getEAllStructuralFeatures());
				}
			}

		}
		final long after = System.currentTimeMillis();
		this.time += (after - before);
		//		System.out.println("time = " + this.time);
		this.nbCall++;
		//		System.out.println("nbCall " + this.nbCall);
		return new ArrayList<Object>(alreadyManagedFeatures);
	}


	public List<String> getEncapsulatedAxisManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
