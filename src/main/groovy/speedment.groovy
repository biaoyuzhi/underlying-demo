import com.speedment.config.parameters.*

name = "localhost";
packageLocation = "src/main/java";
packageName = "speedmentpojo";
enabled = true;
dbms {
    ipAddress = "127.0.0.1";
    name = "db0";
    port = 3306;
    typeName = "MySQL";
    username = "root";
    enabled = true;
    schema {
        columnCompressionType = ColumnCompressionType.NONE;
        fieldStorageType = FieldStorageType.WRAPPER;
        name = "web1";
        schemaName = "web1";
        storageEngineType = StorageEngineType.ON_HEAP;
        defaultSchema = false;
        enabled = true;
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "book";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "book";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "price";
                typeMapper = com.speedment.internal.core.config.mapper.identity.DoubleIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "financial_business_user";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "financial_business_user";
            enabled = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "network_ip";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sex";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "age";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "city";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "question1";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "question2";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "question3";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "question4";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "question5";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "question6";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "result";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "is_deleted";
                typeMapper = com.speedment.internal.core.config.mapper.identity.ByteIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "create_date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "financial_business_user_un";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "network_ip";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "person";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "person";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "password";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "repair_order";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "repair_order";
            enabled = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "contact_name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "contact_phone";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "contact_address";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "description";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "remark";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "is_deleted";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "create_date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "modify_date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "reservation_order";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "reservation_order";
            enabled = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "order_id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "user_name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "user_phone";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "user_address";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sale_store";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "door_panoramic";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "door_thickness";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "edge_length";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "remark";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "is_deleted";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "visit_date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "create_date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "modify_date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
            index {
                name = "order_id";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "order_id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
                indexColumn {
                    name = "user_phone";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "student";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "student";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "course";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "score";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "summary_requirements";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "summary_requirements";
            enabled = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.LongIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "company";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "description";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "phone";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "is_deleted";
                typeMapper = com.speedment.internal.core.config.mapper.identity.ByteIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "create_date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "test";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "test";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "sex";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "user";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "user";
            enabled = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "password";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                }
            }
        }
    }
}