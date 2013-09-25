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
package org.eclipse.papyrus.cdo.core.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;


/**
 * An utility that provides interruptible wait for a {@code Job} or
 * job {@linkplain Job#belongsTo(Object) family} with a time-out.
 */
public class JobWaiter {

	private static final ScheduledExecutorService timeoutService = Executors.newSingleThreadScheduledExecutor();

	private final Object targetFamily;

	private final Job targetJob;

	final long start = System.currentTimeMillis();

	/**
	 * Not instantiable by clients.
	 */
	private JobWaiter(Job job, Object family) {
		super();

		this.targetJob = job;
		this.targetFamily = family;
	}

	/**
	 * Wait for all jobs (if any) in the given {@code family} to finish.
	 * 
	 * @param family
	 *        a job family to wait for
	 * @param timeout
	 *        a positive timeout
	 * @param unit
	 *        the time unit for the {@code timeout}
	 * 
	 * @return {@code true} on successful wait (if required); {@code false} on time-out
	 * 
	 * @throws InterruptedException
	 *         if the wait is interrupted
	 */
	public static boolean waitFor(Object family, long timeout, TimeUnit unit) throws InterruptedException {
		return new JobWaiter(null, family).doWait(timeout, unit);
	}

	/**
	 * Wait for a specific {@code job} to finish.
	 * 
	 * @param job
	 *        a job to wait for
	 * @param timeout
	 *        a positive timeout
	 * @param unit
	 *        the time unit for the {@code timeout}
	 * 
	 * @return {@code true} on successful wait (if required); {@code false} on time-out
	 * 
	 * @throws InterruptedException
	 *         if the wait is interrupted
	 */
	public static boolean waitFor(Job job, long timeout, TimeUnit unit) throws InterruptedException {
		return new JobWaiter(job, null).doWait(timeout, unit);
	}

	protected boolean doWait(long timeout, TimeUnit unit) throws InterruptedException {
		if(timeout <= 0) {
			throw new IllegalArgumentException("Non-positive timeout"); //$NON-NLS-1$
		}

		boolean result = false;

		// create and schedule a task that will time-out the join
		Timeout timeoutTask = new Timeout();

		timeoutService.schedule(timeoutTask, timeout, unit);

		try {
			if(targetJob != null) {
				// the Job::join() API documents that it is interruptible, but the
				// actual implementation in the JobManager is not
				new JobFinishListener(targetJob).await();
			} else {
				Job.getJobManager().join(targetFamily, null);
			}

			result = true;
			timeoutTask.cancel();

			if(Thread.interrupted()) {
				throw new InterruptedException();
			}
		} catch (InterruptedException e) {
			if(timeoutTask.timedOut()) {
				// normal condition: time-out task interrupted us
			} else {
				// "real" interruption
				throw e;
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private static class Timeout implements Runnable {

		private final Thread toInterrupt = Thread.currentThread();

		private final AtomicBoolean cancelled = new AtomicBoolean();

		private final AtomicBoolean timedOut = new AtomicBoolean();

		public void run() {
			if(!cancelled.get()) {
				timedOut.set(true);
				toInterrupt.interrupt();
			}
		}

		void cancel() {
			cancelled.set(true);
		}

		boolean timedOut() {
			return timedOut.get();
		}
	}

	private static final class JobFinishListener extends JobChangeAdapter {

		private final Job job;

		private boolean done;

		JobFinishListener(Job job) {
			super();

			this.job = job;
			Job.getJobManager().addJobChangeListener(this);
		}

		synchronized void await() throws InterruptedException {
			for(;;) {
				// check running state because it may have finished already before we got here
				if(done || (job.getState() != Job.RUNNING)) {
					break;
				}

				wait();
			}
		}

		@Override
		public synchronized void done(IJobChangeEvent event) {
			done = true;

			notifyAll();
		}
	}
}
