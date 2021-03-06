/*******************************************************************************
 * Copyright (c) 2011 Subgraph.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Subgraph - initial API and implementation
 ******************************************************************************/
package com.subgraph.vega.ui.http.commands;

import java.util.logging.Logger;

import com.subgraph.vega.api.http.proxy.IHttpProxyService;
import com.subgraph.vega.ui.http.Activator;

public class StartProxyHandler extends AbstractProxyCommandHandler {

	@Override
	protected void executeCommand(IHttpProxyService proxyService,
			ProxyStateSourceProvider proxyState) {
		Logger logger = Logger.getLogger(getClass().getName());
		logger.info("Start proxy");
		int proxyPort = Activator.getDefault().getPreferenceStore()
		.getInt("ProxyPort");
		proxyService.start(proxyPort);
		proxyState.setProxyRunning(true);
		Activator.getDefault().setStatusLineProxyRunning(proxyPort);
	}
}
