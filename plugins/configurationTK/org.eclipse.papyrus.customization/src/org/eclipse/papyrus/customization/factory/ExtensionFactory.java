/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.customization.model.customization.CustomizableElement;
import org.eclipse.papyrus.customization.model.customization.CustomizationPackage;
import org.eclipse.papyrus.customization.plugin.ProjectEditor;


public interface ExtensionFactory {

	public static Registry registry = Registry.instance;

	public static class Registry {

		private static Registry instance = new Registry();

		private final Map<EClass, ExtensionFactory> factories;

		private Registry() {
			factories = new HashMap<EClass, ExtensionFactory>();
			factories.put(CustomizationPackage.eINSTANCE.getPropertyView(), new PropertyViewExtensionFactory());
			factories.put(CustomizationPackage.eINSTANCE.getModelTemplate(), new ModelTemplateExtensionFactory());
			factories.put(CustomizationPackage.eINSTANCE.getUICustom(), new UICustomExtensionFactory());
			factories.put(CustomizationPackage.eINSTANCE.getEnvironment(), new EnvironmentExtensionFactory());
			//factoryMap.put("Palette", new Factory("oep.p", "file", "test", true));
			factories.put(CustomizationPackage.eINSTANCE.getProfile(), new ProfileExtensionFactory());
			factories.put(CustomizationPackage.eINSTANCE.getUMLModel(), new UMLModelExtensionFactory());
		}

		public ExtensionFactory getFactory(EClass type) {
			return factories.get(type);
		}

		public void registerFactory(EClass forType, ExtensionFactory factory) {
			factories.put(forType, factory);
		}

		public Collection<? extends ExtensionFactory> getFactories() {
			return factories.values();
		}
	}

	public void addElement(CustomizableElement element, ProjectEditor editor);

	public String getName();
}
