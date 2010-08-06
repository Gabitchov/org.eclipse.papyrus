package org.eclipse.papyrus.diagram.common.palette.customization.dialog;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Proxy class for container entries
 */
public class PaletteLocalDrawerProxy extends PaletteContainerProxy {

	/** label of the drawer */
	protected String label;

	/** id of the drawer */
	protected String id;

	/** icon of the drawer */
	protected String imagePath;

	/** description of the drawer */
	private String description;


	/** PropertyChangeSupport */
	protected PropertyChangeSupport drawerListener = new PropertyChangeSupport(this);

	/**
	 * Creates a new PaletteContainer
	 * 
	 * @param drawer
	 *        the drawer to cache
	 */
	public PaletteLocalDrawerProxy(String name, String id, String imagePath, String description) {
		super(null);
		this.label = name;
		this.id = id;
		this.setDescription(description);
		this.imagePath = imagePath;
	}

	/**
	 * A listener can only be added once. Adding it more than once will do nothing.
	 * 
	 * @param listener
	 *        the PropertyChangeListener that is to be notified of changes
	 * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		drawerListener.removePropertyChangeListener(listener);
		drawerListener.addPropertyChangeListener(listener);
		super.addPropertyChangeListener(listener);
	}

	/**
	 * @param listener
	 *        the PropertyChangeListener that is not to be notified anymore
	 * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		drawerListener.removePropertyChangeListener(listener);
		super.removePropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaletteContainer getEntry() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getPluginIconImage(Activator.ID, imagePath);
	}

	/**
	 * Returns the image path
	 * 
	 * @return the image path
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Sets the label of the drawer
	 * 
	 * @param label
	 *        the label to set
	 */
	public void setLabel(String label) {
		String oldValue = this.label;
		this.label = label;
		drawerListener.firePropertyChange(PROPERTY_ICON_PATH, oldValue, label);
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void addChild(PaletteEntryProxy entry) {
		super.addChild(entry);
	}

	/**
	 * Sets the id of the drawer
	 * 
	 * @param id
	 *        the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the image path of the drawer
	 * 
	 * @param imagePath
	 *        the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		String oldValue = this.imagePath;
		this.imagePath = imagePath;
		drawerListener.firePropertyChange(PROPERTY_ICON_PATH, oldValue, imagePath);
	}

	/**
	 * Sets the description of the drawer
	 * 
	 * @param description
	 *        the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the description of the drawer
	 * 
	 * @return the description of the drawer
	 */
	public String getDescription() {
		return description;
	}

}
