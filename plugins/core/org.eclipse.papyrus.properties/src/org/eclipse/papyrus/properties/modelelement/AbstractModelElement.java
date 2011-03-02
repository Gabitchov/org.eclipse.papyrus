package org.eclipse.papyrus.properties.modelelement;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

/**
 * Provides a default implementation for ModelElement methods applied on the
 * modelElement's properties.
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractModelElement implements ModelElement {

	protected DataSource dataSource;

	public IStaticContentProvider getContentProvider(String propertyPath) {
		return EmptyContentProvider.instance;
	}

	public ILabelProvider getLabelProvider(String propertyPath) {
		return null;
	}

	public boolean isOrdered(String propertyPath) {
		return true;
	}

	public boolean isUnique(String propertyPath) {
		return false;
	}

	public boolean isMandatory(String propertyPath) {
		return false;
	}

	public boolean isEditable(String propertyPath) {
		return true;
	}

	public boolean forceRefresh(String propertyPath) {
		return false;
	}

	public void setDataSource(DataSource source) {
		this.dataSource = source;
	}

	protected Property getProperty(String propertyPath) {
		return ConfigurationManager.instance.getProperty(propertyPath, dataSource.getView().getContext());
	}

}
