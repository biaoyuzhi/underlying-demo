package speedmentpojo.localhost.db0.web1.student.impl;

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
import speedmentpojo.localhost.db0.web1.student.Student;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the Table 'localhost.db0.web1.student'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class StudentManagerImpl extends AbstractSqlManager<Student> {
    
    private final TypeMapper<Integer, Integer> idTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<String, String> nameTypeMapper = new StringIdentityMapper();
    private final TypeMapper<String, String> courseTypeMapper = new StringIdentityMapper();
    private final TypeMapper<Integer, Integer> scoreTypeMapper = new IntegerIdentityMapper();
    
    public StudentManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
    
    @Override
    public Object get(Student entity, Column column) {
        switch (column.getName()) {
            case "id" : return entity.getId();
            case "name" : return entity.getName();
            case "course" : return entity.getCourse();
            case "score" : return entity.getScore();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(Student entity, Column column, Object value) {
        switch (column.getName()) {
            case "id" : entity.setId((Integer) value); break;
            case "name" : entity.setName((String) value); break;
            case "course" : entity.setCourse((String) value); break;
            case "score" : entity.setScore((Integer) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.web1.student");
    }
    
    protected Student defaultReadEntity(ResultSet resultSet) {
        final Student entity = newInstance();
        try {
            entity.setId(idTypeMapper.toJavaType(resultSet.getInt(1)));
            entity.setName(nameTypeMapper.toJavaType(resultSet.getString(2)));
            entity.setCourse(courseTypeMapper.toJavaType(resultSet.getString(3)));
            entity.setScore(scoreTypeMapper.toJavaType(getInt(resultSet, 4)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public Student newInstance() {
        return new StudentImpl(speedment);
    }
    
    @Override
    public Integer primaryKeyFor(Student entity) {
        return entity.getId();
    }
}