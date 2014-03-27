/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.navigator

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import plugin.Activator
import xpt.Common

@Singleton class DomainNavigatorContentProvider extends xpt.navigator.DomainNavigatorContentProvider {
	@Inject extension Common;

	@Inject Activator xptActivator
	@Inject NavigatorContentProvider xptNavigatorContentProvider;
	@Inject DomainNavigatorItem xptDomainNavigatorItem;

	override def wrapEObjects(GenNavigator it) '''
		«generatedMemberComment()»
		public Object[] wrapEObjects(Object[] objects, Object parentElement) {
			java.util.Collection<«xptDomainNavigatorItem.qualifiedClassName(it)»> result = new java.util.ArrayList<«xptDomainNavigatorItem.qualifiedClassName(it)»>();
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] instanceof org.eclipse.emf.ecore.EObject) {
					result.add(new «xptDomainNavigatorItem.qualifiedClassName(it)»((org.eclipse.emf.ecore.EObject) objects[i], parentElement, myAdapterFctoryContentProvier));
				}
			}
			return result.toArray();
		}
	'''

}
