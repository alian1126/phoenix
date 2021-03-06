/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.phoenix.schema;

import org.apache.phoenix.coprocessor.TableInfo;

public class ParentTableNotFoundException extends TableNotFoundException {
    private static final long serialVersionUID = 1L;
    private final byte[] parentTenantId;
    private final byte[] parentSchemaName;
    private final byte[] parentTableName;

    public ParentTableNotFoundException(TableInfo parentTableInfo, String tableName) {
        super(tableName);
        this.parentTenantId = parentTableInfo.getTenantId();
        this.parentSchemaName = parentTableInfo.getSchemaName();
        this.parentTableName = parentTableInfo.getTableName();
    }

    public byte[] getParentTenantId() {
        return parentTenantId;
    }

    public byte[] getParentSchemaName() {
        return parentSchemaName;
    }

    public byte[] getParentTableName() {
        return parentTableName;
    }

}
