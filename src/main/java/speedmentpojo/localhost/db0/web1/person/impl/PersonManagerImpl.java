package speedmentpojo.localhost.db0.web1.person.impl;

import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.LongIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Generated;
import speedmentpojo.localhost.db0.web1.person.Person;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the Table 'localhost.db0.web1.person'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class PersonManagerImpl extends AbstractSqlManager<Person> {
    
    private final TypeMapper<Long, Long> idTypeMapper = new LongIdentityMapper();
    private final TypeMapper<String, String> nameTypeMapper = new StringIdentityMapper();
    private final TypeMapper<String, String> passwordTypeMapper = new StringIdentityMapper();
    
    public PersonManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }
    
    @Override
    public Object get(Person entity, Column column) {
        switch (column.getName()) {
            case "id" : return entity.getId();
            case "name" : return entity.getName();
            case "password" : return entity.getPassword();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(Person entity, Column column, Object value) {
        switch (column.getName()) {
            case "id" : entity.setId((Long) value); break;
            case "name" : entity.setName((String) value); break;
            case "password" : entity.setPassword((String) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.web1.person");
    }
    
    protected Person defaultReadEntity(ResultSet resultSet) {
        final Person entity = newInstance();
        try {
            entity.setId(idTypeMapper.toJavaType(resultSet.getLong(1)));
            entity.setName(nameTypeMapper.toJavaType(resultSet.getString(2)));
            entity.setPassword(passwordTypeMapper.toJavaType(resultSet.getString(3)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public Person newInstance() {
        return new PersonImpl(speedment);
    }
    
    @Override
    public Long primaryKeyFor(Person entity) {
        return entity.getId();
    }
}