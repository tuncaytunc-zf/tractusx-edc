/********************************************************************************
 * Copyright (c) 2023 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

package org.eclipse.tractusx.edc.tests.edr;


import com.nimbusds.jose.util.Base64;
import org.eclipse.edc.junit.annotations.EndToEndTest;
import org.eclipse.edc.spi.security.Vault;
import org.eclipse.tractusx.edc.lifecycle.ParticipantRuntime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.security.SecureRandom;

@EndToEndTest
public class RenewalEdrInMemoryTest extends AbstractRenewalEdrTest {

    @RegisterExtension
    protected static final ParticipantRuntime SOKRATES_RUNTIME = new ParticipantRuntime(
            ":edc-tests:runtime:runtime-memory",
            SOKRATES.getName(),
            SOKRATES.getBpn(),
            SOKRATES.renewalConfiguration()
    );

    @RegisterExtension
    protected static final ParticipantRuntime PLATO_RUNTIME = new ParticipantRuntime(
            ":edc-tests:runtime:runtime-memory",
            PLATO.getName(),
            PLATO.getBpn(),
            PLATO.renewalConfiguration()
    );

    @BeforeAll
    static void prepare() {
        var bytes = new byte[32];

        new SecureRandom().nextBytes(bytes);
        var value = Base64.encode(bytes).toString();
        var vault = SOKRATES_RUNTIME.getContext().getService(Vault.class);
        vault.storeSecret("test-alias", value);
        vault = PLATO_RUNTIME.getContext().getService(Vault.class);
        vault.storeSecret("test-alias", value);

    }
}
