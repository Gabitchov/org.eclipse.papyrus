/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.generation.layout;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.properties.environment.LayoutType;
import org.eclipse.papyrus.properties.environment.Namespace;
import org.eclipse.papyrus.properties.environment.Type;
import org.eclipse.papyrus.properties.generation.Activator;
import org.eclipse.papyrus.properties.generation.messages.Messages;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.ui.CompositeWidget;
import org.eclipse.papyrus.properties.ui.Layout;
import org.eclipse.papyrus.properties.ui.PropertyEditor;
import org.eclipse.papyrus.properties.ui.UiFactory;
import org.eclipse.papyrus.properties.ui.ValueAttribute;
import org.eclipse.papyrus.properties.util.Util;

/**
 * Default implementation for ILayoutGenerator
 * PropertyEditors are grouped by their property type (Strings, booleans, ...)
 * Boolean and integer sections have two columns, while the other ones have only one columns
 * 
 * All multiple value editors are displayed after all the single value editors.
 * 
 * @author Camille Letavernier
 */
public class StandardLayoutGenerator implements ILayoutGenerator {

	private TreeMap<Category, List<PropertyEditor>> editorsByCategory = new TreeMap<Category, List<PropertyEditor>>();

	public List<Section> layoutElements(List<PropertyEditor> editors, View parent) {

		editorsByCategory.clear();

		Set<Namespace> namespaces = new HashSet<Namespace>(ConfigurationManager.instance.getBaseNamespaces());

		for(PropertyEditor editor : editors) {
			Category category = new Category(editor.getProperty());
			getByCategory(category).add(editor);
			if(editor.getWidgetType() == null) {
				Activator.log.warn("Editor for property " + editor.getProperty().getName() + " doesn't have a WidgetType"); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				namespaces.add(editor.getWidgetType().getNamespace());
			}
		}

		ConfigurationManager configManager = ConfigurationManager.instance;

		Section section = ContextsFactory.eINSTANCE.createSection();
		section.setName(parent.getName());
		section.setSectionFile("ui/" + section.getName().replaceAll(" ", "") + ".xwt"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		URI compositeURI = URI.createURI(section.getSectionFile());
		compositeURI = compositeURI.resolve(parent.eResource().getURI());
		Resource resource = parent.eResource().getResourceSet().createResource(compositeURI);

		CompositeWidgetType compositeType = configManager.getDefaultCompositeType();
		namespaces.add(compositeType.getNamespace());
		LayoutType propertiesLayoutType = configManager.getDefaultLayoutType();
		namespaces.add(propertiesLayoutType.getNamespace());

		CompositeWidget sectionRoot = UiFactory.eINSTANCE.createCompositeWidget();
		sectionRoot.setWidgetType(compositeType);
		Layout layout = UiFactory.eINSTANCE.createLayout();
		layout.setLayoutType(propertiesLayoutType);
		sectionRoot.setLayout(layout);
		sectionRoot.getAttributes().addAll(createNamespaces(namespaces));

		section.setWidget(sectionRoot);

		resource.getContents().add(sectionRoot);

		for(Map.Entry<Category, List<PropertyEditor>> mapping : editorsByCategory.entrySet()) {
			Category category = mapping.getKey();
			List<PropertyEditor> categorizedEditors = mapping.getValue();

			CompositeWidget container = UiFactory.eINSTANCE.createCompositeWidget();
			container.setWidgetType(compositeType);
			layout = UiFactory.eINSTANCE.createLayout();
			container.setLayout(layout);
			ValueAttribute numColumns = UiFactory.eINSTANCE.createValueAttribute();
			numColumns.setName("numColumns"); //$NON-NLS-1$
			numColumns.setValue(category.getNumColumns().toString());
			layout.getAttributes().add(numColumns);
			layout.setLayoutType(propertiesLayoutType);
			container.getWidgets().addAll(categorizedEditors);
			sectionRoot.getWidgets().add(container);
		}

		return Collections.singletonList(section);
	}

	private List<ValueAttribute> createNamespaces(Collection<Namespace> namespaces) {
		List<ValueAttribute> xmlNamespaces = new LinkedList<ValueAttribute>();
		for(Namespace namespace : namespaces) {
			if(namespace == null)
				continue;

			ValueAttribute attribute = UiFactory.eINSTANCE.createValueAttribute();
			attribute.setName(Util.getQualifiedName(namespace));
			attribute.setValue(Util.getPrefixedValue(namespace));
			xmlNamespaces.add(attribute);
		}
		return xmlNamespaces;
	}

	private List<PropertyEditor> getByCategory(Category category) {
		if(!editorsByCategory.containsKey(category)) {
			editorsByCategory.put(category, new LinkedList<PropertyEditor>());
		}
		return editorsByCategory.get(category);
	}

	private class Category implements Comparable<Category> {

		public Type editorType;

		public int multiplicity;

		public Integer getNumColumns() {
			switch(editorType) {
			case BOOLEAN:
				return 2;
			case ENUMERATION:
				return 1;
			case INTEGER:
				return 2;
			case REFERENCE:
				return 1;
			case STRING:
				return 1;
			}
			return 1; //Cannot happen
		}

		public Category(Property property) {
			this.editorType = property.getType();
			this.multiplicity = property.getMultiplicity();
		}

		@Override
		public int hashCode() {
			return editorType.hashCode() * multiplicity;
		}

		@Override
		public boolean equals(Object o) {
			if(o == null)
				return false;
			if(!(o instanceof Category))
				return false;

			Category category = (Category)o;
			return category.editorType == editorType && category.multiplicity == multiplicity;
		}

		public int compareTo(Category category) {
			if(category == null)
				return -1;

			if(category.multiplicity != multiplicity) {
				return multiplicity == 1 ? -1 : 1;
			}

			int result = getTypeIndex().compareTo(category.getTypeIndex());
			return result;
		}

		public Integer getTypeIndex() {
			int i = 0;
			for(Type type : orderedTypes) {
				if(type == editorType)
					return i;
				i++;
			}
			return orderedTypes.length;
		}

		@Override
		public String toString() {
			return (multiplicity == 1 ? "Single" : "Multiple") + editorType.toString(); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * The order in which the types are displayed
	 */
	public static Type[] orderedTypes = new Type[]{ Type.STRING, Type.BOOLEAN, Type.INTEGER, Type.ENUMERATION, Type.REFERENCE };

	public String getName() {
		return Messages.StandardLayoutGenerator_name;
	}
}
