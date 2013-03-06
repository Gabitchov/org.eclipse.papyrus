/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.net4j.util.event.Event;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.event.Notifier;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Objects;

/**
 * This is the RepositoryPropertiesBlock type. Enjoy.
 */
public class RepositoryPropertiesBlock
		extends Notifier {

	private Text nameText;

	private ComboViewer protocolCombo;

	private Button defaultPort;

	private Text portText;

	private Text hostText;

	private Text repoText;

	private String name;

	private String url;

	private IStatus status = Status.OK_STATUS;

	private IPapyrusRepository repository;

	private boolean createMode;

	private boolean editable = true;

	public RepositoryPropertiesBlock() {
		this(null, true);
	}

	public RepositoryPropertiesBlock(IPapyrusRepository repository) {
		this(repository, false);
	}

	private RepositoryPropertiesBlock(IPapyrusRepository repository,
			boolean createMode) {
		this.repository = repository;
		this.createMode = createMode;
	}

	public Control createControl(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new GridLayout(2, false));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(result);

		new Label(result, SWT.NONE).setText("Name:");
		nameText = new Text(result, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(nameText);

		new Label(result, SWT.NONE).setText("Protocol:");
		protocolCombo = new ComboViewer(result);
		protocolCombo.setContentProvider(new ArrayContentProvider());
		protocolCombo.setInput(Protocol.values());

		defaultPort = new Button(result, SWT.CHECK);
		defaultPort.setText("Use default port");
		GridDataFactory.swtDefaults().span(2, 1).applyTo(defaultPort);

		Label label = new Label(result, SWT.NONE);
		label.setText("Port:");
		GridDataFactory.swtDefaults().indent(15, 0).applyTo(label);
		portText = new Text(result, SWT.BORDER);
		GridDataFactory.fillDefaults().applyTo(portText);

		new Label(result, SWT.NONE).setText("Host:");
		hostText = new Text(result, SWT.BORDER);
		GridDataFactory.fillDefaults().applyTo(hostText);

		new Label(result, SWT.NONE).setText("Repository:");
		repoText = new Text(result, SWT.BORDER);
		GridDataFactory.fillDefaults().applyTo(repoText);

		reset();

		defaultPort.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				portText.setEnabled(!defaultPort.getSelection());
				if (defaultPort.getSelection()) {
					updatePortForProtocol();
					recalculateURL();
				}
			}
		});
		protocolCombo
			.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					if (defaultPort.getSelection()) {
						updatePortForProtocol();
						recalculateURL();
					}
				}
			});

		ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				recalculateURL();
			}
		};
		nameText.addModifyListener(modifyListener);
		portText.addModifyListener(modifyListener);
		hostText.addModifyListener(modifyListener);
		repoText.addModifyListener(modifyListener);

		updateEditable();

		return result;
	}
	
	public void dispose() {
		// pass
	}

	public void reset() {
		if (nameText == null) {
			return;
		}

		String name = (repository == null)
			? (createMode
				? "My Repository"
				: "")
			: repository.getName();
		String url = (repository == null)
			? (createMode
				? "tcp://localhost?repositoryName=repo1"
				: null)
			: repository.getURL();
		URI uri = (url == null)
			? null
			: URI.createURI(url);
		String host = (uri == null)
			? ""
			: parseHost(uri);
		String repo = (uri == null)
			? ""
			: parseRepositoryName(uri);
		Protocol protocol = Protocol.TCP;
		String portString = "";
		boolean isDefaultPort = true;
		if (uri != null) {
			protocol = Protocol.valueOf(uri.scheme().toUpperCase());
			int port = parsePort(uri);
			if (port < 0) {
				port = getSelectedProtocol().defaultPort();
			}
			portString = Integer.toString(port);
			isDefaultPort = port == getSelectedProtocol().defaultPort();
		}
		nameText.setText(name);
		protocolCombo.setSelection(new StructuredSelection(protocol));
		hostText.setText(host);
		repoText.setText(repo);
		defaultPort.setSelection(isDefaultPort);
		portText.setEnabled(editable && !isDefaultPort);
		portText.setText(portString);
		updatePortForProtocol();

		recalculateURL();
	}

	public void setRepository(IPapyrusRepository repository) {
		if (this.repository != repository) {
			this.repository = repository;
			reset();
		}
	}

	public void setEditable(boolean editable) {
		if (this.editable != editable) {
			this.editable = editable;

			updateEditable();
		}
	}

	Protocol getSelectedProtocol() {
		Protocol result = Protocol.TCP;

		IStructuredSelection sel = (IStructuredSelection) protocolCombo
			.getSelection();
		if (!sel.isEmpty()) {
			result = (Protocol) sel.getFirstElement();
		}

		return result;
	}

	void updatePortForProtocol() {
		portText.setText(String.valueOf(getSelectedProtocol().defaultPort()));
	}

	public void finish() {
		this.name = nameText.getText();
	}

	public void update() {
		recalculateURL();
	}

	void recalculateURL() {
		try {
			if (Integer.parseInt(portText.getText().trim()) <= 0) {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			setStatus(error("Port must be a positive integer."));
			return;
		}

		if (hostText.getText().trim().length() == 0) {
			setStatus(error("The host name is required."));
			return;
		}

		if (repoText.getText().trim().length() == 0) {
			setStatus(error("The repository identifier is required."));
			return;
		}

		if (nameText.getText().trim().length() == 0) {
			setStatus(error("A name for the repository configuration is required."));
			return;
		}

		name = nameText.getText().trim();
		url = computeURL();

		IPapyrusRepository existing = PapyrusRepositoryManager.INSTANCE
			.getRepository(url);
		if ((existing != null) && (existing != repository)) {
			setStatus(error(NLS.bind(
				"A repository \"{0}\" already exists at this location.",
				existing.getName())));
			return;
		}

		for (IPapyrusRepository next : PapyrusRepositoryManager.INSTANCE
			.getRepositories()) {

			if ((next != repository) && Objects.equal(next.getName(), name)) {
				setStatus(warning(NLS
					.bind(
						"A repository named \"{0}\" already exists at a different location.",
						next.getName())));
				return;
			}
		}

		setStatus(Status.OK_STATUS);
	}

	private IStatus error(String reason) {
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, reason);
	}

	private IStatus warning(String reason) {
		return new Status(IStatus.WARNING, Activator.PLUGIN_ID, reason);
	}

	private String computeURL() {
		StringBuilder result = new StringBuilder();

		result.append(getSelectedProtocol().scheme).append(":");

		result.append("//");
		result.append(hostText.getText().trim());

		result.append(":").append(portText.getText().trim());

		result.append("?repositoryName=").append(repoText.getText().trim());

		return result.toString();
	}

	private int parsePort(URI uri) {
		String result = uri.port();
		return (result == null)
			? -1
			: Integer.parseInt(result);
	}

	private String parseHost(URI uri) {
		String result = uri.authority();

		if (result != null) {
			int colon = result.lastIndexOf(':');
			if (colon >= 0) {
				result = result.substring(0, colon);
			}
		}

		return result;
	}

	private String parseRepositoryName(URI uri) {
		return CDOURIUtil.getParameters(uri.query()).get("repositoryName");
	}

	public IStatus getStatus() {
		return status;
	}

	void setStatus(final IStatus status) {
		class StatusChangedEvent
				extends Event
				implements IStatusChangedEvent {

			private static final long serialVersionUID = 1L;

			StatusChangedEvent() {
				super(RepositoryPropertiesBlock.this);
			}

			public IStatus getStatus() {
				return status;
			}
		}

		this.status = status;
		fireEvent(new StatusChangedEvent());
	}

	public String getName() {
		return name;
	}

	public String getURL() {
		return url;
	}

	private void updateEditable() {
		if (nameText == null) {
			return;
		}

		nameText.setEnabled(editable);
		protocolCombo.getControl().setEnabled(editable);
		defaultPort.setEnabled(editable);
		portText.setEnabled(editable && !defaultPort.getSelection());
		hostText.setEnabled(editable);
		repoText.setEnabled(editable);
	}

	public static enum Protocol {
		TCP("tcp", 2036), HTTP("http", 80);

		private final String scheme;

		private final int defaultPort;

		Protocol(String scheme, int defaultPort) {
			this.scheme = scheme;
			this.defaultPort = defaultPort;
		}

		public String scheme() {
			return scheme;
		}

		public int defaultPort() {
			return defaultPort;
		}
	}

	public static interface IStatusChangedEvent
			extends IEvent {

		IStatus getStatus();
	}

	public static class StatusChangedEventAdapter
			implements IListener {

		public void notifyEvent(IEvent event) {
			if (event instanceof IStatusChangedEvent) {
				handleStatusChanged(
					(RepositoryPropertiesBlock) event.getSource(),
					((IStatusChangedEvent) event).getStatus());
			} else {
				handleOtherEvent(event);
			}
		}

		protected void handleStatusChanged(RepositoryPropertiesBlock source,
				IStatus newStatus) {

			// pass
		}

		protected void handleOtherEvent(IEvent event) {
			// pass
		}
	}

	public static class StatusChangedMessageProviderAdapter
			extends StatusChangedEventAdapter {

		@Override
		protected void handleStatusChanged(RepositoryPropertiesBlock source,
				IStatus newStatus) {

			int messageSeverity;

			switch (newStatus.getSeverity()) {
				case IStatus.OK :
					messageSeverity = IMessageProvider.NONE;
					break;
				case IStatus.INFO :
					messageSeverity = IMessageProvider.INFORMATION;
					break;
				case IStatus.WARNING :
					messageSeverity = IMessageProvider.WARNING;
					break;
				default :
					messageSeverity = IMessageProvider.ERROR;
					break;
			}

			handleMessageChange(newStatus.isOK()
				? null
				: newStatus.getMessage(), messageSeverity);
		}

		protected void handleMessageChange(String message, int messageSeverity) {
			// pass
		}
	}
}
