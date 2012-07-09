/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.creation;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.factory.ExtensionFactory;
import org.eclipse.papyrus.customization.factory.ExtensionFactoryRegistry;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.Profile;
import org.eclipse.papyrus.customization.model.customizationplugin.UMLModel;
import org.eclipse.papyrus.customization.wizard.CreateNewCustomizationPluginWizard;
import org.eclipse.papyrus.infra.emf.utils.EClassNameComparator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.widgets.Control;


//TODO : Use E4 Contexts to retrieve the provider
//The provider needs to be (re)injected each time the wizard CustomizationPage is displayed
public class CustomizationElementCreationFactory extends EcorePropertyEditorFactory {

	public CustomizationElementCreationFactory(EReference referenceIn) {
		super(referenceIn);
	}

	@Override
	protected List<EClass> getAvailableEClasses() {
		List<EClass> availableEClasses = EMFHelper.getSubclassesOf(type, true, getContributedEPackages());
		Collections.sort(availableEClasses, new EClassNameComparator());
		return availableEClasses;
	}

	@Override
	protected EObject simpleCreateObject(Control widget) {
		EClass eClass = chooseEClass(widget);
		if(eClass == null) {
			return null;
		}

		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		if(eClass == CustomizationPluginPackage.eINSTANCE.getProfile()) {
			((Profile)instance).setProvider(CreateNewCustomizationPluginWizard.current.getProvider());
		} else if(eClass == CustomizationPluginPackage.eINSTANCE.getUMLModel()) {
			((UMLModel)instance).setProvider(CreateNewCustomizationPluginWizard.current.getProvider());
		}
		return instance;
	}

	public static final String METAMODEL_EXTENSION = Activator.PLUGIN_ID;

	protected static Set<EPackage> getContributedEPackages() {
		if(contributedEPackages == null) {
			contributedEPackages = new HashSet<EPackage>();
			for(ExtensionFactory factory : ExtensionFactoryRegistry.instance.getFactories()) {
				if(factory.getCustomizableElementClass() != null) {
					if(factory.getCustomizableElementClass().getEPackage() != null) {
						contributedEPackages.add(factory.getCustomizableElementClass().getEPackage());
					}
				}

			}
		}
		return contributedEPackages;
	}

	protected static Set<EPackage> contributedEPackages;

}
