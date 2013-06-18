package org.eclipse.papyrus.infra.emf.compare.ui.utils;

import org.eclipse.papyrus.infra.emf.compare.ui.provider.EMFCompareLabelProvider;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * This interface provides useful methods to manage easily the customization of the viewers in an editor
 * 
 */
public interface ICustomizableEditor extends IEditorPart {

	/**
	 * 
	 * @return
	 *         a LabelProvider
	 */
	public EMFCompareLabelProvider getLabelProvider();

	/**
	 * Refresh the viewers of the editor
	 */
	public void refreshViewers();
}
