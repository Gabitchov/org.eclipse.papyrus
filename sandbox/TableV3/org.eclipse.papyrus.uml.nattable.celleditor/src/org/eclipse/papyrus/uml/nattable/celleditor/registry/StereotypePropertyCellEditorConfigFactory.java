/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.celleditor.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.celleditor.factory.AbstractCellEditorConfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.uml.nattable.celleditor.Activator;
import org.eclipse.papyrus.uml.nattable.celleditor.config.UMLSingleBooleanCellEditorConfig;
import org.eclipse.papyrus.uml.nattable.common.utils.Constants;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;



public class StereotypePropertyCellEditorConfigFactory extends AbstractCellEditorConfigurationFactory {

	private Map<Integer, IAxisCellEditorConfiguration> configurations;

	//FIXME, 
	public IAxisCellEditorConfiguration getCellEditorConfiguration(String editorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean handles(Table table, Object obj) {
		return ((obj instanceof String) && ((String)obj).startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX));//FIXME : remove this dependency or not?
	}

	public IAxisCellEditorConfiguration getCellEditorConfiguration(Table table, Object object) {
		final EObject context = table.getContext();
		assert context instanceof Element;
		Model model = ((Element)context).getModel();
		String propertyQualifiedName = (String)object;
		propertyQualifiedName = propertyQualifiedName.substring(Constants.PROPERTY_OF_STEREOTYPE_PREFIX.length(), propertyQualifiedName.length());
		final String stereotypeQN = NamedElementUtil.getParentQualifiedName(propertyQualifiedName);
		final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQualifiedName);

		final String profileQN = NamedElementUtil.getParentQualifiedName(stereotypeQN);
		Profile prof = model.getAppliedProfile(profileQN, true);
		String steName = NamedElementUtil.getNameFromQualifiedName(stereotypeQN);
		Stereotype ste = (Stereotype)prof.getMember(steName);
		Property prop = ste.getAttribute(propertyName, null);
		if(prop.getType().getName().contains("oolean")) {
			return new UMLSingleBooleanCellEditorConfig();
		}
		//		final Stereotype ste = ((Element)el).getAppliedStereotype(stereotypeQN);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initFactory(String id) {
		super.initFactory(id);
		this.configurations = new TreeMap<Integer, IAxisCellEditorConfiguration>();
		Collection<String> editorId = new ArrayList<String>();

		final Collection<IConfigurationElement> config = getAllRegisteredCellEditorConfiguration();
		for(IConfigurationElement iConfigurationElement : config) {
			final Integer order = new Integer(iConfigurationElement.getAttribute(ORDER_ATTRIBUTE));
			IAxisCellEditorConfiguration cellEditorConfig = null;
			try {
				cellEditorConfig = (IAxisCellEditorConfiguration)iConfigurationElement.createExecutableExtension(CLASS_ATTRIBUTE);
			} catch (CoreException e) {
				Activator.log.error(e);
			}

			final String currentId = cellEditorConfig.getConfigCellId();
			if(currentId != null) {
				if(editorId.contains(currentId)) {
					Activator.log.warn(NLS.bind("Several Cell Editor configuration are declared with the same id {0}", currentId));
				}
				editorId.add(currentId);
				this.configurations.put(order, cellEditorConfig);
			} else {
				Activator.log.warn(NLS.bind("The cell editor configuration {0} provides a null cellId", cellEditorConfig.getClass()));
			}
		}
	}

}
