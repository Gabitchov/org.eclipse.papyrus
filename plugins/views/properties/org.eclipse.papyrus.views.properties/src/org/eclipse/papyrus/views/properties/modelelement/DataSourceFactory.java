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
package org.eclipse.papyrus.views.properties.modelelement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.environment.ModelElementFactoryDescriptor;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;

/**
 * A Factory to build and populate DataSource with the right ModelElements
 * 
 * @author Camille Letavernier
 */
public class DataSourceFactory {

	/**
	 * Singleton instance for DataSourceFactory
	 */
	public static DataSourceFactory instance = new DataSourceFactory();

	/**
	 * Creates a new DataSource from a selection and a view.
	 * 
	 * @param selection
	 *        The selection of Objects
	 * @param view
	 *        The view to display
	 * @return The DataSource that can be passed to the DisplayEngine to display
	 *         the view
	 */
	public DataSource createDataSourceFromSelection(IStructuredSelection selection, View view) {
		SelectionEntry selectionEntry = new SelectionEntry(selection, view);

		if(!sources.containsKey(selectionEntry)) {
			DataSource source = new DataSource(view, selection);
			sources.put(selectionEntry, source);
		}

		return sources.get(selectionEntry);
	}

	public void removeFromCache(IStructuredSelection selection, View view) {
		if(selection == null || view == null) {
			return;
		}

		SelectionEntry entry = new SelectionEntry(selection, view);
		sources.remove(entry);
	}

	/**
	 * Returns the ModelElement corresponding to the given propertyPath and
	 * DataSource
	 * 
	 * @param source
	 *        The DataSource used to retrieved informations such as the View
	 *        and the Selection
	 * @param propertyPath
	 *        The path describing the property for which we want a
	 *        ModelElement
	 * @return The matching modelElement
	 */
	public ModelElement getModelElementFromPropertyPath(DataSource source, String propertyPath) {
		String key = propertyPath.substring(0, propertyPath.lastIndexOf(":")); //$NON-NLS-1$
		for(Context context : PropertiesUtil.getDependencies(source.getView().getContext())) {
			DataContextElement element = PropertiesUtil.getContextElementByQualifiedName(key, context.getDataContexts());
			if(element != null) {
				ModelElement modelElement = DataSourceFactory.instance.createModelElement(element, source.getSelection());
				if(modelElement != null) {
					modelElement.setDataSource(source);
				}
				return modelElement;
			}
		}
		return null;
	}

	/**
	 * Creates a ModelElement from the given DataContextElement and Selection.
	 * 
	 * @param contextElement
	 *        The contextElement for which we are creating a ModelElement
	 * @param selection
	 *        The list of objects currently selected
	 * @return The model element corresponding to the given contextElement and
	 *         selection
	 */
	private ModelElement createModelElement(DataContextElement contextElement, IStructuredSelection selection) {
		if(selection.size() == 1) { // Single Selection
			ModelElement modelElement = createFromSource(selection.getFirstElement(), contextElement);
			return modelElement;
		} else { // MultiSelection
			CompositeModelElement composite = new CompositeModelElement();

			Iterator<?> it = selection.iterator();
			while(it.hasNext()) {
				ModelElement element = createFromSource(it.next(), contextElement);
				if(element != null) {
					composite.addModelElement(element);
				}
			}

			return composite;
		}
	}

	/**
	 * Retrieves the ModelElementFactory for the given DataContextElement. The
	 * ModelElementFactory is declared by the DataContextRoot owning the given
	 * DataContextElement
	 * 
	 * @param context
	 *        The DataContextElement for which we want to retrieve the
	 *        ModelElementFactory
	 * @return The ModelElementFactory corresponding to the given
	 *         DataContextElement
	 */
	private ModelElementFactory getFactory(DataContextElement context) {
		DataContextRoot rootPackage = getRootPackage(context);
		ModelElementFactoryDescriptor factoryDescriptor = rootPackage.getModelElementFactory();

		if(factoryDescriptor == null) {
			Activator.log.warn("No ModelElementFactory is attached to DataContextElement " + getQualifiedName(context)); //$NON-NLS-1$
			return null;
		}

		String factoryName = factoryDescriptor.getFactoryClass();
		ModelElementFactory factory = ClassLoaderHelper.newInstance(factoryName, ModelElementFactory.class);

		return factory;
	}

	private ModelElement createFromSource(Object source, DataContextElement context) {
		ModelElementFactory factory = getFactory(context);

		if(factory == null) {
			return null;
		}

		return factory.createFromSource(source, context);
	}

	private DataContextRoot getRootPackage(DataContextElement context) {
		if(context.getPackage() == null) {
			return (DataContextRoot)context;
		}
		return getRootPackage(context.getPackage());
	}

	private String getQualifiedName(DataContextElement context) {
		if(context.getPackage() == null) {
			return context.getName();
		}
		return getQualifiedName(context.getPackage()) + ":" + context.getName(); //$NON-NLS-1$
	}

	/**
	 * Singleton Constructor.
	 */
	private DataSourceFactory() {

	}

	private class SelectionEntry {

		private IStructuredSelection selection;

		private View view;

		public SelectionEntry(IStructuredSelection selection, View view) {
			if(selection == null) {
				throw new IllegalArgumentException("The selection must not be null");
			}
			if(view == null) {
				throw new IllegalArgumentException("The view must not be null");
			}
			this.selection = selection;
			this.view = view;
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof SelectionEntry)) {
				return false;
			}

			SelectionEntry other = (SelectionEntry)obj;
			return other.view.equals(view) && selection.equals(other.selection);
		}

		@Override
		public int hashCode() {
			return selection.hashCode() + view.hashCode();
		}
	}

	/**
	 * More than one {@link XWTSection} may share the same DataSource.
	 * They all need to listen on the same source, so that they can correctly
	 * refresh themselves. We maintain a cache for each Selection/View pair.
	 * 
	 * The cache is cleaned when the sections are disposed.
	 */
	//TODO : More than one view can be displayed at the same time. The cache should only
	//rely on a selection ; not on a selection-view pair.
	//We may use a (ISelection, Context) key : the DataSource must be associated to a single context
	private Map<SelectionEntry, DataSource> sources = new HashMap<SelectionEntry, DataSource>();
}
