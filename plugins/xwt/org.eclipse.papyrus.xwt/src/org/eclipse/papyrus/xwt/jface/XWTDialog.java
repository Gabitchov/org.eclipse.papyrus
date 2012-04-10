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
package org.eclipse.papyrus.xwt.jface;

import java.net.URL;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.swt.widgets.Shell;

/**
 * Default XWT Dialog with a content via static URL
 * 
 * @author yyang <yves.yang@soyatec.com>
 */
public class XWTDialog extends AbstractDialog {

	private Class<?> contentForm;

	public XWTDialog(Shell parentShell, String title, Object dataContext, Class<?> contentForm) {
		super(parentShell, title, dataContext);
		this.contentForm = contentForm;
	}

	@Override
	protected URL getContentURL() {
		if(contentForm != null) {
			return contentForm.getResource(contentForm.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX);
		}
		return null;
	}

	@Override
	protected ClassLoader getClassLoader() {
		return contentForm.getClassLoader();
	}
}
