/*
 * Copyright (c) 2021, IOT-Hub.RU and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is dual-licensed: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License Version 3 as
 * published by the Free Software Foundation. For the terms of this
 * license, see <http://www.gnu.org/licenses/>.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public
 * License Version 3 for more details (a copy is included in the LICENSE
 * file that accompanied this code).
 *
 * You should have received a copy of the GNU Affero General Public License
 * version 3 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact support@iot-hub.ru or visit www.iot-hub.ru if you need
 * additional information or have any questions.
 *
 * You can be released from the requirements of the license by purchasing
 * a Java Embedded Framework Commercial License. Buying such a license is
 * mandatory as soon as you develop commercial activities involving the
 * Java Embedded Framework software without disclosing the source code of
 * your own applications.
 *
 * Please contact sales@iot-hub.ru if you have any question.
 */

package ru.iothub.jef.devices.library.bosch;

import ru.iothub.jef.devices.library.core.DeviceFactory;

public abstract class BoschDeviceFactory implements DeviceFactory {
    private final static String VENDOR = "Bosch";

    @Override
    public String getVendor() {
        return VENDOR;
    }

    @Override
    public String getVendorIcon() {
        return "data:image/png;base64,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";
    }
}
