/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.parser.HTMLCleaner;
import org.eclipse.papyrus.uml.properties.tabbedproperties.comments.Activator;
import org.eclipse.papyrus.uml.properties.tabbedproperties.comments.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Section with advanced editor for the {@link Comment} in Papyrus
 */
public class CommentedElementPropertySection extends AbstractPropertySection implements IFilter {

	/** advanced editor for the comments */
	protected CommentRichTextEditor richText;

	/** edited element */
	protected Element element;

	/** edited comment */
	protected Comment comment;

	/** Table viewer for comment */
	protected TableViewer viewer;

	/** selection change listener on the comment viewer */
	protected ISelectionChangedListener viewerListener = new SelectionChangeListener();

	/** icon path for the display button */
	public final static String DISPLAY_ICON = "/icons/ConsoleView.gif"; //$NON-NLS-1$

	/** Remove comment button */
	protected Button removeCommentButton;

	/** Display comment button */
	protected Button displayCommentButton;

	/**
	 * 
	 */
	public CommentedElementPropertySection() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		// create a main composite for this section
		Composite mainComposite = getWidgetFactory().createComposite(parent);
		mainComposite.setLayout(new GridLayout(2, false));

		// create a composite for the comment viewer (label + buttons + viewer itself)
		Composite tableComposite = getWidgetFactory().createComposite(mainComposite);
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		tableComposite.setLayoutData(data);
		GridLayout layout = new GridLayout(4, false);
		tableComposite.setLayout(layout);

		// label for the comments viewer
		Label commentViewerLabel = getWidgetFactory().createLabel(tableComposite, Messages.CommentedElementPropertySection_CommentsViewerLabel);
		data = new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1);
		data.horizontalIndent = 3; // put some space on the left of the label
		commentViewerLabel.setLayoutData(data);

		// button to add a comment to the current edited element
		Button addCommentButton = getWidgetFactory().createButton(tableComposite, "", SWT.NONE); //$NON-NLS-1$
		addCommentButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));
		addCommentButton.setToolTipText(Messages.CommentedElementPropertySection_AddButtonTooltip);
		addCommentButton.addMouseListener(new AddCommentButtonMouseListener());

		// button to remove a comment from the current edited element
		removeCommentButton = getWidgetFactory().createButton(tableComposite, "", SWT.NONE); //$NON-NLS-1$
		removeCommentButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		removeCommentButton.setToolTipText(Messages.CommentedElementPropertySection_DeleteButtonTooltip);
		removeCommentButton.addMouseListener(new RemoveCommentButtonMouseListener());

		// button to display a comment in the current diagram
		displayCommentButton = getWidgetFactory().createButton(tableComposite, "", SWT.NONE); //$NON-NLS-1$
		displayCommentButton.setImage(org.eclipse.papyrus.uml.diagram.common.Activator.getPluginIconImage(org.eclipse.papyrus.uml.properties.tabbedproperties.comments.Activator.PLUGIN_ID, DISPLAY_ICON));
		displayCommentButton.setToolTipText(Messages.CommentedElementPropertySection_DisplayButtonTooltip);
		displayCommentButton.addMouseListener(new DisplayCommentButtonMouseListener());

		// creates a table where every comment attached to the current selected element is displayed
		// and selectable
		Table table = getWidgetFactory().createTable(tableComposite, SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
		data.minimumHeight = 210;
		data.minimumWidth = 200;
		table.setLayoutData(data);
		viewer = new TableViewer(table);
		viewer.setContentProvider(new CommentContentProvider());
		CommentLabelProvider labelProvider = new CommentLabelProvider(org.eclipse.papyrus.uml.diagram.common.Activator.getDefault().getItemProvidersAdapterFactory());
		labelProvider.setFireLabelUpdateNotifications(true);
		viewer.setLabelProvider(labelProvider);

		// listen for the viewer selection to update the rich editor content
		viewer.addSelectionChangedListener(viewerListener);

		// creates the rich text editor content
		richText = CommentRichTextFormToolkit.createFocusAwareRichTextEditor(getWidgetFactory(), mainComposite, "", comment, //$NON-NLS-1$
			SWT.NONE, EditorUtils.getMultiDiagramEditor().getEditorSite());
		data = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		data.heightHint = 240;
		richText.setLayoutData(data);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if(!(selection instanceof IStructuredSelection) || !((part instanceof IEditingDomainProvider) || part.getAdapter(IEditingDomainProvider.class) != null)) {
			return;
		}

		Object firstElement = ((IStructuredSelection)selection).getFirstElement();
		EObject newEObject = resolveSemanticObject(firstElement);

		// check an uml element is selected
		if(newEObject instanceof Element) {
			setElement((Element)newEObject);
			viewer.setInput(newEObject);

			// select first comment by default
			Object firstComment = viewer.getElementAt(0);
			if(firstComment != null) {
				viewer.setSelection(new StructuredSelection(firstComment), true);
			} else {
				richText.setEditable(false);
			}
		}

		// enables the display button ?
		if(displayCommentButton != null && !displayCommentButton.isDisposed()) {
			if(firstElement instanceof GraphicalEditPart) {
				displayCommentButton.setEnabled(true);
			} else {
				displayCommentButton.setEnabled(false);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		// remove viewer listener on dispose
		if(viewer != null && viewerListener != null) {
			viewer.removeSelectionChangedListener(viewerListener);
		}
		super.dispose();
	}

	/**
	 * Returns the element to edit
	 * 
	 * @return the element to edit
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * Sets the element to edit
	 * 
	 * @param element
	 *        the element to set
	 */
	public void setElement(Element element) {
		this.element = element;
	}

	/**
	 * Sets the comment to edit
	 * 
	 * @param comment
	 *        the comment to edit
	 */
	protected void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * Returns the comment to edit
	 * 
	 * @return the comment to edit
	 */
	protected Comment getComment() {
		return comment;
	}

	/**
	 * Resolve semantic element
	 * 
	 * @param object
	 *        the object to resolve
	 * @return <code>null</code> or the semantic element associated to the specified object
	 */
	private EObject resolveSemanticObject(Object object) {
		if(object instanceof EObject) {
			return (EObject)object;
		} else if(object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)object;
			if(adaptable.getAdapter(EObject.class) != null) {
				return (EObject)adaptable.getAdapter(EObject.class);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object toTest) {
		EObject eObjectToTest = resolveSemanticObject(toTest);
		return eObjectToTest instanceof Element;
	}

	/**
	 * Content provider for the comment viewer
	 */
	public class CommentContentProvider implements IStructuredContentProvider {

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {

		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof Element) {
				Set<Comment> annotatedElements = new HashSet<Comment>();
				Iterator<Setting> it = UML2Util.getNonNavigableInverseReferences((Element)inputElement).iterator();
				while(it.hasNext()) {
					Setting setting = it.next();
					if(setting.getEStructuralFeature() == UMLPackage.Literals.COMMENT__ANNOTATED_ELEMENT) {
						if(setting.getEObject() instanceof Comment) {
							Comment comment = (Comment)setting.getEObject();

							// small bugfix...
							// UML2Util.getNonNavigableInverseReferences returns more element than
							// needed, especially elements that are not real ones
							// so we must check if they are contained by the current resource or
							// not...
							boolean isProxy = false;
							for(Element annotatedElement : comment.getAnnotatedElements()) {
								if(annotatedElement.eResource() == null) {
									isProxy = true;
								}
							}

							// this is the real element, not a ghost one. display it in the list
							if(!isProxy) {
								if(comment.getAnnotatedElements().contains(inputElement)) {
									annotatedElements.add(comment);
								}
							}

						}
					}

				}
				return annotatedElements.toArray();
			}
			return new Object[0];
		}
	}

	/**
	 * Content provider for the comment viewer
	 */
	public class CommentLabelProvider extends AdapterFactoryLabelProvider {

		public CommentLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		/** max number of char in the label */
		private static final int MAX_SIZE = 25;

		/** string for cutted label */
		private static final String CUT_STRING = "..."; //$NON-NLS-1$

		/** cut string length */
		private final int CUT_STRING_LENGTH = CUT_STRING.length();

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getColumnText(Object object, int columnIndex) {
			return getText(object);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof Comment) {
				String body = ((Comment)element).getBody();
				if(body == null) {
					return ""; //$NON-NLS-1$
				} else {
					body = HTMLCleaner.cleanHTMLTags(body);
					if(body.length() <= MAX_SIZE) {
						return body;
					} else {
						return body.substring(0, MAX_SIZE - CUT_STRING_LENGTH) + CUT_STRING;
					}
				}
			}
			// return element.toString();
			return "<NotAComment>"; //$NON-NLS-1$
		}
	}

	/**
	 * selection change listener for the comment viewer
	 */
	protected class SelectionChangeListener implements ISelectionChangedListener {

		/**
		 * {@inheritDoc}
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection selection = (IStructuredSelection)event.getSelection();
			Comment element = (Comment)selection.getFirstElement();
			if(richText == null) {
				return;
			}
			// should save old comment edition if required...
			richText.getRichTextControl().saveCommentBody();

			// no checks here, perhaps some should be done
			setComment(element);
			richText.init(element, null);
			if(element != null) {
				richText.setEditable(true);
				if(removeCommentButton != null) {
					removeCommentButton.setEnabled(true);
				}
				richText.setText(element.getBody());
			} else {
				// in case no element is selected, remove the text in the editor
				richText.setEditable(false);
				removeCommentButton.setEnabled(false);
				richText.setText("");//$NON-NLS-1$
			}

		}
	}

	/**
	 * Action on the add Comment button
	 */
	protected class AddCommentButtonMouseListener implements MouseListener {

		/**
		 * {@inheritDoc}
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseDown(MouseEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseUp(MouseEvent e) {
			// get the selected element
			final Element element = getElement();

			// add a comment to this element
			TransactionalEditingDomain domain;
			try {
				domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(element);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return;
			}

			// open transaction to save the comment body
			// retrieve editing domain
			if(domain != null) {
				RecordingCommand command = new RecordingCommand(domain, Messages.CommentedElementPropertySection_AddCommentCommand) {

					/**
					 * {@inheritDoc}
					 */
					@Override
					protected void doExecute() {
						Comment newComment = element.createOwnedComment();
						newComment.getAnnotatedElements().add(element);
						newComment.setBody(""); //$NON-NLS-1$

						if(viewer != null && richText != null) {
							viewer.refresh(true);
							viewer.setSelection(new StructuredSelection(newComment), true);
							richText.setFocus();
						}
					}

				};
				domain.getCommandStack().execute(command);
			} else {
				Activator.log.error("Impossible to find current editing domain", null); //$NON-NLS-1$
			}
		}

	}

	/**
	 * Action on the add Comment button
	 */
	protected class RemoveCommentButtonMouseListener implements MouseListener {

		/**
		 * {@inheritDoc}
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseDown(MouseEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseUp(MouseEvent e) {
			// get the selected element
			final Element element = getElement();

			// get the selected comment
			final Comment comment = getComment();

			if(element == null || comment == null) {
				Activator.log.error("Element or comment is null", null); //$NON-NLS-1$
				return;
			}

			// add a comment to this element
			TransactionalEditingDomain domain;
			try {
				domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(element);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return;
			}
			// open transaction to save the comment body
			// retrieve editing domain
			if(domain != null) {
				// 1. check annotated elements
				List<Element> annotatedElements = comment.getAnnotatedElements();
				boolean hasOtherAnnotatedElement = (annotatedElements.size() > 1);

				// 2. if there are more than one annotated element, ask for destruction of
				// the comment or only the removal of the element in the annotated element
				// list
				boolean destroy = true;
				if(hasOtherAnnotatedElement) {
					destroy = MessageDialog.openQuestion(getPart().getSite().getShell(), Messages.CommentedElementPropertySection_DestroyUpdateComment_DialogTitle, Messages.bind(Messages.CommentedElementPropertySection_DestroyUpdateComment_Message, prettyPrint(comment.getAnnotatedElements())));
				}

				try {
					if(destroy) {
						DestroyElementCommand command = new DestroyElementCommand(new DestroyElementRequest(getComment(), true));
						if(command != null && command.canExecute()) {
							command.execute(new NullProgressMonitor(), null);
						} else {
							Activator.log.error("Impossible to execute the delete command for the comment", null);
						}
					} else {
						AbstractTransactionalCommand command = new AbstractTransactionalCommand(domain, "Remove element from annotated element comment list", null) {

							@Override
							protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								comment.getAnnotatedElements().remove(element);
								return CommandResult.newOKCommandResult();
							}
						};
						if(command != null && command.canExecute()) {
							domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
						} else {
							Activator.log.error("Impossible to modify the annotated element list for the comment", null);
						}
					}
				} catch (ExecutionException e1) {
					Activator.log.error(e1);
				}

				if(viewer != null && richText != null) {
					viewer.refresh(true);
					Object firstElement = viewer.getElementAt(0);
					if(firstElement != null) {
						viewer.setSelection(new StructuredSelection(firstElement), true);
					}
					richText.setFocus();
				}
			}

		}

		/**
		 * Pretty print the list of annotated element for the message dialog
		 * 
		 * @param annotatedElements
		 *        the list of annotated elements
		 * @return the string corresponding to the list of annotated elements
		 */
		protected String prettyPrint(EList<Element> annotatedElements) {
			StringBuffer buffer = new StringBuffer();
			Iterator<Element> it = annotatedElements.iterator();
			while(it.hasNext()) {
				Element element = it.next();
				if(element instanceof NamedElement) {
					buffer.append(((NamedElement)element).getLabel());
				} else {
					buffer.append(element.toString());
				}
				if(it.hasNext()) {
					buffer.append(", ");
				}
			}

			return buffer.toString();
		}
	}



	/**
	 * Action on the add Comment button
	 */
	protected class DisplayCommentButtonMouseListener implements MouseListener {

		/**
		 * {@inheritDoc}
		 */
		public void mouseDoubleClick(MouseEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public void mouseDown(MouseEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		@SuppressWarnings("unchecked")
		public void mouseUp(MouseEvent e) {
			ISelection selection = getSelection();
			if(!(selection instanceof IStructuredSelection)) {
				return;
			}
			Object selectedObject = null;
			if(((IStructuredSelection)selection).getFirstElement() instanceof EditPart) {
				selectedObject = ((IStructuredSelection)selection).getFirstElement();
			}

			if(selectedObject instanceof GraphicalEditPart) {
				GraphicalEditPart selectionEditPart = (GraphicalEditPart)selectedObject;
				IAdaptable elementAdapter = new EObjectAdapter(getComment());
				ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, false, selectionEditPart.getDiagramPreferencesHint());
				CreateViewRequest request = new CreateViewRequest(descriptor);

				Command createCommand = null;
				GraphicalEditPart parent = getParent(selectionEditPart);
				while(createCommand == null && parent != null) {
					Command command = parent.getCommand(request);
					if(command.canExecute()) {
						createCommand = command;
					} else {
						command.dispose();
					}
					// retrieve parent of the current edit part
					parent = getParent(parent);
				}

				IAdaptable sourceAdapter = (IAdaptable)((List)request.getNewObject()).get(0);
				IAdaptable targetAdapter = new SemanticAdapter(null, selectionEditPart.getModel());

				TransactionalEditingDomain domain;
				try {
					domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(element);
				} catch (ServiceException ex) {
					Activator.log.error(ex);
					return;
				}

				CreateCommentLinkTransactionnalCommand linkVisualIDCommand = new CreateCommentLinkTransactionnalCommand(domain, selectionEditPart.getViewer(), sourceAdapter, targetAdapter);
				CompositeCommand compoundCommand = new CompositeCommand("Display Comment with link");
				compoundCommand.compose(new CommandProxy(createCommand));
				compoundCommand.compose(linkVisualIDCommand);

				try {
					compoundCommand.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e1) {
					Activator.log.error(e1);
				}
			}
		}

	}

	/**
	 * Returns the first valid parent edit part where to display the comment
	 * 
	 * @param selectionEditPart
	 *        the edit part to comment
	 * @return the first valid parent edit part where to display the comment or <code>null</code>
	 */
	protected GraphicalEditPart getParent(EditPart editPart) {
		EditPart parentEditPart = editPart.getParent();
		if(parentEditPart == null) {
			return null;
		} else if(parentEditPart instanceof GraphicalEditPart) {
			return ((GraphicalEditPart)parentEditPart);
		} else {
			return getParent(parentEditPart);
		}
	}

	protected class CreateCommentLinkTransactionnalCommand extends AbstractTransactionalCommand {

		/** edit part viewer */
		private EditPartViewer viewer;

		/** IAdaptable from which to retrieve availalbe links */
		private IAdaptable sourceViewAdapter;

		/** IAdaptable to the target commented element */
		private IAdaptable targetViewAdapter;

		/**
		 * Constructor.
		 * 
		 * @param domain
		 *        transactionnal editing domain on which the operation is run
		 */
		public CreateCommentLinkTransactionnalCommand(TransactionalEditingDomain domain, EditPartViewer viewer, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter) {
			super(domain, "Retrieve Comment Link visual ID", null);
			this.viewer = viewer;
			this.sourceViewAdapter = sourceViewAdapter;
			this.targetViewAdapter = targetViewAdapter;
		}

		/**
		 * {@inheritDoc}
		 */
		@SuppressWarnings("unchecked")
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			Map epRegistry = viewer.getEditPartRegistry();
			IGraphicalEditPart sourceEP = (IGraphicalEditPart)epRegistry.get(sourceViewAdapter.getAdapter(View.class));

			// perhaps it could be more simple => directly pass the edit part in parameter ?
			List<IElementType> types = ModelingAssistantService.getInstance().getRelTypesOnSource(sourceEP);
			for(IElementType type : types) {
				if(!"org.eclipse.gmf.runtime.diagram.ui.presentation.noteAttachment".equals(type.getId())) {
					ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(type, ((IHintedType)type).getSemanticHint(), sourceEP.getDiagramPreferencesHint());

					CommonDeferredCreateConnectionViewCommand binaryCommand = new CommonDeferredCreateConnectionViewCommand(EditorUtils.getTransactionalEditingDomain(), ((IHintedType)type).getSemanticHint(), sourceViewAdapter, targetViewAdapter, viewer, sourceEP.getDiagramPreferencesHint(), viewDescriptor, null);
					if(binaryCommand != null && binaryCommand.canExecute()) {
						binaryCommand.execute(new NullProgressMonitor(), null);
					}
				}
			}

			return CommandResult.newOKCommandResult();
		}
	}
}
