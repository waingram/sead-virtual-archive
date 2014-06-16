/*
 * Copyright 2014 The Trustees of Indiana University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dataconservancy.dcs.access.client.api;

import java.util.List;

import org.dataconservancy.dcs.access.shared.Person;
import org.dataconservancy.dcs.access.shared.ROMetadata;

import com.google.gwt.user.client.rpc.AsyncCallback;



public interface RegistryServiceAsync {

	void registerAgents(List<Person> persons, String registryUrl, AsyncCallback<Boolean> callback);

	void getAllCOs(String repository, String agentId, String roUrl,
                   AsyncCallback<List<ROMetadata>> callback);

	void getRO(String roId, String roUrl, AsyncCallback<String> callback);

	void putRO(String sipPath, String roUrl, AsyncCallback<Void> callback);

	void trackEvent(String agentId, String entityId, String roUrl,
                    AsyncCallback<Boolean> callback);

	void makeObsolete(String entityId, String roUrl, AsyncCallback<Boolean> callback);

	void updateSip(String sipPath, String entityId, String key, String value,
                   AsyncCallback<Void> callback);

	void getROAffiliation(String entityId, String registryUrl,
                          AsyncCallback<String> callback);

	void assignToAgent(String entityId, String agentId, String registryUrl,
                       AsyncCallback<Boolean> callback);

}
