/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.javabean.metadata;

import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.papyrus.xwt.metadata.ISetPostAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandItem;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public class ExpandItemHeightAction implements ISetPostAction {

	public void action(Object target, IProperty property, Object value) {
		if(target instanceof ExpandItem && value instanceof Control) {
			ExpandItem targetControl = (ExpandItem)target;
			Control valueControl = (Control)value;
			targetControl.setHeight(valueControl.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		}
	}
}
