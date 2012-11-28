/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.hyperlink;

import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.swt.graphics.Image;

public class HyperLinkTableEditor extends HyperLinkEditor {


	public Image getImage(Object element) {//TODO remove this method
		if(element instanceof PapyrusTableInstance) {
			return getEditorRegistry().getEditorIcon(element);
		}
		return null;
	}

	public String getText(Object element) {//TODO remove this method
		if(element instanceof PapyrusTableInstance) {
			return ((PapyrusTableInstance)element).getName();
		}
		return null;
	}


}
