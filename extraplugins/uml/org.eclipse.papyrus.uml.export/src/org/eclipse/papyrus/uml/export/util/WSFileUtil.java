/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;


// TODO: Auto-generated Javadoc
/**
 * The Class WSFileUtil.
 */
public class WSFileUtil {



	/**
	 * Gets the file name.
	 * 
	 * @param model
	 *        the model
	 * @param extension
	 *        the extension
	 * @return the file name
	 * @throws ServiceException
	 *         the service exception
	 */
	public static String getFileName(EObject model, String extension) throws ServiceException {

		Resource resource = model.eResource();
		String resourcepath = resource.getURI().toString();
		String umlFileName = resourcepath.substring(resourcepath.lastIndexOf("/") + 1, resourcepath.length());
		return umlFileName;

	}

	/**
	 * Load resource.
	 * 
	 * @param path
	 *        the path
	 * @param resourceSet
	 *        the resource set
	 * @return the resource
	 */
	@SuppressWarnings("deprecation")
	public static Resource loadResource(String path, ResourceSet resourceSet) {
		//java.net.URL templateURL = Platform.getBundle(myPluginId).getResource(path);
		//String fullUri = templateURL.getPath();
		URI uri = URI.createPlatformResourceURI(path);
		try {
			Resource resource = resourceSet.getResource(uri, true);
			if(resource.isLoaded()) {
				return resource;
			}
		} catch (WrappedException ex) {
			ex.printStackTrace();
		}

		return null;
	}


	/**
	 * Search for a specific string in an xmi file and replace all its occurences by the new string.
	 * 
	 * @param oldString
	 *        the old uri
	 * @param newString
	 *        the new uri
	 * @param adapter
	 *        the adapter
	 * @param doc
	 *        the doc
	 * @param offset
	 *        the offset
	 * @param multiEdit
	 *        the multi text edit
	 * @throws BadLocationException
	 *         the bad location exception
	 */
	public static void replaceString(String oldString, String newString, FindReplaceDocumentAdapter adapter, IDocument doc, int offset, MultiTextEdit multiEdit) throws BadLocationException {
		IRegion region = adapter.find(offset, oldString, true, true, false, true);

		if(region != null) {
			multiEdit.addChild(new ReplaceEdit(region.getOffset(), region.getLength(), newString));
			replaceString(oldString, newString, adapter, doc, region.getOffset() + region.getLength(), multiEdit);
			//return new ReplaceEdit(region.getOffset(), region.getLength(), installedURI);
		}


	}


	/**
	 * Copy.
	 * 
	 * @param source
	 *        the source
	 * @param target
	 *        the target
	 * @throws IOException
	 *         Signals that an I/O exception has occurred.
	 */
	public static void copy(InputStream source, File target) throws IOException {
		if(!target.getParentFile().exists()) {
			target.getParentFile().mkdirs();
		}


		OutputStream out = new FileOutputStream(target);


		byte[] buf = new byte[1024];

		int len;
		try {
			while((len = source.read(buf)) > 0) {

				out.write(buf, 0, len);

			}

		} catch (IOException ex) {
			throw ex;
		} finally {

			source.close();

			out.close();
		}
	}


	public static void copyFile(IProject project, File iconSrc, String destinationDir, String destFileName) {
		// TODO Auto-generated method stub
		File targetIconFile = FileUtil.getWorkspaceFile("/" + project.getName() + "/" + destinationDir + "/" + destFileName);

		if(!targetIconFile.getParentFile().exists()) {
			targetIconFile.getParentFile().mkdirs();

		}
		try {

			WSFileUtil.copy(new FileInputStream(iconSrc), targetIconFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
