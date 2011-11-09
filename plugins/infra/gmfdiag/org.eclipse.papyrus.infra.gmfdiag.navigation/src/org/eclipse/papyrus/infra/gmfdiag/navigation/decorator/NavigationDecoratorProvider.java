/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.navigation.decorator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.papyrus.infra.gmfdiag.navigation.preference.INavigationPreferenceConstant;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;

public class NavigationDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	private static Set<Class<?>> forbiddenClasses = new HashSet<Class<?>>();

	private static Set<Class<?>> decoratedClasses = new HashSet<Class<?>>();

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.gmfdiag.navigation.navigationDecoratorRules";

	private static final String FORBIDDENCLASS_ID = "forbiddenClass";

	private static final String DECORATEDCLASS_ID = "decoratedClass";

	private static final String CLASS_ID = "class";

	static {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for(IConfigurationElement configElement : configElements) {
			String className = configElement.getAttribute(CLASS_ID);
			Class<?> class_ = null;
			try {
				class_ = Platform.getBundle(configElement.getContributor().getName()).loadClass(className);
			} catch (Exception e) {
			}

			if(class_ != null) {
				if(FORBIDDENCLASS_ID.equals(configElement.getName())) {
					forbiddenClasses.add(class_);
				} else if(DECORATEDCLASS_ID.equals(configElement.getName())) {
					decoratedClasses.add(class_);
				}
			}
		}
	}

	public boolean provides(IOperation operation) {
		String decoratorVisibility = Activator.getDefault().getPreferenceStore().getString(INavigationPreferenceConstant.PAPYRUS_NAVIGATION_DECORATOR_VISIBILITY);
		if(operation instanceof CreateDecoratorsOperation && !INavigationPreferenceConstant.DISABLED.equals(decoratorVisibility)) {
			IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation)operation).getDecoratorTarget();
			EditPart editPart = (EditPart)decoratorTarget.getAdapter(EditPart.class);
			if(editPart instanceof IPrimaryEditPart) {
				EObject element = ((IGraphicalEditPart)editPart).resolveSemanticElement();
				boolean decorate = false;
				for(Class<?> class_ : decoratedClasses) {
					if(class_.isInstance(element)) {
						decorate = true;
						break;
					}
				}
				for(Class<?> class_ : forbiddenClasses) {
					if(class_.isInstance(element)) {
						decorate = false;
						break;
					}
				}
				return decorate;
			}
		}
		return false;
	}

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		new NavigationDecorator(decoratorTarget);
	}

}
