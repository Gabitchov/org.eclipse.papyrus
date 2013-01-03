/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusLabelEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLParserProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Feature;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class MessageAsyncAppliedStereotypeEditPart extends PapyrusLabelEditPart implements ITextAwareEditPart

{

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 61;

	/**
	 * @generated
	 */
	private DirectEditManager manager;

	/**
	 * @generated
	 */
	private IParser parser;

	/**
	 * @generated
	 */
	private List<?> parserElements;

	/**
	 * @generated
	 */
	private String defaultText;

	/**
	 * direct edition mode (default, undefined, registered editor, etc.)
	 * 
	 * @generated
	 */
	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	/**
	 * configuration from a registered edit dialog
	 * 
	 * @generated
	 */
	protected IDirectEditorConfiguration configuration;

	/**
	 * @generated
	 */
	static {
		registerSnapBackPosition(
				UMLVisualIDRegistry.getType(org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncAppliedStereotypeEditPart.VISUAL_ID), new Point(0,
						-30));
	}

	/**
	 * @generated
	 */
	public MessageAsyncAppliedStereotypeEditPart(final View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new UMLTextSelectionEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new TimingDiagramEditPart.LinkLabelDragPolicy());
	}

	/**
	 * @generated
	 */
	@Override
	public int getKeyPoint() {
		return ConnectionLocator.MIDDLE;
	}

	/**
	 * @generated
	 */
	protected String getLabelTextHelper(final IFigure figure) {
		if (figure instanceof WrappingLabel) {
			return ((WrappingLabel) figure).getText();
		} else if (figure instanceof ILabelFigure) {
			return ((ILabelFigure) figure).getText();
		} else {
			return ((Label) figure).getText();
		}
	}

	/**
	 * @generated
	 */
	protected void setLabelTextHelper(final IFigure figure, final String text) {
		if (figure instanceof WrappingLabel) {
			((WrappingLabel) figure).setText(text);
		} else if (figure instanceof ILabelFigure) {
			((ILabelFigure) figure).setText(text);
		} else {
			((Label) figure).setText(text);
		}
	}

	/**
	 * @generated
	 */
	protected Image getLabelIconHelper(final IFigure figure) {
		if (figure instanceof WrappingLabel) {
			return ((WrappingLabel) figure).getIcon();
		} else if (figure instanceof ILabelFigure) {
			return ((ILabelFigure) figure).getIcon();
		} else {
			return ((Label) figure).getIcon();
		}
	}

	/**
	 * @generated
	 */
	protected void setLabelIconHelper(final IFigure figure, final Image icon) {
		if (figure instanceof WrappingLabel) {
			((WrappingLabel) figure).setIcon(icon);
		} else if (figure instanceof ILabelFigure) {
			((ILabelFigure) figure).setIcon(icon);
		} else {
			((Label) figure).setIcon(icon);
		}
	}

	/**
	 * @generated
	 */
	public void setLabel(final WrappingLabel figure) {
		unregisterVisuals();
		setFigure(figure);
		this.defaultText = getLabelTextHelper(figure);
		registerVisuals();
		refreshVisuals();
	}

	/**
	 * @generated
	 */
	@Override
	protected List getModelChildren() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public IGraphicalEditPart getChildBySemanticHint(final String semanticHint) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getParserElement() {
		return resolveSemanticElement();
	}

	/**
	 * @generated
	 */
	protected Image getLabelIcon() {
		return null;
	}

	/**
	 * @generated
	 */
	protected String getLabelText() {
		String text = null;
		final EObject parserElement = getParserElement();
		if (parserElement != null && getParser() != null) {
			text = getParser().getPrintString(new EObjectAdapter(parserElement), getParserOptions().intValue());
		}
		if (text == null || text.length() == 0) {
			text = this.defaultText;
		}
		return text;
	}

	/**
	 * @generated
	 */
	public void setLabelText(final String text) {
		setLabelTextHelper(getFigure(), text);
		final Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if (pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
		}
		final Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if (sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy) sfEditPolicy).refreshFeedback();
		}
	}

	/**
	 * @generated
	 */
	public String getEditText() {
		if (getParserElement() == null || getParser() == null) {
			return ""; //$NON-NLS-1$
		}
		return getParser().getEditString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
	}

	/**
	 * @generated
	 */
	protected boolean isEditable() {
		return getParser() != null;
	}

	/**
	 * @generated
	 */
	public ICellEditorValidator getEditTextValidator() {
		return new ICellEditorValidator() {

			public String isValid(final Object value) {
				if (value instanceof String) {
					final EObject element = getParserElement();
					final IParser parser = getParser();
					try {
						final IParserEditStatus valid = (IParserEditStatus) getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

							public void run() {
								setResult(parser.isValidEditString(new EObjectAdapter(element), (String) value));
							}
						});
						return valid.getCode() == IParserEditStatus.EDITABLE ? null : valid.getMessage();
					} catch (final InterruptedException ie) {
						ie.printStackTrace();
					}
				}

				// shouldn't get here
				return null;
			}
		};
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor() {
		if (getParserElement() == null || getParser() == null) {
			return null;
		}
		return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
	}

	/**
	 * @generated
	 */
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (this.parser == null) {
			this.parser = UMLParserProvider.getParser(UMLElementTypes.Message_4, getParserElement(),
					UMLVisualIDRegistry.getType(org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncAppliedStereotypeEditPart.VISUAL_ID));
		}
		return this.parser;
	}

	/**
	 * @generated
	 */
	protected DirectEditManager getManager() {
		if (this.manager == null) {
			setManager(new MultilineLabelDirectEditManager(this, MultilineLabelDirectEditManager.getTextCellEditorClass(this),
					UMLEditPartFactory.getTextCellEditorLocator(this)));
		}
		return this.manager;
	}

	/**
	 * @generated
	 */
	protected void setManager(final DirectEditManager manager) {
		this.manager = manager;
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit() {
		getManager().show();
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit(final Point eventLocation) {
		if (getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager) getManager()).show(eventLocation.getSWTPoint());
		}
	}

	/**
	 * @generated
	 */
	private void performDirectEdit(final char initialCharacter) {
		if (getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager) getManager()).show(initialCharacter);
		} else {
			performDirectEdit();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void performDirectEditRequest(final Request request) {

		final Request theRequest = request;

		if (IDirectEdition.UNDEFINED_DIRECT_EDITOR == this.directEditionMode) {
			this.directEditionMode = getDirectEditionType();
		}
		switch (this.directEditionMode) {
		case IDirectEdition.NO_DIRECT_EDITION:
			// no direct edition mode => does nothing
			return;
		case IDirectEdition.EXTENDED_DIRECT_EDITOR:
			updateExtendedEditorConfiguration();
			if (this.configuration == null || this.configuration.getLanguage() == null) {
				performDefaultDirectEditorEdit(theRequest);
			} else {
				this.configuration.preEditAction(resolveSemanticElement());
				Dialog dialog = null;
				if (this.configuration instanceof IPopupEditorConfiguration) {
					final IPopupEditorHelper helper = ((IPopupEditorConfiguration) this.configuration).createPopupEditorHelper(this);
					helper.showEditor();
					return;
				} else if (this.configuration instanceof IAdvancedEditorConfiguration) {
					dialog = ((IAdvancedEditorConfiguration) this.configuration).createDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							resolveSemanticElement(), this.configuration.getTextToEdit(resolveSemanticElement()));
				} else if (this.configuration instanceof IDirectEditorConfiguration) {
					dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(),
							this.configuration.getTextToEdit(resolveSemanticElement()), this.configuration);
				} else {
					return;
				}
				final Dialog finalDialog = dialog;

				if (Window.OK == dialog.open()) {
					final TransactionalEditingDomain domain = getEditingDomain();
					final RecordingCommand command = new RecordingCommand(domain, "Edit Label") {

						@Override
						protected void doExecute() {
							MessageAsyncAppliedStereotypeEditPart.this.configuration.postEditAction(resolveSemanticElement(),
									((ILabelEditorDialog) finalDialog).getValue());

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
						if (isActive() && isEditable()) {
							if (theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
								final Character initialChar = (Character) theRequest.getExtendedData().get(
										RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
								performDirectEdit(initialChar.charValue());
							} else if ((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
								final DirectEditRequest editRequest = (DirectEditRequest) theRequest;
								performDirectEdit(editRequest.getLocation());
							} else {
								performDirectEdit();
							}
						}
					}
				});
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	/**
	 * @generated
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
	 * @generated
	 */
	protected void refreshLabel() {
		final EditPolicy maskLabelPolicy = getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if (maskLabelPolicy == null) {
			setLabelTextHelper(getFigure(), getLabelText());
			setLabelIconHelper(getFigure(), getLabelIcon());
		}
		final Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if (pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
		}
		final Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if (sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy) sfEditPolicy).refreshFeedback();
		}
	}

	/**
	 * @generated
	 */
	protected void refreshUnderline() {
		final FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if (style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel) getFigure()).setTextUnderline(style.isUnderline());
		}
		if (resolveSemanticElement() instanceof Feature) {
			if (((Feature) resolveSemanticElement()).isStatic()) {
				((WrappingLabel) getFigure()).setTextUnderline(true);
			} else {
				((WrappingLabel) getFigure()).setTextUnderline(false);
			}
		}
	}

	/**
	 * @generated
	 */
	protected void refreshStrikeThrough() {
		final FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if (style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel) getFigure()).setTextStrikeThrough(style.isStrikeThrough());
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void refreshFont() {
		final FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if (style != null) {
			final FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL)
					| (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setFontColor(final Color color) {
		getFigure().setForegroundColor(color);
	}

	/**
	 * @generated
	 */
	@Override
	protected void addSemanticListeners() {
		if (getParser() instanceof ISemanticParser) {
			final EObject element = resolveSemanticElement();
			this.parserElements = ((ISemanticParser) getParser()).getSemanticElementsBeingParsed(element);
			for (int i = 0; i < this.parserElements.size(); i++) {
				addListenerFilter("SemanticModel" + i, this, (EObject) this.parserElements.get(i)); //$NON-NLS-1$
			}
		} else {
			super.addSemanticListeners();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeSemanticListeners() {
		if (this.parserElements != null) {
			for (int i = 0; i < this.parserElements.size(); i++) {
				removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
			}
		} else {
			super.removeSemanticListeners();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected AccessibleEditPart getAccessibleEditPart() {
		if (this.accessibleEP == null) {
			this.accessibleEP = new AccessibleGraphicalEditPart() {

				@Override
				public void getName(final AccessibleEvent e) {
					e.result = getLabelTextHelper(getFigure());
				}
			};
		}
		return this.accessibleEP;
	}

	/**
	 * @generated
	 */
	private View getFontStyleOwnerView() {
		return (View) getModel();
	}

	/**
	 * Returns the kind of associated editor for direct edition.
	 * 
	 * @return an <code>int</code> corresponding to the kind of direct editor, @see
	 *         org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition
	 * @generated
	 */
	public int getDirectEditionType() {
		if (checkExtendedEditor()) {
			initExtendedEditorConfiguration();
			return IDirectEdition.EXTENDED_DIRECT_EDITOR;
		}
		if (checkDefaultEdition()) {
			return IDirectEdition.DEFAULT_DIRECT_EDITOR;
		}

		// not a named element. no specific editor => do nothing
		return IDirectEdition.NO_DIRECT_EDITION;
	}

	/**
	 * Checks if an extended editor is present.
	 * 
	 * @return <code>true</code> if an extended editor is present.
	 * @generated
	 */
	protected boolean checkExtendedEditor() {
		if (resolveSemanticElement() != null) {
			return DirectEditorsUtil.hasSpecificEditorConfiguration(resolveSemanticElement().eClass().getInstanceClassName());
		}
		return false;
	}

	/**
	 * Checks if a default direct edition is available
	 * 
	 * @return <code>true</code> if a default direct edition is available
	 * @generated
	 */
	protected boolean checkDefaultEdition() {
		return (getParser() != null);
	}

	/**
	 * Initializes the extended editor configuration
	 * 
	 * @generated
	 */
	protected void initExtendedEditorConfiguration() {
		if (this.configuration == null) {
			final String languagePreferred = Activator.getDefault().getPreferenceStore()
					.getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
			if (languagePreferred != null && !languagePreferred.equals("")) {
				this.configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());
			} else {
				this.configuration = DirectEditorsUtil.findEditorConfiguration(IDirectEditorsIds.UML_LANGUAGE, resolveSemanticElement().eClass()
						.getInstanceClassName());
			}
		}
	}

	/**
	 * Updates the preference configuration
	 * 
	 * @generated
	 */
	protected void updateExtendedEditorConfiguration() {
		final String languagePreferred = Activator.getDefault().getPreferenceStore()
				.getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());
		if (languagePreferred != null && !languagePreferred.equals("") && languagePreferred != this.configuration.getLanguage()) {
			this.configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());
		} else if (IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(languagePreferred)) {
			this.configuration = null;
		}
	}

	/**
	 * Performs the direct edit usually used by GMF editors.
	 * 
	 * @param theRequest
	 *            the direct edit request that starts the direct edit system
	 * @generated
	 */
	protected void performDefaultDirectEditorEdit(final Request theRequest) {
		// initialize the direct edit manager
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if (isActive() && isEditable()) {
						if (theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							final Character initialChar = (Character) theRequest.getExtendedData().get(
									RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else if ((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
							final DirectEditRequest editRequest = (DirectEditRequest) theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(final Notification event) {
		final Object feature = event.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			final Integer c = (Integer) event.getNewValue();
			setFontColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
			refreshUnderline();
		} else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
			refreshStrikeThrough();
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
			refreshFont();
		} else {
			if (getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {
				refreshLabel();
			}
			if (getParser() instanceof ISemanticParser) {
				final ISemanticParser modelParser = (ISemanticParser) getParser();
				if (modelParser.areSemanticElementsAffected(null, event)) {
					removeSemanticListeners();
					if (resolveSemanticElement() != null) {
						addSemanticListeners();
					}
					refreshLabel();
				}
			}
		}

		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	@Override
	protected IFigure createFigure() {
		// Parent should assign one using setLabel() method
		return null;
	}

}
