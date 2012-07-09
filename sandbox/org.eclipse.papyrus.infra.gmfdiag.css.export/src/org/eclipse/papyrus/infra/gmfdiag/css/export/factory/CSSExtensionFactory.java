/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.export.factory;

import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.customization.factory.FileBasedExtensionFactory;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.plugin.PluginEditor;
import org.eclipse.papyrus.infra.gmfdiag.css.export.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CSSStylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager;
import org.w3c.dom.Element;


public class CSSExtensionFactory extends FileBasedExtensionFactory {

	protected final static String stylesheetContribution = "stylesheet"; //$NON-NLS-1$ //From oep.infra.gmfdiag.css.theme extension point

	protected final static String themeDefinition = "themeDefinition"; //$NON-NLS-1$ //From oep.infra.gmfdiag.css.theme extension point

	protected final static String themeIcon = "icon"; //$NON-NLS-1$ //From oep.infra.gmfdiag.css.theme extension point

	protected final static String themeLabel = "label"; //$NON-NLS-1$ //From oep.infra.gmfdiag.css.theme extension point

	protected final static String themeId = "id"; //$NON-NLS-1$ //From oep.infra.gmfdiag.css.theme extension point

	public CSSExtensionFactory() {
		super("CSS Theme", ThemeManager.EXTENSION_ID, "stylesheetPath", "themeContribution", true);
	}

	public EClass getCustomizableElementClass() {
		return CsscustomizationPackage.eINSTANCE.getCSSStylesheet();
	}

	@Override
	public void addElement(CustomizableElement element, PluginEditor editor) {
		super.addElement(element, editor);
	}

	@Override
	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "style/" + getFileName(element); //$NON-NLS-1$
	}

	@Override
	protected Element createExtension(FileBasedCustomizableElement element, PluginEditor editor) {
		Element themeContributionElement = null;
		if(element instanceof CSSStylesheet) {
			//Override the super implementation: The extension point structure has 
			//one more level than the super-implementation (css_theme > themeContribution > stylesheet)
			CSSStylesheet stylesheetElement = (CSSStylesheet)element;

			Element extension = editor.getPluginEditor().addExtension(extensionPoint); //cssTheme

			//Optional: Create & configure the themeDefinition (New Theme)
			if(ThemeManager.instance.getTheme(stylesheetElement.getTheme()) == null) {
				createNewThemeExtension(stylesheetElement, editor, extension);
			}

			//Required: Create the Theme contribution
			themeContributionElement = editor.getPluginEditor().addChild(extension, fileElementName);
			Element cssContributionElement = editor.getPluginEditor().addChild(themeContributionElement, stylesheetContribution);

			editor.getPluginEditor().setAttribute(cssContributionElement, fileAttributeName, getTargetPath(stylesheetElement));

			//Configure the themeContribution
			themeContributionElement.setAttribute(themeId, stylesheetElement.getTheme());
		}

		return themeContributionElement;
	}

	protected Element createNewThemeExtension(CSSStylesheet stylesheetElement, PluginEditor editor, Element extension) {
		Element themeDefinitionElement = editor.getPluginEditor().addChild(extension, themeDefinition);

		String iconPath = stylesheetElement.getIcon();
		if(iconPath == null) {
			throw new IllegalArgumentException("Icon path should not be empty");
		}

		String targetIconPath = getFileName(getTargetIconPath(stylesheetElement));
		if(targetIconPath == null || targetIconPath.equals("")) {
			throw new IllegalArgumentException("Icon path should not be empty");
		}

		try {
			copyFile(iconPath, targetIconPath, editor);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		editor.getPluginEditor().setAttribute(themeDefinitionElement, themeId, stylesheetElement.getTheme());
		editor.getPluginEditor().setAttribute(themeDefinitionElement, themeIcon, targetIconPath);
		editor.getPluginEditor().setAttribute(themeDefinitionElement, themeLabel, stylesheetElement.getLabel());

		return themeDefinitionElement;
	}

	protected String getTargetIconPath(CSSStylesheet stylesheetElement) {
		return "icons/" + getFileName(stylesheetElement.getIcon());
	}
}
