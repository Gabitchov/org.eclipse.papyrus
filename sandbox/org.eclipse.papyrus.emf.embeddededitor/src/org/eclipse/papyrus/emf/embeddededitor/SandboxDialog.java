package org.eclipse.papyrus.emf.embeddededitor;

import java.util.EventObject;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.emf.embeddededitor.editor.EmbeddedEditor;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.runtime.EmbeddedDisplayEngine;
import org.eclipse.papyrus.widgets.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


public class SandboxDialog extends TrayDialog {

	protected EmbeddedEditor editor;

	private String shellTitle = "Sample Embedded Editor"; //$NON-NLS-1$

	public static String APPLY_LABEL = "Apply";

	public static int APPLY_ID = 50; //Avoid conflicts with IDialogConstants

	protected SandboxDialog(Shell shell) {
		super(shell);
	}

	@Override
	public void create() {
		super.create();

		SashForm self = new SashForm(getDialogArea(), SWT.NONE);
		self.setOrientation(SWT.VERTICAL);
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Composite topPart = new Composite(self, SWT.NONE);
		topPart.setLayout(new FillLayout());

		SashForm topSash = new SashForm(topPart, SWT.NONE);
		topSash.setOrientation(SWT.HORIZONTAL);
		topSash.setSashWidth(3);

		Composite bottomPart = new Composite(self, SWT.NONE);
		bottomPart.setLayout(new GridLayout(1, true));

		createSelectionPart(topSash);
		createEditorPart(topSash);
		createPropertiesPart(bottomPart);

		getShell().setImage(Activator.getDefault().getImage("icons/papyrus.png")); //$NON-NLS-1$
		getShell().setText(shellTitle);

		self.setWeights(new int[]{ 30, 20 });
		topSash.setWeights(new int[]{ 20, 60 });

		getShell().setSize(750, 500);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		//The OK button still has the initial focus, but does not
		//automatically get it back when another non-button widget is selected
		//(default = false)
		//This will prevent the dialog to close when a text-widget is
		//validated with the "Enter" key
		getShell().setDefaultButton(null);
		getButton(IDialogConstants.OK_ID).setFocus();

		Button apply = createButton(parent, APPLY_ID, APPLY_LABEL, false);
		apply.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				editor.save();
				updateTitle();
			}
		});
	}

	protected void updateTitle() {
		if(editor.isSaveNeeded()) {
			getShell().setText(shellTitle + "*"); //$NON-NLS-1$
		} else {
			getShell().setText(shellTitle);
		}
	}

	@Override
	protected int getShellStyle() {
		int style = super.getShellStyle();
		return style;
	}

	private void createSelectionPart(Composite topPart) {
		Tree tree = new Tree(topPart, SWT.MULTI | SWT.BORDER);
		TreeItem item = new TreeItem(tree, SWT.NONE);
		{
			TreeItem subItem = new TreeItem(item, SWT.NONE);
			subItem.setText("subItem");
			TreeItem subItem2 = new TreeItem(item, SWT.NONE);
			{
				TreeItem subItem3 = new TreeItem(subItem2, SWT.NONE);
				subItem3.setText("subItem3");
			}
			subItem2.setText("subItem2");
		}
		item.setText("item");
		TreeItem item2 = new TreeItem(tree, SWT.NONE);
		{
			TreeItem subItem = new TreeItem(item2, SWT.NONE);
			subItem.setText("subItem");
			TreeItem subItem2 = new TreeItem(item2, SWT.NONE);
			subItem2.setText("subItem2");
		}
		item2.setText("item2");
		TreeItem item3 = new TreeItem(tree, SWT.NONE);
		item3.setText("item3");

		GridData data = new GridData(SWT.FILL, SWT.FILL, false, true);
		data.widthHint = 100;
		tree.setLayoutData(data);
	}

	private void createButtons(Composite topPart) {
		Composite buttonsPart = new Composite(topPart, SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.CENTER, false, true);
		buttonsPart.setLayoutData(data);
		buttonsPart.setLayout(new GridLayout());

		Button right = new Button(buttonsPart, SWT.PUSH);
		right.setImage(Activator.getDefault().getImage("org.eclipse.papyrus.widgets", "/icons/arrow_right.gif"));

		Button left = new Button(buttonsPart, SWT.PUSH);
		left.setImage(Activator.getDefault().getImage("org.eclipse.papyrus.widgets", "/icons/arrow_left.gif"));
	}

	private void createEditorPart(Composite topPart) {
		try {
			Composite editorAndButtonsPart = new Composite(topPart, SWT.NONE);
			GridLayout layout = new GridLayout(2, false);
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.horizontalSpacing = 2;
			editorAndButtonsPart.setLayout(layout);
			editorAndButtonsPart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			createButtons(editorAndButtonsPart);

			Composite editorPart = new Composite(editorAndButtonsPart, SWT.BORDER);
			FillLayout fillLayout = new FillLayout();
			fillLayout.marginWidth = 0;
			editorPart.setLayout(fillLayout);
			editorPart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResource(URI.createPlatformResourceURI("/Test/NewChildConfig/NewchildConfig.xmi", true), true);

			editor = new EmbeddedEditor(resourceSet);
			editor.createWidget(editorPart);

			editor.addCommandStackListener(new CommandStackListener() {

				public void commandStackChanged(EventObject event) {
					updateTitle();
				}

			});
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	private void createPropertiesPart(Composite bottomPart) {
		final ScrolledComposite scrolled = new ScrolledComposite(bottomPart, SWT.NONE | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolled.getVerticalBar().setIncrement(8);
		scrolled.setBackground(scrolled.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		scrolled.setBackgroundMode(SWT.INHERIT_DEFAULT);

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 120;
		scrolled.setLayoutData(data);

		final Composite properties = new Composite(scrolled, SWT.NONE);
		final EmbeddedDisplayEngine displayEngine = new EmbeddedDisplayEngine();
		properties.setLayout(new FillLayout());

		data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.heightHint = 120;
		properties.setLayoutData(data);

		scrolled.setContent(properties);

		editor.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				Set<View> views = ConfigurationManager.instance.constraintEngine.getViews(selection);
				displayEngine.display(views, properties, selection, SWT.TOP);
				refreshDisplay(properties, scrolled);
			}

		});

		scrolled.addControlListener(new ControlListener() {

			public void controlMoved(ControlEvent e) {
				//Nothing
			}

			public void controlResized(ControlEvent e) {
				refreshDisplay(properties, scrolled);
			}

		});
	}

	private void refreshDisplay(Composite properties, Composite scrolled) {
		Point size = properties.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		if(scrolled.getSize().x > 0) {
			size.x = scrolled.getSize().x - 21;
		}
		properties.setSize(size);
		properties.layout();
		//		scrolled.layout();
	}

	@Override
	protected void okPressed() {
		editor.save();
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		handleShellCloseEvent();
	}

	@Override
	protected void handleShellCloseEvent() {
		if(editor.isSaveNeeded()) {
			MessageDialog dialog = new MessageDialog(getShell(), "Cancel ?", null, "Unsaved changes", MessageDialog.WARNING, new String[]{ "Save", "Don't save", "Cancel" }, 2);
			dialog.open();
			switch(dialog.getReturnCode()) {
			case 0: //Save & quit
				editor.save();
				//No break
			case 1: //Quit
				super.handleShellCloseEvent();
				break;
			case 2:
				return;
			}
		} else {
			super.handleShellCloseEvent();
		}
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Composite createDialogArea(Composite parent) {
		Composite control = (Composite)super.createDialogArea(parent);
		//		control.setBackgroundMode(SWT.INHERIT_DEFAULT);
		//		control.setBackground(control.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		return control;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
	}
}
