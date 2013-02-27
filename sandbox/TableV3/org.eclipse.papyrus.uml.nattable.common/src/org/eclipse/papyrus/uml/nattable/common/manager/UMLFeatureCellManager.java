package org.eclipse.papyrus.uml.nattable.common.manager;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.solver.CellFeatureValueManager;
import org.eclipse.uml2.uml.UMLPackage;

//FIXME : useless?
public class UMLFeatureCellManager extends CellFeatureValueManager {



	@Override
	public boolean handles(Object obj1, Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		if(objects.size() == 2) {
			final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
			EObject featureContainer = feature.eContainer();
			if(UMLPackage.eINSTANCE.eContents().contains(featureContainer)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean handlersAxisElement(Object obj) {
		if(super.handlersAxisElement(obj)) {
			final EStructuralFeature feature = (EStructuralFeature)obj;
			EObject featureContainer = feature.eContainer();
			if(UMLPackage.eINSTANCE.eContents().contains(featureContainer)) {
				return true;
			}
		}
		return false;
	}



	//	@Override
	//	public ICellEditor getCellEditor(Table table, Object obj) {
	//		if(obj instanceof EAttribute) {
	//			return getEAttributeCellEditor(table, (EAttribute)obj);
	//		} else if(obj instanceof EReference)
	//			return getEReferenceCellEditor(table, (EReference)obj);
	//		return null;
	//	}

	//	protected ICellEditor getEReferenceCellEditor(final Table table, final EReference reference) {
	//		if(reference.isMany()) {
	//			return getEReferenceNAryEditor(table, reference);
	//		} else {
	//			return getEReferenceUnaryEditor(table, reference);
	//		}
	//	}
	//
	//	protected ICellEditor getEAttributeCellEditor(final Table table, final EAttribute attribute) {
	//		if(attribute.isMany()) {
	//			return getEAttributeNAryEditor(table, attribute);
	//		} else {
	//			return getEAttributeUnaryEditor(table, attribute);
	//		}
	//	}
	//
	//	protected ICellEditor getEReferenceNAryEditor(final Table table, final EReference reference) {
	//		return null;
	//	}
	//
	//	protected ICellEditor getEReferenceUnaryEditor(final Table table, final EReference reference) {
	//		return null;
	//	}
	//
	//	protected ICellEditor getEAttributeNAryEditor(final Table table, final EAttribute attribute) {
	//		return null;
	//	}
	//
	//	protected ICellEditor getEAttributeUnaryEditor(final Table table, final EAttribute attribute) {
	//		return null;
	//	}

}
