package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.papyrus.views.properties.modelelement.DataSource;

/**
 * The inteface to be implemented by all PropertyEditors
 * 
 * @author Camille Letavernier
 * 
 */
public interface CustomizablePropertyEditor {

	public DataSource getInput();

	public void setInput(DataSource input);

	public String getProperty();

	public void setProperty(String property);

	public boolean getShowLabel();

	public void setShowLabel(boolean showLabel);

	public String getCustomLabel();

	public void setCustomLabel(String customLabel);

	public void setReadOnly(boolean readOnly);

	public boolean getReadOnly();
}
