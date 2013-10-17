package org.eclipse.papyrus.uml.properties.xtext.sheet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.StyledTextXtextAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class AdvancedEditingPropertySection extends
		AbstractModelerPropertySection implements IContextElementProvider {

	private FormToolkit toolkit;

	private Form form;

	private StyledText textControl;

	private DefaultXtextDirectEditorConfiguration configuration;

	private StyledTextXtextAdapter xtextAdapter;

	final private ContextElementAdapter contextElementAdapter = new ContextElementAdapter(
			this);

	@Override
	public void refresh() {
		updateXtextAdapters(textControl);

		IParser parser = getParser();
		if (parser != null) {
			String printString = parser.getEditString(null, 0);
			textControl.setText(printString);
		}

	}

	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();
		if (xtextAdapter != null) {
			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.remove(contextElementAdapter);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		if (toolkit != null)
			toolkit.dispose();
	}

	@Override
	public final void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.setBorderStyle(SWT.BORDER);
		super.createControls(parent, aTabbedPropertySheetPage);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
		parent.setLayout(new GridLayout(1, true));
		form = toolkit.createForm(parent);
		toolkit.decorateFormHeading(form);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(form);
		form.getBody().setLayout(new GridLayout(1, false));
		createTextControl(form.getBody());
	}

	protected void createTextControl(final Composite parent) {

		textControl = new StyledText(parent, SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL | SWT.WRAP);
		textControl.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				IParser parser = getParser();
				if (parser != null) {
					ICommand command = parser.getParseCommand(
							new EObjectAdapter(getEObject()),
							textControl.getText(), 0);

					getEditingDomain().getCommandStack().execute(
							new GMFtoEMFCommandWrapper(command));
				}
			}

			public void focusGained(FocusEvent e) {
			}
		});
		((StyledText) textControl).setAlwaysShowScrollBars(false);
		GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize())
				.applyTo(textControl);

	}

	protected DefaultXtextDirectEditorConfiguration getConfigurationFromSelection() {
		IGraphicalEditPart part = getEditPartFromSelection();
		if (part != null) {
			IPreferenceStore store = Activator.getDefault()
					.getPreferenceStore();
			String semanticClassName = part.resolveSemanticElement().eClass()
					.getInstanceClassName();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT
					+ semanticClassName;
			String languagePreferred = store.getString(key);

			if (languagePreferred != null && !languagePreferred.equals("")) {
				IDirectEditorConfiguration configuration = DirectEditorsUtil
						.findEditorConfiguration(languagePreferred,
								semanticClassName);
				if (configuration instanceof DefaultXtextDirectEditorConfiguration) {
					return (DefaultXtextDirectEditorConfiguration) configuration;
				}
			}
		}
		return null;
	}

	protected IGraphicalEditPart getEditPartFromSelection() {
		Object selection = getPrimarySelection();
		if (selection instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart) selection;
		}
		return null;
	}

	protected IParser getParser() {
		final IGraphicalEditPart part = getEditPartFromSelection();
		if (configuration != null && part != null) {
			return configuration.createParser(part.resolveSemanticElement());
		}
		return null;
	}

	protected void updateXtextAdapters(Control styledText) {
		final DefaultXtextDirectEditorConfiguration newConfiguration = getConfigurationFromSelection();
		// Check if configuration has changed and update adapters
		if (newConfiguration != null && newConfiguration != configuration) {
			if (xtextAdapter != null) {
				xtextAdapter.getFakeResourceContext().getFakeResource()
						.eAdapters().remove(contextElementAdapter);
			}
			configuration = newConfiguration;
			xtextAdapter = new StyledTextXtextAdapter(
					configuration.getInjector());
			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.add(contextElementAdapter);
			xtextAdapter.adapt((StyledText) styledText);
		}
	}

	public EObject getContextObject() {
		return getEObject();
	}
}