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
package org.eclipse.papyrus.customization.properties.generation.layout;

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
import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.customization.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.papyrus.views.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.views.properties.environment.LayoutType;
import org.eclipse.papyrus.views.properties.environment.Namespace;
import org.eclipse.papyrus.views.properties.environment.Type;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.ui.CompositeWidget;
import org.eclipse.papyrus.views.properties.ui.Layout;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;
import org.eclipse.papyrus.views.properties.ui.UiFactory;
import org.eclipse.papyrus.views.properties.ui.ValueAttribute;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;

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

	protected final TreeMap<Category, List<PropertyEditor>> editorsByCategory = new TreeMap<Category, List<PropertyEditor>>();

	protected final Set<Namespace> namespaces = new HashSet<Namespace>();

	public synchronized List<Section> layoutElements(List<PropertyEditor> editors, View parent) {

		editorsByCategory.clear();
		namespaces.clear();

		namespaces.addAll(ConfigurationManager.getInstance().getBaseNamespaces());

		sortEditors(editors);

		Section section = createSection(parent);

		for(Map.Entry<Category, List<PropertyEditor>> mapping : editorsByCategory.entrySet()) {
			Category category = mapping.getKey();
			List<PropertyEditor> categorizedEditors = mapping.getValue();

			CompositeWidget container = layoutCategorizedEditors(category, categorizedEditors);

			section.getWidget().getWidgets().add(container);
		}

		return Collections.singletonList(section);
	}

	protected CompositeWidget layoutCategorizedEditors(Category category, List<PropertyEditor> editors) {
		CompositeWidgetType compositeType = ConfigurationManager.getInstance().getDefaultCompositeType();
		LayoutType propertiesLayoutType = ConfigurationManager.getInstance().getDefaultLayoutType();

		CompositeWidget container = UiFactory.eINSTANCE.createCompositeWidget();
		container.setWidgetType(compositeType);
		Layout layout = UiFactory.eINSTANCE.createLayout();
		container.setLayout(layout);
		ValueAttribute numColumns = UiFactory.eINSTANCE.createValueAttribute();
		numColumns.setName("numColumns"); //$NON-NLS-1$
		numColumns.setValue(category.getNumColumns().toString());
		layout.getAttributes().add(numColumns);
		layout.setLayoutType(propertiesLayoutType);
		container.getWidgets().addAll(editors);

		return container;
	}

	protected void sortEditors(List<PropertyEditor> editors) {
		for(PropertyEditor editor : editors) {
			Category category = new Category(editor.getProperty());
			getByCategory(category).add(editor);

			if(editor.getWidgetType() == null) {
				Activator.log.warn(String.format("Editor for property %s doesn't have a WidgetType", editor.getProperty().getName())); //$NON-NLS-1$
				continue;
			}

			namespaces.add(editor.getWidgetType().getNamespace());
		}
	}

	protected Section createSection(View parent) {
		CompositeWidget sectionRoot = createSectionRoot();

		Section section = ContextsFactory.eINSTANCE.createSection();
		section.setName(parent.getName());
		section.setSectionFile(String.format("ui/%s.xwt", section.getName().replaceAll(" ", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 

		URI compositeURI = URI.createURI(section.getSectionFile());
		compositeURI = compositeURI.resolve(parent.eResource().getURI());
		Resource resource = parent.eResource().getResourceSet().createResource(compositeURI);

		section.setWidget(sectionRoot);

		resource.getContents().add(sectionRoot);

		return section;
	}

	protected CompositeWidget createSectionRoot() {
		CompositeWidgetType compositeType = ConfigurationManager.getInstance().getDefaultCompositeType();
		namespaces.add(compositeType.getNamespace());
		LayoutType propertiesLayoutType = ConfigurationManager.getInstance().getDefaultLayoutType();
		namespaces.add(propertiesLayoutType.getNamespace());

		CompositeWidget sectionRoot = UiFactory.eINSTANCE.createCompositeWidget();
		sectionRoot.setWidgetType(compositeType);
		Layout layout = UiFactory.eINSTANCE.createLayout();
		layout.setLayoutType(propertiesLayoutType);
		sectionRoot.setLayout(layout);
		sectionRoot.getAttributes().addAll(createNamespaces(namespaces));

		return sectionRoot;
	}

	protected List<ValueAttribute> createNamespaces(Collection<Namespace> namespaces) {
		List<ValueAttribute> xmlNamespaces = new LinkedList<ValueAttribute>();
		for(Namespace namespace : namespaces) {
			if(namespace == null) {
				continue;
			}

			ValueAttribute attribute = UiFactory.eINSTANCE.createValueAttribute();
			attribute.setName(PropertiesUtil.getQualifiedName(namespace));
			attribute.setValue(PropertiesUtil.getPrefixedValue(namespace));
			xmlNamespaces.add(attribute);
		}
		return xmlNamespaces;
	}

	protected List<PropertyEditor> getByCategory(Category category) {
		if(!editorsByCategory.containsKey(category)) {
			editorsByCategory.put(category, new LinkedList<PropertyEditor>());
		}
		return editorsByCategory.get(category);
	}

	protected class Category implements Comparable<Category> {

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
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((editorType == null) ? 0 : editorType.hashCode());
			result = prime * result + multiplicity;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			if(!(obj instanceof Category)) {
				return false;
			}
			Category other = (Category)obj;
			if(!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if(editorType != other.editorType) {
				return false;
			}
			if(multiplicity != other.multiplicity) {
				return false;
			}
			return true;
		}

		public int compareTo(Category category) {
			if(category == null) {
				return -1;
			}

			if(category.multiplicity != multiplicity) {
				return multiplicity == 1 ? -1 : 1;
			}

			int result = getTypeIndex().compareTo(category.getTypeIndex());
			return result;
		}

		public Integer getTypeIndex() {
			int i = 0;
			for(Type type : orderedTypes) {
				if(type == editorType) {
					return i;
				}
				i++;
			}
			return orderedTypes.length;
		}

		@Override
		public String toString() {
			return (multiplicity == 1 ? "Single" : "Multiple") + editorType.toString(); //$NON-NLS-1$ //$NON-NLS-2$
		}

		private StandardLayoutGenerator getOuterType() {
			return StandardLayoutGenerator.this;
		}
	}

	/**
	 * The order in which the types are displayed
	 */
	public static Type[] orderedTypes = new Type[]{ Type.STRING, Type.BOOLEAN, Type.INTEGER, Type.ENUMERATION, Type.REFERENCE };

	public String getName() {
		return Messages.StandardLayoutGenerator_name;
	}

	public void setGenerator(IGenerator generator) {
		//Ignored
	}
}
