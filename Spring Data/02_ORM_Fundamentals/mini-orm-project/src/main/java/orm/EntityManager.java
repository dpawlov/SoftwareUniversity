package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.sql.Connection;
import java.sql.SQLException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class EntityManager<E> implements DbContext<E> {

    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    //saves object to database, if the object exists the object is updated
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field id = this.getId(entity.getClass());
        id.setAccessible(true);
        Object value = id.get(entity);
        if (value == null || (int) value <= 0) {
            return this.doInsert(entity, id);
        }
        return this.doUpdate(entity, id);
    }

    private boolean doInsert(E entity, Field primary) throws IllegalAccessException, SQLException {
        String query = "INSERT INTO " + this.getTableName(entity.getClass()) + " ";
        String columns = "(";
        String values = "(";

        Field[] fields = entity.getClass().getDeclaredFields();

        //get all columns from User without id column
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Id.class)) {
                columns += "`" + this.getColumnName(field) + "`";

                Object value = field.get(entity);

                if (value instanceof Date) {
                    values += "'" + new SimpleDateFormat("yyyy-MM-dd").format(value) + "'";
                } else if (value instanceof Integer) {
                    values += value;
                } else {
                    values += "'" + value + "'";
                }

                if (i < fields.length - 1) {
                    values += ",";
                    columns += ",";
                }
            }
        }
        query += columns + ") VALUES " + values + ")";
        return connection.prepareStatement(query).execute();
    }

    private boolean doUpdate(E entity, Field primary) throws IllegalAccessException, SQLException {
        String query = "UPDATE " + this.getTableName(entity.getClass()) + " SET ";
        String columnAndValue = "";
        String where = "";
        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            Object value = field.get(entity);
            if (field.isAnnotationPresent(Id.class)) {
                where += " WHERE " + this.getColumnName(field) + " = " + value;
            } else {
                if (value instanceof Date) {
                    columnAndValue += this.getColumnName(field) + " = '"
                            + new SimpleDateFormat("yyyy-MM-dd").format(value) + "'";
                } else if (value instanceof Integer) {
                    columnAndValue += this.getColumnName(field) + " = " + value;
                } else {
                    columnAndValue += this.getColumnName(field) + " = '" + value + "'";
                }
                if (i < fields.length - 1) {
                    columnAndValue += ",";
                }
            }
        }
        query += columnAndValue + where;
        return connection.prepareStatement(query).execute();
    }

    public Iterable<E> find(Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return find(table,null);
    }

    public Iterable<E> find(Class<E> table, String where) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM " + table.getAnnotation(Entity.class).name() +
                " WHERE 1 " + (where != null ? " AND " + where : "");
        ResultSet resultSet = statement.executeQuery(query);
        List<E> entities = new ArrayList<>();
        while(resultSet.next()){
            E entity = table.getDeclaredConstructor().newInstance();
            this.fillEntity(table,resultSet,entity);
            entities.add(entity);
        }
        return entities;
    }

    public E findFirst(Class<E> table) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return this.findFirst(table,null);
    }

    public E findFirst(Class<E> table, String where) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM " + table.getAnnotation(Entity.class).name() +
                " WHERE 1 " + (where != null ? "AND " + where : "") + " LIMIT 1";
        ResultSet resultSet = statement.executeQuery(query);
        E entity = table.getDeclaredConstructor().newInstance();
        resultSet.next();
        this.fillEntity(table,resultSet,entity);
        return entity;
    }

    private Field getId(Class entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity doesn't have ID!"));
    }

    private String getTableName(Class entity) {
        String tableName = "";

        tableName = ((Entity) entity.getAnnotation(Entity.class)).name();

        if (tableName.isEmpty()) {
            tableName = entity.getSimpleName();
        }

        return tableName;
    }

    private String getColumnName(Field field) {
        //for each field get its column
        String columnName = field.getAnnotation(Column.class).name();

        if (columnName.isEmpty()) {
            columnName = field.getName();
        }

        return columnName;
    }

    private void fillEntity(Class table, ResultSet resultSet, E entity) throws SQLException, IllegalAccessException {
        Field[] fields = table.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            this.fillField(field,entity,resultSet,this.getColumnName(field));
        }
    }

    private void fillField(Field field, Object instance, ResultSet set, String fieldName) throws SQLException, IllegalAccessException {
        field.setAccessible(true);

        if (field.getType() == Integer.class || field.getType() == int.class) {
            field.set(instance, set.getInt(fieldName));
        } else if (field.getType() == Date.class) {
            field.set(instance, set.getDate(fieldName));
        } else if (field.getType() == String.class) {
            field.set(instance, set.getString(fieldName));
        }
    }
}