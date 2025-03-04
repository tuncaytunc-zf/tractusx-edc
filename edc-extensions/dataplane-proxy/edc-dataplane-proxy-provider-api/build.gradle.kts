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

plugins {
    `java-library`
    id("io.swagger.core.v3.swagger-gradle-plugin")
}

dependencies {

    implementation(libs.edc.spi.http)
    implementation(libs.edc.util)
    implementation(libs.edc.dpf.util)
    implementation(libs.edc.ext.http)
    implementation(libs.edc.spi.jwt)
    implementation(libs.edc.token.core)
    implementation(libs.edc.spi.dataplane.http)

    implementation(libs.jakarta.rsApi)
    implementation(libs.nimbus.jwt)

    implementation(project(":edc-extensions:dataplane-proxy:edc-dataplane-proxy-provider-spi"))

    testImplementation(libs.edc.junit)
    testImplementation(libs.okhttp.mockwebserver)
}

