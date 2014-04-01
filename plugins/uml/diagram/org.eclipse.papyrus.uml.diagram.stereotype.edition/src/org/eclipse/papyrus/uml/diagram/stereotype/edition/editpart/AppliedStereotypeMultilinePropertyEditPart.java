/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IControlParserForDirectEdit;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypePropertyDirectEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.EditingFlowPage;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.papyrus.uml.diagram.common.parser.StereotypePropertyParser;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * the goal of this editpart is to edit a property of an application of the stereotype into a text area
 * 
 */
public class AppliedStereotypeMultilinePropertyEditPart extends CompartmentEditPart implements ITextAwareEditPart, NotificationListener, IPapyrusListener, IControlParserForDirectEdit {

	public static final String ID = "AppliedStereotypeProperty"; //$NON-NLS-1$

	private DirectEditManager manager;

	private IParser parser;

	private List<?> parserElements;

	private String defaultText;

	/**
	 * direct edition mode (default, undefined, registered editor, etc.)
	 * 
	 */
	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	/**
	 * configuration from a registered edit dialog
	 * 
	 */
	protected IDirectEditorConfiguration configuration;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 */
	public AppliedStereotypeMultilinePropertyEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart#createDefaultEditPolicies()
	 * 
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new UMLTextSelectionEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new AppliedStereotypePropertyDirectEditPolicy());
		//installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new UseCaseDiagramEditPart.NodeLabelDragPolicy());
	}



	/**
	 * get the text from the figure
	 * 
	 * @param figure
	 * @return the text from the figure
	 */
	protected String getLabelTextHelper(IFigure figure) {
		//the figure is an ILabel Figure
		if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getText();
		}
		return "";
	}

	/**
	 * set the text inot the
	 */
	protected void setLabelTextHelper(IFigure figure, String text) {
		if(figure instanceof FlowPage) {
			// remove all children from page.
			((FlowPage)figure).removeAll();


			// generates new ones
			generateBlockForText(text, ((FlowPage)figure));
		}
	}

	/**
	 * Generates block list for the given text, and adds it to the root flow
	 * page
	 * 
	 * @param text
	 *        the string to display
	 */
	protected void generateBlockForText(String text, FlowPage page) {
		// return only one text flow with the content of the text
		TextFlowEx textFlow = new TextFlowEx(text);
		page.add(textFlow);
	}

	/**
	 * return icon from the figure
	 * 
	 * @param figure
	 * @return the icon
	 */
	protected Image getLabelIconHelper(IFigure figure) {
		if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getIcon();
		}
		return null;
	}

	/**
	 * set the icon inot the figure
	 */
	protected void setLabelIconHelper(IFigure figure, Image icon) {
		if(figure instanceof ILabelFigure) {
			((ILabelFigure)figure).setIcon(icon);
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getModelChildren()
	 * 
	 */
	@Override
	protected List getModelChildren() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getChildBySemanticHint(java.lang.String)
	 * 
	 */
	@Override
	public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
		return null;
	}

	/**
	 * the element that will display in the text area
	 * 
	 * @return
	 */
	protected EObject getParserElement() {
		return resolveSemanticElement();
	}

	/**
	 * get the icon to display
	 */
	protected Image getLabelIcon() {
		return null;
	}

	/**
	 * 
	 * @return the text to display in the label
	 */
	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if(parserElement != null && getParser() != null) {
			text = getParser().getPrintString(new SemanticAdapter(this.resolveSemanticElement(), getNotationView()), getParserOptions().intValue());
		}
		if(text == null || text.length() == 0) {
			text = defaultText;
		}
		return text;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#setLabelText(java.lang.String)
	 * 
	 */

	public void setLabelText(String text) {
		setLabelTextHelper(getFigure(), text);
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getEditText()
	 * 
	 */
	public String getEditText() {
		if(getParserElement() == null || getParser() == null) {
			return ""; //$NON-NLS-1$
		}

		// return getParser().getEditString(new SemanticAdapter((EObject) this.getAdapter(AppliedStereotypeProperty.class), getNotationView()), getParserOptions().intValue());
		return getParser().getEditString(new SemanticAdapter(resolveSemanticElement(), getNotationView()), getParserOptions().intValue());
	}

	/**
	 * 
	 * @return true if this edit part is editable, it depends of the attribue derived of the property
	 */
	protected boolean isEditable() {
		if(!(((Property)resolveSemanticElement()).isDerived())) {
			return getParser() != null;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getEditTextValidator()
	 * 
	 */
	public ICellEditorValidator getEditTextValidator() {
		return new ICellEditorValidator() {

			public String isValid(final Object value) {
				if(value instanceof String) {
					final EObject element = getParserElement();
					final IParser parser = getParser();
					try {
						IParserEditStatus valid = (IParserEditStatus)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

							public void run() {
								setResult(parser.isValidEditString(new EObjectAdapter(element), (String)value));
							}
						});
						return valid.getCode() == ParserEditStatus.EDITABLE ? null : valid.getMessage();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}

				// shouldn't get here
				return null;
			}
		};
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getCompletionProcessor()
	 * 
	 */
	public IContentAssistProcessor getCompletionProcessor() {
		if(getParserElement() == null || getParser() == null) {
			return null;
		}
		return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getParserOptions()
	 * 
	 */
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getParser()
	 */
	public IParser getParser() {
		if(parser == null) {
			parser = new StereotypePropertyParser();
		}
		return parser;
	}

	/**
	 * 
	 * @return the manager to edit the label
	 */
	protected DirectEditManager getManager() {
		if(manager == null) {
			setManager(new MultilineLabelDirectEditManager(this, MultilineLabelDirectEditManager.getTextCellEditorClass(this), new MultilineCellEditorLocator((IMultilineEditableFigure)getFigure())));
		}
		return manager;
	}

	/**
	 * set a manager to edit the label
	 */
	protected void setManager(DirectEditManager manager) {
		this.manager = manager;
	}

	/**
	 * do the edition
	 */
	protected void performDirectEdit() {
		BusyIndicator.showWhile(Display.getDefault(), new Runnable() {

			public void run() {
				getManager().show();
			}
		});
	}

	/**
	 * Do the edition
	 * 
	 * @param eventLocation
	 */
	protected void performDirectEdit(Point eventLocation) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(eventLocation.getSWTPoint());
		}
	}

	/**
	 * Do the edition
	 * 
	 * @param initialCharacter
	 */
	private void performDirectEdit(char initialCharacter) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(initialCharacter);
		} else {
			performDirectEdit();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#performDirectEditRequest(org.eclipse.gef.Request)
	 * 
	 */
	@Override
	protected void performDirectEditRequest(Request request) {

		final Request theRequest = request;

		if(IDirectEdition.UNDEFINED_DIRECT_EDITOR == directEditionMode) {
			directEditionMode = getDirectEditionType();
		}
		switch(directEditionMode) {
		case IDirectEdition.NO_DIRECT_EDITION:
			// no direct edition mode => does nothing
			return;
		case IDirectEdition.EXTENDED_DIRECT_EDITOR:
			updateExtendedEditorConfiguration();
			if(configuration == null || configuration.getLanguage() == null) {
				performDefaultDirectEditorEdit(theRequest);
			} else {
				configuration.preEditAction(getAdapter(AppliedStereotypeProperty.class));
				Dialog dialog = null;
				if (configuration instanceof ICustomDirectEditorConfiguration) {
					setManager(((ICustomDirectEditorConfiguration) configuration)
						.createDirectEditManager(this));
					initializeDirectEditManager(theRequest);
					return;
				}  else if(configuration instanceof IPopupEditorConfiguration) {
					IPopupEditorHelper helper = ((IPopupEditorConfiguration)configuration).createPopupEditorHelper(this);
					if(helper != null) {
						helper.showEditor();
					}
					return;
				} else if(configuration instanceof IAdvancedEditorConfiguration) {
					dialog = ((IAdvancedEditorConfiguration)configuration).createDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), configuration.getTextToEdit(resolveSemanticElement()));
				} else if(configuration instanceof IDirectEditorConfiguration) {
					dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), configuration.getTextToEdit(resolveSemanticElement()), configuration);
				} else {
					return;
				}
				final Dialog finalDialog = dialog;

				if(Window.OK == dialog.open()) {
					TransactionalEditingDomain domain = getEditingDomain();
					RecordingCommand command = new RecordingCommand(domain, "Edit Label") {

						@Override
						protected void doExecute() {
							configuration.postEditAction(resolveSemanticElement(), ((ILabelEditorDialog)finalDialog).getValue());

						}
					};
					domain.getCommandStack().execute(command);
				}
			}
			break;
		case IDirectEdition.DEFAULT_DIRECT_EDITOR:

			// initialize the direct edit manager
			try {
				getEditingDomain().runExclusive(new Runnable() {

					public void run() {
						if(isActive() && isEditable()) {
							if(theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
								Character initialChar = (Character)theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
								performDirectEdit(initialChar.charValue());
							} else if((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
								DirectEditRequest editRequest = (DirectEditRequest)theRequest;
								performDirectEdit(editRequest.getLocation());
							} else {
								performDirectEdit();
							}
						}
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	public void setParser(IParser parser) {
		this.parser = parser;
	}

	/**
	 */
	protected void initializeDirectEditManager(final Request request) {
		// initialize the direct edit manager
		try {
			getEditingDomain().runExclusive(new Runnable() {
				public void run() {
					if (isActive() && isEditable()) {
						if (request
							.getExtendedData()
							.get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character) request
								.getExtendedData()
								.get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else if ((request instanceof DirectEditRequest)
							&& (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest) request;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#refreshVisuals()
	 * 
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshUnderline();
		refreshStrikeThrough();
	}

	/**
	 * refresh the label
	 */
	protected void refreshLabel() {
		EditPolicy maskLabelPolicy = getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(maskLabelPolicy == null) {
			setLabelTextHelper(getFigure(), getLabelText());
		}
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	/**
	 * refresh the underline for the label
	 */
	protected void refreshUnderline() {
		@SuppressWarnings("unused")
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		//cannot be done in the text area
	}

	/**
	 * refresh the strike for the label
	 */
	protected void refreshStrikeThrough() {
		@SuppressWarnings("unused")
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		//cannot be done in the text area
	}

	/**
	 * refresh font
	 */
	@Override
	protected void refreshFont() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null) {
			FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	/**
	 * change the color
	 */
	@Override
	protected void setFontColor(Color color) {
		getFigure().setForegroundColor(color);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addSemanticListeners()
	 * 
	 */
	@Override
	protected void addSemanticListeners() {
		if(getParser() instanceof ISemanticParser) {

			EObject element = resolveSemanticElement();
			parserElements = ((ISemanticParser)getParser()).getSemanticElementsBeingParsed(element);
			for(int i = 0; i < parserElements.size(); i++) {
				addListenerFilter("SemanticModel" + i, this, (EObject)parserElements.get(i)); //$NON-NLS-1$
			}
		} else {
			super.addSemanticListeners();
		}
	}


	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeSemanticListeners()
	 * 
	 */
	@Override
	protected void removeSemanticListeners() {
		if(parserElements != null) {
			for(int i = 0; i < parserElements.size(); i++) {
				removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
			}
		} else {
			super.removeSemanticListeners();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAccessibleEditPart()
	 * 
	 */
	@Override
	protected AccessibleEditPart getAccessibleEditPart() {
		if(accessibleEP == null) {
			accessibleEP = new AccessibleGraphicalEditPart() {

				@Override
				public void getName(AccessibleEvent e) {
					e.result = getLabelTextHelper(getFigure());
				}
			};
		}
		return accessibleEP;
	}

	/**
	 * 
	 * @return the view for the font style
	 */
	private View getFontStyleOwnerView() {
		return (View)getModel();
	}

	/**
	 * Returns the kind of associated editor for direct edition.
	 * 
	 * @return an <code>int</code> corresponding to the kind of direct editor, @see org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition
	 */
	public int getDirectEditionType() {
		if(checkExtendedEditor()) {
			initExtendedEditorConfiguration();
			return IDirectEdition.EXTENDED_DIRECT_EDITOR;
		}
		if(checkDefaultEdition()) {
			return IDirectEdition.DEFAULT_DIRECT_EDITOR;
		}

		// not a named element. no specific editor => do nothing
		return IDirectEdition.NO_DIRECT_EDITION;
	}

	/**
	 * Checks if an extended editor is present.
	 * 
	 * @return <code>true</code> if an extended editor is present.
	 */
	protected boolean checkExtendedEditor() {
		if(resolveSemanticElement() != null) {
			return DirectEditorsUtil.hasSpecificEditorConfiguration(resolveSemanticElement().eClass().getInstanceClassName());
		}
		return false;
	}

	/**
	 * Checks if a default direct edition is available
	 * 
	 * @return <code>true</code> if a default direct edition is available
	 */
	protected boolean checkDefaultEdition() {
		return (getParser() != null);
	}

	/**
	 * Initializes the extended editor configuration
	 * 
	 */
	protected void initExtendedEditorConfiguration() {
		if(configuration == null) {
			final String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + AppliedStereotypeProperty.class.getName());
			if(languagePreferred != null && !languagePreferred.equals("")) {
				configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, AppliedStereotypeProperty.class.getName());
			} else {
				configuration = DirectEditorsUtil.findEditorConfiguration(IDirectEditorsIds.UML_LANGUAGE, AppliedStereotypeProperty.class.getName());
			}
		}
	}

	/**
	 * Updates the preference configuration
	 * 
	 */
	protected void updateExtendedEditorConfiguration() {
		String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + AppliedStereotypeProperty.class.getName());
		if(languagePreferred != null && !languagePreferred.equals("") && languagePreferred != configuration.getLanguage()) {
			configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, AppliedStereotypeProperty.class.getName());
		} else if(IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(languagePreferred)) {
			configuration = null;
		}
	}

	/**
	 * Performs the direct edit usually used by GMF editors.
	 * 
	 * @param theRequest
	 *        the direct edit request that starts the direct edit system
	 */
	protected void performDefaultDirectEditorEdit(final Request theRequest) {
		// initialize the direct edit manager
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if(isActive() && isEditable()) {
						if(theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character)theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else if((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest)theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addNotationalListeners()
	 * 
	 */
	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("PrimaryView", this, getPrimaryView()); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeNotationalListeners()
	 * 
	 */
	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("PrimaryView"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 * 
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		refreshLabel();
		Object feature = event.getFeature();
		if(NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			Integer c = (Integer)event.getNewValue();
			setFontColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if(NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
			refreshUnderline();
		} else if(NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
			refreshStrikeThrough();
		} else if(NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
			refreshFont();
		} else {
			if(getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {
				refreshLabel();
			}
			if(getParser() instanceof ISemanticParser) {
				ISemanticParser modelParser = (ISemanticParser)getParser();
				if(modelParser.areSemanticElementsAffected(null, event)) {
					removeSemanticListeners();
					if(resolveSemanticElement() != null) {
						addSemanticListeners();
					}
					refreshLabel();
				}
			}
		}

		super.handleNotificationEvent(event);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#createFigure()
	 * 
	 */
	@Override
	protected IFigure createFigure() {
		return new EditingFlowPage();
	}

	/**
	 * 
	 */
	private static final String ADD_PARENT_MODEL = "AddParentModel";

	protected EObject stereotypeApplication;

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#activate()
	 * 
	 */
	@Override
	public void activate() {
		// before to be suppressed by its owner, the associate EObject can be UNSET, so refresh is prevented 
		if(((View)getNotationView().eContainer()!=null)&&((View)getNotationView().eContainer()).getElement()!=null){
			super.activate();
			addOwnerElementListeners();
			stereotypeApplication = ((View)getNotationView().eContainer()).getElement();
			final Element umlElement = UMLUtil.getBaseElement(stereotypeApplication);
			getDiagramEventBroker().addNotificationListener(stereotypeApplication, this);
			getDiagramEventBroker().addNotificationListener(umlElement, this);
		}
	}

	/**
	 * 
	 */
	protected void addOwnerElementListeners() {
		addListenerFilter(ADD_PARENT_MODEL, this, ((View)getParent().getModel()));

	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#deactivate()
	 * 
	 */
	@Override
	public void deactivate() {
		removeOwnerElementListeners();
		super.deactivate();
		if(stereotypeApplication != null) {
			final Element umlElement = UMLUtil.getBaseElement(stereotypeApplication);
			getDiagramEventBroker().removeNotificationListener(stereotypeApplication, this);
			getDiagramEventBroker().removeNotificationListener(umlElement, this);
		}
	}

	/**
	 * 
	 */
	protected void removeOwnerElementListeners() {
		removeListenerFilter(ADD_PARENT_MODEL);

	}

	/**
	 * It has been overload in order to be display in the property view
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAdapter(java.lang.Class)
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public Object getAdapter(Class key) {
		if(key == AppliedStereotypeProperty.class) {
			return new AppliedStereotypeProperty(((View)getNotationView().eContainer()).getElement(), (Property)resolveSemanticElement());
		}
		return null;
	}

	/**
	 * locator for the multiline Cell
	 * 
	 */
	static public class MultilineCellEditorLocator implements CellEditorLocator {

		private IMultilineEditableFigure multilineEditableFigure;

		public MultilineCellEditorLocator(IMultilineEditableFigure figure) {
			this.multilineEditableFigure = figure;
		}

		public IMultilineEditableFigure getMultilineEditableFigure() {
			return multilineEditableFigure;
		}

		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();
			rect.x = getMultilineEditableFigure().getEditionLocation().x;
			rect.y = getMultilineEditableFigure().getEditionLocation().y;
			getMultilineEditableFigure().translateToAbsolute(rect);
			if(getMultilineEditableFigure().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}

	}

}
