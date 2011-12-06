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
package org.eclipse.papyrus.customization.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.model.customization.CustomizableElement;
import org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.plugin.ProjectEditor;
import org.eclipse.papyrus.widgets.util.FileUtil;
import org.w3c.dom.Element;


public class FileBasedExtensionFactory implements ExtensionFactory {

	private final String extensionPoint;

	private final String fileAttributeName;

	private final String fileElementName;

	private final boolean allowMultiple;

	private final String name;

	public FileBasedExtensionFactory(String name, String extensionPoint, String fileAttributeName, String fileElementName, boolean allowMultiple) {
		this.extensionPoint = extensionPoint;
		this.fileAttributeName = fileAttributeName;
		this.fileElementName = fileElementName;
		this.allowMultiple = allowMultiple;
		this.name = name;
	}

	public void addElement(CustomizableElement element, ProjectEditor editor) {
		createExtension((FileBasedCustomizableElement)element, editor);
		copyFile((FileBasedCustomizableElement)element, editor);
	}

	protected Element createExtension(FileBasedCustomizableElement element, ProjectEditor editor) {
		Element extensionElement = null;
		if(element instanceof FileBasedCustomizableElement) {
			Element extension = editor.getPluginEditor().addExtension(extensionPoint);
			extensionElement = editor.getPluginEditor().addChild(extension, fileElementName);
			editor.getPluginEditor().setAttribute(extensionElement, fileAttributeName, getTargetPath(element));
		}
		return extensionElement;
	}

	protected void copyFile(FileBasedCustomizableElement element, ProjectEditor editor) {
		String path = element.getFile();
		File sourceFile = FileUtil.getFile(path);
		File targetFile = FileUtil.getWorkspaceFile("/" + editor.getProject().getName() + "/" + getTargetPath(element)); //$NON-NLS-1$ //$NON-NLS-2$
		if(!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}

		try {
			//System.out.println("TargetFile : " + targetFile.getAbsolutePath());
			copy(new FileInputStream(sourceFile), targetFile);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		editor.getBuildEditor().addToBuild(getTargetPath(element));
	}

	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "/" + getFileName(element); //$NON-NLS-1$
	}

	protected String getFileName(FileBasedCustomizableElement element) {
		String path = element.getFile();
		String fileName;
		if(path.indexOf("/") < 0) { //$NON-NLS-1$
			fileName = path;
		} else {
			fileName = path.substring(path.lastIndexOf("/") + 1, path.length()); //$NON-NLS-1$
		}
		return fileName;
	}

	protected void copy(InputStream source, File target) throws IOException {
		if(!target.getParentFile().exists()) {
			target.getParentFile().mkdirs();
		}

		FileWriter out = new FileWriter(target);
		try {
			int c;

			while((c = source.read()) != -1) {
				out.write(c);
			}

		} catch (IOException ex) {
			throw ex;
		} finally {
			source.close();
			out.close();
		}
	}

	public boolean isValidElement(CustomizableElement element) {
		return element instanceof FileBasedCustomizableElement;
	}

	public String getName() {
		return name;
	}

}
