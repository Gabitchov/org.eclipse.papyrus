/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.facade.codegen.util;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EEFGeneratorAdapter extends AbstractGeneratorAdapter {

	private static final String JAVA_EXT_FILE = "java";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter#canGenerate(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public boolean canGenerate(Object object, Object projectType) {
		return EMFPlugin.IS_ECLIPSE_RUNNING && object instanceof GenModel;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.codegen.ecore.generator.AbstractGeneratorAdapter#doGenerate(java.lang.Object,
	 *      java.lang.Object, org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	protected Diagnostic doGenerate(Object object, Object projectType,
			Monitor monitor) throws Exception {
		GenModel genmodel = (GenModel) object;
		IFolder folder = null;
		final IProgressMonitor progressMonitor = BasicMonitor
				.toIProgressMonitor(monitor);
		if (projectType == GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE) {
			final Object codeFormatter = createCodeFormatter(null,
					URI.createPlatformResourceURI(genmodel.getModelDirectory(),
							true));
			folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(new Path(genmodel.getModelDirectory())); // path);
			if (folder != null && folder.isAccessible()) {
				folder.accept(new ResourceVisitorFormatter(codeFormatter,
						progressMonitor));
			}
		} else if (projectType == GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE) {
			final Object codeFormatter = createCodeFormatter(null,
					URI.createPlatformResourceURI(genmodel.getEditDirectory(),
							true));
			folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(new Path(genmodel.getEditDirectory()));
			if (folder != null && folder.isAccessible()) {
				folder.accept(new ResourceVisitorFormatter(codeFormatter,
						progressMonitor));
			}
		} else if (projectType == GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE) {
			final Object codeFormatter = createCodeFormatter(null,
					URI.createPlatformResourceURI(
							genmodel.getEditorDirectory(), true));
			folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(new Path(genmodel.getEditorDirectory()));
			if (folder != null && folder.isAccessible()) {
				folder.accept(new ResourceVisitorFormatter(codeFormatter,
						progressMonitor));
			}
		}
		return Diagnostic.OK_INSTANCE;
	}

	/**
	 * @param genmodel
	 * @param genPack
	 * @return
	 */
	protected IPath buildModelPath(GenModel genmodel, GenPackage genPack) {
		String pathStr = genmodel.getModelDirectory() + "/"
				+ genPack.getQualifiedPackageName().replaceAll("\\.", "/");
		IPath path = new Path(pathStr);
		return path;
	}

	/**
	 * @param genmodel
	 * @param genPack
	 * @return
	 */
	protected IPath buildProviderPath(GenModel genmodel, GenPackage genPack) {
		String pathStr = genmodel.getEditDirectory();
		if (genPack.getProviderPackageName() != null
				&& !genPack.getProviderPackageName().equals("")) {
			pathStr += "/"
					+ genPack.getProviderPackageName().replaceAll("\\.", "/");
		}
		IPath path = new Path(pathStr);
		return path;
	}

	/**
	 * @param genmodel
	 * @param genPack
	 * @return
	 */
	protected IPath buildPresentationPath(GenModel genmodel, GenPackage genPack) {
		String pathStr = genmodel.getEditorDirectory();
		if (genPack.getPresentationPackageName() != null
				&& !genPack.getPresentationPackageName().equals("")) {
			pathStr += "/"
					+ genPack.getPresentationPackageName().replaceAll("\\.",
							"/");
		}
		IPath path = new Path(pathStr);
		return path;
	}

	/**
	 * IResourceVisitor responsible to format all java code in a given folder.
	 * 
	 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
	 */
	private final class ResourceVisitorFormatter implements IResourceVisitor {
		private final Object codeFormatter;

		private final IProgressMonitor progressMonitor;

		private ResourceVisitorFormatter(Object codeFormatter,
				IProgressMonitor progressMonitor) {
			this.codeFormatter = codeFormatter;
			this.progressMonitor = progressMonitor;
		}

		public boolean visit(IResource resource) throws CoreException {
			try {
				if (resource instanceof IFile
						&& ((IFile) resource).getFileExtension().equals(
								JAVA_EXT_FILE)) {
					formatFile((IFile) resource, codeFormatter, progressMonitor);
				}
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		/**
		 * @param file
		 * @param codeFormatter
		 * @param progressMonitor
		 * @throws Exception
		 */
		private void formatFile(IFile file, Object codeFormatter,
				IProgressMonitor progressMonitor) throws Exception {
			URI createPlatformResourceURI = URI.createURI(file.getFullPath()
					.toString(), true);
			final String contentsStr = getContents(createPlatformResourceURI,
					null);
			String formatedContentsStr = formatCode(contentsStr, codeFormatter);
			ByteArrayInputStream formatedContents = new ByteArrayInputStream(
					formatedContentsStr.getBytes());
			file.setContents(formatedContents, true, true, progressMonitor);
			formatedContents.close();
		}

	}
}
