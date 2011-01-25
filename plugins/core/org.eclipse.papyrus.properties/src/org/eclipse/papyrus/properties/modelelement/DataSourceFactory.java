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
package org.eclipse.papyrus.properties.modelelement;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor;
import org.eclipse.papyrus.properties.runtime.DataSource;
import org.eclipse.papyrus.properties.util.ClassLoader;
import org.eclipse.papyrus.widgets.Activator;

public class DataSourceFactory {

	private DataSourceFactory() {

	}

	//DataContextElement : Class, Block
	//QualifiedName : UML:Class, SysML:Blocks:Block
	//RootPackage : UML, SysML
	public DataSource createDataSourceFromSelection(IStructuredSelection selection, View view) {

		SelectionEntry selectionEntry = new SelectionEntry(selection, view);

		if(!sources.containsKey(selectionEntry)) {

			Collection<DataContextElement> rootContextElements = view.getDatacontexts();

			DataSource source = new DataSource(view);

			Set<DataContextElement> contextElements = getAllContextElements(rootContextElements);
			for(DataContextElement contextElement : contextElements) {
				String key = getQualifiedName(contextElement);
				ModelElement modelElement = createModelElement(contextElement, selection);
				if(modelElement == null) {
					Activator.log.warn("Cannot find a matching ModelElement for " + key); //$NON-NLS-1$
				} else {
					source.addModelElement(key, modelElement);
				}
			}

			sources.put(selectionEntry, source);
		}

		return sources.get(selectionEntry);
	}

	protected Set<DataContextElement> getAllContextElements(Collection<DataContextElement> source) {
		Set<DataContextElement> result = new HashSet<DataContextElement>();
		getAllContextElements(source, result);
		return result;
	}

	public void getAllContextElements(Collection<DataContextElement> source, Set<DataContextElement> result) {
		for(DataContextElement element : source) {
			if(!result.contains(element)) {
				result.add(element);
				getAllContextElements(element.getSupertypes(), result);
			}
		}
	}

	protected ModelElement createModelElement(DataContextElement contextElement, IStructuredSelection selection) {
		if(selection.size() == 1) { //Single Selection
			ModelElement modelElement = createFromSource(selection.getFirstElement(), contextElement);
			return modelElement;
		} else { //MultiSelection
			CompositeModelElement composite = new CompositeModelElement();

			Iterator<?> it = selection.iterator();
			while(it.hasNext()) {
				ModelElement element = createFromSource(it.next(), contextElement);
				if(element != null)
					composite.addModelElement(element);
			}

			return composite;
		}
	}

	public List<DataSource> createSubDataSource(ModelElement currentElement, View view, DataSource source, String propertyPath) {
		List<DataSource> sourceResult = new LinkedList<DataSource>();
		for(DataContextElement context : getAllContextElements(view.getDatacontexts())) {
			if(view.getElementMultiplicity() == 1) { //Single selection
				List<ModelElement> elements = createFromDataSource(currentElement, source, propertyPath, context);
				int i = 0;
				for(ModelElement element : elements) {
					getDataSource(sourceResult, i, view).addModelElement(getQualifiedName(context), element);
					i++;
				}
			} else { //Multiple selection
				//Does it even make sense ?
				throw new UnsupportedOperationException();
			}
		}
		return sourceResult;
	}

	public DataSource getDataSource(List<DataSource> source, int index, View view) {
		while(source.size() <= index) {
			source.add(new DataSource(view));
		}
		return source.get(index);
	}

	public List<ModelElement> createFromDataSource(ModelElement currentElement, DataSource source, String propertyPath, DataContextElement context) {
		ModelElementFactory factory = getFactory(context);

		if(factory == null)
			return new LinkedList<ModelElement>();

		return factory.createFromDataSource(currentElement, source, propertyPath, context);
	}

	public ModelElementFactory getFactory(DataContextElement context) {
		ClassLoader loader = new ClassLoader();
		DataContextRoot rootPackage = getRootPackage(context);
		ModelElementFactoryDescriptor factoryDescriptor = rootPackage.getModelElementFactory();

		if(factoryDescriptor == null) {
			Activator.log.warn("No ModelElementFactory is attached to DataContextElement " + getQualifiedName(context)); //$NON-NLS-1$
			return null;
		}

		String factoryName = factoryDescriptor.getFactoryClass();
		ModelElementFactory factory = (ModelElementFactory)loader.newInstance(factoryName);

		return factory;
	}

	public ModelElement createFromSource(Object source, DataContextElement context) {
		ModelElementFactory factory = getFactory(context);

		if(factory == null)
			return null;

		return factory.createFromSource(source, context);
	}

	public DataContextRoot getRootPackage(DataContextElement context) {
		if(context.getPackage() == null)
			return (DataContextRoot)context;
		return getRootPackage(context.getPackage());
	}

	public String getQualifiedName(DataContextElement context) {
		if(context.getPackage() == null)
			return context.getName();
		return getQualifiedName(context.getPackage()) + ":" + context.getName(); //$NON-NLS-1$
	}

	public String getRootPackageName(DataContextElement context) {
		return getRootPackage(context).getName();
	}

	public void addFactory(String contextID, ModelElementFactory factory) {
		modelElementFactories.put(contextID, factory);
	}

	public static DataSourceFactory instance = new DataSourceFactory();

	private Map<SelectionEntry, DataSource> sources = new HashMap<SelectionEntry, DataSource>();

	private class SelectionEntry {

		private IStructuredSelection selection;

		private View view;

		public SelectionEntry(IStructuredSelection selection, View view) {
			this.selection = selection;
			this.view = view;
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof SelectionEntry))
				return false;

			SelectionEntry other = (SelectionEntry)obj;
			return other.view.equals(view) && selection.equals(other.selection);
		}

		@Override
		public int hashCode() {
			return selection.hashCode() + view.hashCode();
		}
	}

	private Map<String, ModelElementFactory> modelElementFactories = new HashMap<String, ModelElementFactory>();
}
