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
package aspects.xpt.editor;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Externalizer;
import xpt.ExternalizerUtils_qvto;

@Singleton
@SuppressWarnings("all")
public class NewDiagramFileWizard extends xpt.editor.NewDiagramFileWizard {
  @Inject
  @Extension
  private ExternalizerUtils_qvto _externalizerUtils_qvto;
  
  @Inject
  private Externalizer xptExternalizer;
  
  public CharSequence i18nValues(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    String _i18nKeyForNewDiagramFileWizardCreationPage = this.i18nKeyForNewDiagramFileWizardCreationPage(it);
    String _nameKey = this._externalizerUtils_qvto.nameKey(_i18nKeyForNewDiagramFileWizardCreationPage);
    CharSequence _messageEntry = this.xptExternalizer.messageEntry(_nameKey, "Initialize new diagram file");
    _builder.append(_messageEntry, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardCreationPage_1 = this.i18nKeyForNewDiagramFileWizardCreationPage(it);
    String _titleKey = this._externalizerUtils_qvto.titleKey(_i18nKeyForNewDiagramFileWizardCreationPage_1);
    CharSequence _messageEntry_1 = this.xptExternalizer.messageEntry(_titleKey, "Diagram file");
    _builder.append(_messageEntry_1, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardCreationPage_2 = this.i18nKeyForNewDiagramFileWizardCreationPage(it);
    String _descriptionKey = this._externalizerUtils_qvto.descriptionKey(_i18nKeyForNewDiagramFileWizardCreationPage_2);
    CharSequence _messageEntry_2 = this.xptExternalizer.messageEntry(_descriptionKey, 
      "Create new diagram based on {0} model content");
    _builder.append(_messageEntry_2, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardRootSelectionPage = this.i18nKeyForNewDiagramFileWizardRootSelectionPage(it);
    String _nameKey_1 = this._externalizerUtils_qvto.nameKey(_i18nKeyForNewDiagramFileWizardRootSelectionPage);
    CharSequence _messageEntry_3 = this.xptExternalizer.messageEntry(_nameKey_1, 
      "Select diagram root element");
    _builder.append(_messageEntry_3, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardRootSelectionPage_1 = this.i18nKeyForNewDiagramFileWizardRootSelectionPage(it);
    String _titleKey_1 = this._externalizerUtils_qvto.titleKey(_i18nKeyForNewDiagramFileWizardRootSelectionPage_1);
    CharSequence _messageEntry_4 = this.xptExternalizer.messageEntry(_titleKey_1, "Diagram root element");
    _builder.append(_messageEntry_4, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardRootSelectionPage_2 = this.i18nKeyForNewDiagramFileWizardRootSelectionPage(it);
    String _descriptionKey_1 = this._externalizerUtils_qvto.descriptionKey(_i18nKeyForNewDiagramFileWizardRootSelectionPage_2);
    CharSequence _messageEntry_5 = this.xptExternalizer.messageEntry(_descriptionKey_1, 
      "Select semantic model element to be depicted on diagram");
    _builder.append(_messageEntry_5, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle = this.i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle(it);
    CharSequence _messageEntry_6 = this.xptExternalizer.messageEntry(_i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle, 
      "Select diagram root element:");
    _builder.append(_messageEntry_6, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage = this.i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage(it);
    CharSequence _messageEntry_7 = this.xptExternalizer.messageEntry(_i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage, 
      "Diagram root element is not selected");
    _builder.append(_messageEntry_7, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage = this.i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage(it);
    CharSequence _messageEntry_8 = this.xptExternalizer.messageEntry(_i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage, 
      "Invalid diagram root element is selected");
    _builder.append(_messageEntry_8, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardInitDiagramCommand = this.i18nKeyForNewDiagramFileWizardInitDiagramCommand(it);
    CharSequence _messageEntry_9 = this.xptExternalizer.messageEntry(_i18nKeyForNewDiagramFileWizardInitDiagramCommand, "Initializing diagram contents");
    _builder.append(_messageEntry_9, "");
    _builder.newLineIfNotEmpty();
    String _i18nKeyForNewDiagramFileWizardIncorrectRootError = this.i18nKeyForNewDiagramFileWizardIncorrectRootError(it);
    CharSequence _messageEntry_10 = this.xptExternalizer.messageEntry(_i18nKeyForNewDiagramFileWizardIncorrectRootError, 
      "Incorrect model object stored as a root resource object");
    _builder.append(_messageEntry_10, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
