/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.widgets.editors;

import java.text.Collator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.infra.widgets.editors.ReferenceCombo;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;


public class XWTAwareFontEditor extends AbstractPropertyEditor {

	private ReferenceCombo editor;

	private static IStaticContentProvider fontContentProvider;

	public XWTAwareFontEditor(Composite parent, int style) {
		editor = new ReferenceCombo(parent, style);
		setEditor(editor);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider contentProvider = getFontContentProvider();

		editor.setContentProvider(contentProvider);
		editor.setUnsettable(!input.isMandatory(propertyPath));

		super.doBinding();
	}

	private synchronized static IStaticContentProvider getFontContentProvider() {
		if(fontContentProvider == null) {
			FontData[] fontDatas = Display.getDefault().getFontList(null, true);

			Set<String> fontNames = new HashSet<String>();
			for(FontData data : fontDatas) {
				if(data.getName() != null) {
					fontNames.add(data.getName());
				}
			}

			String[] uniqueFontNames = fontNames.toArray(new String[fontNames.size()]);
			Arrays.sort(uniqueFontNames, Collator.getInstance());

			fontContentProvider = new StaticContentProvider(uniqueFontNames);
		}
		return fontContentProvider;
	}

}
