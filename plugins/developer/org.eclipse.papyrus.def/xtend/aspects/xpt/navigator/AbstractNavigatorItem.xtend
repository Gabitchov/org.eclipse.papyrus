/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
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
import xpt.Common

@Singleton class AbstractNavigatorItem extends xpt.navigator.AbstractNavigatorItem {
	@Inject extension Common;

	override def registerAdapterFactory(GenNavigator it) '''
		«generatedMemberComment()»
		static {
			@SuppressWarnings("rawtypes")
			final Class[] supportedTypes = new Class[] { org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class };
			final org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor propertySheetPageContributor = new org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor() {
				public String getContributorId() {
					return "«editorGen.plugin.ID»";  «nonNLS(1)»
				}
			};
			org.eclipse.core.runtime.Platform.getAdapterManager().registerAdapters(new org.eclipse.core.runtime.IAdapterFactory() {
				
				@SuppressWarnings("rawtypes")
				public Object getAdapter(Object adaptableObject, Class adapterType) {
					if (adaptableObject instanceof «qualifiedClassName(it)» && adapterType == org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class) {
						return propertySheetPageContributor;				
					}
					return null;
				}
		
				@SuppressWarnings("rawtypes")
				public Class[] getAdapterList() {
					return supportedTypes;
				}
			}, «qualifiedClassName(it)».class);
		}
	'''

}
