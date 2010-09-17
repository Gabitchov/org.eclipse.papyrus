package org.eclipse.papyrus.compare.report.services;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

public class UmlElementService {
	private static  AdapterFactoryLabelProvider oursAdapterLabelProvider = new AdapterFactoryLabelProvider(
            new UMLItemProviderAdapterFactory());

	public String getText(EObject eobject) {
		return oursAdapterLabelProvider.getText(eobject);
	}
	
	public String getContents(EObject eObject) {
		EClass eClass = eObject.eClass();
		StringBuffer result = new StringBuffer();
        for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
        {
          EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
          if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived())
          {
            if (eStructuralFeature instanceof EAttribute)
            {
             EAttribute attr = (EAttribute)eStructuralFeature;
              result.append(attr.getName());
              result.append('=');
              result.append(eObject.eGet(attr));
              result.append("</br>");
            }
            else
            {
              EReference eReference = (EReference)eStructuralFeature;
              if (eReference.isContainment())
              {
                  result.append(eReference.getName());
                  result.append('=');
                  result.append(eObject.eGet(eReference));
                  result.append("</br>");
              }
            }
          }
        }
		return result.toString();
	}
	

}
