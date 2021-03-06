/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.sentry.provider.db.generic.service.thrift;

import org.apache.sentry.provider.db.service.thrift.ThriftUtil;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

public class SentryGenericPolicyProcessorWrapper<I extends SentryGenericPolicyService.Iface>
    extends SentryGenericPolicyService.Processor<SentryGenericPolicyService.Iface> {

  public SentryGenericPolicyProcessorWrapper(I iface) {
    super(iface);
  }

  @Override
  public boolean process(TProtocol in, TProtocol out) throws TException {
    // set the ip and impersonator for audit log
    ThriftUtil.setIpAddress(in);
    ThriftUtil.setImpersonator(in);
    return super.process(in, out);
  }
}
