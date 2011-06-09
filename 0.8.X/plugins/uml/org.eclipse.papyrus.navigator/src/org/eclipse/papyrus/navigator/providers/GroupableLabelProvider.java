/*******************************************************************************
 * Copyright (c) 2008, 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=290422>Bug #290422</a>
 */
public class GroupableLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if(element instanceof PackagingNode) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if(element instanceof PackagingNode) {
			return "<" + ((PackagingNode)element).getName() + ">";
		}
		return super.getText(element);
	}

}
