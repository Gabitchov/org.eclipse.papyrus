/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Vincent Lorenzo (CEA-LIST)   - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.emf.facet.custom.ui;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * This interface allows to use a {@link ILabelProvider}, an
 * {@link IColorProvider} and an {@link IFontProvider} which is implemented and
 * customizable using the EMF Facet customization mechanism.
 * 
 * @author Gregoire Dupe
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizedLabelProvider extends ILabelProvider,
		IColorProvider, IFontProvider , ICustomizedToolTipLabelProvider {
	/**
	 * This method returns the customization manager used by the label provider. The
	 * customization stack updates have to be done using this
	 * {@link ICustomizationManager}.
	 * 
	 * @return the customization manager used by the content provider.
	 */
	ICustomizationManager getCustomizationManager();
	
	boolean isUnderlined(Object element, ETypedElement eTypedElement);
	
	boolean isStruckthrough(Object element, ETypedElement eTypedElement);
	
	Image getTopLeftOverlay(Object element, ETypedElement eTypedElement);
	Image getTopMiddleOverlay(Object element, ETypedElement eTypedElement);
	Image getTopRightOverlay(Object element, ETypedElement eTypedElement);
	
	Image getBottomLeftOverlay(Object element, ETypedElement eTypedElement);
	Image getBottomMiddleOverlay(Object element, ETypedElement eTypedElement);
	Image getBottomRightOverlay(Object element, ETypedElement eTypedElement);
	
	String getText(Object element, ETypedElement eTypedElement);
	
	Image getImage(Object element, ETypedElement eTypedElement);

	/**
	 * @since 0.2
	 */
	ICustomizedLabelProvider cloneLabelProvider();

}
