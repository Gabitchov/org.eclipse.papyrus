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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.example.uml.comment.editor.sharedresource.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.example.text.instance.papyrustextinstance.PapyrusTextInstance;
import org.eclipse.papyrus.example.uml.comment.editor.sharedresource.Activator;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.uml2.uml.Comment;

public class PapyrusCommentEditor extends TextEditor {

	/** the service registry */
	protected final ServicesRegistry registry;

	/** the papyrus text instance */
	protected final PapyrusTextInstance papyrusTextInstance;

	/** the text listener */
	protected ITextListener listener;

	/** the editing domain */
	protected TransactionalEditingDomain domain;

	public static final String EDITOR_DEFAULT_NAME = "Comment Editor Shared Resource";
	
	public static final String EDITOR_TYPE = "CommentEditorSharedResource";
	
	/**
	 * 
	 * Constructor.
	 * 
	 * @param registry
	 * @param papyrusTextInstance
	 */
	public PapyrusCommentEditor(final ServicesRegistry registry, final PapyrusTextInstance papyrusTextInstance) {
		super();
		this.registry = registry;
		this.papyrusTextInstance = papyrusTextInstance;
		try {
			domain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
	}


	/**
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createSourceViewer(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.jface.text.source.IVerticalRuler, int)
	 * 
	 * @param parent
	 * @param ruler
	 * @param styles
	 * @return
	 */
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		ISourceViewer viewer = super.createSourceViewer(parent, ruler, styles);
		//we add a listener on the viewer to be notified when the text is edited
		//TODO try to improve, because we execute a command for each character
		listener = new ITextListener() {

			//we edit the uml.Comment
			public void textChanged(TextEvent event) {
				String currentText = getSourceViewer().getTextWidget().getText();
				Comment cmt = (Comment)papyrusTextInstance.getEditedObject();
				EStructuralFeature feature = cmt.eClass().getEStructuralFeature("body");
				IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(cmt);
				SetRequest request = new SetRequest(domain, cmt, feature, currentText);
				ICommand command = elementEditService.getEditCommand(request);
				if(command.canExecute()) {
					domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
				}
			}
		};

		viewer.addTextListener(listener);
		
		return viewer;
	}

	/**
	 * We override this method because setInput can't be overriden for TextEditor.
	 * We replace the default papyrus input by our input for Comment
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#doSetInput(org.eclipse.ui.IEditorInput)
	 * 
	 * @param input
	 * @throws CoreException
	 */
	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		String string = ((Comment)papyrusTextInstance.getEditedObject()).getBody();
		if(string == null) {
			string = "";
		}
		IStorage storage = new TextStorage(string);
		super.doSetInput(new TextInput(storage));
	}

	/**
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		//we remove the listener
		getSourceViewer().removeTextListener(listener);
		super.dispose();
	}


	//for this classes , see : http://wiki.eclipse.org/FAQ_How_do_I_open_an_editor_on_something_that_is_not_a_file%3F
	class TextStorage implements IStorage {

		private String string;

		TextStorage(String input) {
			this.string = input;
		}

		public InputStream getContents() throws CoreException {
			return new ByteArrayInputStream(string.getBytes());
		}

		public IPath getFullPath() {
			return null;
		}

		public Object getAdapter(Class adapter) {
			return null;
		}

		public String getName() {
			int len = Math.min(5, string.length());
			return string.substring(0, len).concat("..."); //$NON-NLS-1$
		}

		public boolean isReadOnly() {
			return false;
		}
	}

	//for this classes , see : http://wiki.eclipse.org/FAQ_How_do_I_open_an_editor_on_something_that_is_not_a_file%3F
	class TextInput implements IStorageEditorInput {

		private IStorage storage;

		TextInput(IStorage storage) {
			this.storage = storage;
		}

		public boolean exists() {
			return true;
		}

		public ImageDescriptor getImageDescriptor() {
			return null;
		}

		public String getName() {
			return storage.getName();
		}

		public IPersistableElement getPersistable() {
			return null;
		}

		public IStorage getStorage() {
			return storage;
		}

		public String getToolTipText() {
			return "String-based file: " + storage.getName();
		}

		public Object getAdapter(Class adapter) {
			return null;
		}
	}

}
