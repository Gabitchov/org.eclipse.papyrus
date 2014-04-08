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
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto

@Singleton class NewDiagramFileWizard extends xpt.editor.NewDiagramFileWizard {
	@Inject extension ExternalizerUtils_qvto;
	@Inject Externalizer xptExternalizer;

	override i18nValues(GenDiagram it) '''
		«xptExternalizer.messageEntry(nameKey(i18nKeyForNewDiagramFileWizardCreationPage(it)), 'Initialize new diagram file')»
		«xptExternalizer.messageEntry(titleKey(i18nKeyForNewDiagramFileWizardCreationPage(it)), 'Diagram file')»
		«xptExternalizer.messageEntry(descriptionKey(i18nKeyForNewDiagramFileWizardCreationPage(it)),
			'Create new diagram based on {0} model content')»
		«xptExternalizer.messageEntry(nameKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)),
			'Select diagram root element')»
		«xptExternalizer.messageEntry(titleKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)), 'Diagram root element')»
		«xptExternalizer.messageEntry(descriptionKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)),
			'Select semantic model element to be depicted on diagram')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle(it),
			'Select diagram root element:')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage(it),
			'Diagram root element is not selected')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage(it),
			'Invalid diagram root element is selected')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardInitDiagramCommand(it), 'Initializing diagram contents')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardIncorrectRootError(it),
			'Incorrect model object stored as a root resource object')»
	'''


}
