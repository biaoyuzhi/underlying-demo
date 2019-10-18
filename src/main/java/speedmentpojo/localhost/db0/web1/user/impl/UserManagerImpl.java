package speedmentpojo.localhost.db0.web1.user.impl;

import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Generated;
import speedmentpojo.localhost.db0.web1.user.User;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the Table 'localhost.db0.web1.user'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class UserManagerImpl extends AbstractSqlManager<User> {
    
    private final TypeMapper<Integer, Integer> idTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<String, String> nameTypeMapper = new StringIdentityMapper();
    private final TypeMapper<String, String> passwordTypeMapper = new StringIdentityMapper();
    
    public UserManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
    
    @Override
    public Object get(User entity, Column column) {
        switch (column.getName()) {
            case "id" : return entity.getId();
            case "name" : return entity.getName();
            case "password" : return entity.getPassword();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(User entity, Column column, Object value) {
        switch (column.getName()) {
            case "id" : entity.setId((Integer) value); break;
            case "name" : entity.setName((String) value); break;
            case "password" : entity.setPassword((String) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.web1.user");
    }
    
    protected User defaultReadEntity(ResultSet resultSet) {
        final User entity = newInstance();
        try {
            entity.setId(idTypeMapper.toJavaType(resultSet.getInt(1)));
            entity.setName(nameTypeMapper.toJavaType(resultSet.getString(2)));
            entity.setPassword(passwordTypeMapper.toJavaType(resultSet.getString(3)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public User newInstance() {
        return new UserImpl(speedment);
    }
    
    @Override
    public Integer primaryKeyFor(User entity) {
        return entity.getId();
    }
}