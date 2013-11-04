package org.eclipse.papyrus.qompass.designer.debug.dialogs;

import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.acceleo.AcceleoException;
import org.eclipse.papyrus.infra.widgets.toolbox.utils.DialogUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Select container rules, either from a list of globally defined rules or from
 * local rules which may be created "on the fly" by this dialog.
 * 
 * TODO: extend rule application to instances (problematic, since rules
 * transformation is done on type level)
 * 
 * @author ansgar
 */
public class TestAcceleoDialog extends SelectionStatusDialog {

	protected NamedElement m_acceleoParam;

	protected Text fTemplate;

	protected Button fApplyAcceleoButton;

	protected Text fOutput;

	protected Text fErr;

	protected static String saveTemplate = "";

	public TestAcceleoDialog(Shell parent, NamedElement acceleoParam) {
		super(parent);
		m_acceleoParam = acceleoParam;
	}

	/**
	 * @see SelectionStatusDialog#computeResult()
	 */
	protected void computeResult() {
		// nothing to do
		saveTemplate = fTemplate.getText();
	}

	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);
		// (parent, "Container rules", "Avail. extensions/interceptors");

		createTextAcceleoGroup(contents);
		return contents;
	}

	// create instance configuration group
	protected void createTextAcceleoGroup(Composite parent) {
		GridData groupGridData = DialogUtils.createFillGridData();

		Group instanceConfigurationGroup = new Group(parent, SWT.BORDER);
		instanceConfigurationGroup.setText(" Test Acceleo Template");
		instanceConfigurationGroup.setLayout(new RowLayout(SWT.VERTICAL));
		instanceConfigurationGroup.setLayout(new GridLayout(1, false));
		instanceConfigurationGroup.setLayoutData(groupGridData);

		GridData span2 = new GridData();
		span2.horizontalAlignment = GridData.FILL;
		span2.verticalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		span2.grabExcessVerticalSpace = true;
		span2.widthHint = 400;
		span2.heightHint = 150;

		Label descriptionLabel = new Label(instanceConfigurationGroup, SWT.NONE);
		descriptionLabel.setText("Template:");

		fTemplate = new Text(instanceConfigurationGroup, SWT.WRAP
			| SWT.V_SCROLL);
		fTemplate.setLayoutData(span2);
		fTemplate.setText(saveTemplate);

		fApplyAcceleoButton = new Button(instanceConfigurationGroup, SWT.NONE);
		fApplyAcceleoButton.setText("instantiate template");
		fApplyAcceleoButton.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				System.out.println(e);
			}
		});
		// fApplyAcceleoButton.setLayoutData(span2);
		fApplyAcceleoButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				try {
					AcceleoDriver.clearErrors();
					String result = AcceleoDriver.bind(fTemplate.getText(), m_acceleoParam);
					fOutput.setText(result);
					fErr.setText("");
				}
				catch (AcceleoException err) {
					fOutput.setText("");
					fErr.setText(err.toString());
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		Button fResetButton = new Button(instanceConfigurationGroup, SWT.NONE);
		fResetButton.setText("reset acceleo driver (reread initial scripts)");
		fResetButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				fOutput.setText("");
				fErr.setText("");
				AcceleoDriver.init();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		Label resultLabel = new Label(instanceConfigurationGroup, SWT.NONE);
		resultLabel.setText("Result:");

		fOutput = new Text(instanceConfigurationGroup, SWT.WRAP
			| SWT.V_SCROLL | SWT.READ_ONLY);
		fOutput.setLayoutData(span2);

		Label errLabel = new Label(instanceConfigurationGroup, SWT.NONE);
		errLabel.setText("Error:");

		GridData span3 = new GridData();
		span3.horizontalAlignment = GridData.FILL;
		span3.verticalAlignment = GridData.FILL;
		span3.grabExcessHorizontalSpace = true;
		// span3.grabExcessVerticalSpace = true;
		span3.heightHint = 50;

		fErr = new Text(instanceConfigurationGroup, SWT.WRAP
			| SWT.V_SCROLL | SWT.READ_ONLY);
		fErr.setLayoutData(span3);
	}

}
