package speedmentpojo.localhost.db0.web1.book.impl;

import com.speedment.Speedment;
import com.speedment.config.Column;
import com.speedment.config.Table;
import com.speedment.config.mapper.TypeMapper;
import com.speedment.exception.SpeedmentException;
import com.speedment.internal.core.config.mapper.identity.DoubleIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper;
import com.speedment.internal.core.config.mapper.identity.StringIdentityMapper;
import com.speedment.internal.core.manager.sql.AbstractSqlManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Generated;
import speedmentpojo.localhost.db0.web1.book.Book;

/**
 * A manager implementation representing an entity (for example, a row) in
 * the Table 'localhost.db0.web1.book'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class BookManagerImpl extends AbstractSqlManager<Book> {
    
    private final TypeMapper<Integer, Integer> idTypeMapper = new IntegerIdentityMapper();
    private final TypeMapper<Double, Double> priceTypeMapper = new DoubleIdentityMapper();
    private final TypeMapper<String, String> nameTypeMapper = new StringIdentityMapper();
    
    public BookManagerImpl(Speedment speedment) {
        super(speedment);
        setSqlEntityMapper(this::defaultReadEntity);
    }
    
    @Override
    public Class<Book> getEntityClass() {
        return Book.class;
    }
    
    @Override
    public Object get(Book entity, Column column) {
        switch (column.getName()) {
            case "id" : return entity.getId();
            case "price" : return entity.getPrice();
            case "name" : return entity.getName();
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public void set(Book entity, Column column, Object value) {
        switch (column.getName()) {
            case "id" : entity.setId((Integer) value); break;
            case "price" : entity.setPrice((Double) value); break;
            case "name" : entity.setName((String) value); break;
            default : throw new IllegalArgumentException("Unknown column '" + column.getName() + "'.");
        }
    }
    
    @Override
    public Table getTable() {
        return speedment.getProjectComponent().getProject().findTableByName("db0.web1.book");
    }
    
    protected Book defaultReadEntity(ResultSet resultSet) {
        final Book entity = newInstance();
        try {
            entity.setId(idTypeMapper.toJavaType(resultSet.getInt(1)));
            entity.setPrice(priceTypeMapper.toJavaType(getDouble(resultSet, 2)));
            entity.setName(nameTypeMapper.toJavaType(resultSet.getString(3)));
        }
        catch (SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    @Override
    public Book newInstance() {
        return new BookImpl(speedment);
    }
    
    @Override
    public Integer primaryKeyFor(Book entity) {
        return entity.getId();
    }
}