package org.eclipse.papyrus.compare.report.services;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

public class UmlElementService {

	private static AdapterFactoryLabelProvider oursAdapterLabelProvider = new AdapterFactoryLabelProvider(
			new UMLItemProviderAdapterFactory());

	public String getFileName(DiffModel model) {
		return getFirstElementName(model.getLeftRoots()) + "_diff_" + getFirstElementName(model.getRightRoots());
	}

	private String getFirstElementName(EList<EObject> children) {
		if (children.isEmpty()) {
			return "";
		}
		return getElementName(children.get(0));
	}
	
	public String getText(EObject eobject) {
		return oursAdapterLabelProvider.getText(eobject);
	}
	

	public String getContents(EObject eObject) {
		EClass eClass = eObject.eClass();
		StringBuffer result = new StringBuffer();
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
			EStructuralFeature eStructuralFeature = eClass
					.getEStructuralFeature(i);
			if (eStructuralFeature.isChangeable()
					&& !eStructuralFeature.isDerived()) {
				if (eStructuralFeature instanceof EAttribute) {
					result.append(getAttributeString(eObject,
							(EAttribute) eStructuralFeature));
				} else {
					result.append(getReferenceString(eObject,
							(EReference) eStructuralFeature));
				}
			}
		}
		return result.toString();
	}

	private StringBuffer getAttributeString(EObject eObject, EAttribute attr) {
		StringBuffer result = new StringBuffer();
		Object attrValue = eObject.eGet(attr);
		if (attrValue != null && !attrValue.equals("")) {
			result.append(attr.getName());
			result.append(" : ");
			result.append(attrValue);
			result.append("</br>");
		}
		return result;
	}

	private StringBuffer getReferenceString(EObject eObject,
			EReference eReference) {
		StringBuffer result = new StringBuffer();
		Object refValue = getElementName(eObject.eGet(eReference));
		if (refValue != null && !refValue.equals("") && !refValue.equals("[]") && !refValue.equals(" ")) {
			if (eReference.isContainment()) {
				result.append(eReference.getName());
				result.append("&nbsp;");
				result.append(" : ");
				result.append(refValue);
				result.append("</br>");
			} else {
				result.append(eReference.getName());
				result.append(" : ");
				result.append("'" + refValue + "'");
				result.append("</br>");
			}
		}
		return result;
	}

	private String getElementName(Object obj) {
		if (obj == null) {
			return "";
		}
		if (obj instanceof NamedElement) {
			return ((NamedElement) obj).getLabel();
		}
		if (obj instanceof Comment) {
			return ((Comment) obj).getBody();
		}
		if (obj instanceof EObject) {
			return obj.toString();
		}
		if (obj instanceof List) {
			String result = "";
			for (Object next : ((List) obj)) {
				result += getElementName(next);
				result += ", ";
			}
			return result;
		}
		return obj.toString();
	}

}
