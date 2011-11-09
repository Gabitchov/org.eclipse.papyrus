package org.eclipse.papyrus.customization.creation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.customization.model.customization.CustomizationPackage;
import org.eclipse.papyrus.customization.model.customization.Profile;
import org.eclipse.papyrus.customization.model.customization.UMLModel;
import org.eclipse.papyrus.customization.wizard.CreateNewCustomizationPluginWizard;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.widgets.Control;


//TODO : Use E4 Contexts to retrieve the provider
//The provider needs to be (re)injected each time the wizard CustomizationPage is displayed
public class CustomizationElementCreationFactory extends EcorePropertyEditorFactory {

	public CustomizationElementCreationFactory(EReference referenceIn) {
		super(referenceIn);
	}

	@Override
	protected EObject simpleCreateObject(Control widget) {
		EClass eClass = chooseEClass(widget);
		if(eClass == null) {
			return null;
		}

		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		if(eClass == CustomizationPackage.eINSTANCE.getProfile()) {
			((Profile)instance).setProvider(CreateNewCustomizationPluginWizard.current.getProvider());
		} else if(eClass == CustomizationPackage.eINSTANCE.getUMLModel()) {
			((UMLModel)instance).setProvider(CreateNewCustomizationPluginWizard.current.getProvider());
		}
		return instance;
	}

}
