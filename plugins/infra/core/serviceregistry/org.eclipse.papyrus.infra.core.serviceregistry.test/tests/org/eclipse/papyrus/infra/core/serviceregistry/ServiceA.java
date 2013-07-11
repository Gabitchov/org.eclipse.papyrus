package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.ArrayList;
import java.util.List;

public class ServiceA implements IService {

	public enum TraceKind {
		init, start, dispose
	}

	static List<TraceKind> trace = new ArrayList<TraceKind>();

	static List<String> nametrace = new ArrayList<String>();



	static public TraceKind getEvent(int index) {
		return trace.get(index);
	}

	static public String getTraceName(int index) {
		return nametrace.get(index);
	}

	static public void resetTrace() {
		trace.clear();
		nametrace.clear();
	}

	public void init(ServicesRegistry servicesRegistry) {
		trace.add(TraceKind.init);
		nametrace.add(this.getClass().getSimpleName());

	}

	public void startService() {
		trace.add(TraceKind.start);
		nametrace.add(this.getClass().getSimpleName());

	}

	public void disposeService() {
		trace.add(TraceKind.dispose);
		nametrace.add(this.getClass().getSimpleName());

	}

}
