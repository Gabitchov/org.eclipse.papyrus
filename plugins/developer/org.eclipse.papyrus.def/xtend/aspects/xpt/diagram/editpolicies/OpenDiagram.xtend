/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour
import xpt.Common
import xpt.editor.DiagramEditorUtil

@Singleton class OpenDiagram extends xpt.diagram.editpolicies.OpenDiagram {
	@Inject extension Common;


	@Inject DiagramEditorUtil xptDiagramEditorUtil;



	override openCommandClass_intializeNewDiagram(OpenDiagramBehaviour it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.notation.Diagram intializeNewDiagram() throws org.eclipse.core.commands.ExecutionException {
			org.eclipse.gmf.runtime.notation.Diagram d = org.eclipse.gmf.runtime.diagram.core.services.ViewService.createDiagram(getDiagramDomainElement(), getDiagramKind(), getPreferencesHint());
			if (d == null) {
				throw new org.eclipse.core.commands.ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind");
			}
			diagramFacet.setDiagramLink(d);
			«_assert('diagramFacet.eResource() != null')»
			diagramFacet.eResource().getContents().add(d);
			org.eclipse.emf.ecore.EObject container = diagramFacet.eContainer();
			while (container instanceof org.eclipse.gmf.runtime.notation.View) {
				((org.eclipse.gmf.runtime.notation.View) container).persist();
				container = container.eContainer();
			}
			try {
			«IF null == subject.diagram.editorGen.application»
				new org.eclipse.ui.actions.WorkspaceModifyOperation() {
					protected void execute(org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException, java.lang.reflect.InvocationTargetException, InterruptedException {
						try {
			«ENDIF»
			for (java.util.Iterator<?> it = diagramFacet.eResource().getResourceSet().getResources().iterator(); it.hasNext();) {
				org.eclipse.emf.ecore.resource.Resource nextResource = (org.eclipse.emf.ecore.resource.Resource) it.next();
				if (nextResource.isLoaded() && !getEditingDomain().isReadOnly(nextResource)) {
					nextResource.save(«xptDiagramEditorUtil.qualifiedClassName(subject.diagram)».getSaveOptions());
				}
			}
			«IF null == subject.diagram.editorGen.application»
				} catch (java.io.IOException ex) {
					throw new java.lang.reflect.InvocationTargetException(ex, "Save operation failed");
				}		
				}
				}.run(null);
				} catch (java.lang.reflect.InvocationTargetException e) {
					throw new org.eclipse.core.commands.ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
				} catch (InterruptedException e) {
					throw new org.eclipse.core.commands.ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
				}
			«ELSE»
				} catch (java.io.IOException ex) {
					throw new org.eclipse.core.commands.ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", ex);
				}
			«ENDIF»
			return d;
		}
	'''


}
