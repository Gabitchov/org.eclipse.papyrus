package org.eclipse.papyrus.properties.providers;

import org.eclipse.papyrus.properties.widgets.MaskProvider;

/**
 * Given the way the XWT files are parsed, the MaskProvider is passed to its
 * parent before being fully initialized.
 * 
 * This interface enables a MaskProvider to notify its parent when it is ready,
 * so that the parent is forced to wait for its MaskProvider to be ready before
 * it can call any method on it.
 * 
 * @author Camille Letavernier
 */
public interface XWTCompliantMaskProvider extends MaskProvider {

	public void addMaskProviderListener(XWTCompliantMaskProviderListener listener);

	public void removeMaskProviderListener(XWTCompliantMaskProviderListener listener);
}
