/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import plugin.Activator
import xpt.Common
import xpt.Externalizer

@Singleton class DocumentProvider extends xpt.editor.DocumentProvider {
	@Inject extension Common;
	
	@Inject Activator xptActivator;
	@Inject Externalizer xptExternalizer;

	

	override setDocumentContent(GenDiagram it) '''
		«generatedMemberComment»
		protected void setDocumentContent(org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document, org.eclipse.ui.IEditorInput element) throws org.eclipse.core.runtime.CoreException {
			org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument diagramDocument = (org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) document;
			org.eclipse.emf.transaction.TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
			«IF null == it.editorGen.application»if (element instanceof «fileEditorInputClassFQName(it)») {
				org.eclipse.core.resources.IStorage storage = ((«fileEditorInputClassFQName(it)») element).getStorage();
				org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil.load(domain, storage, true, getProgressMonitor());
				document.setContent(diagram);
			} else «ENDIF»if(element instanceof «uriEditorInputClassFQName(it)») {
				org.eclipse.emf.common.util.URI uri = ((«uriEditorInputClassFQName(it)») element).getURI();
				org.eclipse.emf.ecore.resource.Resource resource = null;
				try {
					resource = domain.getResourceSet().getResource(uri.trimFragment(), false);
					if (resource == null) {
						resource = domain.getResourceSet().createResource(uri.trimFragment());
					}
					if (!resource.isLoaded()) {
						try {
							@SuppressWarnings({ "rawtypes", "unchecked" })
							java.util.Map<?,?> options = new java.util.HashMap(org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory.getDefaultLoadOptions());
							// @see 171060 
							// options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
							resource.load(options);
						} catch (java.io.IOException e) {
							resource.unload();
							throw e;
						}
					}
					if (uri.fragment() != null) {
						org.eclipse.emf.ecore.EObject rootElement = resource.getEObject(uri.fragment());
						if (rootElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
							document.setContent((org.eclipse.gmf.runtime.notation.Diagram) rootElement);
							return;
						}
					} else {
						for (java.util.Iterator<org.eclipse.emf.ecore.EObject> it = resource.getContents().iterator(); it.hasNext();) {
							Object rootElement = it.next();
							if (rootElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
								document.setContent((org.eclipse.gmf.runtime.notation.Diagram) rootElement);
								return;
							}
						}
					}
					throw new RuntimeException(«xptExternalizer.accessorCall(editorGen, i18nKeyForDocumentProviderNoDiagramInResourceError(it))»);
				} catch (Exception e) {
					org.eclipse.core.runtime.CoreException thrownExcp = null;
					if (e instanceof org.eclipse.core.runtime.CoreException) {
						thrownExcp = (org.eclipse.core.runtime.CoreException) e;
					} else {
						String msg = e.getLocalizedMessage();
						thrownExcp = new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, «xptActivator.qualifiedClassName(it.editorGen.plugin)».ID, 0, 
						msg != null ? msg : «xptExternalizer.accessorCall(editorGen, i18nKeyForDocumentProviderDiagramLoadingError(it))», e));
					}
					throw thrownExcp;
				}
			} else {
			«throwIncorrectInputException(it)»
			}	
		}
	'''
}